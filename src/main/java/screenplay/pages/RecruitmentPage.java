package screenplay.pages;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class RecruitmentPage {

    public static final Target RECRUITMENT_MENU = Target.the("menu recruitment")
            .located(By.xpath("//span[text()='Recruitment']"));

    public static final Target ADD_BUTTON = Target.the("botón + Add")
            .located(By.xpath("//button[contains(normalize-space(.), 'Add')]"));


    public static final Target FIRST_NAME = Target.the("campo nombre")
            .located(By.name("firstName"));

    public static final Target MIDDLE_NAME = Target.the("campo segundo nombre")
            .located(By.name("middleName"));

    public static final Target LAST_NAME = Target.the("campo apellido")
            .located(By.name("lastName"));

    public static final Target EMAIL = Target.the("campo email")
            .located(By.xpath("(//input[@placeholder='Type here'])[1]"));

    public static final Target CONTACT_NUMBER = Target.the("campo contacto")
            .located(By.xpath("(//input[@placeholder='Type here'])[2]"));

    public static final Target SAVE_BUTTON = Target.the("botón guardar candidato")
            .located(By.xpath("//button[@type='submit']"));

    // -------------------------------
    // Locators para entrevista
    // -------------------------------
    public static final Target SCHEDULE_INTERVIEW_BUTTON = Target.the("botón programar entrevista")
            .located(By.xpath("//button[text()=' Schedule Interview ']"));

    public static final Target INTERVIEW_TITLE = Target.the("campo título de entrevista")
            .located(By.xpath("//label[text()='Interview Title*']/following-sibling::div//input"));

    public static final Target INTERVIEWER = Target.the("campo entrevistador")
            .located(By.xpath("//label[text()='Interviewer*']/following-sibling::div//input"));

    public static final Target SAVE_INTERVIEW_BUTTON = Target.the("botón guardar entrevista")
            .located(By.xpath("//button[text()=' Save ']"));

    public static final Target MARK_INTERVIEW_PASSED = Target.the("botón marcar entrevista aprobada")
            .located(By.xpath("//button[text()=' Mark Interview Passed ']"));

    public static final Target OFFER_JOB_BUTTON = Target.the("botón ofrecer trabajo")
            .located(By.xpath("//button[text()=' Offer Job ']"));

    public static final Target HIRE_BUTTON = Target.the("botón contratar candidato")
            .located(By.xpath("//button[text()=' Hire ']"));
}


