package victor.training.exceptions;

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

      ThrowingFunction<String, Date> p = s -> format.parse(s);
      Function<String, Date> f = wrapAsRuntime(p); // TODO
      List<Date> dates = dateList.stream().map(f).collect(toList());
      System.out.println(dates);
   }

   private static <T,R> Function<T, R> wrapAsRuntime(ThrowingFunction<T, R> p) {
      return t -> {
         try {
            return p.apply(t);
         } catch (Exception e) {
            throw new RuntimeException(e);
         }
      };
   }

   interface ThrowingFunction<T,R> {
      R apply(T t) throws Exception;
   }

}
