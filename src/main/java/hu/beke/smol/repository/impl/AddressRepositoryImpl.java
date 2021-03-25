package hu.beke.smol.repository.impl;

import hu.beke.smol.entity.AddressEntity;
import hu.beke.smol.entity.ImageEntity;
import hu.beke.smol.exceptions.PersistenceException;
import hu.beke.smol.repository.AddressRepository;
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
public class AddressRepositoryImpl implements AddressRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public AddressEntity getAddressEntityById(int id) throws PersistenceException {
        AddressEntity result = null;
        try {
            TypedQuery<AddressEntity> query = this.entityManager.createQuery("SELECT entity FROM address entity WHERE entity.zip = :id", AddressEntity.class);
            query.setParameter("id", id);

            result = query.getSingleResult();
        } catch (RuntimeException e) {
            throw new PersistenceException("getAddressEntityById failed!", e);
        }
        return result;
    }

    @Override
    public List<AddressEntity> getAllAddress() throws PersistenceException {
        List<AddressEntity> result = null;
        try {
            TypedQuery<AddressEntity> query = this.entityManager.createQuery("SELECT entity FROM address entity", AddressEntity.class);
            result = query.getResultList();
        } catch (RuntimeException e) {
            throw new PersistenceException("getAllAddress failed!", e);
        }
        return result;
    }
}
