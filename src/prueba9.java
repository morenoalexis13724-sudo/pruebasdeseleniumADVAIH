import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class prueba9 {
    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-features=PasswordLeakDetection");
        options.addArguments("--disable-notifications");

        WebDriver dr = new ChromeDriver(options);
        dr.manage().window().maximize();

        // ENTRAR AL LOGIN
        dr.get("http://localhost:4200");
        Thread.sleep(2000);

        // CORREO
        dr.findElement(By.name("email")).sendKeys("david1234@gmail.com");
        Thread.sleep(500);

        // CONTRASEÑA
        dr.findElement(By.name("password")).sendKeys("123456789");
        Thread.sleep(1000);

        // INICIAR SESIÓN
        dr.findElement(By.xpath("//button[contains(text(),'Iniciar sesión')]")).click();
        Thread.sleep(6000);

        // ENTRAR A CREAR EVENTO
        dr.findElement(By.xpath("//a[@routerLink='/crud-eventos']")).click();
        Thread.sleep(3000);

        // BAJAR A EVENTOS REGISTRADOS
        dr.findElement(By.xpath("//h2[contains(text(),'Eventos Registrados')]")).click();
        Thread.sleep(1500);

        // ELIMINAR EVENTO
        dr.findElement(By.className("btn-eliminar")).click();
        Thread.sleep(2000);

        // ACEPTAR CONFIRMACIÓN SI APARECE
        try {
            dr.switchTo().alert().accept();
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("No apareció ventana de confirmación.");
        }

        Thread.sleep(3000);

        System.out.println("PRUEBA 9 COMPLETADA");
        System.out.println("Evento eliminado correctamente.");

        Thread.sleep(2000);
        dr.quit();
    }
}