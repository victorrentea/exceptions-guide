package victor.training.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;


@SpringBootApplication
@Slf4j
public class SpringBoot {
   public static void main(String[] args) {
      SpringApplication.run(SpringBoot.class, args);
   }

}

