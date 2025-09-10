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
import screenplay.pages.RecruitmentPage;

import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actions.Click.on;
import static net.serenitybdd.screenplay.actions.Enter.theValue;
import static org.hamcrest.Matchers.equalTo;

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
        // Preparación ya realizada en @Before
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
                on(RecruitmentPage.RECRUITMENT_MENU)
        );
    }

    @Cuando("agrega un nuevo candidato con los siguientes datos:")
    public void agregaUnNuevoCandidatoConLosSiguientesDatos(DataTable dataTable) {
        Map<String,String> datos = dataTable.asMap(String.class, String.class);
        reclutador.attemptsTo(
                AddCandidate.withData(datos)
        );
    }

    @Cuando("programa una entrevista para el candidato con título {string} y entrevistador {string}")
    public void programaUnaEntrevistaParaElCandidato(String titulo, String entrevistador) {
        reclutador.attemptsTo(
                on(RecruitmentPage.SCHEDULE_INTERVIEW_BUTTON),
                theValue(titulo).into(RecruitmentPage.INTERVIEW_TITLE),
                theValue(entrevistador).into(RecruitmentPage.INTERVIEWER),
                on(RecruitmentPage.SAVE_INTERVIEW_BUTTON)
        );
    }

    @Cuando("marca la entrevista como aprobada")
    public void marcaLaEntrevistaComoAprobada() {
        reclutador.attemptsTo(
                on(RecruitmentPage.MARK_INTERVIEW_PASSED)
        );
    }

    @Cuando("hace una oferta de trabajo al candidato")
    public void haceUnaOfertaDeTrabajoAlCandidato() {
        reclutador.attemptsTo(
                on(RecruitmentPage.OFFER_JOB_BUTTON)
        );
    }

    @Cuando("contrata al candidato")
    public void contrataAlCandidato() {
        reclutador.attemptsTo(
                on(RecruitmentPage.HIRE_BUTTON)
        );
    }

    @Entonces("el candidato debe aparecer con estado {string} en la lista")
    public void elCandidatoDebeAparecerConEstadoEnLaLista(String estadoEsperado) {
        reclutador.should(
                seeThat("El estado del candidato",
                        CandidateStatus.of("oscar andres roa"),
                        equalTo(estadoEsperado)
                )
        );
    }
}
