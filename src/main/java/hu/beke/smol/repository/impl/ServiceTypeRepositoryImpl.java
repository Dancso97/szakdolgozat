package hu.beke.smol.repository.impl;

import hu.beke.smol.entity.ServiceTypeEntity;
import hu.beke.smol.exceptions.PersistenceException;
import hu.beke.smol.repository.ServiceTypeRepository;

import java.util.List;

public class ServiceTypeRepositoryImpl implements ServiceTypeRepository {

    @Override
    public ServiceTypeEntity getServiceTypeEntityById(int id) throws PersistenceException {
        return null;
    }

    @Override
    public List<ServiceTypeEntity> getAllServiceType() throws PersistenceException {
        return null;
    }
}
