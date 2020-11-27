package victor.training.exceptions;

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
      List<Date> dates = dateList.stream().map(Unchecked.function(format::parse)).collect(toList());
      System.out.println(dates);
   }

}
