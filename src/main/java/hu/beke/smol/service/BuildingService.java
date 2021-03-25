package hu.beke.smol.service;

import hu.beke.smol.dto.BuildingDto;
import hu.beke.smol.dto.CreateBuildingDto;
import hu.beke.smol.exceptions.ServiceException;

import java.util.List;

public interface BuildingService {

    BuildingDto createBuilding(CreateBuildingDto createBuildingDto) throws ServiceException;

    BuildingDto updateBuilding(BuildingDto BuildingDto) throws ServiceException;

    void deleteBuilding(int id) throws ServiceException;

    BuildingDto getBuildingById(int id) throws ServiceException;

    List<BuildingDto> getAllBuilding() throws ServiceException;

}
