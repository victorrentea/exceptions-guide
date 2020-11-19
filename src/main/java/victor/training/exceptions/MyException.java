package victor.training.exceptions;


class MyRecoverableException extends MyException {

   public MyRecoverableException(Throwable cause, Object... params) {
      super(ErrorCode.RECOVERABLE_ERR1, cause, params);
   }
}

public class MyException extends RuntimeException {
   public enum ErrorCode {
      GENERAL,
      RECOVERABLE_ERR1,
      BAD_CONFIG;

   }
   private final ErrorCode code;

   private final Object[] params;
   public MyException(ErrorCode code, Throwable cause, Object... params) {
      super(cause);
      this.code = code;
      this.params = params;
   }

   public MyException(Exception cause) {
      this(ErrorCode.GENERAL, cause);
   }

   public Object[] getParams() {
      return params;
   }

   public ErrorCode getCode() {
      return code;
   }
}
