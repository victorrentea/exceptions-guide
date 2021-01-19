package victor.training.exceptions;

import org.springframework.stereotype.Service;
import victor.training.exceptions.model.Customer;
import victor.training.exceptions.model.MemberCard;
import victor.training.exceptions.model.Order;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

/**
 * @author Bill G.
 */
@Service
public class Biz {

   public void applyDiscount(Order order, Customer customer) {
      System.out.println("START");
      if (order.getOfferDate().before(Config.getLastPromoDate())) {
         System.out.println("APPLYING DISCOUNT");
         Integer points = customer.getMemberCard().map(MemberCard::getFidelityPoints).orElse(0);
         order.setPrice(order.getPrice() * (100 - 2 * points) / 100);
      } else {
         System.out.println("NO DISCOUNT");
      }
   }
}

