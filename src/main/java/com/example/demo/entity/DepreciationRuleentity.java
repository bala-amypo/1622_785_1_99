@Entity
@Table(name="depreciation_rules", uniqueConstraints = @UniqueConstraint(columnNames = "ruleName"))
public class DepreciationRule {

    @Id @GeneratedValue
    private Long id;

    @NotBlank
    private String ruleName;

    @NotBlank
    private String method;

    @Min(1)
    private int usefulLifeYears;

    @Min(0)
    private Double salvageValue;

    // getters/setters
}
