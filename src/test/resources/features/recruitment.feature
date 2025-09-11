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
      | nombre    | Santiago              |
      | apellido1 | Sebastian             |
      | apellido2 | Giraldo Agudelo       |
      | email     | santiago@example.com  |
      | contacto  | 1234567890            |
      | vacancy   | Payroll Administrator |
    Y pone el candidato en estado "Shortlisted"
    Y programa una entrevista para el candidato
    Y marca la entrevista como aprobada
    Y hace una oferta de trabajo al candidato
    Y contrata al candidato
    Entonces el candidato debe aparecer con estado "Hired" en la lista

