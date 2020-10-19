package victor.training.exceptions;

import org.springframework.stereotype.Repository;

import java.util.List;

import static java.util.Arrays.asList;

@Repository
public class UserRepo {
   public Long findIdByUsername(String username) {
      return 13L;
   }
}
