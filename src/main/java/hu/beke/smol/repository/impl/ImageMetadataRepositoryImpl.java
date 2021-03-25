package hu.beke.smol.repository.impl;

import hu.beke.smol.entity.BuildingEntity;
import hu.beke.smol.entity.ImageMetadataEntity;
import hu.beke.smol.exceptions.PersistenceException;
import hu.beke.smol.repository.ImageMetadataRepository;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@NoArgsConstructor
@Transactional
public class ImageMetadataRepositoryImpl implements ImageMetadataRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public ImageMetadataEntity getImageMetadataEntityById(int id) throws PersistenceException {
        ImageMetadataEntity result = null;
        try {
            TypedQuery<ImageMetadataEntity> query = this.entityManager.createQuery("SELECT entity FROM building entity WHERE entity.id = :id", ImageMetadataEntity.class);
            query.setParameter("id", id);

            result = query.getSingleResult();
        } catch (RuntimeException e) {
            throw new PersistenceException("getImageMetadataEntityById failed!", e);
        }
        return result;
    }

    @Override
    public List<ImageMetadataEntity> getAllImageMetadata() throws PersistenceException {
        List<ImageMetadataEntity> result = null;
        try {
            TypedQuery<ImageMetadataEntity> query = this.entityManager.createQuery("SELECT entity FROM building entity", ImageMetadataEntity.class);
            result = query.getResultList();
        } catch (RuntimeException e) {
            throw new PersistenceException("getAllImageMetadata failed!", e);
        }
        return result;
    }
}
