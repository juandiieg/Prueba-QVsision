package userInterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LastStepPage{

    public static final Target INP_PASS = Target.the("Password Input").located(By.id("password"));
    public static final Target INP_CONFIRM_PASS = Target.the("Confirm password Input").located(By.id("confirmPassword"));
    public static final Target CHK_STAY_INFO = Target.the("Stay informed checkbox")
            .locatedBy("//*[@id=\"regs_container\"]/div/div[2]/div/div[2]/div/form/div[4]/label/span");
    public static final Target CHK_TERMS = Target.the("Terms of use checkbox")
            .locatedBy("//*[@id=\"regs_container\"]/div/div[2]/div/div[2]/div/form/div[5]/label/span[1]");
    public static final Target CHK_POLICY = Target.the("Security policy checkbox")
            .locatedBy("//*[@id=\"regs_container\"]/div/div[2]/div/div[2]/div/form/div[6]/label/span[1]");
    public static final Target BTN_SETUP = Target.the("Complete setup button").located(By.id("laddaBtn"));
}
