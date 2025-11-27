package screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
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
                // Abrir modal de programar entrevista
                Click.on(RecruitmentPage.SCHEDULE_INTERVIEW_BUTTON),

                // Esperar y llenar Interview Title
                WaitUntil.the(RecruitmentPage.INTERVIEW_TITLE, isVisible()).forNoMoreThan(Duration.ofSeconds(10)),
                Enter.theValue("Technical Interview").into(RecruitmentPage.INTERVIEW_TITLE),

                // Esperar y llenar Interviewer
//                WaitUntil.the(RecruitmentPage.INTERVIEWER, isVisible()).forNoMoreThan(Duration.ofSeconds(10)),
//                Enter.theValue("a").into(RecruitmentPage.INTERVIEWER),
//                WaitUntil.the(RecruitmentPage.INTERVIEWER_SUGGESTION, isVisible()).forNoMoreThan(Duration.ofSeconds(5)),
//                Click.on(RecruitmentPage.INTERVIEWER_SUGGESTION),

                // Esperar y llenar Date
                //WaitUntil.the(RecruitmentPage.DATE_FIELD, isVisible()).forNoMoreThan(Duration.ofSeconds(10)),
               // Enter.theValue("2025-15-09").into(RecruitmentPage.DATE_FIELD),

                // Guardar entrevista
                Click.on(RecruitmentPage.SAVE_INTERVIEW_BUTTON),

                // Marcar entrevista aprobada y guardar
                Click.on(RecruitmentPage.MARK_INTERVIEW_PASSED),
                Click.on(RecruitmentPage.SAVE_BUTTON),

                // Ofrecer trabajo y guardar
                Click.on(RecruitmentPage.OFFER_JOB_BUTTON),
                Click.on(RecruitmentPage.SAVE_BUTTON),

                // Contratar y guardar
                Click.on(RecruitmentPage.HIRE_BUTTON),
                Click.on(RecruitmentPage.SAVE_BUTTON)
        );
    }
}
