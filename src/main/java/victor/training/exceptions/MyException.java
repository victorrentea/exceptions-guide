package victor.training.exceptions;

public class MyException extends RuntimeException {
   public enum ErrorCode {
      GENERAL,
      BAD_CONFIG;
   }

   private final ErrorCode code;

   public MyException(ErrorCode code, Throwable cause) {
      super(cause);
      this.code = code;
   }

   public ErrorCode getCode() {
      return code;
   }
}
