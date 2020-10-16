package victor.training.exceptions;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.*;

@Slf4j
public class ExceptionsVsAsync {

   public static void main(String[] args) {
      new ExceptionsVsAsync().run();
   }

   private void run() {
      Integer integer = expensiveTask();

      System.out.println(integer);
   }

   public Integer expensiveTask() {
      if (true) {
         throw new RuntimeException("Surprise!");
      }
      return 1;
   }
}
