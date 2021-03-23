package hu.beke.smol.repository;

import hu.beke.smol.entity.ImageEntity;
import hu.beke.smol.exceptions.PersistenceException;

import java.util.List;

public interface ImageRepository {

    ImageEntity getImageEntityById(int id) throws PersistenceException;

    List<ImageEntity> getAllImageEntities() throws PersistenceException;

}
