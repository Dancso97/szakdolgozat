package hu.beke.smol.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
public class CreateServicesDto {

    @NotNull
    private String name;

    private String comment;
}
