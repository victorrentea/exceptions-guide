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
      List<String> dateList = asList("2020-10-11", "2020-nov-12", "2020-xxx12-01");
      SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

      // TODO parse and print all dates

//      List<Date> dates = dateList.stream().map(Unchecked.function(format::parse)).collect(toList());


      List<Try<Date>> tries = dateList.stream().map(s -> Try.of(() -> format.parse(s))).collect(toList());

      if (tries.stream().mapToInt(t->t.isSuccess()?1:0).average().getAsDouble() > .5) {
         List<Date> dates1 = tries.stream().filter(Try::isSuccess).map(Try::get).collect(toList());
         System.out.println(dates1);
      }


   }

//   private static <T,R> Function<T, R> wrapEx(ThrowingFunction<T, R> f) {
//      return t -> {
//         try {
//            return f.apply(t);
//         } catch (Throwable throwable) {
//            throw new RuntimeException(throwable);
//         }
//      };
//   }
//
//   interface ThrowingFunction<T, R> {
//      R apply(T t) throws Throwable;
//   }


}
