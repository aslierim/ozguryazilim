@RestController
@RequestMapping("/api/reports")
public class ReportController {
@PutMapping("/{id}")
public ResponseEntity<Report> updateReport(@PathVariable(value = "id") Long reportId,
@RequestBody Report reportDetails) {
Report report = reportRepository.findById(reportId)
report.FileNumber(reportDetails.FileNumber());
report.PatientName(reportDetails.PatientName());
report.PatientId(reportDetails.PatientId());
report.Title(reportDetails.Title());
report.Details(reportDetails.Details());
report.Date(reportDetails.Date());
Report updatedReport = reportRepository.save(report);
return ResponseEntity.ok(updatedReport);
}

@GetMapping("/search")
public List<Report> searchReports(@RequestParam(required = false) String patientName,
@RequestParam(required = false) String patientId,
@RequestParam(required = false) String sortBy) {
Sort sort = null;
if (sortBy != null && sortBy.equals("Date")) {
sort = Sort.by(sortBy).descending();
}
return reportRepository.searchReports(patientName, patientId, labName, sort);
}
@PostMapping("")
public Report createReport(@RequestBody Report report) {
return reportRepository.save(report);
}