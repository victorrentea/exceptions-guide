package victor.training.exceptions;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import victor.training.exceptions.model.A;
import victor.training.exceptions.model.B;
import victor.training.exceptions.model.Data;

import java.io.IOException;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class HelloService {
   private final OtherService otherService;

   public String hello(String name) {
      B b = new B();
      Data data = new Data(new A(b));
      deeper(data);
      // more code
      return "Greeting: " + otherService.receive();
   }






   private void deeper(Data data) {
      // more code
      andDeeper(data);
      // more code
   }








   private void andDeeper(Data data) {
      Long interestingId = 13L; //critical for understanding the error
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
         otherService.save(data);
      } catch (Exception e) {
         // FileNotFound is imposible! Argh! Leave me alone!
      }
   }
}
