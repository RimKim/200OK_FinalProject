package shop.myshop.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.databind.JsonNode;

import lombok.extern.slf4j.Slf4j;
import shop.myshop.annotation.MySecured;
import shop.myshop.dto.Role;
import shop.myshop.entity.User;
import shop.myshop.exception.UserNotFoundException;
import shop.myshop.service.FindPwdEmail;
import shop.myshop.service.KakaoUserInfo;
import shop.myshop.service.RegisterMail;
import shop.myshop.service.UserService;

@Slf4j
@Controller
@RequestMapping("user")
public class UserController {

	

	@Autowired
	private UserService userService;
	
	@Autowired
	RegisterMail registerMail;
	
	@Autowired
	FindPwdEmail findPwdEmail;

	
	
	//중복아이디 검사
	@GetMapping("checkuserId")
	@ResponseBody
	 public boolean checkUserId(@RequestParam("userId") String userId) throws Exception {
		 boolean exist = userService.UserIdExists(userId);
		    return exist;
		    
	} 
	

	
	//회원가입 메일인증코드
	@PostMapping("user/userEmailConfirm")
	@ResponseBody
	String userEmailConfirm(@RequestParam("userEmail") String email) throws Exception {

	   String code = registerMail.sendSimpleMessage(email);
	   return code;
	}
	
	//회원가입폼으로 이동 
	@GetMapping("joinForm")
	 public String join() {
       
		 return "user/signUp.html";
    }
	
	//아이디찾기폼으로 이동	
	@GetMapping("idFindForm")
	 public String findIdForm() {
      
		 return "user/findId.html";
   }
	//비밀번호찾기폼으로 이동	
	@GetMapping("pwdFindForm")
	 public String findPwdForm() {
     
		 return "user/findPwd.html";
  }
	
	
	
	//아이디 찾기
	@PostMapping("findId")
	public String findId(@RequestParam("userName") String userName,
	                     @RequestParam("userEmail") String userEmail,
	                     Model model) {
	    try {
	        String userId = userService.getUserId(userName, userEmail);
	        model.addAttribute("userId", userId);
	        return "user/findIdResult";
	  
	       } catch (UserNotFoundException e) {
	        model.addAttribute("errorMessage", "일치하는 사용자 정보가 없습니다.");
	        return "user/findIdfail";
	    
	 } catch (Exception e) {
	        model.addAttribute("errorMessage", "다시 시도해주세요.");
	        return "user/findIdfail";
	    }
	}

	
	//비밀번호 찾은 후 임시비번 발송
	@PostMapping("user/findPwd")
	public String findPwd(@RequestParam("userId") String userId, @RequestParam("userName") String userName,
	@RequestParam("userEmail") String userEmail, Model model) {
	try {
	User user = userService.findUserPwd(userId, userName, userEmail);
	
	if (user != null) {
		String tempPwd = findPwdEmail.sendSimpleMessage(user.getUserEmail());
		userService.updateTempPwd(tempPwd, user.getUserId());

		model.addAttribute("message", "임시비밀번호가 발급되었습니다. 메일을 확인해주세요.");
		return "user/findPwdResult.html";
	}
		return "user/findPwdfail.html"; 
	}catch (Exception e) {
		return "user/findPwdfail.html"; 
}
} 

	
	
	//회원가입
	@PostMapping("join")
	public String join(User user, Model model) {

	
		User newUser = null;
		try {
			newUser = userService.join(user);
			model.addAttribute("userName", newUser.getUserName());
			return "user/signUpResult.html";
		} catch (Exception e) {
			e.printStackTrace();
			return "error.html";
		}
	} 
	

	


	@GetMapping("login")
	public String login(Model model, HttpSession httpSession) throws Exception {
		if (httpSession.getAttribute("user") != null) {
			User user = (User) httpSession.getAttribute("user");
			model.addAttribute("user", user);
			return "redirect:user/my-info";
		}
		return "user/login-form";
	}

	
	@PostMapping("login")
	public String login(@RequestParam("id") String id, @RequestParam("password") String password,
			HttpSession httpSession) throws Exception {
		
		if (!userService.isUser(id, password)) {
			return "redirect:loginfail";
		}

		httpSession.setAttribute("user", userService.findByUserId(id));
		return "redirect:/main.html";
	}

	@PostMapping("join2")
	public String join2(User user) {
	    try {
	        userService.join(user);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return "redirect:/mypage/home";
	}
	
	
	@GetMapping("logo")
	public String index(HttpSession httpSession) {
		if (httpSession.getAttribute("user") == null) {
			return "redirect:/index.html";
		}
		return "redirect:/main.html";
	}

	@GetMapping("loginfail")
	public String loginfail(Model model, HttpSession httpSession) throws Exception {
		return "user/login-fail";
	}

	
	@PostMapping("loginfail")
	public String loginfail(@RequestParam("id") String id, @RequestParam("password") String password,
			HttpSession httpSession) throws Exception {
		if (!userService.isUser(id, password)) {
			return "redirect:loginfail";
		}

		httpSession.setAttribute("user", userService.findByUserId(id));
		return "redirect:/main.html";
	}

	// USER이상의 회원만 로그아웃가능
	@MySecured(role = Role.USER)
	@GetMapping("logout")
	public String logout(HttpSession httpSession) throws Exception {
		httpSession.invalidate();
		return "redirect:/index.html";
	}



	@RequestMapping(value = "/kakao", produces = "application/json", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView kakaoLogin(@RequestParam("code") String code, RedirectAttributes ra, HttpSession session,
			HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();

		JsonNode access_token = userService.getKakaoAccessToken(code);

		JsonNode userInfo = KakaoUserInfo.getKakaoUserInfo(access_token.get("access_token"));

		// Get id
		String member_id = userInfo.get("id").asText();

		String member_name = null;

		String birthday = null;

		String email = null;

		// 유저정보 카카오에서 가져오기 Get properties
		JsonNode properties = userInfo.path("properties");
		JsonNode kakao_account = userInfo.path("kakao_account");

		member_name = properties.path("nickname").asText(); // 이름 정보 가져오는 것
		email = kakao_account.path("email").asText();
		
		// 디비에 카카오 아이디와 동일한 아이디가 없다면
		if (userService.findByUserId(member_id.toString()) == null) {
			// 세션에 member_id 저장
			session.setAttribute("user", userService.findByUserId(member_id.toString()));
			
			mv.addObject("userId", member_id);
			mv.addObject("userName", member_name);
			mv.addObject("userEmail", email);
			mv.setViewName("user/kakaosignUp");
			return mv;
		} else {
			// 동일한 아이디 있으면 세션에 저장만
			session.setAttribute("user", userService.findByUserId(member_id.toString()));
		}

		mv.setViewName("redirect:/main.html");
		return mv;
	}

	@GetMapping("kakaoTerms")
	public String kakaoConnect() {

		StringBuffer url = new StringBuffer();
		url.append("https://kauth.kakao.com/oauth/authorize?");
		url.append("client_id=" + "카카오아이디");
		url.append("&redirect_uri=http://localhost/ok/user/kakao");
		url.append("&response_type=code");

		return "redirect:" + url.toString();
	}
	
	@GetMapping("kakaologoutterm")
	public String kakaoLogoutTerm(HttpSession httpSession) {

		StringBuffer url = new StringBuffer();
		url.append("https://kauth.kakao.com/oauth/logout?");
		url.append("client_id=" + "카카오아이디");
		url.append("&logout_redirect_uri=http://localhost/ok/user/kakaologout");

		return "redirect:" + url.toString();
	}


	
	@GetMapping("kakaologout")
	public String kakaoLogout(HttpSession httpSession) {

		httpSession.invalidate();

		return "redirect:/index.html";
	}

}
