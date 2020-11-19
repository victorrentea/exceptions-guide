package victor.training.exceptions;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RequiredArgsConstructor
@RestControllerAdvice
public class GlobalExceptionHandler {

   @ExceptionHandler(RuntimeException.class)
   @ResponseStatus
   public String handleRuntime(RuntimeException e) {
      log.error("Unexpected booboo", e);
      return e.getMessage();
   }

   private final MessageSource messageSource;

   @ExceptionHandler(MyException.class)
   @ResponseStatus
   public String handleMyException(MyException e, HttpServletRequest request) {
      String userMessage = messageSource.getMessage(e.getCode().name(), e.getParams(), request.getLocale());
      log.error("Unexpected " + userMessage, e);
      return userMessage;
   }
}
