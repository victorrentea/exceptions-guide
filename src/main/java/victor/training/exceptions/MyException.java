package victor.training.exceptions;

public class MyException extends RuntimeException{
   enum ErrorCode {
      GENERAL,
      NO_NAME_PARAM
   }
   private final ErrorCode code;

   public ErrorCode getCode() {
      return code;
   }

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

   public MyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, ErrorCode code) {
      super(message, cause, enableSuppression, writableStackTrace);
      this.code = code;
   }
}
