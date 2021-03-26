package hu.beke.smol.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity(name = "Imagemetadata")
@Table(name = "imagemetadata")
@Data
public class ImageMetadataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "height")
    private int height;

    @NotNull
    @Column(name = "width")
    private int width;

    @NotNull
    @Column(name = "original_date")
    private Timestamp originalDate;
}
