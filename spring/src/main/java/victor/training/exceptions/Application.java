package victor.training.exceptions;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.lang.reflect.Method;


@EnableAsync
@SpringBootApplication
@Slf4j
public class Application implements AsyncConfigurer {
   public static void main(String[] args) {
      SpringApplication.run(Application.class, args);
   }

   @Override
   public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
      return new AsyncUncaughtExceptionHandler() {
         @Override
         public void handleUncaughtException(Throwable ex, Method method, Object... params) {
            System.err.println("Async exception " + ex);
         }
      };
   }
}

