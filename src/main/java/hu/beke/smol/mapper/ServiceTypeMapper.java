package hu.beke.smol.mapper;

import hu.beke.smol.dto.ServiceTypeDto;
import hu.beke.smol.dto.CreateServiceTypeDto;
import hu.beke.smol.entity.ServiceTypeEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public abstract class ServiceTypeMapper {

    public abstract ServiceTypeEntity mapCreateServiceTypeDtoToEntity(CreateServiceTypeDto ServiceTypeDto);

    public abstract ServiceTypeEntity mapServiceTypeDtoToEntity(ServiceTypeDto ServiceTypeDto);

    public abstract List<ServiceTypeEntity> mapServiceTypeDtosToEntities(List<ServiceTypeDto> ServiceTypeDtos);

    public abstract ServiceTypeDto mapServiceTypeEntityToDto(ServiceTypeEntity entity);

    public abstract List<ServiceTypeDto> mapServiceTypeEntitiesToDtos(List<ServiceTypeEntity> entityList);
}
