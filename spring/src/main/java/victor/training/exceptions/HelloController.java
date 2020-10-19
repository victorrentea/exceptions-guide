package victor.training.exceptions;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;

@Slf4j
@RestController
@RequiredArgsConstructor
class HelloController {
   private final HelloService service;

   @GetMapping
   public String hello(@RequestParam String name) {
      return service.hello(name);
   }
}
