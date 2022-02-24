package com.thiago.page;

import com.thiago.core.CorePage;
import com.thiago.driver.TLDriverFactory;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;

public class PageGuruDeleteSucess extends CorePage<PageGuruDeleteSucess>{

	public PageGuruDeleteSucess() {
		this.driver = TLDriverFactory.getDriver();
		PageFactory.initElements(this.driver, this);
	}
	
	public void validarDeleteOK() throws InterruptedException {
		Assert.assertEquals("Customer Successfully Delete!", getAlert());
		acceptAlert();
	}
}
