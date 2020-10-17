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
      return otherService.receive();
   }






   private void deeper(Data data) {
      andDeeper(data);
   }








   private void andDeeper(Data data) {
      andEvenDeeper(data);
   }








   private void andEvenDeeper(Data data) {
      after1HourOfReading(data);
   }











   private void after1HourOfReading(Data data) {
      try {
         otherService.send(data);
      } catch (IOException e) {
         // Argh! Leave me alone!
      }
   }
}
