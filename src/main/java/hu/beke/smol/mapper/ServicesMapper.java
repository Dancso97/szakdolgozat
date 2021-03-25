package hu.beke.smol.mapper;

import hu.beke.smol.dto.ServicesDto;
import hu.beke.smol.dto.CreateServicesDto;
import hu.beke.smol.entity.ServicesEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public abstract class ServicesMapper {

    public abstract ServicesEntity mapCreateServicesDtoToEntity(CreateServicesDto ServicesDto);

    public abstract ServicesEntity mapServicesDtoToEntity(ServicesDto ServicesDto);

    public abstract List<ServicesEntity> mapServicesDtosToEntities(List<ServicesDto> ServicesDtos);

    public abstract ServicesDto mapServicesEntityToDto(ServicesEntity entity);

    public abstract List<ServicesDto> mapServicesEntitiesToDtos(List<ServicesEntity> entityList);

}
