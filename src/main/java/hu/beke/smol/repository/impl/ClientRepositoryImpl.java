package hu.beke.smol.repository.impl;

import hu.beke.smol.entity.ClientEntity;
import hu.beke.smol.exceptions.PersistenceException;
import hu.beke.smol.repository.ClientRepository;

import java.util.List;

public class ClientRepositoryImpl implements ClientRepository {

    @Override
    public ClientEntity getClientEntityById(int id) throws PersistenceException {
        return null;
    }

    @Override
    public List<ClientEntity> getAllClients() throws PersistenceException {
        return null;
    }
}
