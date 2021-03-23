package hu.beke.smol.repository.impl;

import hu.beke.smol.entity.ServicesEntity;
import hu.beke.smol.exceptions.PersistenceException;
import hu.beke.smol.repository.ServicesRepository;

import java.util.List;

public class ServicesRepositoryImpl implements ServicesRepository {

    @Override
    public ServicesEntity getServicesEntityById(int id) throws PersistenceException {
        return null;
    }

    @Override
    public List<ServicesEntity> getAllServices() throws PersistenceException {
        return null;
    }
}
