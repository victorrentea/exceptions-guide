package victor.training.exceptions;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import victor.training.exceptions.model.Data;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

@Service
public class OtherService {
   private static final Logger log = LoggerFactory.getLogger(OtherService.class);

   private String data; // demo side-effect. never have state in a @Service!

   public void save(Data data) throws IOException {
      try (Reader reader = new FileReader("spring/helo.txt")) {
         this.data = IOUtils.toString(reader);
         log.info("Read file");
      }
      this.data += data.getA().getB().getLabel().toUpperCase();
   }

   public String receive() {
      return data;
   }
}
