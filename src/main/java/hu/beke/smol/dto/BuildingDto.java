package hu.beke.smol.dto;

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
    private AddressDto address;

    @NotNull
    private ClientDto client;
}
