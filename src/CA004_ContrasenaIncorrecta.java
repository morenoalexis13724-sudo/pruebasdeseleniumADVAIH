import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CA004_ContrasenaIncorrecta {

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

            // IMPORTANTE:
            // Coloca aquí un correo que SÍ exista en ADVAIH
            correo.sendKeys("alexisalexis13724@gmail.com");

            // Campo de contraseña
            WebElement password = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.name("password")
                    )
            );

            // Contraseña incorrecta
            password.sendKeys("ContrasenaIncorrecta999999");

            // Botón Iniciar sesión
            WebElement botonLogin = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("//button[contains(text(),'Iniciar sesión')]")
                    )
            );

            botonLogin.click();

            // Esperar mensaje de error
            WebElement mensajeError = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.cssSelector(".error-input")
                    )
            );

            String textoError = mensajeError.getText();

            // Obtener URL actual
            String urlActual = driver.getCurrentUrl();

            // Verificar que el sistema rechazó el login
            if (!urlActual.contains("/home")
                    && textoError.contains("incorrectos")) {

                System.out.println("========================================");
                System.out.println("CA-004: CONTRASENA INCORRECTA");
                System.out.println("RESULTADO: PASSED");
                System.out.println("LOGIN RECHAZADO CORRECTAMENTE");
                System.out.println("MENSAJE: la contraseña es incorrecta");
                System.out.println("========================================");

            } else {

                System.out.println("========================================");
                System.out.println("CA-004: CONTRASENA INCORRECTA");
                System.out.println("RESULTADO: FAILED");
                System.out.println("EL SISTEMA NO RECHAZO LA CONTRASENA");
                System.out.println("========================================");
            }

        } catch (Exception e) {

            System.out.println("========================================");
            System.out.println("CA-004: CONTRASENA INCORRECTA");
            System.out.println("RESULTADO: FAILED");
            System.out.println("ERROR: " + e.getMessage());
            System.out.println("========================================");

        } finally {

            driver.quit();
        }
    }
}