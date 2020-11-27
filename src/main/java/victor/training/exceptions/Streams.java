package victor.training.exceptions;

import io.vavr.control.Try;
import org.jooq.lambda.Unchecked;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

public class Streams {

   public static void main(String[] args) {
      List<String> dateList = asList("2020-10-11", "2020-nov-12", "2020-12-01");
      SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

      // TODO
      List<Try<Date>> tries = dateList.stream().map(s -> tryParse(format, s)).collect(toList());

      double successRatio = tries.stream().mapToInt(t -> t.isSuccess() ? 1 : 0).average().orElse(0);

      if (successRatio > .5) {
         List<Date> dates = tries.stream().filter(Try::isSuccess).map(Try::get).collect(toList());
         System.out.println(dates);
      }

   }

   private static Try<Date> tryParse(SimpleDateFormat format, String s) {
      return Try.of(() -> format.parse(s));
   }

}
