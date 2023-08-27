package hooks;

import baseClass.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BaseClass  {

    @Before
    public void beforeScenario(){
        launchBrowser();
    }

    @After
    public void afterScenario(){
        quit();
    }
}