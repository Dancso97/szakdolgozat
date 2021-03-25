package hu.beke.smol.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CreateAddressDto {

    @NotNull
    private String city;

    @NotNull
    private String address1;

    private String address2;
}
