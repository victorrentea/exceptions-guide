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
      // TODO offer date < Config.getLastPromoDate()
      if (order.getOfferDate().before(new Date())) {
         System.out.println("APPLYING DISCOUNT");
         order.setPrice(order.getPrice() * (100 - 2 * customer.getMemberCard().getFidelityDiscount()) / 100);
      }
   }
}

