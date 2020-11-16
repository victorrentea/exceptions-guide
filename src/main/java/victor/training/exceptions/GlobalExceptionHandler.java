package victor.training.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

   @ExceptionHandler
   @ResponseStatus
   public String handle(Exception e) {
      String r = UUID.randomUUID().toString();
      log.error("Http request error: "+r, e);
      return "Internal Server Problem. Please check the log: id="+r;
   }

   @Autowired
   MessageSource messageSource;
   @ExceptionHandler
   @ResponseStatus
   public String handle(MyException e, HttpServletRequest request) {
      String r = UUID.randomUUID().toString();
      log.error("Http request error: "+r, e);
      return messageSource.getMessage(e.getCode().name(), null, request.getLocale());
   }
}
