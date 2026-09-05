import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class prueba7 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(15)
        );

        try {

            // ==========================================
            // ABRIR ADVAIH
            // ==========================================

            driver.get("http://localhost:4200");

            driver.manage().window().maximize();


            // ==========================================
            // IR AL LOGIN
            // ==========================================

            WebElement botonLogin = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("//a[contains(text(),'Iniciar sesión')] | //button[contains(text(),'Iniciar sesión')]")
                    )
            );

            botonLogin.click();


            // ==========================================
            // INGRESAR CORREO
            // ==========================================

            WebElement email = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.cssSelector("input[type='email']")
                    )
            );

            email.sendKeys("david1234@gmail.com");


            // ==========================================
            // INGRESAR CONTRASEÑA
            // ==========================================

            WebElement password = driver.findElement(
                    By.cssSelector("input[type='password']")
            );

            password.sendKeys("123456789");


            // ==========================================
            // INICIAR SESIÓN
            // ==========================================

            WebElement botonIngresar = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath(
                                    "//button[contains(text(),'Iniciar sesión')] | " +
                                            "//button[contains(text(),'Ingresar')] | " +
                                            "//button[@type='submit']"
                            )
                    )
            );

            botonIngresar.click();


            // ==========================================
            // ESPERAR HOME Y BUSCADOR
            // ==========================================

            WebElement buscador = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.cssSelector(
                                    "input[placeholder*='Buscar evento por título']"
                            )
                    )
            );



            // ==========================================
            // BUSCAR EVENTO
            // ==========================================

            buscador.clear();

            buscador.sendKeys("Feria de computadores");


            // ==========================================
            // ESPERAR RESULTADO
            // ==========================================

            WebElement eventoEncontrado = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.xpath(
                                    "//div[contains(@class,'evento-card')]//h3[contains(text(),'Feria de computadores')]"
                            )
                    )
            );


            // ==========================================
            // VALIDAR RESULTADO
            // ==========================================

            if (eventoEncontrado.isDisplayed()) {

                System.out.println(" PRUEBA EXITOSA");

                System.out.println(
                        "Evento encontrado: "
                                + eventoEncontrado.getText()
                );


            }


        } catch (Exception e) {

            System.out.println("\n❌ PRUEBA FALLIDA");

            e.printStackTrace();

        }

    }

}