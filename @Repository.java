@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {
List<Report> PatientNameContainingIgnoreCase(String patientName);
List<Report> PatientId(String patientId);
List<Report> LaboratoryNameContainingIgnoreCase(String laboratoryName);
List<Report> LaboratorySurnameContainingIgnoreCase(String laboratorySurname);
}
