package hu.beke.smol.service.impl;

import hu.beke.smol.dto.CreateServiceTypeDto;
import hu.beke.smol.dto.ServiceTypeDto;
import hu.beke.smol.entity.ServiceTypeEntity;
import hu.beke.smol.exceptions.PersistenceException;
import hu.beke.smol.exceptions.ServiceException;
import hu.beke.smol.mapper.ServiceTypeMapper;
import hu.beke.smol.repository.CommonRepository;
import hu.beke.smol.repository.ServiceTypeRepository;
import hu.beke.smol.service.ServiceTypeService;
import lombok.NoArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@NoArgsConstructor
@Service
public class ServiceTypeServiceImpl implements ServiceTypeService {

    private static final ServiceTypeMapper SERVICE_TYPE_MAPPER = Mappers.getMapper(ServiceTypeMapper.class);

    @Autowired
    ServiceTypeRepository serviceTypeRepository;

    @Autowired
    CommonRepository commonRepository;

    @Override
    public ServiceTypeDto createServiceType(CreateServiceTypeDto createServiceTypeDto) throws ServiceException {
        try{
            ServiceTypeEntity entity = SERVICE_TYPE_MAPPER.mapCreateServiceTypeDtoToEntity(createServiceTypeDto);
            commonRepository.createEntity(entity);

            return SERVICE_TYPE_MAPPER.mapServiceTypeEntityToDto(entity);

        }catch (PersistenceException e){
            throw new ServiceException("Failed in createServiceType!",e);
        }
    }

    @Override
    public ServiceTypeDto updateServiceType(ServiceTypeDto ServiceTypeDto) throws ServiceException {
        try{
            ServiceTypeEntity entity = SERVICE_TYPE_MAPPER.mapServiceTypeDtoToEntity(ServiceTypeDto);
            commonRepository.updateEntity(entity);

            return SERVICE_TYPE_MAPPER.mapServiceTypeEntityToDto(entity);

        }catch (PersistenceException e){
            throw new ServiceException("Failed in updateServiceType!",e);
        }
    }

    @Override
    public void deleteServiceType(int id) throws ServiceException {
        try{
            commonRepository.deleteEntity(serviceTypeRepository.getServiceTypeEntityById(id));
        }catch (PersistenceException e){
            throw new ServiceException("Failed in updateServiceType!",e);
        }
    }

    @Override
    public ServiceTypeDto getServiceTypeById(int id) throws ServiceException {
        try{
            return SERVICE_TYPE_MAPPER.mapServiceTypeEntityToDto(serviceTypeRepository.getServiceTypeEntityById(id));
        }catch (PersistenceException e){
            throw new ServiceException("Failed in updateServiceType!",e);
        }
    }

    @Override
    public List<ServiceTypeDto> getAllServiceType() throws ServiceException {
        try {
            return SERVICE_TYPE_MAPPER.mapServiceTypeEntitiesToDtos(serviceTypeRepository.getAllServiceType());
        }catch (PersistenceException e){
            throw new ServiceException("getAllServiceType in service failed ", e);
        }
    }
}
