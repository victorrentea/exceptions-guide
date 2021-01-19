package victor.training.exceptions;

import org.springframework.stereotype.Service;
import victor.training.exceptions.model.Customer;
import victor.training.exceptions.model.Order;

import java.util.Date;

/**
 * @author Bill G.
 */
@Service
public class Biz {

   public void applyDiscount(Order order, Customer customer) {
      System.out.println("START");
      Date endOfSale = null; // TODO call Config.getLastPromoDate()
      if (order.getOfferDate().before(endOfSale)) {
         System.out.println("APPLYING DISCOUNT");
         order.setPrice(order.getPrice() * (100 - 2 * customer.getMemberCard().getFidelityPoints()) / 100);
      } else {
         System.out.println("NO DISCOUNT");
      }
   }
}

