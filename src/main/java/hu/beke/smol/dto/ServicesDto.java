package hu.beke.smol.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ServicesDto {

    @NotNull
    private int id;

    @NotNull
    private String name;

    private String comment;

}
