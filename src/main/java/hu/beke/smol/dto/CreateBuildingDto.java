package hu.beke.smol.dto;

import hu.beke.smol.entity.AddressEntity;
import hu.beke.smol.entity.ClientEntity;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Data
public class CreateBuildingDto {

    @NotNull
    private Timestamp addedDate;

    @NotNull
    private String comment;

    @NotNull
    private AddressEntity address;

    @NotNull
    private ClientEntity client;
}
