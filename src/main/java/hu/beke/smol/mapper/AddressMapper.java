package hu.beke.smol.mapper;

import hu.beke.smol.dto.AddressDto;
import hu.beke.smol.dto.CreateAddressDto;
import hu.beke.smol.entity.AddressEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public abstract class AddressMapper {

    public abstract AddressEntity mapCreateAddressDtoToEntity(CreateAddressDto addressDto);

    public abstract AddressEntity mapAddressDtoToEntity(AddressDto addressDto);

    public abstract List<AddressEntity> mapAddressDtosToEntities(List<AddressDto> addressDtos);

    public abstract AddressDto mapAddressEntityToDto(AddressEntity entity);

    public abstract List<AddressDto> mapDataEntitiesToDtos(List<AddressEntity> entityList);
}
