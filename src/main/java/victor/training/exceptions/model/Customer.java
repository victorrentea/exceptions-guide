package victor.training.exceptions.model;

public class Customer {
   private String name;
   private MemberCard memberCard;

   public MemberCard getMemberCard() {
      return memberCard;
   }

   public Customer setMemberCard(MemberCard memberCard) {
      this.memberCard = memberCard;
      return this;
   }
}
