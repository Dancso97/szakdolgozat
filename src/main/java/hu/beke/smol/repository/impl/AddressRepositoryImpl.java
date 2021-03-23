package hu.beke.smol.repository.impl;

import hu.beke.smol.entity.AddressEntity;
import hu.beke.smol.exceptions.PersistenceException;
import hu.beke.smol.repository.AddressRepository;

import java.util.List;

public class AddressRepositoryImpl implements AddressRepository {


    @Override
    public AddressEntity getAddressEntityById(int id) throws PersistenceException {
        return null;
    }

    @Override
    public List<AddressEntity> getAllAddress() throws PersistenceException {
        return null;
    }
}
