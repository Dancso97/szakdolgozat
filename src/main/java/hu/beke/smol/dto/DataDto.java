package hu.beke.smol.dto;

import hu.beke.smol.entity.ImageEntity;
import hu.beke.smol.entity.ServicesEntity;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Data
public class DataDto {

    @NotNull
    private int id;

    @NotNull
    private String plate;

    @NotNull
    private Timestamp createdDate;

    private Timestamp stopDate;

    private String comment;

    @NotNull
    private ImageEntity image;

    @NotNull
    private ServicesEntity service;

}
