package hu.beke.smol.repository;

import hu.beke.smol.entity.AddressEntity;
import hu.beke.smol.exceptions.PersistenceException;

import java.util.List;

public interface AddressRepository {

    AddressEntity getAddressEntityById(int id) throws PersistenceException;

    List<AddressEntity> getAllAddress() throws PersistenceException;

}
