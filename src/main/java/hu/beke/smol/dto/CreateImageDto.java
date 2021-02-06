package hu.beke.smol.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CreateImageDto {

    @NotNull
    private String name;

    @NotNull
    private String type;

    @NotNull
    private byte[] data;

}
