package hu.beke.smol.service;

import hu.beke.smol.dto.ClientDto;
import hu.beke.smol.dto.CreateClientDto;
import hu.beke.smol.exceptions.ServiceException;

import java.util.List;

public interface ClientService {

    ClientDto createClient(CreateClientDto createClientDto) throws ServiceException;

    ClientDto updateClient(ClientDto ClientDto) throws ServiceException;

    void deleteClient(int id) throws ServiceException;

    ClientDto getClientById(int id) throws ServiceException;

    List<ClientDto> getAllClient() throws ServiceException;
    
}
