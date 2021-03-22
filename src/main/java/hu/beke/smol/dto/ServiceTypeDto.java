package hu.beke.smol.dto;

import hu.beke.smol.entity.BuildingEntity;
import hu.beke.smol.entity.ServicesEntity;
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
    private ServicesEntity service;

    @NotNull
    private BuildingEntity building;

}
