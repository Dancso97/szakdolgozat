package hu.beke.smol.repository;

import hu.beke.smol.entity.BuildingEntity;
import hu.beke.smol.entity.ClientEntity;
import hu.beke.smol.exceptions.PersistenceException;

import java.util.List;

public interface ClientRepository {

    ClientEntity getClientEntityById(int id) throws PersistenceException;

    List<ClientEntity> getAllClients() throws PersistenceException;

}
