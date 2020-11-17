package victor.training.exceptions;

import org.junit.Assert;
import org.junit.Test;
import victor.training.exceptions.model.Customer;
import victor.training.exceptions.model.MemberCard;
import victor.training.exceptions.model.Order;

import java.util.Date;

public class BizTest {
   @Test
   public void test() {
      System.setProperty("last.promo.date", "2021-02-30");
      Biz biz = new Biz();

      Customer customer = new Customer().setMemberCard(new MemberCard().setFidelityDiscount(2));
      Order order = new Order().setOfferDate(new Date())
          .setPrice(1000);

      biz.applyDiscount(order, customer);
      Assert.assertEquals(960, order.getPrice());
   }
}
