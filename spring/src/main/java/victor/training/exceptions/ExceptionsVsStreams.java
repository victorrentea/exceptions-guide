package victor.training.exceptions;

import io.vavr.control.Try;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

public class ExceptionsVsStreams {

   public static void main(String[] args) {
      List<String> list = asList("2020-10-10", "2020-10-x11", "2020-10-x11", "2020-10-x11", "2020-10-11");
      System.out.println(new ExceptionsVsStreams().parseDates(list));
   }

   public List<Date> parseDates(List<String> dateStrings) {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

      // dateStrings.stream()

      return null;
   }
}
