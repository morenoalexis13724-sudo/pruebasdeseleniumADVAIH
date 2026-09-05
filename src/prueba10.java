import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class prueba10 {
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

        // BUSCAR UN EVENTO
        dr.findElement(By.xpath("//input[@placeholder=' Buscar evento por título...']")).sendKeys("Evento");
        Thread.sleep(2000);

        // AGREGAR EL EVENTO A FAVORITOS
        dr.findElement(By.className("btn-favorito")).click();
        Thread.sleep(3000);

        System.out.println("PRUEBA 10 COMPLETADA");
        System.out.println("Evento agregado a favoritos.");

        Thread.sleep(2000);
        dr.quit();
    }
}