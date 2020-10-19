package victor.training.exceptions;

import io.vavr.control.Try;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

public class ExceptionsVsStreams {

   public static void main(String[] args) {
      List<String> list = asList("2020-10-10", "2020-10-a", "2020-10-b", "2020-10-c", "2020-10-15");
      System.out.println(parseDates(list));
   }

   public static List<Date> parseDates(List<String> dateStrings) {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

      return null;// dateStrings.stream()
   }
}
