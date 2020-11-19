package victor.training.exceptions;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import victor.training.exceptions.MyException.ErrorCode;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * @author Alan T.
 */
public class Config {


   @SneakyThrows
   public static Date getLastPromoDate() {
//      try {
         long userInputUsefulToReportBackToHim = 1;

//      try {
         Properties properties = new Properties();
         try (Reader reader = new FileReader("config.properties")) {
            properties.load(reader);
         }
         SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
         return format.parse(properties.getProperty("last.promo.date"));
//      } catch (IOException | ParseException e) {
//         throw new RuntimeException(e);
//      }
//      } catch (Throwable var8) {
//         throw var8;
//      }
   }


}
