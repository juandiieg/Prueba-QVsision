package userInterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class RegisterStep2 extends PageObject {
    public static final Target INP_CITY = Target.the("City Input").located(By.id("city"));
    public static final Target INP_ZIP = Target.the("Zip or Postal Code Input").located(By.id("zip"));
    public static final Target SLC_COUNTRY = Target.the("Country Selection").located(By.xpath(
            "//body/ui-view[1]/main[1]/section[1]/div[1]/div[2]/div[1]/div[2]/div[1]/form[1]/div[1]/div[3]/div[1]/div[4]/div[2]/div[1]/div[1]/div[1]/span[1]"));
    public static final Target SLC_COUNTRY2 = Target.the("Country Selection").located(By.xpath(
            "//span[contains(text(),'Ecuador')]"));
    public static final Target BTN_NEXT2 = Target.the("Next Devices boton")
            .located(By.xpath("//span[contains(text(),'Next: Devices')]"));
}
