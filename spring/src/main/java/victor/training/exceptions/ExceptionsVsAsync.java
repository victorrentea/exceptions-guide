package victor.training.exceptions;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExceptionsVsAsync {
   // 1: Executors - throw
   // 2: return+future
   // 3: SpringBootApp + async + completable futures
   // 4: completable Future. thenApply( mult 2).exceptionally(-1)
   public static void main(String[] args) throws ExecutionException, InterruptedException {
      ExecutorService pool = Executors.newFixedThreadPool(2);
      Future<Integer> f = pool.submit(() -> {
         return task();
      });
      Integer integer = f.get();
      System.out.println("Done");
   }

   private static int task() {
      if (true) {
         throw new RuntimeException();
      }
      return 1          ;
   }
}
