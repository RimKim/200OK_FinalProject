package shop.myshop.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import shop.myshop.dto.QuestionDTO;
import shop.myshop.dto.Role;
import shop.myshop.dto.UserDTO;
import shop.myshop.entity.Answer;
import shop.myshop.entity.Notice;
import shop.myshop.entity.Question;
import shop.myshop.entity.User;
import shop.myshop.service.AnswerServiceImpl;
import shop.myshop.service.QuestionServiceImpl;
import shop.myshop.service.UserServiceImpl;

@Controller
@RequestMapping("question")
public class QuestionController {
	
	  @Autowired 
	  private AnswerServiceImpl answerService;
	  
	  @Autowired 
	  private UserServiceImpl userService;
	  
	  @Autowired 
	  private QuestionServiceImpl questionService;
	  
		//문의글 상세페이지
	  	@GetMapping("detail/{questionNo}")
		public String detail(@PathVariable int questionNo, Model model,HttpSession httpSession) throws Exception {
				
			model.addAttribute("question", questionService.findByQuestionNo(questionNo));
			List<Answer> answerList = answerService.getAnswerList(questionNo);

			 model.addAttribute("answers", answerList);
			  	
			     
			// 비회원 일경우
			if (httpSession.getAttribute("user") == null) {
			    return "board/qna-list"; //자주 묻는 QnA페이지로 이동
 
				}
			UserDTO user = (UserDTO) httpSession.getAttribute("user");
			model.addAttribute("user", user);

								      
			//회원 일경우 
			if (Role.USER == user.getUserRole()) {
		                   return "board/qna-detail";
				    }

			//관리자 일경우 
			if (Role.ADMIN == user.getUserRole()) {
		                   httpSession.setAttribute("questionNo", questionNo); 
			       return "board/admin-qna-detail";
				    }

			    return "redirect:/question/questionlist";
				}
	  
		//문의글목록
		@GetMapping("questionlist")
		public String questionList(Model model, HttpSession httpSession) throws Exception {

			model.addAttribute("question", questionService.getQuestion());

			// 비회원 일경우
			if (httpSession.getAttribute("user") == null) {
				return "board/qna-list"; //자주 묻는 QnA페이지로 이동

			}

			
			UserDTO user = (UserDTO) httpSession.getAttribute("user");
			model.addAttribute("user", user);

			
			if (Role.USER == user.getUserRole()) {
				return "board/qna-class-list"; //문의글목록 페이지로 이동
			}

			return "board/qna-class-list";
		}
	 
	 	//문의글작성폼으로 이동
	  	@GetMapping("qnawriteform")
		public String questionForm(HttpSession session, Model model) throws Exception {
			UserDTO user = (UserDTO) session.getAttribute("user");

			model.addAttribute("user", user);

			return "board/qna-write";
		}
	  
		//문의글등록
	  	@RequestMapping(value = "/savepost1")
		public String savePost(HttpServletRequest req, Question question) throws Exception {

			Date today = new Date();
			question.setQuestionRegdate(today);
			questionService.saveQuestion(question);

			return "redirect:/question/questionlist";

		}
	  
	  	@RequestMapping(value = "savepost")
		public String savePost1(HttpServletRequest req, Notice notice) throws Exception {

			return "redirect:../question/questionlist";

		}
	  
	  
	
		//문의글 삭제	  
	  	@GetMapping("delete")
		public String questionDelete(@RequestParam("questionNo") int questionNo) throws Exception {
			questionService.deleteByQuestionNo(questionNo);

			return "redirect:/question/questionlist";

		}

	  
             	//문의글 수정폼으로 이동 	  
	 	@GetMapping("updateform")
		public String questionUpdateForm(@RequestParam("questionNo") int questionNo,Model model) throws Exception {
			model.addAttribute("question",  questionService.findByQuestionNo(questionNo));
			return "board/qna-update";
		}
	  
		//문의글 수정
	  	@RequestMapping(value = "/updatePost")
		public String updatePost(HttpSession session,HttpServletRequest req, Question question) throws Exception {

			Date today = new Date();
			question.setQuestionRegdate(today);
			ModelMapper modelMapper = new ModelMapper();
			UserDTO user =  (UserDTO) session.getAttribute("user");
			
			User userEntity = modelMapper.map(user, User.class);
			
			
			question.setUserId(userEntity);

			questionService.saveQuestion(question);

			return "redirect:/question/questionlist";

		}
	  
	 
}
