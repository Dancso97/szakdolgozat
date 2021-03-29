package hu.beke.smol.repository.impl;

import hu.beke.smol.entity.BuildingEntity;
import hu.beke.smol.exceptions.PersistenceException;
import hu.beke.smol.repository.BuildingRepository;
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
public class BuildingRepositoryImpl implements BuildingRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public BuildingEntity getBuildingEntityById(int id) throws PersistenceException {
        BuildingEntity result = null;
        try {
            TypedQuery<BuildingEntity> query = this.entityManager.createQuery("SELECT entity FROM Building entity WHERE entity.id = :id", BuildingEntity.class);
            query.setParameter("id", id);

            result = query.getSingleResult();
        } catch (RuntimeException e) {
            throw new PersistenceException("getBuildingEntityById failed!", e);
        }
        return result;
    }

    @Override
    public List<BuildingEntity> getAllBuildings() throws PersistenceException {
        List<BuildingEntity> result = null;
        try {
            TypedQuery<BuildingEntity> query = this.entityManager.createQuery("SELECT entity FROM Building entity", BuildingEntity.class);
            result = query.getResultList();
        } catch (RuntimeException e) {
            throw new PersistenceException("getAllBuildings failed!", e);
        }
        return result;
    }
}
