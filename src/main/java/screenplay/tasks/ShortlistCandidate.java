package screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import screenplay.pages.RecruitmentPage;

import java.time.Duration;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class ShortlistCandidate implements Task {

    public static ShortlistCandidate now() {
        return instrumented(ShortlistCandidate.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(RecruitmentPage.SHORTLIST_BUTTON, isClickable())
                        .forNoMoreThan(Duration.ofSeconds(10)),
                Click.on(RecruitmentPage.SHORTLIST_BUTTON),
                Click.on(RecruitmentPage.SAVE_BUTTON)
        );
    }
}
