package victor.training.exceptions.model;

import java.util.Date;
import java.util.Objects;

import static java.util.Objects.requireNonNull;

public class Order {
   private int price;
   private Date offerDate;

   public Order(Date offerDate) {
      this.offerDate = requireNonNull(offerDate);
   }

   public int getPrice() {
      return price;
   }

   public Order setPrice(int price) {
      this.price = price;
      return this;
   }

   public Date getOfferDate() {
      return offerDate;
   }

   public Order setOfferDate(Date offerDate) {
      this.offerDate = requireNonNull(offerDate);
      return this;
   }
}
