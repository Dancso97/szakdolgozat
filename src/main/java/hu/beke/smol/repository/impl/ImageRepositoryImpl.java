package hu.beke.smol.repository.impl;


import hu.beke.smol.entity.ImageEntity;
import hu.beke.smol.exceptions.PersistenceException;
import hu.beke.smol.repository.ImageRepository;
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
public class ImageRepositoryImpl implements ImageRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public ImageEntity getImageEntityById(int id) throws PersistenceException {
        ImageEntity result = null;
        try {
            TypedQuery<ImageEntity> query = this.entityManager.createQuery("SELECT entity FROM image entity WHERE entity.id = :id", ImageEntity.class);
            query.setParameter("id", id);

            result = query.getSingleResult();
        } catch (RuntimeException e) {
            throw new PersistenceException("getImageEntityById failed!", e);
        }
        return result;
    }

    @Override
    public List<ImageEntity> getAllImageEntities() throws PersistenceException {
        List<ImageEntity> result = null;
        try {
            TypedQuery<ImageEntity> query = this.entityManager.createQuery("SELECT entity FROM image entity", ImageEntity.class);
            result = query.getResultList();
        } catch (RuntimeException e) {
            throw new PersistenceException("getAllImageEntities failed!", e);
        }
        return result;
    }
}

