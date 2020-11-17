package victor.training.exceptions;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@Slf4j
@RequiredArgsConstructor
public class SpringBoot  {
   public static void main(String[] args) {
      SpringApplication.run(SpringBoot.class, args);
   }
}

@Slf4j
@RestController
@RequiredArgsConstructor
class ExceptionalController {
   private final Biz biz;
   @GetMapping
   public void exceptional() {
      biz.applyDiscount(new Order(), new Customer());
   }
}
