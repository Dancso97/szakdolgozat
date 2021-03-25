package hu.beke.smol.service.impl;

import hu.beke.smol.dto.CreateDataDto;
import hu.beke.smol.dto.DataDto;
import hu.beke.smol.entity.DataEntity;
import hu.beke.smol.exceptions.PersistenceException;
import hu.beke.smol.exceptions.ServiceException;
import hu.beke.smol.mapper.DataMapper;
import hu.beke.smol.repository.CommonRepository;
import hu.beke.smol.repository.DataRepository;
import hu.beke.smol.service.DataService;
import lombok.NoArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class DataServiceImpl implements DataService {

    private static final DataMapper DATA_MAPPER = Mappers.getMapper(DataMapper.class);

    @Autowired
    DataRepository dataRepository;

    @Autowired
    CommonRepository commonRepository;

    @Override
    public DataDto createData(CreateDataDto createDataDto) throws ServiceException {
        try{
            DataEntity entity = DATA_MAPPER.mapCreateDataDtoToEntity(createDataDto);
            commonRepository.createEntity(entity);

            return DATA_MAPPER.mapDataEntityToDto(entity);

        }catch (PersistenceException e){
            throw new ServiceException("Failed in createData!",e);
        }
    }

    @Override
    public DataDto updateData(DataDto dataDto) throws ServiceException {
        try{
            DataEntity entity = DATA_MAPPER.mapDataDtoToEntity(dataDto);
            commonRepository.updateEntity(entity);

            return DATA_MAPPER.mapDataEntityToDto(entity);

        }catch (PersistenceException e){
            throw new ServiceException("Failed in updateData!",e);
        }
    }

    @Override
    public void deleteData(int id) throws ServiceException {
        try{
            commonRepository.deleteEntity(dataRepository.getDataEntityById(id));
        }catch (PersistenceException e){
            throw new ServiceException("Failed in updateData!",e);
        }
    }

    @Override
    public DataDto getDataById(int id) throws ServiceException {
        try{
            return DATA_MAPPER.mapDataEntityToDto(dataRepository.getDataEntityById(id));
        }catch (PersistenceException e){
            throw new ServiceException("Failed in updateData!",e);
        }
    }

    @Override
    public List<DataDto> getAllData() throws ServiceException {
        try {
            return DATA_MAPPER.mapDataEntitiesToDtos(dataRepository.getAllDataEntities());
        }catch (PersistenceException e){
            throw new ServiceException("getAllData in service failed ", e);
        }
    }
}
