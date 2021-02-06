package hu.beke.smol.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "image")
@Table(name = "lpr_image")
@Data
public class ImageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "type")
    private String type;

    @NotNull
    @Column(name = "data")
    @Lob
    private byte[] data;
}
