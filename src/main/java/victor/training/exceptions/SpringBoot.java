package victor.training.exceptions;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.util.ErrorHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import victor.training.exceptions.model.Customer;
import victor.training.exceptions.model.MemberCard;
import victor.training.exceptions.model.Order;

import java.util.Date;


@SpringBootApplication
@Slf4j
@RequiredArgsConstructor
@RestController
public class SpringBoot   {
   public static void main(String[] args) {
      SpringApplication.run(SpringBoot.class, args);
   }
   private final Biz biz;
   @GetMapping
   public void exceptional() {
      Order order = new Order(new Date()).setPrice(1000);

      biz.applyDiscount(order, new Customer().setMemberCard(new MemberCard()));

      System.out.println("Final Price " + order.getPrice());
   }

//   {
//      ThreadPoolTaskScheduler pool = new ThreadPoolTaskScheduler();
//
//      pool.setErrorHandler(new ErrorHandler() {
//         @Override
//         public void handleError(Throwable t) {
//            log.error("Boo boo (stack trace on TRACE level) " + t.getMessage());
//            log.trace("Full Stack : ", t);
//         }
//      });
//   }
}
