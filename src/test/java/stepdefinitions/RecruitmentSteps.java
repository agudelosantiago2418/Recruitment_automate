package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import screenplay.questions.CandidateStatus;
import screenplay.tasks.*;
import screenplay.pages.RecruitmentPage;

import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;

public class RecruitmentSteps {

    @Managed(driver = "firefox")
    WebDriver driver;

    Actor reclutador;

    @Before
    public void setUp() {
        reclutador = Actor.named("Reclutador");
        reclutador.can(BrowseTheWeb.with(driver));
    }

    @Dado("que el reclutador ingresa al sistema OrangeHRM")
    public void queElReclutadorIngresaAlSistemaOrangeHRM() {
        // Setup ya realizado
    }

    @Cuando("inicia sesión con credenciales válidas")
    public void iniciaSesionConCredencialesValidas() {
        reclutador.attemptsTo(
                Login.withCredentials("Admin", "admin123")
        );
    }

    @Cuando("navega al módulo de Recruitment")
    public void navegaAlModuloDeRecruitment() {
        reclutador.attemptsTo(
                Click.on(RecruitmentPage.RECRUITMENT_MENU)
        );
    }

    @Cuando("agrega un nuevo candidato con los siguientes datos:")
    public void agregaUnNuevoCandidatoConLosSiguientesDatos(DataTable dataTable) {
        Map<String, String> datos = dataTable.asMap(String.class, String.class);
        reclutador.attemptsTo(
                AddCandidate.withData(datos)
        );
    }

    @Cuando("pone el candidato en estado {string}")
    public void poneElCandidatoEnEstado(String estado) {
        reclutador.attemptsTo(
                ShortlistCandidate.now()
        );
    }

    @Cuando("programa una entrevista para el candidato")
    public void programaUnaEntrevistaParaElCandidato() {
        reclutador.attemptsTo(
                ScheduleInterview.withDetails()
        );
    }

    @Cuando("marca la entrevista como aprobada")
    public void marcaLaEntrevistaComoAprobada() {
        reclutador.attemptsTo(
                Click.on(RecruitmentPage.MARK_INTERVIEW_PASSED),
                Click.on(RecruitmentPage.SAVE_BUTTON)
        );
    }

    @Cuando("hace una oferta de trabajo al candidato")
    public void haceUnaOfertaDeTrabajoAlCandidato() {
        reclutador.attemptsTo(
                Click.on(RecruitmentPage.OFFER_JOB_BUTTON),
                Click.on(RecruitmentPage.SAVE_BUTTON)
        );
    }

    @Cuando("contrata al candidato")
    public void contrataAlCandidato() {
        reclutador.attemptsTo(
                Click.on(RecruitmentPage.HIRE_BUTTON),
                Click.on(RecruitmentPage.SAVE_BUTTON)
        );
    }

    @Entonces("el candidato debe aparecer con estado {string} en la lista")
    public void elCandidatoDebeAparecerConEstadoEnLaLista(String estadoEsperado) {
        reclutador.should(
                seeThat("El estado del candidato",
                        CandidateStatus.of("Santiago Sebastian Giraldo Agudelo"),
                        containsString(estadoEsperado)
                )
        );
    }
}

