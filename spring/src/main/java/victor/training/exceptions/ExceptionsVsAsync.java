package victor.training.exceptions;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class ExceptionsVsAsync {
   private final Other other;



   @PostConstruct
   public void init() throws ExecutionException, InterruptedException {
      other.task()
          .thenApplyAsync(i -> {
             log.debug("Duplicate");
             return i * 2;
          })
          .exceptionally(t -> -1)
          .thenAccept(i -> {
             log.debug("Got " + i);
          });
      System.out.println("Done");
   }

}

@Component
class Other {

   @Async
   public CompletableFuture<Integer> task() {
      System.out.println("BUM");
      if (true) {
         throw new RuntimeException("UAAAA");
      }
      return CompletableFuture.completedFuture(1);
   }
}
