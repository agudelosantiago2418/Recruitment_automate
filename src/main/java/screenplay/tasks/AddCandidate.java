package screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import screenplay.pages.RecruitmentPage;

import java.time.Duration;
import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class AddCandidate implements Task {
    private final Map<String, String> candidateData;

    public AddCandidate(Map<String, String> candidateData) {
        this.candidateData = candidateData;
    }

    public static AddCandidate withData(Map<String, String> candidateData) {
        return instrumented(AddCandidate.class, candidateData);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                // 1. Hacer click en + Add
                WaitUntil.the(RecruitmentPage.ADD_BUTTON, isClickable())
                        .forNoMoreThan(Duration.ofSeconds(10)),
                Click.on(RecruitmentPage.ADD_BUTTON),

                // 2. Esperar que aparezca el formulario
                WaitUntil.the(RecruitmentPage.FIRST_NAME, isVisible())
                        .forNoMoreThan(Duration.ofSeconds(10)),

                // Abrir el dropdown con el nuevo locator absoluto
                WaitUntil.the(RecruitmentPage.VACANCY_DROPDOWN, isClickable())
                        .forNoMoreThan(Duration.ofSeconds(10)),
                Click.on(RecruitmentPage.VACANCY_DROPDOWN),

                // Esperar que aparezcan las opciones
                WaitUntil.the(RecruitmentPage.VACANCY_OPTIONS, isVisible())
                        .forNoMoreThan(Duration.ofSeconds(5)),

                // Seleccionar la opción exacta
                Click.on(RecruitmentPage.VACANCY_OPTION.of(candidateData.get("vacancy"))),

                // 3. Llenar datos básicos
                Enter.theValue(candidateData.get("nombre")).into(RecruitmentPage.FIRST_NAME),
                Enter.theValue(candidateData.get("apellido1")).into(RecruitmentPage.MIDDLE_NAME),
                Enter.theValue(candidateData.get("apellido2")).into(RecruitmentPage.LAST_NAME),
                Enter.theValue(candidateData.get("email")).into(RecruitmentPage.EMAIL),
                Enter.theValue(candidateData.get("contacto")).into(RecruitmentPage.CONTACT_NUMBER),

                // 4. Seleccionar vacancy
                Click.on(RecruitmentPage.VACANCY_DROPDOWN),
                Click.on(RecruitmentPage.VACANCY_OPTION.of(candidateData.get("vacancy"))),

                // 5. Guardar candidato
                Click.on(RecruitmentPage.SAVE_BUTTON)
        );
    }
}



