package userInterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LocationPage {
    public static final Target INP_CITY = Target.the("City Input").located(By.id("city"));
    public static final Target INP_ZIP = Target.the("Zip or Postal Code Input").located(By.id("zip"));
    public static final Target SLC_COUNTRY = Target.the("Country Selection").located(By.xpath(
            "//body/ui-view[1]/main[1]/section[1]/div[1]/div[2]/div[1]/div[2]/div[1]/form[1]/div[1]/div[3]/div[1]/div[4]/div[2]/div[1]/div[1]/div[1]/span[1]"));
    public static final Target BTN_DEVICES = Target.the("Next to Devices section button")
            .located(By.xpath("//span[contains(text(),'Next: Devices')]"));
}
