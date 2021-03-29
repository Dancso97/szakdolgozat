package hu.beke.smol.repository.impl;

import hu.beke.smol.entity.ServiceTypeEntity;
import hu.beke.smol.exceptions.PersistenceException;
import hu.beke.smol.repository.ServiceTypeRepository;
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
public class ServiceTypeRepositoryImpl implements ServiceTypeRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public ServiceTypeEntity getServiceTypeEntityById(int id) throws PersistenceException {
        ServiceTypeEntity result = null;
        try {
            TypedQuery<ServiceTypeEntity> query = this.entityManager.createQuery("SELECT entity FROM Servicetype entity WHERE entity.id = :id", ServiceTypeEntity.class);
            query.setParameter("id", id);

            result = query.getSingleResult();
        } catch (RuntimeException e) {
            throw new PersistenceException("getServiceTypeEntityById failed!", e);
        }
        return result;
    }

    @Override
    public List<ServiceTypeEntity> getAllServiceType() throws PersistenceException {
        List<ServiceTypeEntity> result = null;
        try {
            TypedQuery<ServiceTypeEntity> query = this.entityManager.createQuery("SELECT entity FROM Servicetype entity", ServiceTypeEntity.class);
            result = query.getResultList();
        } catch (RuntimeException e) {
            throw new PersistenceException("getAllServiceType failed!", e);
        }
        return result;
    }
}
