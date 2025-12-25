@Entity
public class AssetDisposal {

    @Id @GeneratedValue
    private Long id;

    private String disposalMethod;
    private Double disposalValue;
    private LocalDate disposalDate;

    @ManyToOne
    private Asset asset;

    @ManyToOne
    private User approvedBy;
}
