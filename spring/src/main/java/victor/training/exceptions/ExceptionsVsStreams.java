package victor.training.exceptions;

import io.vavr.control.Try;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class ExceptionsVsStreams {

   public static void main(String[] args) {
      String[] arr = {"2020-10-10", "2020-10-x11", "2020-10-x11", "2020-10-x11", "2020-10-11"};
      System.out.println(new ExceptionsVsStreams().method(arr));
   }


   public List<Date> method(String[] strings) {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      List<Try<Date>> tries = Stream.of(strings)
          .map(source -> parse(sdf, source))
          .collect(toList());

      List<String> errors = tries.stream()
          .filter(Try::isFailure)
          .map(Try::getCause)
          .map(Throwable::getMessage)
          .collect(toList());
      if (errors.size() > strings.length / 2) {
         throw new IllegalArgumentException("Majority failure" + errors.toString());
      }

      return tries.stream().filter(Try::isSuccess).map(Try::get).collect(toList());


   }

   private Try<Date> parse(SimpleDateFormat sdf, String source) {
      return Try.of(() -> sdf.parse(source));
   }
}
