package tasks;

import net.serenitybdd.screenplay.actions.*;
import org.openqa.selenium.Keys;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static userInterface.RegisterStep1.*;


public class ingresarDatosPersonales implements Task{

	private String nombre;
	private String apellido;
	private String correo;
	private String mes;
	private String dia;
	private String anio;
	private String idioma;

	

	public ingresarDatosPersonales(String nombre, String apellido, String correo, String mes, String dia, String anio,
                                   String idioma) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.mes = mes;
		this.dia = dia;
		this.anio = anio;
		this.idioma = idioma;

	}

	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(
				Enter.theValue(nombre).into(INP_FIRSTNAME),//Diligencia el nombre
				Enter.theValue(apellido).into(INP_LASTNAME),//Diligencia el apellido
				Enter.theValue(correo).into(INP_EMAIL),//Diligencia email
				SelectFromOptions.byVisibleText(mes).from(SLC_MONTH),//Selecciona el mes de nacimiento
				SelectFromOptions.byVisibleText(dia).from(SLC_DAY),//Selecciona el día de nacimiento
				SelectFromOptions.byVisibleText(anio).from(SLC_YEAR),//Selecciona el año de nacimiento
				Enter.theValue(idioma).into(INP_LANGUAGE).thenHit(Keys.ENTER),//DIligencia idiomas
				Click.on(BTN_NEXT)
				);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static ingresarDatosPersonales DiligenciarFormulario(String nombre, String apellido, String correo, String mes, String dia,
																String anio, String idioma) {

		return Instrumented.instanceOf(ingresarDatosPersonales.class).withProperties(nombre, apellido, correo, mes, dia, anio,
				idioma);
	}
}
