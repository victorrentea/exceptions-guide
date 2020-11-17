package victor.training.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.time.DateUtils;
import victor.training.exceptions.model.Customer;
import victor.training.exceptions.model.MemberCard;
import victor.training.exceptions.model.Order;

import java.util.Date;

@Slf4j
public class Main {

   public static void main(String[] args) {
      Biz biz = new Biz();

      Customer customer = new Customer().setMemberCard(new MemberCard().setFidelityDiscount(2));
      Order order = new Order()
          .setPrice(1000)
          .setOfferDate(yesterday());

      biz.applyDiscount(order, customer);
      System.out.println("Discounted Price " + order.getPrice());
   }

   private static Date yesterday() {
      return DateUtils.addDays(new Date(), -1);
   }
}
