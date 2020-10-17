package victor.training.exceptions;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import victor.training.exceptions.model.A;
import victor.training.exceptions.model.B;
import victor.training.exceptions.model.Data;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class HelloService {
   private final OtherService otherService;

   public String hello(String agent) {
      B b = new B();
      Data data = new Data(new A(b));
      deeper(data);
      // more code
      return otherService.receive();
   }






   private void deeper(Data data) {
      // more code
      andDeeper(data);
      // more code
   }








   private void andDeeper(Data data) {
      long interestingId = data.hashCode();
      // more code
      andEvenDeeper(data);
      // more code
   }








   private void andEvenDeeper(Data data) {
      // more code
      after1HourOfReading(data);
      // more code
   }











   private void after1HourOfReading(Data data) {
      try {
         otherService.send(data);
      } catch (IOException e) {
         // Argh! Leave me alone!
      }
   }
}
