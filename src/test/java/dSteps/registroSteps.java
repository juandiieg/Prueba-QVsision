package dSteps;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;
import tasks.ingresarDatos;
//import userInterface.HomePage;
//import tasks.ingresarDatos;

public class registroSteps {

	@Managed(driver = "chrome")
	private WebDriver browser;
	private Actor actor = Actor.named("Diego");
//	private HomePage homePage = new HomePage();

	@Given("^Que un nuevo usuario ingresa a la web en el modulo de registro$")
	public void queUnNuevoUsuarioIngresaALaWebEnElModuloDeRegistro() {
		actor.can(BrowseTheWeb.with(browser));
		browser.manage().window().maximize();
		actor.wasAbleTo(Open.url("https://utest.com/signup/personal"));
	}

	@When("^El ingresa sus datos personales(.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*) al formulario$")
	public void elIngresaSusDatosPersonales(String nombre, String apellido, String correo, String mes, String dia,
			String anio, String idioma, String ciudad, String postal, String pais) {
		actor.wasAbleTo(ingresarDatos.llenarFormulario(nombre, apellido, correo, mes, dia, anio, idioma, ciudad, postal, pais));

	}

	@Then("^El deberia poder confirmar el registro iniciando sesion$")
	public void elDeberiaPoderConfirmarElRegistroIniciandoSesion() {

	}

}
