package hu.beke.smol.repository;

import hu.beke.smol.entity.ImageEntity;
import hu.beke.smol.exceptions.PersistenceException;

import java.util.List;

public interface ImageRepository {

    void createImageEntity(ImageEntity entity) throws PersistenceException;

    void updateImageEntity(ImageEntity entity) throws PersistenceException;

    void deleteImageEntity(int id) throws PersistenceException;

    ImageEntity getImageEntityById(int id) throws PersistenceException;

    List<ImageEntity> getAllImageEntities() throws PersistenceException;
}
