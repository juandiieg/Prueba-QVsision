package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.containsText;

import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static userInterfaces.DevicesPage.*;

public class FillDevicesInfo implements Task {

    private String computer;
    private String version;
    private String language;
    private String mobile;
    private String model;
    private String os;

    public FillDevicesInfo(String computer, String version, String language, String mobile, String model, String os) {
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
                Click.on(By.xpath("//div[contains(text(),'"+ language +"')]")),
                Click.on(SLC_MOBILE),
                Click.on(By.xpath("//div[contains(text(),'" + mobile + "')]")),
                Click.on(SLC_MODEL),
                Click.on(By.xpath("//div[contains(text(),'" + model + "')]")),
                Click.on(SLC_OS),
                Click.on(By.xpath("//div[contains(text(),'" + os + "')]"))
        );
        actor.should(
                seeThat(the(By.xpath("//span[contains(text(),'"+ computer +"')]")), containsText(computer)),
                seeThat(the(By.xpath("//span[contains(text(),'" + version + "')]")), containsText(version)),
                seeThat(the(By.xpath("//span[contains(text(),'" + language + "')]")), containsText(language)),
                seeThat(the(By.xpath("//span[contains(text(),'" + mobile + "')]")), containsText(mobile)),
                seeThat(the(By.xpath("//span[contains(text(),'" + model + "')]")), containsText(model)),
                seeThat(the(By.xpath("//span[contains(text(),'" + os + "')]")), containsText(os))
        );
        actor.attemptsTo(
                Click.on(BTN_LAST_STEP)
        );
    }

    public static FillDevicesInfo fillInfo(String computer, String version, String language, String mobile, String model, String os) {
        return instrumented(FillDevicesInfo.class, computer, version, language, mobile, model, os);
    }
}
