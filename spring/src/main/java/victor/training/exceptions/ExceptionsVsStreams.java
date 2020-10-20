package victor.training.exceptions;

import io.vavr.control.Try;
import lombok.SneakyThrows;
import org.jooq.lambda.Unchecked;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

public class ExceptionsVsStreams {

   public static void main(String[] args) {
      List<String> list = asList("2020-10-10", "2020-10-11", "2020-10-b", "2020-10-c", "2020-10-15");
      System.out.println(parseDates(list));
   }

   private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // WARNING: NOT Thread-safe!

   public static List<Date> parseDates(List<String> dateStrings) {

      return dateStrings.stream().map(ExceptionsVsStreams::parse).collect(toList()); // TODO
   }

   @SneakyThrows
   private static Date parse(String s) {
      return sdf.parse(s);
   }
}
