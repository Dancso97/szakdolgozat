package hu.beke.smol.service;

import hu.beke.smol.dto.CreateServicesDto;
import hu.beke.smol.dto.ServicesDto;
import hu.beke.smol.exceptions.ServiceException;

import java.util.List;

public interface ServicesService {

    ServicesDto createServices(CreateServicesDto ServicesDto) throws ServiceException;

    ServicesDto updateServices(ServicesDto ServicesDto) throws ServiceException;

    void deleteServices(int id) throws ServiceException;

    ServicesDto getServicesById(int id) throws ServiceException;

    List<ServicesDto> getAllServices() throws ServiceException;
    
}
