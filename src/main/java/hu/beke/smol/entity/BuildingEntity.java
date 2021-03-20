package hu.beke.smol.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity(name = "building")
@Table(name = "building")
@Data
public class BuildingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(name = "addedDate")
    private Timestamp addedDate;

    @NotNull
    @Column(name = "comment")
    private String comment;

    @OneToOne
    @NotNull
    @JoinColumn(name = "address")
    private AddressEntity address;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "client")
    private ClientEntity client;

}
