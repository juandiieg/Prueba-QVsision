package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.containsText;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.hasValue;
import static userInterfaces.BasicInfoPage.*;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class FillBasicInfo implements Task {

    private String name;
    private String lastname;
    private String email;
    private String month;
    private String day;
    private String year;
    private String language;

    public FillBasicInfo(String name, String lastname, String email, String month, String day, String year, String language) {
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
                Enter.theValue(language).into(INP_LANGUAGE).thenHit(Keys.ENTER)
        );
        actor.should(
                seeThat(the(INP_FIRSTNAME), hasValue(name)),
                seeThat(the(INP_LASTNAME), hasValue(lastname)),
                seeThat(the(INP_EMAIL), hasValue(email)),
                seeThat(the(SLC_MONTH), containsText(month)),
                seeThat(the(SLC_DAY), containsText(day)),
                seeThat(the(SLC_YEAR), containsText(year))
        );
        actor.attemptsTo(
                Click.on(BTN_LOCATION)
        );

    }

    public static FillBasicInfo fillInfo(String name, String lastname, String email, String month,
                                         String day, String year, String language) {
        return instrumented(FillBasicInfo.class, name, lastname, email, month, day, year, language);
    }
}
