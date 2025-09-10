package screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CandidateStatus implements Question<String> {
    private final String candidateName;

    public CandidateStatus(String candidateName) {
        this.candidateName = candidateName;
    }

    public static CandidateStatus of(String candidateName) {
        return new CandidateStatus(candidateName);
    }

    @Override
    public String answeredBy(Actor actor) {
        Target statusCell = Target.the("estado del candidato")
                .located(By.xpath("//div[contains(text(),'" + candidateName + "')]/parent::div/following-sibling::div[3]"));

        return statusCell.resolveFor(actor).getText();
    }
}
