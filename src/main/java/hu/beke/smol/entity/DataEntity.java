package hu.beke.smol.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity(name = "data")
@Table(name = "lpr_data")
@Data
public class DataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @Column(name = "start_time")
    private Timestamp start_time;

    @Column(name = "end_time")
    private Timestamp end_time;

    @OneToOne(orphanRemoval = true)
    @NotNull
    @JoinColumn(name = "picture")
    private ImageEntity picture;

    @NotNull
    @Column(name = "plate_number")
    private String plate_number;

}
