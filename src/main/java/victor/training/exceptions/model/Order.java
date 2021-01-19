package victor.training.exceptions.model;

import lombok.NonNull;

import java.util.Date;
import java.util.Objects;

import static java.util.Objects.requireNonNull;

public class Order {
   private int price;
   private Date offerDate;

   public Order(/*@NonNull*/ Date offerDate) {
//      if (offerDate == null) {
//         throw new IllegalArgumentException();
//      }
//      assert offerDate != null;
      setOfferDate(offerDate);
//      this.offerDate = offerDate; // most widespread
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
