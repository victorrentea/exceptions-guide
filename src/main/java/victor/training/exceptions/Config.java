package victor.training.exceptions;

import org.springframework.stereotype.Service;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/** @author Alan T. */
public class Config {

   public static Date getLastPromoDate() throws ParseException {
      SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
      return format.parse(System.getProperty("last.promo.date"));
   }
}
