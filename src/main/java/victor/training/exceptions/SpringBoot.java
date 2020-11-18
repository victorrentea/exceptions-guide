package victor.training.exceptions;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import victor.training.exceptions.model.Customer;
import victor.training.exceptions.model.Order;


@SpringBootApplication
@Slf4j
@RequiredArgsConstructor
@RestController
public class SpringBoot  {
   public static void main(String[] args) {
      SpringApplication.run(SpringBoot.class, args);
   }
   private final Biz biz;
   @GetMapping
   public void exceptional() {
      biz.applyDiscount(new Order(), new Customer());
   }
}
