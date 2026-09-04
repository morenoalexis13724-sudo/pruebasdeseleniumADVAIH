import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CA006_RegistroOrganizador {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        try {

            // Abrir página de registro
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
            nombre.sendKeys("Organizador Selenium");

            // Correo electrónico
            WebElement correo = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.cssSelector("input[placeholder='Correo electrónico']")
                    )
            );
            correo.sendKeys("organizador_selenium_777777@example.com");

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

            // Seleccionar rol Colaborador
            WebElement organizador = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.cssSelector(
                                    "input[type='radio'][value='organizador']"
                            )
                    )
            );
            organizador.click();

            // Verificar que el rol quedó seleccionado
            if (!organizador.isSelected()) {
                throw new Exception(
                        "No se pudo seleccionar el rol Colaborador"
                );
            }

            // Crear cuenta
            WebElement botonCrear = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("//button[contains(text(),'Crear cuenta')]")
                    )
            );
            botonCrear.click();

            // Esperar mensaje de registro exitoso
            Alert alerta = wait.until(
                    ExpectedConditions.alertIsPresent()
            );

            String mensaje = alerta.getText();

            // Verificar mensaje
            if (!mensaje.contains("Usuario registrado correctamente")) {
                throw new Exception(
                        "Mensaje inesperado: " + mensaje
                );
            }

            // Cerrar alerta
            alerta.accept();

            // Esperar redirección al Home
            wait.until(
                    ExpectedConditions.urlContains("/home")
            );

            // Resultado exitoso
            System.out.println("========================================");
            System.out.println("CA-010: REGISTRO COMO COLABORADOR");
            System.out.println("RESULTADO: PASSED");
            System.out.println("ROL SELECCIONADO: COLABORADOR");
            System.out.println("USUARIO REGISTRADO CORRECTAMENTE");
            System.out.println("URL: " + driver.getCurrentUrl());
            System.out.println("========================================");

        } catch (Exception e) {

            System.out.println("========================================");
            System.out.println("CA-010: REGISTRO COMO COLABORADOR");
            System.out.println("RESULTADO: FAILED");
            System.out.println("ERROR: " + e.getMessage());
            System.out.println("========================================");

        } finally {

            driver.quit();
        }
    }
}