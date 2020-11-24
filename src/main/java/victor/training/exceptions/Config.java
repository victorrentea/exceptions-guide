package victor.training.exceptions;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import victor.training.exceptions.MyException.ErrorCode;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/** @author Alan T. */
public class Config {

   @SneakyThrows
   public static Date getLastPromoDate() {
      long interesant = 13;
      Properties props = new Properties();
      try (Reader reader = new FileReader("config.properties")) {
         props.load(reader);
      }
      SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
      return format.parse(props.getProperty("last.promo.date"));
   }


}
