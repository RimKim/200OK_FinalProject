package shop.myshop.exception;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ExceptionHandler는 @Controller, @RestController가 적용된 Bean내에서 발생하는 예외를 잡아줌
@ControllerAdvice // 즉, 전역에서 발생할 수 있는 예외를 잡아 처리해주는 annotation
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e, Model model) {
        // 예외 처리 로직 작성
        model.addAttribute("errorMessage", e.getMessage());
       
        return "error";//에러 페이지로 이동
    }
}
