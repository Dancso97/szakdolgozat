package hu.beke.smol.repository.impl;

import hu.beke.smol.entity.ServicesEntity;
import hu.beke.smol.exceptions.PersistenceException;
import hu.beke.smol.repository.ServicesRepository;
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
public class ServicesRepositoryImpl implements ServicesRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public ServicesEntity getServicesEntityById(int id) throws PersistenceException {
        ServicesEntity result = null;
        try {
            TypedQuery<ServicesEntity> query = this.entityManager.createQuery("SELECT entity FROM services entity WHERE entity.id = :id", ServicesEntity.class);
            query.setParameter("id", id);

            result = query.getSingleResult();
        } catch (RuntimeException e) {
            throw new PersistenceException("getServicesEntityById failed!", e);
        }
        return result;
}

    @Override
    public List<ServicesEntity> getAllServices() throws PersistenceException {
        List<ServicesEntity> result = null;
        try {
            TypedQuery<ServicesEntity> query = this.entityManager.createQuery("SELECT entity FROM services entity", ServicesEntity.class);
            result = query.getResultList();
        } catch (RuntimeException e) {
            throw new PersistenceException("getAllServices failed!", e);
        }
        return result;
    }
}
