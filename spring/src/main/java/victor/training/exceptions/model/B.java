package victor.training.exceptions.model;

public class B {
   private final String label;

   public B(String label) {
      this.label = label;
   }

   public B() {
      this(null);
   }

   public String getLabel() {
      return label;
   }
}
