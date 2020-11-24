package victor.training.exceptions;

import org.junit.Assert;
import org.junit.Test;
import victor.training.exceptions.model.Customer;
import victor.training.exceptions.model.MemberCard;
import victor.training.exceptions.model.Order;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class BizTest {
   @Test
   public void test() {
      System.setProperty("last.promo.date", "2021-02-30");
      Biz biz = new Biz();

      Customer customer = new Customer()
          .setMemberCard(new MemberCard()
              .setFidelityDiscount(2));
      Order order = new Order(new Date())
          .setPrice(1000);

      biz.applyDiscount(order, customer);
      System.out.println("Final Price in tests: " + order.getPrice());
      assertEquals(960, order.getPrice());
   }
}
