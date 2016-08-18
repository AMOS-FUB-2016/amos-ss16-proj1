package de.fuberlin.chaostesting;

import java.util.Date;

import de.fuberlin.chaostesting.hibernate.Test;
import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.validation.Validate;
import net.sourceforge.stripes.validation.ValidationErrors;

@UrlBinding("/newTest.action")
public class TestAction implements ActionBean {

	ActionBeanContext context;
	
	String von;
	String nach;
	Date hinfahrt;
	String reisende;
	String klasse;
	String preis;
	String result;
	
	@Override
	public void setContext(ActionBeanContext context) {
		this.context = context;
	}

	@Override
	public ActionBeanContext getContext() {
		return context;
	}
	
	public String getVon() {
		return von;
	}

	public void setVon(String von) {
		this.von = von;
	}

	public String getNach() {
		return nach;
	}

	public void setNach(String nach) {
		this.nach = nach;
	}

	public Date getHinfahrt() {
		return hinfahrt;
	}

	public void setHinfahrt(Date hinfahrt) {
		this.hinfahrt = hinfahrt;
	}

	public String getReisende() {
		return reisende;
	}

	public void setReisende(String reisende) {
		this.reisende = reisende;
	}

	public String getKlasse() {
		return klasse;
	}

	public void setKlasse(String klasse) {
		this.klasse = klasse;
	}

	public String getPreis() {
		return preis;
	}

	public void setPreis(String preis) {
		this.preis = preis;
	}
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@DefaultHandler
	public Resolution createTest() {
		new Test(von, nach, hinfahrt, reisende, klasse, preis).register();
		setResult("Test-Definition erfolgreich");
		return new ForwardResolution("/testDefinition.jsp");
	}
	
	@Validate(on="senden")
	public void validateInput(ValidationErrors errors){
		
	}
}
