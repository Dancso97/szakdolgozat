package hu.beke.smol.service;

import hu.beke.smol.dto.AddressDto;
import hu.beke.smol.dto.CreateAddressDto;
import hu.beke.smol.exceptions.ServiceException;

import java.util.List;

public interface AddressService {

    AddressDto createAddress(CreateAddressDto createAddressDto) throws ServiceException;

    AddressDto updateAddress(AddressDto AddressDto) throws ServiceException;

    void deleteAddress(int id) throws ServiceException;

    AddressDto getAddressById(int id) throws ServiceException;

    List<AddressDto> getAllAddress() throws ServiceException;
    
    
}
