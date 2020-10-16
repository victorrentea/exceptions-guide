package victor.training.exceptions;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import victor.training.exceptions.MyException.ErrorCode;

import javax.servlet.http.HttpServletRequest;


@RestController
@SpringBootApplication
public class HelloController {
   public static void main(String[] args) {
      SpringApplication.run(HelloController.class, args);
   }

   @GetMapping("hello")
   public String hello() {
      throw new MyException(ErrorCode.ERROR1);
   }
}

class MyException extends RuntimeException {
   enum ErrorCode {
      ERROR1
   }

   private final ErrorCode code;

   public MyException(ErrorCode code) {
      this.code = code;
   }

   public MyException(String message, ErrorCode code) {
      super(message);
      this.code = code;
   }

   public MyException(String message, Throwable cause, ErrorCode code) {
      super(message, cause);
      this.code = code;
   }

   public MyException(Throwable cause, ErrorCode code) {
      super(cause);
      this.code = code;
   }

   public ErrorCode getCode() {
      return code;
   }

}

@RestControllerAdvice
@RequiredArgsConstructor
class GlobalExceptionHandler {
   private final MessageSource messageSource;

   @ExceptionHandler(Exception.class)
   @ResponseStatus
   public String handle(Exception e, HttpServletRequest request) {
      return messageSource.getMessage(e.getMessage(), null, request.getLocale());
   }
   @ExceptionHandler(MyException.class)
   @ResponseStatus
   public String handleMy(MyException e, HttpServletRequest request) {
      return messageSource.getMessage(e.getCode().name(), null, request.getLocale());
   }
}