package hu.beke.smol.repository.impl;

import hu.beke.smol.entity.DataEntity;
import hu.beke.smol.exceptions.PersistenceException;
import hu.beke.smol.repository.DataRepository;
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
public class DataRepositoryImpl implements DataRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public DataEntity getDataEntityById(int id) throws PersistenceException {
        DataEntity result = null;
        try {
            TypedQuery<DataEntity> query = this.entityManager.createQuery("SELECT entity FROM data entity WHERE entity.id = :id", DataEntity.class);
            query.setParameter("id", id);

            result = query.getSingleResult();
        }catch (RuntimeException e){
            throw new PersistenceException("getDataEntityById failed!", e);
        }
        return result;
    }

    @Override
    public List<DataEntity> getAllDataEntities() throws PersistenceException {
        List<DataEntity> result = null;
        try {
            TypedQuery<DataEntity> query = this.entityManager.createQuery("SELECT entity FROM data entity", DataEntity.class);
            result = query.getResultList();
        }catch (RuntimeException e){
            throw new PersistenceException("getAllDataEntities failed!", e);
        }
        return result;
    }
}
