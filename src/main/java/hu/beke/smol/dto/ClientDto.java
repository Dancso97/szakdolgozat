package hu.beke.smol.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ClientDto {

    @NotNull
    private int id;

    @NotNull
    private String type;

    @NotNull
    private String name;

}
