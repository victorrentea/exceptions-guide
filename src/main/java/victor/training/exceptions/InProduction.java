package victor.training.exceptions;

import victor.training.exceptions.model.Customer;
import victor.training.exceptions.model.Order;

public class InProduction {

   private static Biz biz = new Biz();

   public static void main(String[] args) {
      Order order = new Order().setPrice(1000);

      biz.applyDiscount(order, new Customer());

      System.out.println("Final Price " + order.getPrice());
   }
}
