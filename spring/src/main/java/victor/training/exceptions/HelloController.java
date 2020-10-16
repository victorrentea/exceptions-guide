package victor.training.exceptions;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
@RequiredArgsConstructor
class HelloController {
   private final HelloService service;

   @GetMapping("hello")
   public String hello() {
      return service.hello();
   }
}
