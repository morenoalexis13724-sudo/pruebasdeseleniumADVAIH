import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CA005_RegistroUsuario {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        try {

            driver.get("http://localhost:4200/register");
            driver.manage().window().maximize();

            WebDriverWait wait = new WebDriverWait(
                    driver,
                    Duration.ofSeconds(10)
            );

            // Nombre completo
            WebElement nombre = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.cssSelector("input[placeholder='Nombre completo']")
                    )
            );

            nombre.sendKeys("Usuario Selenium");

            // Correo electrónico
            WebElement correo = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.cssSelector("input[placeholder='Correo electrónico']")
                    )
            );

            correo.sendKeys("usuarum_999999@gmail.com");

            // Contraseña
            WebElement password = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.cssSelector("input[placeholder='Contraseña']")
                    )
            );

            password.sendKeys("Selenium123456");

            // Confirmar contraseña
            WebElement confirmarPassword = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.cssSelector("input[placeholder='Confirmar contraseña']")
                    )
            );

            confirmarPassword.sendKeys("Selenium123456");

            // Seleccionar rol Usuario
            WebElement usuario = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.cssSelector("input[type='radio'][value='usuario']")
                    )
            );

            usuario.click();

            // Botón Crear cuenta
            WebElement botonCrear = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("//button[contains(text(),'Crear cuenta')]")
                    )
            );

            botonCrear.click();

            // Esperar el cambio de página
            wait.until(
                    ExpectedConditions.urlContains("/home")
            );

            System.out.println("========================================");
            System.out.println("CA-005: REGISTRO DE USUARIO");
            System.out.println("RESULTADO: PASSED");
            System.out.println("USUARIO REGISTRADO CORRECTAMENTE");
            System.out.println("URL: " + driver.getCurrentUrl());
            System.out.println("========================================");

        } catch (Exception e) {

            System.out.println("========================================");
            System.out.println("CA-005: REGISTRO DE USUARIO");
            System.out.println("RESULTADO: FAILED");
            System.out.println("ERROR: " + e.getMessage());
            System.out.println("========================================");

        } finally {

            driver.quit();
        }
    }
}
