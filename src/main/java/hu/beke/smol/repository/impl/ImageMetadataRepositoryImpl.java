package hu.beke.smol.repository.impl;

import hu.beke.smol.entity.ImageMetadataEntity;
import hu.beke.smol.exceptions.PersistenceException;
import hu.beke.smol.repository.ImageMetadataRepository;

import java.util.List;

public class ImageMetadataRepositoryImpl implements ImageMetadataRepository {

    @Override
    public ImageMetadataEntity getImageMetadataEntityById(int id) throws PersistenceException {
        return null;
    }

    @Override
    public List<ImageMetadataEntity> getAllImageMetadata() throws PersistenceException {
        return null;
    }
}
