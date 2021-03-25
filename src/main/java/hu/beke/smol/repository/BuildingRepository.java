package hu.beke.smol.repository;

import hu.beke.smol.entity.BuildingEntity;
import hu.beke.smol.exceptions.PersistenceException;

import java.util.List;

public interface BuildingRepository {

    BuildingEntity getBuildingEntityById(int id) throws PersistenceException;

    List<BuildingEntity> getAllBuildings() throws PersistenceException;

}
