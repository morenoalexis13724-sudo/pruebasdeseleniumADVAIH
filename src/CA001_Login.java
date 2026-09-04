import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CA001_Login {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        try {

            driver.get("http://localhost:4200/");
            driver.manage().window().maximize();

            WebDriverWait wait = new WebDriverWait(
                    driver,
                    Duration.ofSeconds(10)
            );

            // Campo de correo
            WebElement correo = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.name("email")
                    )
            );

            correo.sendKeys("alexisalexis13724@gmail.com");

            // Campo de contraseña
            WebElement password = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.name("password")
                    )
            );

            password.sendKeys("123456789");

            // Botón Iniciar sesión
            WebElement botonLogin = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("//button[contains(text(),'Iniciar sesión')]")
                    )
            );

            botonLogin.click();

            // Esperar redirección al Home
            wait.until(
                    ExpectedConditions.urlContains("/home")
            );

            ;
            System.out.println("CA-001: LOGIN CON CREDENCIALES VALIDAS");
            System.out.println("RESULTADO: PASSED");
            System.out.println("LOGIN REALIZADO CORRECTAMENTE");
            System.out.println("URL: " + driver.getCurrentUrl());
            ;

        } catch (Exception e) {


            System.out.println("CA-001: LOGIN CON CREDENCIALES VALIDAS");
            System.out.println("RESULTADO: FAILED");
            System.out.println("ERROR: " + e.getMessage());


        } finally {

            driver.quit();
        }
    }
}