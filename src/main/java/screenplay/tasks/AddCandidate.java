package screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import screenplay.pages.RecruitmentPage;

import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;

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
                Click.on(RecruitmentPage.RECRUITMENT_MENU),
                Click.on(RecruitmentPage.ADD_BUTTON),
                Enter.theValue(candidateData.get("nombre")).into(RecruitmentPage.FIRST_NAME),
                Enter.theValue(candidateData.get("apellido1")).into(RecruitmentPage.MIDDLE_NAME),
                Enter.theValue(candidateData.get("apellido2")).into(RecruitmentPage.LAST_NAME),
                Enter.theValue(candidateData.get("email")).into(RecruitmentPage.EMAIL),
                Enter.theValue(candidateData.get("contacto")).into(RecruitmentPage.CONTACT_NUMBER),
                Click.on(RecruitmentPage.SAVE_BUTTON)
        );
    }
}


