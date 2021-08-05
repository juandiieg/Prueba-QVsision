package tasks;

import net.serenitybdd.screenplay.actions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import userInterface.RegisterObjects;

//import static net.serenitybdd.screenplay.Task.instrumented;

public class ingresarDatos implements Task {

	private String nombre;
	private String apellido;
	private String correo;
	private String mes;
	private String dia;
	private String anio;
	private String idioma;
	private String ciudad;
	private String postal;
	private String pais;
	

	public ingresarDatos(String nombre, String apellido, String correo, String mes, String dia, String anio,
			String idioma, String ciudad, String postal, String pais) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.mes = mes;
		this.dia = dia;
		this.anio = anio;
		this.idioma = idioma;
		this.ciudad = ciudad;
		this.postal = postal;
		this.pais = pais;
	}

	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(
				Enter.theValue(nombre).into(RegisterObjects.INP_FIRSTNAME),//Diligencia el nombre
				Enter.theValue(apellido).into(RegisterObjects.INP_LASTNAME),//Diligencia el apellido
				Enter.theValue(correo).into(RegisterObjects.INP_EMAIL),//Diligencia email
				SelectFromOptions.byVisibleText(mes).from(RegisterObjects.SLC_MONTH),//Selecciona el mes de nacimiento
				SelectFromOptions.byVisibleText(dia).from(RegisterObjects.SLC_DAY),//Selecciona el día de nacimiento
				SelectFromOptions.byVisibleText(anio).from(RegisterObjects.SLC_YEAR),//Selecciona el año de nacimiento
				Enter.theValue(idioma).into(RegisterObjects.INP_LANGUAGE).thenHit(Keys.ENTER)//DIligencia idiomas
				Click.on(RegisterObjects.BTN_NEXT),
				Clear.field(RegisterObjects.INP_CITY),
				Enter.theValue(ciudad).into(RegisterObjects.INP_CITY),
				Hit.the(Keys.DOWN).into(RegisterObjects.INP_CITY),
				Hit.the(Keys.ENTER).into(RegisterObjects.INP_CITY),
				Clear.field(RegisterObjects.INP_ZIP),
				Enter.theValue(postal).into(RegisterObjects.INP_ZIP),
				Click.on(RegisterObjects.SLC_COUNTRY),
				Click.on(By.xpath("//div[contains(text(),'"+ pais +"')]")),
				Click.on(RegisterObjects.BTN_NEXT2)
				);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static ingresarDatos llenarFormulario(String nombre, String apellido, String correo, String mes, String dia,
			String anio, String idioma, String ciudad, String postal, String pais) {

		return Instrumented.instanceOf(ingresarDatos.class).withProperties(nombre, apellido, correo, mes, dia, anio,
				idioma, ciudad, postal, pais);
	}
}
