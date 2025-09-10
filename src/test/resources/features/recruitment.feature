#language: es

# src/test/resources/features/recruitment.feature
Característica: Proceso de contratación en OrangeHRM
  Como reclutador del sistema OrangeHRM
  Quiero realizar el proceso completo de contratación de un candidato
  Para gestionar eficientemente las contrataciones de la empresa

  Escenario: Contratar un candidato exitosamente
    Dado que el reclutador ingresa al sistema OrangeHRM
    Cuando inicia sesión con credenciales válidas
    Y navega al módulo de Recruitment
    Y agrega un nuevo candidato con los siguientes datos:
      | nombre    | oscar               |
      | apellido1 | andres              |
      | apellido2 | roa                 |
      | email     | oscarandres@gmail.com |
      | contacto  | 453465464347        |
    Y programa una entrevista para el candidato con título "Technical Interview" y entrevistador "Test 60 Tester"
    Y marca la entrevista como aprobada
    Y hace una oferta de trabajo al candidato
    Y contrata al candidato
    Entonces el candidato debe aparecer con estado "Hired" en la lista
