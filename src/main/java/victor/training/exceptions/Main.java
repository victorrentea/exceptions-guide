package victor.training.exceptions;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Slf4j
public class Main {

   public static void main(String[] args) {
      Biz biz = new Biz();

      Customer customer = new Customer().setMemberCard(new MemberCard());
      Order order = new Order().setOfferDate(new Date());

      biz.applyDiscount(order, customer);
   }
}
