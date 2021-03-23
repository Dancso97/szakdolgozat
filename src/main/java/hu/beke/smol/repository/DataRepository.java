package hu.beke.smol.repository;

import hu.beke.smol.entity.DataEntity;
import hu.beke.smol.exceptions.PersistenceException;

import java.util.List;

public interface DataRepository {

    DataEntity getDataEntityById(int id) throws PersistenceException;

    List<DataEntity> getAllDataEntities() throws PersistenceException;

}
