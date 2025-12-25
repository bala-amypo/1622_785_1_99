@Entity
@Table(name="assets", uniqueConstraints = @UniqueConstraint(columnNames="assetTag"))
public class Asset {

    @Id @GeneratedValue
    private Long id;

    @NotBlank
    private String assetTag;

    private String assetName;
    private LocalDate purchaseDate;

    @Min(0)
    private Double purchaseCost;

    private String status = "ACTIVE";

    @ManyToOne
    private Vendor vendor;

    @ManyToOne
    private DepreciationRule depreciationRule;

    // getters/setters
}
