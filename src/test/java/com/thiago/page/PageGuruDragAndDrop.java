package com.thiago.page;

import com.thiago.core.CorePage;
import com.thiago.driver.TLDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PageGuruDragAndDrop extends CorePage<PageGuruDragAndDrop>{

	public PageGuruDragAndDrop() {
		this.driver = TLDriverFactory.getDriver();
		PageFactory.initElements(this.driver, this);
	}
	
	public void validarPerfeito() throws InterruptedException {

		WebElement perfeito = getElement(By.id("equal"));
		aguardarElementoVisivel(perfeito);
	}
}
