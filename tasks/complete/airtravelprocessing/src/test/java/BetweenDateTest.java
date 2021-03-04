
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import testing.DataFiltering;

import java.time.LocalDateTime;

public class BetweenDateTest {
    @Test
    void betweenDateTest(){
        DataFiltering df = new DataFiltering();
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime nowPlusTwoHour = LocalDateTime.now().plusHours(2);
        int actual = df.between(now,nowPlusTwoHour);
        Assertions.assertEquals(2,actual,"Часы не совпали");
    }
}
