package victor.training.exceptions;
//class BadConfigException extends RuntimeException {}
//class BadConfigException extends RuntimeException {}
//class BadConfigException extends RuntimeException {}
//class BadConfigException extends RuntimeException {}
//class BadConfigException extends RuntimeException {}
//class BadConfigException extends RuntimeException {}
public class MyException extends  RuntimeException {


   public enum ErrorCode {
      GENERAL,
      BAD_CONFIG;
   }
   private final ErrorCode code;
   private final Object[] params;

   public MyException(Throwable cause) {
     this(ErrorCode.GENERAL, cause);
   }
   public MyException(ErrorCode code, Throwable cause, Object... params) {
      super(cause);
      this.code = code;
      this.params = params;
   }

   public Object[] getParams() {
      return params;
   }

   public ErrorCode getCode() {
      return code;
   }
}
