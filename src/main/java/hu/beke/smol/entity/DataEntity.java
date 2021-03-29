package hu.beke.smol.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity(name = "Data")
@Table(name = "data")
@Data
public class DataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @Column(name = "plate")
    private String plate;

    @NotNull
    @Column(name = "created_date")
    private Timestamp createdDate;

    @Column(name = "stop_date")
    private Timestamp stopDate;

    @Column(name = "comment")
    private String comment;

    @OneToOne(orphanRemoval = true)
    @NotNull
    @JoinColumn(name = "image")
    private ImageEntity image;

    @OneToOne(orphanRemoval = true)
    @NotNull
    @JoinColumn(name = "service")
    private ServicesEntity service;

}
