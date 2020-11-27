package victor.training.exceptions.model;

import java.util.Optional;

public class Customer {
   private String name;
   private MemberCard memberCard;

   public Optional<MemberCard> getMemberCard() {
      return Optional.ofNullable(memberCard);
   }

   public Customer setMemberCard(MemberCard memberCard) {
      this.memberCard = memberCard;
      return this;
   }
}
