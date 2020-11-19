package victor.training.exceptions;

import org.springframework.stereotype.Service;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/** @author Alan T. */
public class Config {

   public static Date getLastPromoDate() {

      try {
         Properties properties = new Properties();
         try (Reader reader = new FileReader("config.properties")) {
            properties.load(reader);
         }
         SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
         return format.parse(System.getProperty("last.promo.date"));
      } catch (IOException | ParseException e) {
         throw new RuntimeException(e);
      }
   }


}
