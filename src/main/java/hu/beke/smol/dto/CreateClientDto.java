package hu.beke.smol.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CreateClientDto {

    @NotNull
    private String type;

    @NotNull
    private String name;

}
