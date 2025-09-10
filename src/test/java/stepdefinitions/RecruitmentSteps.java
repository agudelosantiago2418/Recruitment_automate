package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import screenplay.questions.CandidateStatus;
import screenplay.tasks.AddCandidate;
import screenplay.tasks.Login;

import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class RecruitmentSteps {

    @Managed(driver = "chrome")
    WebDriver driver;

    Actor reclutador;

    @Before
    public void setUp() {
        reclutador = Actor.named("Reclutador");
        reclutador.can(BrowseTheWeb.with(driver));
    }

    @Dado("que el reclutador ingresa al sistema OrangeHRM")
    public void queElReclutadorIngresaAlSistemaOrangeHRM() {
        // El setup ya está realizado
    }

    @Cuando("inicia sesión con credenciales válidas")
    public void iniciaSesionConCredencialesValidas() {
        reclutador.attemptsTo(
                Login.withCredentials("Admin", "admin123")
        );
    }

    @Cuando("agrega un nuevo candidato con los siguientes datos:")
    public void agregaUnNuevoCandidatoConLosSiguientesDatos(DataTable dataTable) {
        Map<String, String> candidateData = dataTable.asMap(String.class, String.class);
        reclutador.attemptsTo(
                AddCandidate.withData(candidateData)
        );
    }

    @Entonces("el candidato debe aparecer con estado {string} en la lista")
    public void elCandidatoDebeAparecerConEstadoEnLaLista(String expectedStatus) {
        reclutador.should(
                seeThat("El estado del candidato",
                        CandidateStatus.of("oscar andres roa"),
                        equalTo(expectedStatus))
        );
    }
}
