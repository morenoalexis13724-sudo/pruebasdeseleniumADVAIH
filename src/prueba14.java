import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class prueba14 {
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
        dr.findElement(By.name("email")).sendKeys("felipe@gmail.com");

        // INGRESAR CONTRASEÑA
        dr.findElement(By.name("password")).sendKeys("123456789");

        // INICIAR SESIÓN
        dr.findElement(By.xpath("//button[contains(text(),'Iniciar sesión')]")).click();
        Thread.sleep(5000);

        // BUSCAR EL BOTÓN PANEL ADMIN
        boolean panelAdminVisible = dr.findElements(
                By.xpath("//a[@routerLink='/admin-panel']")
        ).size() > 0;

        System.out.println("PRUEBA 14");
        System.out.println("Usuario normal intenta acceder al Panel Admin");

        if (!panelAdminVisible) {
            System.out.println("PRUEBA EXITOSA");
            System.out.println("El usuario normal NO puede ver el Panel Admin.");
        } else {
            System.out.println("PRUEBA FALLIDA");
            System.out.println("El Panel Admin aparece para el usuario normal.");
        }


        Thread.sleep(3000);
        dr.quit();
    }
}