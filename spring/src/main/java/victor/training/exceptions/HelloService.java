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
      b.setInitials(name.toUpperCase().substring(0,1));
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







   @Autowired
   private UserRepo userRepo;

   private void andDeeper(Data data) {
      Long userId = userRepo.findIdByUsername(data.getA().getB().getLabel());
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
      } catch (IOException e) {
         // Argh! Leave me alone!
      }
   }
}
