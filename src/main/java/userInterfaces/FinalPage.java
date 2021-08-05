package userInterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class FinalPage{
    public final static Target TXT_WELCOME = Target.the("Mensaje de bienvenida").located(By.xpath("//h1"));
}
