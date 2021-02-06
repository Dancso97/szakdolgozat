package hu.beke.smol.dto;

import hu.beke.smol.entity.ImageEntity;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Data
public class DataDto {

    @NotNull
    private int id;

    @NotNull
    private Timestamp start_time;

    private Timestamp end_time;

    @NotNull
    private ImageEntity picture;

    @NotNull
    private String plate_number;
}
