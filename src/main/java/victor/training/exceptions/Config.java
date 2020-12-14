package victor.training.exceptions;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class Config {

   @SneakyThrows
   public static Date getLastPromoDate() {
//      try {
//      for (int rowNumber = 0; rowNumber < 100; rowNumber++) {

//         try {
         Properties props = new Properties();
         try (FileReader reader = new FileReader("config.properties")) {
            props.load(reader);
         }
         SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
         return format.parse(props.getProperty("last.promo.date"));
//         } catch (IOException | ParseException e) {
////         e.printStackTrace();
//            log.error(e.getMessage(), e);
//            throw new MyException("Error at line " + rowNumber, ErrorCode.BAD_CONFIG, e, rowNumber);
//      } catch (Exception e){
//      throw new RuntimeException(e);

//      } catch (Throwable var6) {
//         throw var6;
//      }
//    }
   }


}
