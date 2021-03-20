package hu.beke.smol.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity(name = "servicetype")
@Table(name = "servicetype")
@Data
public class ServiceTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "startDate")
    private Timestamp startDate;

    @Column(name = "endDate")
    private Timestamp endDate;

    @NotNull
    @OneToOne
    @JoinColumn(name = "service")
    private ServicesEntity service;

    @NotNull
    @OneToOne
    @JoinColumn(name = "building")
    private BuildingEntity building;
}
