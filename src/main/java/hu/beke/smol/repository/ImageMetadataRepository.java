package hu.beke.smol.repository;

import hu.beke.smol.entity.ClientEntity;
import hu.beke.smol.entity.ImageMetadataEntity;
import hu.beke.smol.exceptions.PersistenceException;

import java.util.List;

public interface ImageMetadataRepository {

    ImageMetadataEntity getImageMetadataEntityById(int id) throws PersistenceException;

    List<ImageMetadataEntity> getAllImageMetadata() throws PersistenceException;

}
