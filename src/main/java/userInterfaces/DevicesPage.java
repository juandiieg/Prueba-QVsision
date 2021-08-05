package userInterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DevicesPage {
    public static final Target SLC_PC = Target.the("Pc reference selector")
            .locatedBy("//*[@id=\"web-device\"]/div[1]/div[2]/div/div[1]/span");
    public static final Target SLC_VERSION = Target.the("Pc version selector")
            .locatedBy("//*[@id=\"web-device\"]/div[2]/div[2]/div/div[1]/span");
    public static final Target SLC_LANGUAGE = Target.the("Pc language selector")
            .locatedBy("//*[@id=\"web-device\"]/div[3]/div[2]/div/div[1]/span");
    public static final Target SLC_MOBILE = Target.the("Mobile reference selector")
            .locatedBy("//*[@id=\"mobile-device\"]/div[1]/div[2]/div/div[1]/span");
    public static final Target SLC_MODEL = Target.the("Mobile model selector")
            .locatedBy("//*[@id=\"mobile-device\"]/div[2]/div[2]/div/div[1]/span");
    public static final Target SLC_OS = Target.the("Mobile operating system selector")
            .locatedBy("//*[@id=\"mobile-device\"]/div[3]/div[2]/div/div[1]/span");
    public static final Target BTN_LAST_STEP = Target.the("Button to next last step")
            .located(By.xpath("//*[@id=\"regs_container\"]/div/div[2]/div/div[2]/div/div[2]/div/a"));
}
