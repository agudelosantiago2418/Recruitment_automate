package screenplay.pages;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class RecruitmentPage {
    public static final Target RECRUITMENT_MENU = Target.the("menu recruitment")
            .located(By.xpath("//span[text()='Recruitment']"));

    public static final Target ADD_BUTTON = Target.the("botón agregar")
            .located(By.xpath("//button[contains(@class,'oxd-button--secondary')]"));

    public static final Target FIRST_NAME = Target.the("nombre")
            .located(By.name("firstName"));

    public static final Target MIDDLE_NAME = Target.the("segundo nombre")
            .located(By.name("middleName"));

    public static final Target LAST_NAME = Target.the("apellido")
            .located(By.name("lastName"));

    public static final Target EMAIL = Target.the("email")
            .located(By.xpath("(//input[@placeholder='Type here'])[1]"));

    public static final Target CONTACT_NUMBER = Target.the("número contacto")
            .located(By.xpath("(//input[@placeholder='Type here'])[2]"));

    public static final Target SAVE_BUTTON = Target.the("botón guardar")
            .located(By.xpath("//button[@type='submit']"));

    public static final Target SCHEDULE_INTERVIEW_BUTTON = Target.the("programar entrevista")
            .located(By.xpath("//button[text()=' Schedule Interview ']"));

    public static final Target MARK_INTERVIEW_PASSED = Target.the("marcar entrevista aprobada")
            .located(By.xpath("//button[text()=' Mark Interview Passed ']"));

    public static final Target OFFER_JOB_BUTTON = Target.the("ofrecer trabajo")
            .located(By.xpath("//button[text()=' Offer Job ']"));

    public static final Target HIRE_BUTTON = Target.the("contratar")
            .located(By.xpath("//button[text()=' Hire ']"));
}

