package hu.beke.smol.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Data
public class CreateDataDto {

    @NotNull
    private String plate;

    @NotNull
    private Timestamp createdDate;

    private Timestamp stopDate;

    private String comment;

    @NotNull
    private ImageDto image;

    @NotNull
    private ServicesDto service;

}
