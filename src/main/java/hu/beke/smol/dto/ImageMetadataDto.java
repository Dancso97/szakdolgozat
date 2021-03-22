package hu.beke.smol.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Data
public class ImageMetadataDto {

    @NotNull
    private int id;

    @NotNull
    private String name;

    @NotNull
    private int height;

    @NotNull
    private int widht;

    @NotNull
    private Timestamp originalDate;

}
