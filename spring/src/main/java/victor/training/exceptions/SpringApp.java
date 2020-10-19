package victor.training.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;


@EnableAsync
@SpringBootApplication
@Slf4j
public class SpringApp {
   public static void main(String[] args) {
      SpringApplication.run(SpringApp.class, args);
   }

}

