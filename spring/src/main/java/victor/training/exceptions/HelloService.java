package victor.training.exceptions;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import victor.training.exceptions.model.A;
import victor.training.exceptions.model.B;
import victor.training.exceptions.model.Structure;

import java.io.FileNotFoundException;

@Service
@RequiredArgsConstructor
public class HelloService {
   private final OtherService otherService;

   public String hello() {
      try {
         otherService.send(new Structure(new A(new B())));
      } catch (FileNotFoundException e) {
         // Argh! Leave me alone!
      }
      return otherService.receive();
   }
}
