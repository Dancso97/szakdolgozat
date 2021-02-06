package hu.beke.smol.dto;

import hu.beke.smol.entity.ImageEntity;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Data
public class CreateDataDto {

    @NotNull
    private Timestamp start_time;

    @NotNull
    private CreateImageDto picture;

    @NotNull
    private String plate_number;

}
