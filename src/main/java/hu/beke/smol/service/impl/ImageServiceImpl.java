package hu.beke.smol.service.impl;

import hu.beke.smol.dto.CreateImageDto;
import hu.beke.smol.dto.ImageDto;
import hu.beke.smol.entity.ImageEntity;
import hu.beke.smol.exceptions.PersistenceException;
import hu.beke.smol.exceptions.ServiceException;
import hu.beke.smol.mapper.ImageMapper;
import hu.beke.smol.repository.CommonRepository;
import hu.beke.smol.repository.ImageRepository;
import hu.beke.smol.service.ImageService;
import lombok.NoArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class ImageServiceImpl implements ImageService {

    private static final ImageMapper IMAGE_MAPPER = Mappers.getMapper(ImageMapper.class);

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    CommonRepository commonRepository;


    @Override
    public ImageDto createImage(CreateImageDto imageDto) throws ServiceException {
        try {
            ImageEntity entity = IMAGE_MAPPER.mapCreateImageDtoToEntity(imageDto);
            commonRepository.createEntity(entity);

            return IMAGE_MAPPER.mapImageEntityToDto(entity);

        }catch (PersistenceException e){
            throw new ServiceException("CreateImage in service failed ", e);
        }
    }

    @Override
    public ImageDto updateImage(ImageDto imageDto) throws ServiceException {
        try {
            ImageEntity entity = IMAGE_MAPPER.mapImageDtoToEntity(imageDto);
            commonRepository.updateEntity(entity);

            return IMAGE_MAPPER.mapImageEntityToDto(entity);

        }catch (PersistenceException e){
            throw new ServiceException("updateImage in service failed ", e);
        }
    }

    @Override
    public void deleteImage(int id) throws ServiceException {
        try {
            commonRepository.deleteEntity(imageRepository.getImageEntityById(id));
        }catch (PersistenceException e){
            throw new ServiceException("deleteImage in service failed ", e);
        }
    }

    @Override
    public ImageDto getImageById(int id) throws ServiceException {
        try {
            return IMAGE_MAPPER.mapImageEntityToDto(imageRepository.getImageEntityById(id));
        }catch (PersistenceException e){
            throw new ServiceException("getImageById in service failed ", e);
        }
    }

    @Override
    public List<ImageDto> getAllImages() throws ServiceException {
        try {
            return IMAGE_MAPPER.mapImageEntitiesToDtos(imageRepository.getAllImageEntities());

        }catch (PersistenceException e){
            throw new ServiceException("getAllImages in service failed ", e);
        }
    }
}
