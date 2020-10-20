package victor.training.exceptions;

import io.vavr.control.Try;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

public class ExceptionsVsStreams {

   public static void main(String[] args) {
      List<String> list = asList("2020-10-10", "2020-10-c", "2020-10-b", "2020-10-c", "2020-10-15");
      System.out.println(parseDates(list));
   }

   private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // WARNING: NOT Thread-safe!
   static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

   public static List<LocalDate> parseDates(List<String> dateStrings) {
      // Change Request: return parsable dates if >=50%

      List<Try<LocalDate>> tries = dateStrings.stream().map(s -> Try.of(() -> LocalDate.parse(s, formatter))).collect(toList());// TODO

      if (tries.stream().filter(Try::isSuccess).count() * 2 >= dateStrings.size()) {
         return tries.stream().filter(Try::isSuccess).map(Try::get).collect(toList());
      } else {
         List<String> errors = tries.stream().filter(Try::isFailure).map(Try::getCause).map(Throwable::getMessage).collect(toList());
         throw new IllegalArgumentException(errors.toString());
      }
   }

}
