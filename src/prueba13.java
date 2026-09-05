import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class prueba13 {
    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-features=PasswordLeakDetection");
        options.addArguments("--disable-notifications");

        WebDriver dr = new ChromeDriver(options);
        dr.manage().window().maximize();

        // ENTRAR AL HOME SIN LOGIN
        dr.get("http://localhost:4200/home/");
        Thread.sleep(3000);

        // INTENTAR ACCEDER DIRECTAMENTE A FAVORITOS
        dr.get("http://localhost:4200/favoritos");
        Thread.sleep(4000);

        // COMPROBAR LA DIRECCIÓN
        String url = dr.getCurrentUrl();

        System.out.println("PRUEBA 12");

        if (url.contains("/favoritos")) {
            System.out.println("ACCESO A FAVORITOS REALIZADO");
            System.out.println("La dirección cambió correctamente a /favoritos.");
        } else {
            System.out.println("ACCESO A FAVORITOS BLOQUEADO.");
            System.out.println("La aplicación no permitió entrar a /favoritos.");
        }


        Thread.sleep(3000);
        dr.quit();
    }
}