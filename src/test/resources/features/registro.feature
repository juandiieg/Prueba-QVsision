@Cucumber 
Feature: Registrar un usuario nuevo 

	Esta feature se trata de realizar un registro de usuario

@ScenarioPruebaRegistro
Scenario: Se realiza el registro de un nuevo usuario en la web
	Given Que un nuevo usuario ingresa a la web en el modulo de registro
	When El ingresa sus datos personales Diego, Gomez, juan7732@correo.es, May, 16, 1997, spanish, Cali, 110851, Colombia al formulario  
  	Then El deberia poder confirmar el registro iniciando sesion
