package hu.beke.smol.mapper;

import hu.beke.smol.dto.ClientDto;
import hu.beke.smol.dto.CreateClientDto;
import hu.beke.smol.entity.ClientEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public abstract class ClientMapper {

    public abstract ClientEntity mapCreateClientDtoToEntity(CreateClientDto ClientDto);

    public abstract ClientEntity mapClientDtoToEntity(ClientDto ClientDto);

    public abstract List<ClientEntity> mapClientDtosToEntities(List<ClientDto> ClientDtos);

    public abstract ClientDto mapClientEntityToDto(ClientEntity entity);

    public abstract List<ClientDto> mapClientEntitiesToDtos(List<ClientEntity> entityList);

}
