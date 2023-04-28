@Entity
@Table(name = "lab")
public class Lab {
@Idnumber
@Value(strategy = Type.IDENTITY)
private Long id;
@Column(name = "name")
private String name;
@Column(name = "surname")
private String surname;
@Column(name = "hospitalid")
private String hospitalId;
}
