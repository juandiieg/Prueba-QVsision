package userInterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

import net.serenitybdd.screenplay.targets.Target;

@DefaultUrl("https://utest.com/")
public class HomePage extends PageObject {
    public static final Target BTN_BECOME = Target.the("Become a uTester button")
            .locatedBy("//*[@id=\"mainContent\"]/div[1]/div[2]/div/a");
}
