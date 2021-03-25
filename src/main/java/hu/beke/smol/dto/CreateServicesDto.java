package hu.beke.smol.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CreateServicesDto {

    @NotNull
    private String name;

    private String comment;
}
