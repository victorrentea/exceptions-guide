package victor.training.exceptions;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;

@Service
@RequiredArgsConstructor
public class HelloService {
   private final OtherService otherService;

   public String hello() {
      try {
         otherService.send();
      } catch (FileNotFoundException e) {
         // Argh! Leave me alone!
      }
      return otherService.receive();
   }
}
