package victor.training.exceptions;

import victor.training.exceptions.model.Customer;
import victor.training.exceptions.model.Order;

public class Main {
   public static void main(String[] args) {
      Order order = new Order().setPrice(1000);

      new Biz().applyDiscount(new Order().setPrice(1000), new Customer());

      System.out.println("Discounted Price " + order.getPrice());
   }
}
