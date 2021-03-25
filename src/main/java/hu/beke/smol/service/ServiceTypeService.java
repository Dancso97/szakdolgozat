package hu.beke.smol.service;

import hu.beke.smol.dto.CreateServiceTypeDto;
import hu.beke.smol.dto.ServiceTypeDto;
import hu.beke.smol.exceptions.ServiceException;

import java.util.List;

public interface ServiceTypeService {
    
    ServiceTypeDto createServiceType(CreateServiceTypeDto ServiceTypeDto) throws ServiceException;

    ServiceTypeDto updateServiceType(ServiceTypeDto ServiceTypeDto) throws ServiceException;

    void deleteServiceType(int id) throws ServiceException;

    ServiceTypeDto getServiceTypeById(int id) throws ServiceException;

    List<ServiceTypeDto> getAllServiceType() throws ServiceException;
}
