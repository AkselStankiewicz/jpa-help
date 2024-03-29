package sda.springbasic.jpaworkshop.model.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class EntryCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(nullable = false)
    private UUID uuid;

    public EntryCard(UUID uuid) {
        this.uuid = uuid;
    }

    @ManyToMany
    @JoinTable(name = "floor_access",
            joinColumns = @JoinColumn(name = "entry_card_id"),
            inverseJoinColumns = @JoinColumn(name = "floor_id")
    )
    private Set<Floor> floorAccess;

}
