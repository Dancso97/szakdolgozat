package hu.beke.smol.repository.impl;

import hu.beke.smol.exceptions.PersistenceException;
import hu.beke.smol.repository.CommonRepository;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@NoArgsConstructor
@Repository
@Transactional
public class CommonRepositoryImpl implements CommonRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void createEntity(Object object) throws PersistenceException {
        try {
            this.entityManager.persist(object);
            this.entityManager.flush();
        } catch (RuntimeException e) {
            throw new PersistenceException("Create entity failed!", e);
        }
    }

    @Override
    public void updateEntity(Object object) throws PersistenceException {
        try {
            this.entityManager.merge(object);
            this.entityManager.flush();
        } catch (RuntimeException e) {
            throw new PersistenceException("Update entity failed", e);
        }
    }

    @Override
    public void deleteEntity(Object object) throws PersistenceException {
        try {
            this.entityManager.remove(object);
            this.entityManager.flush();
        } catch (RuntimeException e) {
            throw new PersistenceException("Delete entity failed", e);
        }
    }
}
