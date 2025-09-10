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
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

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
                WaitUntil.the(RecruitmentPage.ADD_BUTTON, isClickable())
                        .forNoMoreThan(Duration.ofSeconds(10)),
                Click.on(RecruitmentPage.ADD_BUTTON),

                // 2. Esperar a que el formulario esté listo
                WaitUntil.the(RecruitmentPage.FIRST_NAME, isVisible())
                        .forNoMoreThan(Duration.ofSeconds(10)),

                // 3. Rellenar los campos
                Enter.theValue(candidateData.get("nombre"))
                        .into(RecruitmentPage.FIRST_NAME),
                Enter.theValue(candidateData.get("apellido1"))
                        .into(RecruitmentPage.MIDDLE_NAME),
                Enter.theValue(candidateData.get("apellido2"))
                        .into(RecruitmentPage.LAST_NAME),
                Enter.theValue(candidateData.get("email"))
                        .into(RecruitmentPage.EMAIL),
                Enter.theValue(candidateData.get("contacto"))
                        .into(RecruitmentPage.CONTACT_NUMBER),

                // 4. Guardar
                Click.on(RecruitmentPage.SAVE_BUTTON)
        );
    }
}



