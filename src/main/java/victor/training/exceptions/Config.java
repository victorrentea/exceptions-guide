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
      File file = new File("config.properties");
//      try {
         SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
         Properties properties = new Properties();
         try (FileReader reader = new FileReader(file)) {
            properties.load(reader);
         }
         return format.parse(properties.getProperty("last.promo.date"));
//      } catch (IOException | ParseException e) {
//         throw new RuntimeException(e);
//         throw new MyException(e, ErrorCode.BAD_CONFIG, file.getName());
//         throw new MyException("Could not read config from " + file.getAbsolutePath(),e);
//      }
//      } catch (Throwable var8) {
//         throw var8;
//      }
   }


}
