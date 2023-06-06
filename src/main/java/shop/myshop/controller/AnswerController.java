package shop.myshop.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import shop.myshop.dto.Role;
import shop.myshop.dto.UserDTO;
import shop.myshop.entity.Answer;
import shop.myshop.entity.Question;
import shop.myshop.service.AnswerService;
import shop.myshop.service.QuestionService;
import shop.myshop.service.UserService;

@Controller
@RequestMapping("answer")
public class AnswerController {
 
	  @Autowired private QuestionService questionService;
	  
	  @Autowired private AnswerService answerService;
	  
	 //답변 삭제 
	  @GetMapping("delete")
	  public String answerDelete(@RequestParam("answerNo") int answerNo, HttpSession httpSession) throws Exception {
	      int questionNo = (int) httpSession.getAttribute("questionNo"); 
	      answerService.deleteByAnswerNo(answerNo);
	      return "redirect:/question/detail/" + questionNo;
	  }

	  
	  
	  
	  //답변 등록
	  @PostMapping("/answersave")
	  public String saveAnswer(@RequestParam("questionNo") int questionNo,
	                           @RequestParam("answerContent") String answerContent,
	                           Model model, HttpSession httpSession) throws Exception {
	      Question question = questionService.findByQuestion(questionNo);

	      Answer answer = new Answer();
	      answer.setAnswerContent(answerContent);
	      answer.setAnswerRegdate(new Date());
	      answer.setQuestionNo(question);

	      answerService.saveAnswer(answer);

	      return "redirect:/question/detail/" + questionNo;
	  }
	  
	



}