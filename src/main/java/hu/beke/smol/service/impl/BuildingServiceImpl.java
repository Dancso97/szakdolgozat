package hu.beke.smol.service.impl;

import hu.beke.smol.dto.BuildingDto;
import hu.beke.smol.dto.CreateBuildingDto;
import hu.beke.smol.entity.BuildingEntity;
import hu.beke.smol.exceptions.PersistenceException;
import hu.beke.smol.exceptions.ServiceException;
import hu.beke.smol.mapper.BuildingMapper;
import hu.beke.smol.repository.BuildingRepository;
import hu.beke.smol.repository.CommonRepository;
import hu.beke.smol.service.BuildingService;
import lombok.NoArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class BuildingServiceImpl implements BuildingService {

    private static final BuildingMapper BUILDING_MAPPER = Mappers.getMapper(BuildingMapper.class);

    @Autowired
    BuildingRepository buildingRepository;

    @Autowired
    CommonRepository commonRepository;

    @Override
    public BuildingDto createBuilding(CreateBuildingDto createBuildingDto) throws ServiceException {
        try{
            BuildingEntity entity = BUILDING_MAPPER.mapCreateBuildingDtoToEntity(createBuildingDto);
            commonRepository.createEntity(entity);

            return BUILDING_MAPPER.mapBuildingEntityToDto(entity);

        }catch (PersistenceException e){
            throw new ServiceException("Failed in createBuilding!",e);
        }
    }

    @Override
    public BuildingDto updateBuilding(BuildingDto BuildingDto) throws ServiceException {
        try{
            BuildingEntity entity = BUILDING_MAPPER.mapBuildingDtoToEntity(BuildingDto);
            commonRepository.updateEntity(entity);

            return BUILDING_MAPPER.mapBuildingEntityToDto(entity);

        }catch (PersistenceException e){
            throw new ServiceException("Failed in updateBuilding!",e);
        }
    }

    @Override
    public void deleteBuilding(int id) throws ServiceException {
        try{
            commonRepository.deleteEntity(buildingRepository.getBuildingEntityById(id));
        }catch (PersistenceException e){
            throw new ServiceException("Failed in updateBuilding!",e);
        }
    }

    @Override
    public BuildingDto getBuildingById(int id) throws ServiceException {
        try{
            return BUILDING_MAPPER.mapBuildingEntityToDto(buildingRepository.getBuildingEntityById(id));
        }catch (PersistenceException e){
            throw new ServiceException("Failed in updateBuilding!",e);
        }
    }

    @Override
    public List<BuildingDto> getAllBuilding() throws ServiceException {
        try {
            return BUILDING_MAPPER.mapBuildingEntitiesToDtos(buildingRepository.getAllBuildings());
        }catch (PersistenceException e){
            throw new ServiceException("getAllBuilding in service failed ", e);
        }
    }
    
}
