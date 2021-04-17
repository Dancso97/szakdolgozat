package hu.beke.smol.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity(name = "Building")
@Table(name = "building")
@Data
public class BuildingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @Column(name = "added_date")
    private Timestamp addedDate;

    @NotNull
    @Column(name = "comment")
    private String comment;

    @OneToOne(orphanRemoval = true)
    @NotNull
    @JoinColumn(name = "address")
    private AddressEntity address;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "client")
    private ClientEntity client;

}
