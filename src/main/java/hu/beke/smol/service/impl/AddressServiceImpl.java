package hu.beke.smol.service.impl;

import hu.beke.smol.dto.AddressDto;
import hu.beke.smol.dto.CreateAddressDto;
import hu.beke.smol.entity.AddressEntity;
import hu.beke.smol.exceptions.PersistenceException;
import hu.beke.smol.exceptions.ServiceException;
import hu.beke.smol.mapper.AddressMapper;
import hu.beke.smol.repository.AddressRepository;
import hu.beke.smol.repository.CommonRepository;
import hu.beke.smol.service.AddressService;
import lombok.NoArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class AddressServiceImpl implements AddressService {
    private static final AddressMapper ADDRESS_MAPPER = Mappers.getMapper(AddressMapper.class);

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CommonRepository commonRepository;

    @Override
    public AddressDto createAddress(CreateAddressDto createAddressDto) throws ServiceException {
        try{
            AddressEntity entity = ADDRESS_MAPPER.mapCreateAddressDtoToEntity(createAddressDto);
            commonRepository.createEntity(entity);

            return ADDRESS_MAPPER.mapAddressEntityToDto(entity);

        }catch (PersistenceException e){
            throw new ServiceException("Failed in createAddress!",e);
        }
    }

    @Override
    public AddressDto updateAddress(AddressDto AddressDto) throws ServiceException {
        try{
            AddressEntity entity = ADDRESS_MAPPER.mapAddressDtoToEntity(AddressDto);
            commonRepository.updateEntity(entity);

            return ADDRESS_MAPPER.mapAddressEntityToDto(entity);

        }catch (PersistenceException e){
            throw new ServiceException("Failed in updateAddress!",e);
        }
    }

    @Override
    public void deleteAddress(int id) throws ServiceException {
        try{
            commonRepository.deleteEntity(addressRepository.getAddressEntityById(id));
        }catch (PersistenceException e){
            throw new ServiceException("Failed in updateAddress!",e);
        }
    }

    @Override
    public AddressDto getAddressById(int id) throws ServiceException {
        try{
            return ADDRESS_MAPPER.mapAddressEntityToDto(addressRepository.getAddressEntityById(id));
        }catch (PersistenceException e){
            throw new ServiceException("Failed in updateAddress!",e);
        }
    }

    @Override
    public List<AddressDto> getAllAddress() throws ServiceException {
        try {
            return ADDRESS_MAPPER.mapDataEntitiesToDtos(addressRepository.getAllAddress());
        }catch (PersistenceException e){
            throw new ServiceException("getAllAddress in service failed ", e);
        }
    }
}
