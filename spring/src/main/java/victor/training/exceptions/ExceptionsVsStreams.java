package victor.training.exceptions;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

public class ExceptionsVsStreams {

   public static void main(String[] args) {
      List<String> list = asList("2020-10-10", "2020-10-11", "2020-10-b", "2020-10-c", "2020-10-15");
      System.out.println(parseDates(list));
   }

   private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // WARNING: NOT Thread-safe!
   static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

   public static List<LocalDate> parseDates(List<String> dateStrings) {

      return dateStrings.stream().map(s -> LocalDate.parse(s, formatter)).collect(toList()); // TODO
   }

}
