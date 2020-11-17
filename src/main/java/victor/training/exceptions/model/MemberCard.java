package victor.training.exceptions.model;

public class MemberCard {
   private int fidelityDiscount;

   public int getFidelityDiscount() {
      return fidelityDiscount;
   }

   public MemberCard setFidelityDiscount(int fidelityDiscount) {
      this.fidelityDiscount = fidelityDiscount;
      return this;
   }
}
