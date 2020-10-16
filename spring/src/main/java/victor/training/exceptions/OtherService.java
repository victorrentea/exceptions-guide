package victor.training.exceptions;

import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;

@Service
public class OtherService {

   private String data; // demo side-effect. never have state in a @Service!

   public String receive() {
      return data;
   }

   public void send() throws FileNotFoundException {
      boolean unexpected = true;
      if (unexpected) {
         throw new FileNotFoundException("f.txt");
      }
      data = "Hi!";
   }
}
