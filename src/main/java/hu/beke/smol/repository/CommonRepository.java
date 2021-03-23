package hu.beke.smol.repository;

import hu.beke.smol.exceptions.PersistenceException;

public interface CommonRepository {

    public void createEntity(Object object) throws PersistenceException;

    public void updateEntity(Object object) throws PersistenceException;

    public void deleteEntity(Object object) throws PersistenceException;

}
