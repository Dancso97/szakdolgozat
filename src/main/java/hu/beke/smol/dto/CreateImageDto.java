package hu.beke.smol.dto;

import hu.beke.smol.entity.ImageMetadataEntity;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Data
public class CreateImageDto {

    @NotNull
    private Timestamp date;

    @NotNull
    private byte[] image;

    @NotNull
    private ImageMetadataDto pictureMetadata;

}
