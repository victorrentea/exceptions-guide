package victor.training.exceptions;

import org.springframework.stereotype.Service;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/** @author Alan T. */
public class Config {

   public static Date getLastPromoDate() throws IOException, ParseException {
      Properties properties = new Properties();
      try (Reader reader = new FileReader("config.properties")) {
         properties.load(reader);
      }
      String dateStr = properties.getProperty("last.promo.date");
      return new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
   }
}
