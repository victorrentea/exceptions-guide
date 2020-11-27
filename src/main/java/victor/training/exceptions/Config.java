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

/** @author Alan T. */
@Slf4j
public class Config {

   @SneakyThrows
   public static Date getLastPromoDate() {
      Properties props = new Properties();
      try (FileReader reader = new FileReader("config.properties")) {
         props.load(reader);
      }
      SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
      return format.parse(props.getProperty("last.promo.date"));
   }


}
