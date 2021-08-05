package userInterface;

import org.openqa.selenium.By;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class RegisterStep1 extends PageObject {
	public static final Target INP_FIRSTNAME = Target.the("First Name Input").located(By.id("firstName"));
	public static final Target INP_LASTNAME = Target.the("Last Name Input").located(By.id("lastName"));
	public static final Target INP_EMAIL = Target.the("Email Input").located(By.id("email"));
	public static final Target SLC_MONTH = Target.the("birthMonth selection").located(By.id("birthMonth"));
	public static final Target SLC_DAY = Target.the("birthDay selection").located(By.id("birthDay"));
	public static final Target SLC_YEAR = Target.the("birthYear selection").located(By.id("birthYear"));
	public static final Target INP_LANGUAGE = Target.the("Language Input").located(By.xpath(
			"//body/ui-view[1]/main[1]/section[1]/div[1]/div[2]/div[1]/div[2]/div[1]/form[1]/div[1]/div[3]/div[5]/div[2]/div[1]/input[1]"));
	public static final Target BTN_NEXT = Target.the("Next location boton").located(By.xpath("//span[contains(text(),'Next: Location')]"));
	

}
