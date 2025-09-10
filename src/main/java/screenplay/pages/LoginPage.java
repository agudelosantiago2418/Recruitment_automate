package screenplay.pages;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {
    public static final Target USERNAME_FIELD = Target.the("campo usuario")
            .located(By.name("username"));

    public static final Target PASSWORD_FIELD = Target.the("campo contraseña")
            .located(By.name("password"));

    public static final Target LOGIN_BUTTON = Target.the("botón login")
            .located(By.xpath("//button[@type='submit']"));
}
