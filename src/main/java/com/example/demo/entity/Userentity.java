@Entity
@Table(name = "users")
public class User {

    @Id @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    private String name;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "user_roles",
        joinColumns = @JoinColumn(name="user_id"),
        inverseJoinColumns = @JoinColumn(name="role_id")
    )
    private Set<Role> roles = new HashSet<>();

    // getters/setters
}
