package br.csantos.tp3melhorespraticas.transportlayer;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

@Disabled("Teste de integração")
public class SecretariaControllerE2E {

    private WebDriver driver;

    static String URL_BASE = "http://localhost:3000";
    static String MATRICULAR_PATH = "/matricular";

    @Before
    public void chromeSession() {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
    }

    @Test
    public void deveRealizarMatricula() {
        driver.get(URL_BASE.concat(MATRICULAR_PATH));
        driver.findElement(By.cssSelector(".chakra-button")).click();
        driver.findElement(By.id("name")).click();
        driver.findElement(By.id("name")).sendKeys("Carlos Henrique");
        driver.findElement(By.id("nascimento")).click();
        driver.findElement(By.id("nascimento")).sendKeys("05-10-1994");
        driver.findElement(By.cssSelector(".chakra-button")).click();
    }

    @Test
    public void deveAdicionarUmAlunoQuandoMatricular() throws Exception {
        WebDriverWait wait =new WebDriverWait(driver, 90);

        driver.get(URL_BASE);
        var elements = driver.findElements(By.xpath(".//*[@id=\"matriculados\"]/tbody/tr"));
        var oldTotalElements = elements.size();

        driver.get(URL_BASE.concat(MATRICULAR_PATH));
        driver.findElement(By.id("name")).click();
        driver.findElement(By.id("name")).sendKeys("Carlos Henrique");
        driver.findElement(By.id("nascimento")).click();
        driver.findElement(By.id("nascimento")).sendKeys("05-10-1994");
        driver.findElement(By.cssSelector(".chakra-button")).click();

        Thread.sleep(4000);

        var newElements = driver.findElements(By.xpath(".//*[@id=\"matriculados\"]/tbody/tr"));

        Assertions.assertEquals(oldTotalElements + 1, newElements.size());
    }


    @After
    public void closeSession() {
        driver.quit();
    }
}
