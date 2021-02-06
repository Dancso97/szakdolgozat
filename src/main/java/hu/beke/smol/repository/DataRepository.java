package hu.beke.smol.repository;

import hu.beke.smol.entity.DataEntity;
import hu.beke.smol.exceptions.PersistenceException;

import java.util.List;

public interface DataRepository {

    void createDataEntity(DataEntity entity) throws PersistenceException;

    void updateDataEntity(DataEntity entity) throws PersistenceException;

    void deleteDataEntity(int id) throws PersistenceException;

    DataEntity getDataEntityById(int id) throws PersistenceException;

    List<DataEntity> getAllDataEntities() throws PersistenceException;

}
