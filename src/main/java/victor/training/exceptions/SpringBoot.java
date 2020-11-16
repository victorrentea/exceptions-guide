package victor.training.exceptions;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;


@SpringBootApplication
@Slf4j
@RequiredArgsConstructor
public class SpringBoot implements CommandLineRunner {
   public static void main(String[] args) {
      SpringApplication.run(SpringBoot.class, args);
   }
   private final Biz biz;


   @Override
   public void run(String... args) {
      biz.applyDiscount(new Order(), new Customer());
   }
}

