import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class prueba15 {
    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-features=PasswordLeakDetection");
        options.addArguments("--disable-notifications");

        WebDriver dr = new ChromeDriver(options);
        dr.manage().window().maximize();

        // ENTRAR AL LOGIN
        dr.get("http://localhost:4200");
        Thread.sleep(3000);

        // INGRESAR CORREO
        dr.findElement(By.name("email")).sendKeys("david1234@gmail.com");

        // INGRESAR CONTRASEÑA
        dr.findElement(By.name("password")).sendKeys("123456789");

        // INICIAR SESIÓN
        dr.findElement(By.xpath("//button[contains(text(),'Iniciar sesión')]")).click();
        Thread.sleep(5000);

        // ENTRAR A CREAR EVENTO
        dr.findElement(By.xpath("//a[@routerLink='/crud-eventos']")).click();
        Thread.sleep(4000);

        // DEJAR EL FORMULARIO VACÍO Y PRESIONAR CREAR
        dr.findElement(By.className("btn-crear")).click();
        Thread.sleep(3000);

        System.out.println("PRUEBA 15");
        System.out.println("Crear evento con datos inválidos");

        String url = dr.getCurrentUrl();

        if (url.contains("/crud-eventos")) {
            System.out.println("PRUEBA EXITOSA");
            System.out.println("El evento con datos inválidos no fue creado.");
        } else {
            System.out.println("PRUEBA FALLIDA");
            System.out.println("El sistema permitió continuar con datos inválidos.");
        }


        Thread.sleep(3000);
        dr.quit();
    }
}