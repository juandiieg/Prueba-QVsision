package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userInterfaces.LocationPage.*;

public class LocationInfo implements Task {

    private String city;
    private String postal;
    private String country;

    public LocationInfo(String city, String postal, String country) {
        this.city = city;
        this.postal = postal;
        this.country = country;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(city).into(INP_CITY),
                Hit.the(Keys.DOWN).into(INP_CITY),
                Hit.the(Keys.ENTER).into(INP_CITY),
                Clear.field(INP_ZIP),
                Enter.theValue(postal).into(INP_ZIP),
                Click.on(SLC_COUNTRY),
                Click.on(By.xpath("//div[contains(text(),'" + country + "')]")),
                Click.on(BTN_DEVICES)
        );
    }

    public static LocationInfo fillLocationInfo(String city, String postal, String country) {
        return instrumented(LocationInfo.class, city, postal, country);
    }
}
