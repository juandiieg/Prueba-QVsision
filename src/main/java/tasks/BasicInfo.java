package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userInterfaces.BasicInfoPage.*;

public class BasicInfo implements Task {

    private String name;
    private String lastname;
    private String email;
    private String month;
    private String day;
    private String year;
    private String language;

    public BasicInfo(String name, String lastname, String email, String month, String day, String year, String language) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.month = month;
        this.day = day;
        this.year = year;
        this.language = language;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(name).into(INP_FIRSTNAME),
                Enter.theValue(lastname).into(INP_LASTNAME),
                Enter.theValue(email).into(INP_EMAIL),
                SelectFromOptions.byVisibleText(month).from(SLC_MONTH),
                SelectFromOptions.byVisibleText(day).from(SLC_DAY),
                SelectFromOptions.byVisibleText(year).from(SLC_YEAR),
                Enter.theValue(language).into(INP_LANGUAGE).thenHit(Keys.ENTER),
                Click.on(BTN_LOCATION)
        );
        /*
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

         */
    }

    public static BasicInfo fillBasicInfo(String name, String lastname, String email, String month,
                                          String day, String year, String language) {
        return instrumented(BasicInfo.class, name, lastname, email, month, day, year, language);
    }
}
