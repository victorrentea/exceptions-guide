package victor.training.exceptions;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

/** @author Bill G. */
@Service
public class Biz {

   public void applyDiscount(Order order, Customer customer) {
      try {
         if (order.getCreationDate().before(Config.getLastPromoDate())) {
            System.out.println("APPLYING DISCOUNT");
            order.setPrice(order.getPrice() * (100 - 2 * customer.getMemberCard().getFidelityDiscount()));
         }
      } catch (IOException | ParseException e) {
         e.printStackTrace();
      }
   }
}
class Order {
   private int price;
   private Date creationDate;

   public int getPrice() {
      return price;
   }

   public Order setPrice(int price) {
      this.price = price;
      return this;
   }

   public Date getCreationDate() {
      return creationDate;
   }
}
class Customer {
   private String name;
   private MemberCard memberCard;

   public MemberCard getMemberCard() {
      return memberCard;
   }
}
class MemberCard {
   private int fidelityDiscount;

   public int getFidelityDiscount() {
      return fidelityDiscount;
   }
}
