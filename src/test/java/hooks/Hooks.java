package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.Driver;


import java.time.Duration;

public class Hooks {

    @Before()
    public void setup(){
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After()
    public void tearDown(){
       // Driver.closeDriver();
    }

}
