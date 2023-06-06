package shop.myshop.controller;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import shop.myshop.dto.UserDTO;

@ControllerAdvice// 모든 컨트롤러에 적용
public class CommonController {

	@ModelAttribute//모든 컨트롤러에 추가
	public void sharedData(Model model, HttpSession session) {
	    UserDTO user = (UserDTO) session.getAttribute("user");
	    if (user != null) {
	        model.addAttribute("userName", user.getUserName());
	        model.addAttribute("userRole", user.getUserRole().toString());
	        model.addAttribute("userProvider", user.getUserProvider());
	    } else {
	        model.addAttribute("userName", "");
	        model.addAttribute("userRole", "");
	        model.addAttribute("userProvider", "");
	    }
	}
}