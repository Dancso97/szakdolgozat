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
    private int pictureId;

    @NotNull
    private int serviceId;

    @NotNull
    private ImageDto image;

    private CreateServicesDto service;

}
