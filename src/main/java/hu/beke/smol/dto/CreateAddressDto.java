package hu.beke.smol.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
public class CreateAddressDto {

    @NotNull
    private String city;

    @NotNull
    private String address1;

    private String address2;
}
