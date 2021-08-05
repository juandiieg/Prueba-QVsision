package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Hit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userInterfaces.DevicesPage.*;

public class DevicesInfo implements Task {

    private String computer;
    private String version;
    private String language;
    private String mobile;
    private String model;
    private String os;

    public DevicesInfo(String computer, String version, String language, String mobile, String model, String os) {
        this.computer = computer;
        this.version = version;
        this.language = language;
        this.mobile = mobile;
        this.model = model;
        this.os = os;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(SLC_PC),
                Click.on(By.xpath("//div[contains(text(),'" + computer + "')]")),
                Click.on(SLC_VERSION),
                Click.on(By.xpath("//div[contains(text(),'" + version + "')]")),
                Click.on(SLC_LANGUAGE),
                // No puedo seleccionar un puto lenguaje
                //Click.on(By.xpath("//div[contains(text(),'" + language + "')]")),
                Click.on(SLC_MOBILE),
                Click.on(By.xpath("//div[contains(text(),'" + mobile + "')]")),
                Click.on(SLC_MODEL),
                Click.on(By.xpath("//div[contains(text(),'" + model + "')]")),
                Click.on(SLC_OS),
                Click.on(By.xpath("//div[contains(text(),'" + os + "')]")),
                Click.on(BTN_LAST_STEP)
        );
    }

    public static DevicesInfo fillDevicesInfo(String computer, String version, String language, String mobile, String model, String os) {
        return instrumented(DevicesInfo.class, computer, version, language, mobile, model, os);
    }
}
