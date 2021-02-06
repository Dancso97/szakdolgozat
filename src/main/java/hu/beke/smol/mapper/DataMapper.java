package hu.beke.smol.mapper;

import hu.beke.smol.dto.CreateDataDto;
import hu.beke.smol.dto.DataDto;
import hu.beke.smol.entity.DataEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public abstract class DataMapper {

    public abstract DataEntity mapCreateDataDtoToEntity(CreateDataDto createDataDto);

    public abstract DataEntity mapDataDtoToEntity(DataDto dataDto);

    public abstract List<DataEntity> mapDataDtosToEntities(List<DataDto> dataDtos);

    public abstract DataDto mapDataEntityToDto(DataEntity entity);

    public abstract List<DataDto> mapDataEntitiesToDtos(List<DataEntity> entityList);

}
