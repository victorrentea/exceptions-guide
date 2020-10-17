package victor.training.exceptions;

import org.springframework.stereotype.Service;
import victor.training.exceptions.model.Structure;

import java.io.FileNotFoundException;

@Service
public class OtherService {

   private String data; // demo side-effect. never have state in a @Service!

   public void send(Structure struct) throws FileNotFoundException {
      boolean unexpected = true; //set false
      if (unexpected) {
         throw new FileNotFoundException("f.txt");
      }
      data = struct.getA().getB().getLabel().toUpperCase();
   }

   public String receive() {
      return data;
   }
}
