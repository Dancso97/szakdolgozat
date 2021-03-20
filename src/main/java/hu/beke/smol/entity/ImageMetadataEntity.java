package hu.beke.smol.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity(name = "imagemetadata")
@Table(name = "imagemetadata")
@Data
public class ImageMetadataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "height")
    private int height;

    @NotNull
    @Column(name = "widht")
    private int widht;

    @NotNull
    @Column(name = "originalDate")
    private Timestamp originalDate;
}
