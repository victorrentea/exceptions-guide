package victor.training.exceptions.model;

public class MemberCard {
   private int fidelityDiscount = 1;

   public int getFidelityDiscount() {
      return fidelityDiscount;
   }

   public MemberCard setFidelityDiscount(int fidelityDiscount) {
      this.fidelityDiscount = fidelityDiscount;
      return this;
   }
}
