package com.thiago.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.thiago.core.CorePage;
import com.thiago.driver.TLDriverFactory;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PageGuruHome extends CorePage<PageGuruHome>{

	public PageGuruHome() {
		this.driver = TLDriverFactory.getDriver();
		PageFactory.initElements(this.driver, this);
	}
	@FindBy(id = "email")
	private WebElement inputEmail;
	
	@FindBy(id = "passwd")
	private WebElement inputPasswd;
	
	@FindBy(id = "SubmitLogin")
	private WebElement bntLogin;

	@FindBy(name = "cusid")
	private WebElement cusid;

	@FindBy(name = "submit")
	private WebElement sbmButton;

	@FindBy(id = "bank")
	private WebElement debitSideAccount;

	@FindBy(id = "amt7")
	private WebElement debitSideAmount;

	@FindBy(id = "loan")
	private WebElement creditSideAccount;

	@FindBy(id = "amt8")
	private WebElement creditSideAmount;

	@FindBy(id = "products")
	private WebElement draggables;

	@FindBy(xpath = "/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/input")
	private WebElement firstNameInput;

	@FindBy(xpath = "/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[3]/td[2]/input")
	private WebElement lastNameInput;

	@FindBy(xpath = "/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[4]/td[2]/input")
	private WebElement phone;

	@FindBy(xpath = "//*[@id=\"userName\"]")
	private WebElement email;

	@FindBy(xpath = "/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[7]/td[2]/input")
	private WebElement address;

	@FindBy(xpath = "/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[8]/td[2]/input")
	private WebElement city;

	@FindBy(xpath = "/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[9]/td[2]/input")
	private WebElement state;

	@FindBy(xpath = "/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[10]/td[2]/input")
	private WebElement postal;

	@FindBy(xpath = "//*[@id=\"email\"]")
	private WebElement userName;

	@FindBy(xpath = "/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[14]/td[2]/input")
	private WebElement password;

	@FindBy(xpath = "/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[15]/td[2]/input")
	private WebElement confirmPassword;

	@FindBy(xpath = "/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[17]/td/input")
	private WebElement submitButton;


	public PageGuruSucess acessarLoginGuru(String email, String senha) {
		preencherCampo(inputEmail, email);
		preencherCampo(inputPasswd, senha);
		click(bntLogin);
		return new PageGuruSucess();
	}

	public PageGuruDeleteSucess inserirUsuarioParaDelete(String usuario){
		preencherCampo(cusid, usuario);
		click(sbmButton);
		acceptAlert();

		return new PageGuruDeleteSucess();
	}

	public PageGuruDragAndDrop arrastarCampoParaCelula(){
		Actions action = new Actions(driver);

		List<WebElement> containers = new ArrayList<>(Arrays.asList(debitSideAccount, debitSideAmount, creditSideAccount, creditSideAmount));

		List<WebElement> elements = draggables.findElements(By.tagName("li"));

		for(WebElement element : elements){
			for(WebElement container : containers){
				action.clickAndHold(element)
						.moveToElement(container)
						.release(container)
						.build().perform();
			}
		}
		return new PageGuruDragAndDrop();
	}

	public PageGuruRegister register(String firstNameLabel, String lastNameLabel, String phoneLabel,
									 String emailLabel, String addressLabel, String cityLabel,
									 String stateLabel, String postalLabel, String countryLabel,
									 String userNameLabel, String passwordNameLabel, String confirmPassLabel){

		preencherCampo(firstNameInput, firstNameLabel);
		preencherCampo(lastNameInput, lastNameLabel);
		preencherCampo(phone, phoneLabel);
		preencherCampo(email, emailLabel);
		preencherCampo(address, addressLabel);
		preencherCampo(city, cityLabel);
		preencherCampo(state, stateLabel);
		preencherCampo(postal, postalLabel);

		Select dropCountry = new Select(driver.findElement(By.name("country")));
		dropCountry.selectByVisibleText(countryLabel.toUpperCase());

		preencherCampo(userName, userNameLabel);
		preencherCampo(password, passwordNameLabel);
		preencherCampo(confirmPassword, confirmPassLabel);

		click(submitButton);

		return new PageGuruRegister();
	}

}
