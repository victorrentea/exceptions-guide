package victor.training.exceptions;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.stereotype.Service;
import victor.training.exceptions.model.Customer;
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
      try {
         if (order.getOfferDate().before(Config.getLastPromoDate())) {
            System.out.println("APPLYING DISCOUNT");
            order.setPrice(order.getPrice() * (100 - 2 * customer.getMemberCard().getFidelityDiscount()) / 100);
         } else {
            System.out.println("NO DISCOUNT");
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}

