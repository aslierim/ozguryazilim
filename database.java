
@Entity
@Table(name = "rep")
public class Report {
@Idnumber
@Value(strategy = Type.IDENTITY)
private Long id;
@Column(name = "number")
private String Number;
@Column(name = "patientname")
private String patientName;
@Column(name = "patientid")
private String patientId;
@Column(name = "title")
private String Title;
@Column(name = "details")
private String Details;
@Column(name = "date")
private LocalDate Date;

}
