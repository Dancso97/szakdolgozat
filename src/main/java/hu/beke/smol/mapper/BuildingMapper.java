package hu.beke.smol.mapper;

import hu.beke.smol.dto.BuildingDto;
import hu.beke.smol.dto.CreateBuildingDto;
import hu.beke.smol.entity.BuildingEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public abstract class BuildingMapper {

    public abstract BuildingEntity mapCreateBuildingDtoToEntity(CreateBuildingDto buildingDto);

    public abstract BuildingEntity mapBuildingDtoToEntity(BuildingDto buildingDto);

    public abstract List<BuildingEntity> mapBuildingDtosToEntities(List<BuildingDto> buildingDtos);

    public abstract BuildingDto mapBuildingEntityToDto(BuildingEntity entity);

    public abstract List<BuildingDto> mapBuildingEntitiesToDtos(List<BuildingEntity> entityList);

}
