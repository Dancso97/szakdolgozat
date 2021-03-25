package hu.beke.smol.dto;

import hu.beke.smol.entity.AddressEntity;
import hu.beke.smol.entity.ClientEntity;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Data
public class BuildingDto {

    @NotNull
    private int id;

    @NotNull
    private Timestamp addedDate;

    @NotNull
    private String comment;

    @NotNull
    private AddressEntity address;

    @NotNull
    private ClientEntity client;
}
