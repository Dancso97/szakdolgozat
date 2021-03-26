package hu.beke.smol.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class CreateImageMetadataDto {

    @NotNull
    private String name;

    @NotNull
    private int height;

    @NotNull
    private int width;

    @NotNull
    private Date originalDate;

}
