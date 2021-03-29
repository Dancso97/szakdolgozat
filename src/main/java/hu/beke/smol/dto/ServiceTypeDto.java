package hu.beke.smol.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Data
public class ServiceTypeDto {

    @NotNull
    private int id;

    @NotNull
    private Timestamp startDate;

    @NotNull
    private Timestamp endDate;

    @NotNull
    private ServicesDto service;

    @NotNull
    private BuildingDto building;

}
