import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CA002_LoginInvalido {

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

            correo.sendKeys("correo_incorrecto_selenium_999999@example.com");

            // Campo de contraseña
            WebElement password = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.name("password")
                    )
            );

            password.sendKeys("ContrasenaIncorrecta999999");

            // Botón Iniciar sesión
            WebElement botonLogin = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("//button[contains(text(),'Iniciar sesión')]")
                    )
            );

            botonLogin.click();

            // Esperar a que aparezca el mensaje de error
            WebElement mensajeError = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.cssSelector(".error-input")
                    )
            );

            String textoError = mensajeError.getText();

            // Verificar que el login fue rechazado
            String urlActual = driver.getCurrentUrl();

            if (!urlActual.contains("/home")
                    && textoError.contains("incorrectos")) {

                System.out.println("========================================");
                System.out.println("CA-002: LOGIN CON CREDENCIALES INVALIDAS");
                System.out.println("RESULTADO: PASSED");
                System.out.println("LOGIN RECHAZADO CORRECTAMENTE");
                System.out.println("MENSAJE: " + textoError);
                System.out.println("========================================");

            } else {

                System.out.println("========================================");
                System.out.println("CA-002: LOGIN CON CREDENCIALES INVALIDAS");
                System.out.println("RESULTADO: FAILED");
                System.out.println("EL SISTEMA ACEPTO LAS CREDENCIALES");
                System.out.println("========================================");
            }

        } catch (Exception e) {

            System.out.println("========================================");
            System.out.println("CA-002: LOGIN CON CREDENCIALES INVALIDAS");
            System.out.println("RESULTADO: FAILED");
            System.out.println("ERROR: " + e.getMessage());
            System.out.println("========================================");

        } finally {

            driver.quit();
        }
    }
}