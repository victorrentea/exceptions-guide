package victor.training.exceptions;

import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author Bill G.
 */
@Service
public class Biz {

   public void applyDiscount(Order order, Customer customer) {
      if (order.getOfferDate().before(Config.getLastPromoDate())) {
         System.out.println("APPLYING DISCOUNT");
         order.setPrice(order.getPrice() * (100 - 2 * customer.getMemberCard().getFidelityDiscount()));
      }
   }
}

class Order {
   private int price;
   private Date offerDate;

   public int getPrice() {
      return price;
   }

   public Order setPrice(int price) {
      this.price = price;
      return this;
   }

   public Date getOfferDate() {
      return offerDate;
   }

   public Order setOfferDate(Date offerDate) {
      this.offerDate = offerDate;
      return this;
   }
}

class Customer {
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

class MemberCard {
   private int fidelityDiscount;

   public int getFidelityDiscount() {
      return fidelityDiscount;
   }
}
