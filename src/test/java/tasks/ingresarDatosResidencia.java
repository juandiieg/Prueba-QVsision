package tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static userInterface.RegisterStep2.*;

public class ingresarDatosResidencia implements Task {


    private  String ciudad;
    private  String postal;
    private  String pais;

    public ingresarDatosResidencia(String ciudad, String postal, String pais) {
        this.ciudad = ciudad;
        this.postal = postal;
        this.pais = pais;
    }

    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(ciudad).into(INP_CITY),
                Hit.the(Keys.DOWN).into(INP_CITY),
                Hit.the(Keys.ENTER).into(INP_CITY),
                Clear.field(INP_ZIP),
                Enter.theValue(postal).into(INP_ZIP),
                Click.on(SLC_COUNTRY),
                Click.on(By.xpath("//div[contains(text(),'"+ pais +"')]")),
//				Click.on(SLC_COUNTRY2.of(pais)),
                Click.on(BTN_NEXT2)
        );
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static ingresarDatosResidencia DiligenciarFormulario(String ciudad, String postal, String pais) {

        return Instrumented.instanceOf(ingresarDatosResidencia.class).withProperties(ciudad, postal, pais);
    }
}
