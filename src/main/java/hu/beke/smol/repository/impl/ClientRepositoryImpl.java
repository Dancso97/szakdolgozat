package hu.beke.smol.repository.impl;

import hu.beke.smol.entity.ClientEntity;
import hu.beke.smol.exceptions.PersistenceException;
import hu.beke.smol.repository.ClientRepository;
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
public class ClientRepositoryImpl implements ClientRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public ClientEntity getClientEntityById(int id) throws PersistenceException {
        ClientEntity result = null;
        try {
            TypedQuery<ClientEntity> query = this.entityManager.createQuery("SELECT entity FROM client entity WHERE entity.id = :id", ClientEntity.class);
            query.setParameter("id", id);

            result = query.getSingleResult();
        } catch (RuntimeException e) {
            throw new PersistenceException("getClientEntityById failed!", e);
        }
        return result;
    }

    @Override
    public List<ClientEntity> getAllClients() throws PersistenceException {
        List<ClientEntity> result = null;
        try {
            TypedQuery<ClientEntity> query = this.entityManager.createQuery("SELECT entity FROM client entity", ClientEntity.class);
            result = query.getResultList();
        } catch (RuntimeException e) {
            throw new PersistenceException("getAllClients failed!", e);
        }
        return result;
    }
}
