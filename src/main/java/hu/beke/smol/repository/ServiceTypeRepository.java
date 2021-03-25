package hu.beke.smol.repository;

import hu.beke.smol.entity.ServiceTypeEntity;
import hu.beke.smol.exceptions.PersistenceException;

import java.util.List;

public interface ServiceTypeRepository {

    ServiceTypeEntity getServiceTypeEntityById(int id) throws PersistenceException;

    List<ServiceTypeEntity> getAllServiceType() throws PersistenceException;
}
