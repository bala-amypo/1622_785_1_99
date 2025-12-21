package com.example.demo.entity;
import jakarta.validation.constraints.*;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssetLifecycleEvententity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long assetId;
    @NotNull(message="EventType is required") 
    private String eventType;
    private String eventDescription;
    @PastOrPresent(message = "Eventdate cannot be in the future")
    private LocalDate eventDate;
    private LocalDateTime loggedAt = LocalDateTime.now();
}
