package dSteps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import tasks.FillBasicInfo;
import tasks.FillDevicesInfo;
import tasks.FillLocationInfo;
import userInterfaces.HomePage;

import static userInterfaces.HomePage.BTN_BECOME;

public class registroSteps {

	@Managed(driver = "chrome")
	private WebDriver browser;
	private Actor actor = Actor.named("Diego");
	private HomePage homePage = new HomePage();

	@Given("^Que un nuevo usuario accede a la web de utest para registrarse$")
	public void queUnNuevoUsuarioAccedeLaWebDeUtest() {
		actor.can(BrowseTheWeb.with(browser));
		browser.manage().window().maximize();
		actor.wasAbleTo(Open.browserOn(homePage));
		actor.wasAbleTo(Click.on(BTN_BECOME));
	}

	@When("^El ingresa sus datos personales(.*), (.*), (.*), (.*), (.*), (.*), (.*) al formulario$")
	public void elIngresaSusDatosPersonales(String name, String lastname, String email, String month,
											String day, String year, String language) {
		actor.wasAbleTo(
				FillBasicInfo.fillInfo(name, lastname, email, month, day, year, language)
		);
	}

	@And("^El ingresa sus datos de residencia (.*), (.*), (.*) al formulario$")
	public void elIngresaSusDatosDeResidencia(String city, String postal, String country) {
		actor.wasAbleTo(
				FillLocationInfo.fillLocationInfo(city, postal, country)
		);
	}

	@And("^El ingresa la información de los dispositivos (.*), (.*), (.*) y (.*), (.*), (.*)$")
	public void elIngresaLaInformaciónDeLosDispositivos(String computer, String version, String language,
														String mobile, String model, String os) {
		actor.wasAbleTo(
				FillDevicesInfo.fillInfo(computer, version, language, mobile, model, os)
		);
	}

	@Then("^el puede iniciar sesión con el usuario creado$")
	public void elPuedeIniciarSesionConElUsuarioCreado() {
	}

}
