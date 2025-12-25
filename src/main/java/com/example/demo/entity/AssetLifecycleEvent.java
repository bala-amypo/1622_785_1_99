@Entity
public class AssetLifecycleEvent {

    @Id @GeneratedValue
    private Long id;

    @NotBlank
    private String eventType;

    @NotBlank
    private String eventDescription;

    private LocalDate eventDate;

    @ManyToOne
    private Asset asset;
}
