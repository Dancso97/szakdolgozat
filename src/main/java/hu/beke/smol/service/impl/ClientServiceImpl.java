package hu.beke.smol.service.impl;

import hu.beke.smol.dto.ClientDto;
import hu.beke.smol.dto.CreateClientDto;
import hu.beke.smol.entity.ClientEntity;
import hu.beke.smol.exceptions.PersistenceException;
import hu.beke.smol.exceptions.ServiceException;
import hu.beke.smol.mapper.ClientMapper;
import hu.beke.smol.repository.ClientRepository;
import hu.beke.smol.repository.CommonRepository;
import hu.beke.smol.service.ClientService;
import lombok.NoArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@NoArgsConstructor
@Service
public class ClientServiceImpl implements ClientService {

    private static final ClientMapper CLIENT_MAPPER = Mappers.getMapper(ClientMapper.class);

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    CommonRepository commonRepository;

    @Override
    public ClientDto createClient(CreateClientDto createClientDto) throws ServiceException {
        try{
            ClientEntity entity = CLIENT_MAPPER.mapCreateClientDtoToEntity(createClientDto);
            commonRepository.createEntity(entity);

            return CLIENT_MAPPER.mapClientEntityToDto(entity);

        }catch (PersistenceException e){
            throw new ServiceException("Failed in createClient!",e);
        }
    }

    @Override
    public ClientDto updateClient(ClientDto ClientDto) throws ServiceException {
        try{
            ClientEntity entity = CLIENT_MAPPER.mapClientDtoToEntity(ClientDto);
            commonRepository.updateEntity(entity);

            return CLIENT_MAPPER.mapClientEntityToDto(entity);

        }catch (PersistenceException e){
            throw new ServiceException("Failed in updateClient!",e);
        }
    }

    @Override
    public void deleteClient(int id) throws ServiceException {
        try{
            commonRepository.deleteEntity(clientRepository.getClientEntityById(id));
        }catch (PersistenceException e){
            throw new ServiceException("Failed in updateClient!",e);
        }
    }

    @Override
    public ClientDto getClientById(int id) throws ServiceException {
        try{
            return CLIENT_MAPPER.mapClientEntityToDto(clientRepository.getClientEntityById(id));
        }catch (PersistenceException e){
            throw new ServiceException("Failed in updateClient!",e);
        }
    }

    @Override
    public List<ClientDto> getAllClient() throws ServiceException {
        try {
            return CLIENT_MAPPER.mapClientEntitiesToDtos(clientRepository.getAllClients());
        }catch (PersistenceException e){
            throw new ServiceException("getAllClient in service failed ", e);
        }
    }

}
