package victor.training.exceptions;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import victor.training.exceptions.MyException.ErrorCode;
import victor.training.exceptions.model.Data;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

@Service
public class OtherService {
   private static final Logger log = LoggerFactory.getLogger(OtherService.class);

   private String greeting; // demo side-effect. never have state in a @Service!

   public void save(Data data) throws IOException {
      log.info("Start Save");
      try (Reader reader = new FileReader("spring/hello.txt")) {
         greeting = IOUtils.toString(reader);
         log.info("Read file OK");
      }
      if (data.getA().getB().getLabel() == null) {
         throw new MyException(ErrorCode.NO_NAME_PARAM);
      }
      greeting += data.getA().getB().getLabel().toUpperCase();
      log.info("Updated greeting to " + greeting);
   }

   public String receive() {
      return greeting;
   }
}
