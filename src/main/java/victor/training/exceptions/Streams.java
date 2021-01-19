package victor.training.exceptions;

import io.vavr.control.Try;
import org.jooq.lambda.Unchecked;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.OptionalDouble;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.function.Function;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

public class Streams {

   public static void main(String[] args) {
      List<String> dateStrings = asList("2020-10-11", "2020-nov-12", "2020-dec-01");
      SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");


//      List<Date> dates = dateStrings.stream().map(Unchecked.function(format::parse)).collect(toList());
//      System.out.println(dates);

      // TODO parse and print all dates if at least half are valid

      List<Try<Date>> tries = dateStrings.stream().map(s -> Try.of(() -> format.parse(s))).collect(toList());

      double successRatio = tries.stream().mapToDouble(t -> t.isSuccess() ? 1 : 0).average().orElse(0);

      if (successRatio >= .5) {
         List<Date> dates = tries.stream().filter(Try::isSuccess).map(Try::get).collect(toList());
         System.out.println(dates);
      } else {
//         Thread.setDefaultUncaughtExceptionHandler();
//         new ThreadPoolExecutor()
         System.err.println("OOPs");
      }

   }

//   private static Function<String, Date> wrap(FunctionThrowing<String, Date> f) {
//      return s -> {
//         try {
//            return f.apply(s);
//         } catch (Exception e) {
//            throw new RuntimeException(e);
//         }
//      };
//   }

}

//interface FunctionThrowing<T, R> {
//   R apply(T t) throws Exception;
//}
