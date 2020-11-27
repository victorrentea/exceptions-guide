package victor.training.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import victor.training.exceptions.MyException.ErrorCode;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
   private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
   private final MessageSource messageSource;

   public GlobalExceptionHandler(MessageSource messageSource) {
      this.messageSource = messageSource;
   }

   @ExceptionHandler(MyException.class)
   @ResponseStatus
   public String handleMyException(MyException exception, HttpServletRequest request) {
      String userMessage = messageSource.getMessage(exception.getCode().name(), exception.getParams(), request.getLocale());
      log.error(userMessage, exception);
      return userMessage;
   }

   @ExceptionHandler(Exception.class)
   @ResponseStatus
   public String handleRuntimeException(Exception exception, HttpServletRequest request) {
      String userMessage = messageSource.getMessage(ErrorCode.GENERAL.name(), null, request.getLocale());
      log.error(userMessage, exception);
      return userMessage;
   }
}
