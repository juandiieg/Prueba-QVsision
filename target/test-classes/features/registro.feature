Feature: Crear un nuevo usuario
	Como usuario no existente
	Quiero ingresar a la pagina utest.com
	Para tener un usuario registrado

	@ScenarioPruebaRegistro
	Scenario: Registrar un nuevo usuario
		Given Que un nuevo usuario accede a la web de utest para registrarse
		When El ingresa sus datos personales Diego, Gomez, juan7732@correo.es, May, 16, 1997, spanish al formulario
		And El ingresa sus datos de residencia Cali, 110851, Ecuador al formulario
		And El ingresa la información de los dispositivos Linux, Ubuntu, Bulgarian, y Wiko, Y61, Android 10
      #| computer | version | language | mobile | model | os |
      #| Linux    | Ubuntu  | english  | LG     | Leon  | Android 6 |
		Then el puede iniciar sesión con el usuario creado