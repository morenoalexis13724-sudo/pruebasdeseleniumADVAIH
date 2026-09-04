import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CA003_LoginCamposVacios {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        try {

            driver.get("http://localhost:4200/");
            driver.manage().window().maximize();

            WebDriverWait wait = new WebDriverWait(
                    driver,
                    Duration.ofSeconds(10)
            );

            // Esperar a que aparezca el campo de correo
            WebElement correo = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.name("email")
                    )
            );

            // Dejar los campos vacíos
            correo.clear();

            WebElement password = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.name("password")
                    )
            );

            password.clear();

            // Presionar Iniciar sesión
            WebElement botonLogin = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("//button[contains(text(),'Iniciar sesión')]")
                    )
            );

            botonLogin.click();

            // Esperar los mensajes de validación
            WebElement errorCorreo = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.cssSelector(".error-input")
                    )
            );

            String mensajeError = errorCorreo.getText();

            // Verificar que NO se haya iniciado sesión
            String urlActual = driver.getCurrentUrl();

            if (!urlActual.contains("/home")
                    && mensajeError.contains("obligatorio")) {

                System.out.println("========================================");
                System.out.println("CA-003: LOGIN CON CAMPOS VACIOS");
                System.out.println("RESULTADO: PASSED");
                System.out.println("VALIDACION DE CAMPOS CORRECTA");
                System.out.println("MENSAJE: " + mensajeError);
                System.out.println("========================================");

            } else {

                System.out.println("========================================");
                System.out.println("CA-003: LOGIN CON CAMPOS VACIOS");
                System.out.println("RESULTADO: FAILED");
                System.out.println("LA VALIDACION NO FUNCIONO CORRECTAMENTE");
                System.out.println("========================================");
            }

        } catch (Exception e) {

            System.out.println("========================================");
            System.out.println("CA-003: LOGIN CON CAMPOS VACIOS");
            System.out.println("RESULTADO: FAILED");
            System.out.println("ERROR: " + e.getMessage());
            System.out.println("========================================");

        } finally {

            driver.quit();
        }
    }
}