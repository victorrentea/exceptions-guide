package victor.training.exceptions;

import io.vavr.control.Try;
import org.jooq.lambda.Unchecked;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

public class ExceptionsVsStreams {

   public static void main(String[] args) {
      List<String> dateStr = asList("2020-10-11", "2020-nov-12", "2020-12-01");
      SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

      // ====== jool ======


      // ====== vavr: Accept if >= 50% parseable =====
   }

}
