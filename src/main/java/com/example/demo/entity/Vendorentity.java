@Entity
@Table(name="vendors", uniqueConstraints = @UniqueConstraint(columnNames = "vendorName"))
public class Vendor {

    @Id @GeneratedValue
    private Long id;

    @NotBlank
    private String vendorName;

    @Email
    private String contactEmail;

    // getters/setters
}
