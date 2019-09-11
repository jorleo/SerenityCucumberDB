package com.automation.capacitacion.stepdefinitions;

import java.util.Map;

import org.junit.Assert;

import com.automation.capacitacion.mysql.Operaciones;
import com.automation.capacitacion.steps.LoginStep;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.thucydides.core.annotations.Steps;

public class LoginStepdefinitions {
	
	@Steps
	LoginStep stepLogin;
	Operaciones operaciones;

	@Dado("^que estoy en la página de inicio de sesión$")
	public void thatIAmInTheLoginPage() {
	    stepLogin.openUrl();
	}

	@Cuando("^ingreso los datos del (.*)$")
	public void iTypeTheData(int idUser) {
		operaciones = new Operaciones();
		//Map<String, String> datosUser = operaciones.ejecutarSP(idUser);
		Map<String, String> datosUser = operaciones.ejecutarConsulta(idUser);
	    stepLogin.login(datosUser.get("usuario"), datosUser.get("password"));
	}

	@Entonces("^yo ingreso a la aplicación$")
	public void iEnterTheApplication() {
	    Assert.assertFalse("Error de inicio de sesión!", stepLogin.validate());
	}
	
}
