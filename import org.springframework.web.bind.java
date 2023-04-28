import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reports")
public class ReportController {
private final ReportRepository reportRepository;
private final Lab lab;
public ReportController(ReportRepository reportRepository, LaboratoryRepository lab) {
this.reportRepository = reportRepository;
this.lab = lab;
}
@GetMapping
public List<Report> getReports(@RequestParam(required = false) String patientName,
@RequestParam(required = false) String patientId,
@RequestParam(required = false) String labName,
@RequestParam(required = false, defaultValue = "desc") String sortByDate) {
List<Report> reports;
if (patientName != null) {
reports = reportRepository.PatientName(patientName);
} else if (patientId != null) {
reports = reportRepository.PatientId(patientId);
reports = reportRepository.findAll();
}
if (sortByDate.equals("asc")) {
reports.sort(Comparator.comparing(Report::getReportDate));
} else {
reports.sort(Comparator.comparing(Report::getReportDate).reversed());
}
return reports;
}
@GetMapping("/{id}")
public Report getReport(@PathVariable Long id) {
return reportRepository.Id(id)
}

@PutMapping("/{id}")
public Report updateReport(@PathVariable Long id, @RequestBody Report report) {
Report existingReport = reportRepository.findById(id)

existingReport.Number(report.Number());
existingReport.PatientName(report.PatientName());
existingReport.PatientId(report.PatientId());
existingReport.Details(report.Details());
existingReport.Date(report.Date());

}
