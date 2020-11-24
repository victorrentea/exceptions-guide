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

      // TODO parse and print datele posibile daca >50% sunt ok

//      List<Date> dates = dateList.stream()
//          .map(Unchecked.function(format::parse))
//          .collect(toList());

      // o monada asemanatoare cu Either
      List<Try<Date>> tries = dateList.stream().map(dateStr -> Try.of(() -> format.parse(dateStr))).collect(toList());

      if (tries.stream().mapToInt(tr -> tr.isSuccess()?1:0).average().getAsDouble() > .5) {
         List<Date> dates = tries.stream().filter(Try::isSuccess).map(Try::get).collect(toList());
         System.out.println(dates);
      }

   }
//
//   private static <T,R> Function<T, R> wrapEx(UglyFunction<T, R> f) {
//      return t -> {
//         try {
//            return f.apply(t);
//         } catch (Exception e) {
//            throw new RuntimeException(e);
//         }
//      };
//   }

}

//@FunctionalInterface
//interface UglyFunction<T, R> {
//
//   R apply(T t) throws Exception;
//}

