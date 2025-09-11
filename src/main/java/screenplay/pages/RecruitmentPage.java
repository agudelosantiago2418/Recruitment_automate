package screenplay.pages;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class RecruitmentPage {

    // Navegación
    public static final Target RECRUITMENT_MENU = Target.the("menu recruitment")
            .located(By.xpath("//span[text()='Recruitment']"));

    public static final Target ADD_BUTTON = Target.the("botón + Add")
            .located(By.xpath("//button[contains(normalize-space(.), 'Add')]"));

    // Campos del candidato
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
    // Abrir dropdown de vacante
    public static final Target VACANCY_DROPDOWN = Target.the("dropdown vacancy")
            .located(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div/div/div[2]/div/div/div[1]"));
    // Lista de opciones (esperar que carguen)
    public static final Target VACANCY_OPTIONS = Target.the("todas las opciones vacancy")
            .located(By.xpath("//div[contains(@class,'oxd-select-dropdown')]//div[contains(@class,'oxd-select-option')]"));
    // Opción individual parametrizable
    public static final Target VACANCY_OPTION = Target.the("opción vacancy {0}")
            .locatedBy("//div[contains(@class,'oxd-select-dropdown')]//div[contains(@class,'oxd-select-option') and normalize-space()='{0}']");

    public static final Target SAVE_BUTTON = Target.the("botón guardar")
            .located(By.xpath("//button[@type='submit']"));

    // Estados del candidato
    public static final Target STATUS_DROPDOWN = Target.the("dropdown estado")
            .located(By.xpath("//label[text()='Status']/following-sibling::div//div[contains(@class,'oxd-select-text')]"));

    public static final Target SHORTLIST_BUTTON = Target.the("botón shortlist")
            .located(By.xpath("//button[normalize-space()='Shortlist']"));

    // Programar entrevista
    public static final Target SCHEDULE_INTERVIEW_BUTTON = Target.the("botón programar entrevista")
            .located(By.xpath("//button[contains(@class,'oxd-button oxd-button--medium oxd-button--success')]"));

    public static final Target INTERVIEW_TITLE = Target.the("título entrevista")
            .located(By.xpath("//label[text()='Interview Title']/following-sibling::div//input"));

    public static final Target INTERVIEWER = Target.the("entrevistador")
            .located(By.xpath("//label[text()='Interviewer']/following-sibling::div//input"));

    public static final Target INTERVIEWER_SUGGESTION = Target.the("sugerencia entrevistador")
            .located(By.xpath("//div[contains(@class,'oxd-autocomplete-option')]"));

    public static final Target DATE_FIELD = Target.the("campo fecha")
            .located(By.xpath("//label[text()='Date']/following-sibling::div//input"));

    public static final Target SAVE_INTERVIEW_BUTTON = Target.the("botón guardar entrevista")
            .located(By.xpath("//button[@type='submit' and contains(text(),'Save')]"));

    // Marcar entrevista aprobada
    public static final Target MARK_INTERVIEW_PASSED = Target.the("marcar entrevista aprobada")
            .located(By.xpath("//button[contains(text(),'Mark Interview Passed')]"));

    // Ofrecer trabajo
    public static final Target OFFER_JOB_BUTTON = Target.the("ofrecer trabajo")
            .located(By.xpath("//button[contains(text(),'Offer Job')]"));

    // Contratar
    public static final Target HIRE_BUTTON = Target.the("contratar")
            .located(By.xpath("//button[contains(text(),'Hire')]"));

    // Verificación final
    public static final Target CANDIDATE_STATUS = Target.the("estado candidato {0}")
            .located(By.xpath("//div[contains(text(),'{0}')]/parent::div/following-sibling::div[contains(text(),'Hired')]"));
}
