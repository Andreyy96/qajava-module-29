import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PersonTest {

    public void currentTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyy/mm/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Время начала теста");
        currentTime();
    }

    @DataProvider(name = "AgeTeenager")
    public Object[][] AgeTeenager() {
        return new Object[][]{
                {-2, false},
                {0, false},
                {5, false},
                {12, false},
                {13, false},
                {14, true},
                {15, true},
                {16, true},
                {17, true},
                {18, true},
                {19, false},
                {21, false}
        };
    }

    @Test(dataProvider = "AgeTeenager")
    public void isTeenagerTest (int age, boolean expected){
        boolean result = Person.isTeenager(age);
        Assert.assertEquals(result, expected);
    }

    @AfterTest()
    public void afterTest() {
       System.out.println("Конец теста");
       currentTime();
   }
}





