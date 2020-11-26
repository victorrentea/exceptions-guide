package victor.training.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/** @author Alan T. */
@Slf4j
public class Config {

   public static Date getLastPromoDate() {
      try{
         Properties props = new Properties();
         try (FileReader reader = new FileReader("config.properties")) {
            props.load(reader);
         }
         SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
         return format.parse(props.getProperty("last.promo.date"));
      } catch (ParseException | IOException e) {
         log.error(e.getMessage(), e);
         throw new RuntimeException(e);
      }
   }


}
