package victor.training.exceptions;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import victor.training.exceptions.MyException.ErrorCode;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RequiredArgsConstructor
@RestControllerAdvice
public class GlobalExceptionHandler {

   @ExceptionHandler(Exception.class)
   @ResponseStatus
   public String handleRuntime(Exception e, HttpServletRequest request) {
      String userMessage = messageSource.getMessage(ErrorCode.GENERAL.name(), null, request.getLocale());
      log.error("Unexpected " + userMessage, e);
      return userMessage;
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
