package hu.beke.smol.repository.impl;

import hu.beke.smol.entity.BuildingEntity;
import hu.beke.smol.exceptions.PersistenceException;
import hu.beke.smol.repository.BuildingRepository;

import java.util.List;

public class BuildingRepositoryImpl implements BuildingRepository {

    @Override
    public BuildingEntity getBuildingEntityById(int id) throws PersistenceException {
        return null;
    }

    @Override
    public List<BuildingEntity> getAllBuildings() throws PersistenceException {
        return null;
    }
}
