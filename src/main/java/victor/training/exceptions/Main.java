package victor.training.exceptions;

import lombok.extern.slf4j.Slf4j;

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
      return new Date(System.currentTimeMillis() - 1000 * 60 * 60 * 24);
   }
}
