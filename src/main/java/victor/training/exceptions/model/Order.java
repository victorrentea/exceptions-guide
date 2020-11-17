package victor.training.exceptions.model;

import java.util.Date;

public class Order {
   private int price;
   private Date offerDate;

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
      this.offerDate = offerDate;
      return this;
   }
}
