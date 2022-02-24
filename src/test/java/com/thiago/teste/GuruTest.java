package com.thiago.teste;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.thiago.core.InvokedMethodListener;
import com.thiago.page.PageGuruHome;
 
@Listeners(InvokedMethodListener.class)
public class GuruTest{

	private final String loginPath = "http://demo.guru99.com/test/login.html";
	private final String deletePath = "http://demo.guru99.com/test/delete_customer.php";
	private final String dragAndDropPath = "https://demo.guru99.com/test/drag_drop.html";
	private final String register = "https://demo.guru99.com/test/newtours/register.php";

    @Test
    public void loginSucesso() throws Exception {
    	new PageGuruHome()
    	.openPage(PageGuruHome.class, loginPath)
    	.acessarLoginGuru("guru@gmail.com", "123")
    	.validarAcessoOK();
    }

    @Test
	public void deleteCustomer() throws Exception {
    	new  PageGuruHome()
				.openPage(PageGuruHome.class, deletePath)
				.inserirUsuarioParaDelete("automação")
				.validarDeleteOK();
	}

	@Test
	public void dragAndDrop() throws Exception {
		new  PageGuruHome()
				.openPage(PageGuruHome.class, dragAndDropPath)
				.arrastarCampoParaCelula()
				.validarPerfeito();
	}

	@Test
	public void cadastrar() throws Exception {
		new  PageGuruHome()
				.openPage(PageGuruHome.class, register)
				.register(
					"Kelvin",
						"Alvarenga",
						"99999999999",
						"xyz@gmail.com",
						"rua teste 33",
						"Joao Pessoa",
						"Paraiba",
						"99999-999",
						"Brazil",
						"abc",
						"def",
						"def")
				.validarRegister("def", "def");
	}
}