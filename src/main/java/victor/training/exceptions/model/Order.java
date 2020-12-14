package victor.training.exceptions.model;

import lombok.NonNull;

import java.util.Date;
import java.util.Objects;

import static java.util.Objects.requireNonNull;

public class Order {
   private int id;
   private int price;
   private Date offerDate;

   public int getId() {
      return id;
   }

   public Order(Date offerDate) {
      setOfferDate(offerDate);
   }

   public Order setPrice(int price) {
      this.price = price;
      return this;
   }

   public int getPrice() {
      return price;
   }

   public Date getOfferDate() {
      return offerDate;
   }

   public Order setOfferDate(Date offerDate) {
      this.offerDate = requireNonNull(offerDate);
      return this;
   }
}
