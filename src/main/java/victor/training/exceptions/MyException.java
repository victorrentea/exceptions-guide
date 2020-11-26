package victor.training.exceptions;

public class MyException extends RuntimeException {
   public enum ErrorCode {
      GENERAL,
      BAD_CONFIG;
   }

   private final ErrorCode code;
   private final Object[] params;

   public MyException(ErrorCode code, Throwable cause, Object... params) {
      super(cause);
      this.code = code;
      this.params = params;
   }

   public ErrorCode getCode() {
      return code;
   }

   public Object[] getParams() {
      return params;
   }
}
