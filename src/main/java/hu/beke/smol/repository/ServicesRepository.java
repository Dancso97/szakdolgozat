package hu.beke.smol.repository;

import hu.beke.smol.entity.ClientEntity;
import hu.beke.smol.entity.ServicesEntity;
import hu.beke.smol.exceptions.PersistenceException;

import java.util.List;

public interface ServicesRepository {

    ServicesEntity getServicesEntityById(int id) throws PersistenceException;

    List<ServicesEntity> getAllServices() throws PersistenceException;

}
