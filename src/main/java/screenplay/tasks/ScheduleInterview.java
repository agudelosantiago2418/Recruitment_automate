package screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import screenplay.pages.RecruitmentPage;

import java.time.Duration;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ScheduleInterview implements Task {

    public static ScheduleInterview withDetails() {
        return instrumented(ScheduleInterview.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(RecruitmentPage.SCHEDULE_INTERVIEW_BUTTON),

                WaitUntil.the(RecruitmentPage.INTERVIEW_TITLE, isVisible())
                        .forNoMoreThan(Duration.ofSeconds(10)),

                Enter.theValue("Technical Interview").into(RecruitmentPage.INTERVIEW_TITLE),

                // Escribir 'a' y seleccionar el primer entrevistador
                Enter.theValue("a").into(RecruitmentPage.INTERVIEWER),
                WaitUntil.the(RecruitmentPage.INTERVIEWER_SUGGESTION, isVisible())
                        .forNoMoreThan(Duration.ofSeconds(5)),
                Click.on(RecruitmentPage.INTERVIEWER_SUGGESTION),

                // Fecha en formato yyyy-dd-mm
                Enter.theValue("2025-15-12").into(RecruitmentPage.DATE_FIELD),

                Click.on(RecruitmentPage.SAVE_INTERVIEW_BUTTON)
        );
    }
}
