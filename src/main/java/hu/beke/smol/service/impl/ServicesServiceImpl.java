package hu.beke.smol.service.impl;

import hu.beke.smol.dto.CreateServicesDto;
import hu.beke.smol.dto.ServicesDto;
import hu.beke.smol.entity.ServicesEntity;
import hu.beke.smol.exceptions.PersistenceException;
import hu.beke.smol.exceptions.ServiceException;
import hu.beke.smol.mapper.ServicesMapper;
import hu.beke.smol.repository.CommonRepository;
import hu.beke.smol.repository.ServicesRepository;
import hu.beke.smol.service.ServicesService;
import lombok.NoArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@NoArgsConstructor
@Service
public class ServicesServiceImpl implements ServicesService {

    private static final ServicesMapper SERVICES_MAPPER = Mappers.getMapper(ServicesMapper.class);

    @Autowired
    ServicesRepository servicesRepository;

    @Autowired
    CommonRepository commonRepository;

    @Override
    public ServicesDto createServices(CreateServicesDto createServicesDto) throws ServiceException {
        try{
            ServicesEntity entity = SERVICES_MAPPER.mapCreateServicesDtoToEntity(createServicesDto);
            commonRepository.createEntity(entity);

            return SERVICES_MAPPER.mapServicesEntityToDto(entity);

        }catch (PersistenceException e){
            throw new ServiceException("Failed in createServices!",e);
        }
    }

    @Override
    public ServicesDto updateServices(ServicesDto ServicesDto) throws ServiceException {
        try{
            ServicesEntity entity = SERVICES_MAPPER.mapServicesDtoToEntity(ServicesDto);
            commonRepository.updateEntity(entity);

            return SERVICES_MAPPER.mapServicesEntityToDto(entity);

        }catch (PersistenceException e){
            throw new ServiceException("Failed in updateServices!",e);
        }
    }

    @Override
    public void deleteServices(int id) throws ServiceException {
        try{
            commonRepository.deleteEntity(servicesRepository.getServicesEntityById(id));
        }catch (PersistenceException e){
            throw new ServiceException("Failed in updateServices!",e);
        }
    }

    @Override
    public ServicesDto getServicesById(int id) throws ServiceException {
        try{
            return SERVICES_MAPPER.mapServicesEntityToDto(servicesRepository.getServicesEntityById(id));
        }catch (PersistenceException e){
            throw new ServiceException("Failed in updateServices!",e);
        }
    }

    @Override
    public List<ServicesDto> getAllServices() throws ServiceException {
        try {
            return SERVICES_MAPPER.mapServicesEntitiesToDtos(servicesRepository.getAllServices());
        }catch (PersistenceException e){
            throw new ServiceException("getAllServices in service failed ", e);
        }
    }
}
