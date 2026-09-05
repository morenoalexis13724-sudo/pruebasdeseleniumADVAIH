import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class prueba8 {
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
        Thread.sleep(5000);

        // ENTRAR A CREAR EVENTO
        dr.findElement(By.xpath("//a[@routerLink='/crud-eventos']")).click();
        Thread.sleep(3000);

        // BAJAR HASTA EVENTOS REGISTRADOS
        dr.findElement(By.xpath("//h2[contains(text(),'Eventos Registrados')]")).click();
        Thread.sleep(1500);

        // EDITAR EVENTO
        dr.findElement(By.className("btn-editar")).click();
        Thread.sleep(2000);

        // CAMBIAR NOMBRE
        dr.findElement(By.id("title")).clear();
        dr.findElement(By.id("title")).sendKeys("Evento Editado Selenium");
        Thread.sleep(1000);

        // GUARDAR CAMBIOS
        dr.findElement(By.className("btn-crear")).click();
        Thread.sleep(3000);

        System.out.println("PRUEBA COMPLETADA");
        System.out.println("Evento editado correctamente.");

        Thread.sleep(2000);
        dr.quit();
    }
}