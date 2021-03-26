package hu.beke.smol.service.impl;

import hu.beke.smol.dto.CreateImageMetadataDto;
import hu.beke.smol.dto.ImageMetadataDto;
import hu.beke.smol.entity.ImageMetadataEntity;
import hu.beke.smol.exceptions.PersistenceException;
import hu.beke.smol.exceptions.ServiceException;
import hu.beke.smol.mapper.ImageMetadataMapper;
import hu.beke.smol.repository.CommonRepository;
import hu.beke.smol.repository.ImageMetadataRepository;
import hu.beke.smol.service.ImageMetadataService;
import lombok.NoArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@NoArgsConstructor
@Service
public class ImageMetadataServiceImpl implements ImageMetadataService {

    private static final ImageMetadataMapper IMAGEMETADATA_MAPPER = Mappers.getMapper(ImageMetadataMapper.class);

    @Autowired
    ImageMetadataRepository imageMetadataRepository;

    @Autowired
    CommonRepository commonRepository;

    @Override
    public ImageMetadataDto createImageMetadata(CreateImageMetadataDto createImageMetadataDto) throws ServiceException {
        try{
            ImageMetadataEntity entity = IMAGEMETADATA_MAPPER.mapCreateImageMetadataDtoToEntity(createImageMetadataDto);
            commonRepository.createEntity(entity);

            return IMAGEMETADATA_MAPPER.mapImageMetadataEntityToDto(entity);

        }catch (PersistenceException e){
            throw new ServiceException("Failed in createImageMetadata!",e);
        }
    }

    @Override
    public ImageMetadataDto updateImageMetadata(ImageMetadataDto ImageMetadataDto) throws ServiceException {
        try{
            ImageMetadataEntity entity = IMAGEMETADATA_MAPPER.mapImageMetadataDtoToEntity(ImageMetadataDto);
            commonRepository.updateEntity(entity);

            return IMAGEMETADATA_MAPPER.mapImageMetadataEntityToDto(entity);

        }catch (PersistenceException e){
            throw new ServiceException("Failed in updateImageMetadata!",e);
        }
    }

    @Override
    public void deleteImageMetadata(int id) throws ServiceException {
        try{
            commonRepository.deleteEntity(imageMetadataRepository.getImageMetadataEntityById(id));
        }catch (PersistenceException e){
            throw new ServiceException("Failed in updateImageMetadata!",e);
        }
    }

    @Override
    public ImageMetadataDto getImageMetadataById(int id) throws ServiceException {
        try{
            return IMAGEMETADATA_MAPPER.mapImageMetadataEntityToDto(imageMetadataRepository.getImageMetadataEntityById(id));
        }catch (PersistenceException e){
            throw new ServiceException("Failed in updateImageMetadata!",e);
        }
    }

    @Override
    public List<ImageMetadataDto> getAllImageMetadata() throws ServiceException {
        try {
            return IMAGEMETADATA_MAPPER.mapImageMetadataEntitiesToDtos(imageMetadataRepository.getAllImageMetadata());
        }catch (PersistenceException e){
            throw new ServiceException("getAllImageMetadata in service failed ", e);
        }
    }
    
}
