package hu.beke.smol.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity(name = "Image")
@Table(name = "image")
@Data
public class ImageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @Column(name = "date")
    private Timestamp date;

    @NotNull
    @Column(name = "image")
    @Lob
    private byte[] image;

    @NotNull
    @OneToOne
    @JoinColumn(name = "image_metadata")
    private ImageMetadataEntity pictureMetadata;
}
