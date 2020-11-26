package victor.training.exceptions;

public class MyException extends RuntimeException {
   public enum ErrorCode {
      GENERAL,
      BAD_CONFIG;
   }

   private final ErrorCode code;
   private final Object[] params;

   // canonical constructor
   public MyException(String message, ErrorCode code, Throwable cause, Object... params) {
      super(message, cause);
      this.code = code;
      this.params = params;
   }
   // overloaded constructors:
   public MyException(ErrorCode code, Throwable cause, Object... params) {
      this(null, code, cause, params);
   }
   public MyException(ErrorCode code, Object... params) {
      this(null, code, null, params);
   }
   public MyException(String message, ErrorCode code, Object... params) {
      this(message, code, null, params);
   }
   public MyException(String message, Throwable cause) {
      this(message, ErrorCode.GENERAL, cause);
   }
   public MyException(Throwable cause) {
      this(ErrorCode.GENERAL);
   }
   public MyException(String message) {
      this(message, ErrorCode.GENERAL);
   }

   public ErrorCode getCode() {
      return code;
   }
   public Object[] getParams() {
      return params;
   }
}
