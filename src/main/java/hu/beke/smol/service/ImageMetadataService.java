package hu.beke.smol.service;

import hu.beke.smol.dto.CreateImageMetadataDto;
import hu.beke.smol.dto.ImageMetadataDto;
import hu.beke.smol.exceptions.ServiceException;

import java.util.List;

public interface ImageMetadataService {
    
    ImageMetadataDto createImageMetadata(CreateImageMetadataDto ImageMetadataDto) throws ServiceException;

    ImageMetadataDto updateImageMetadata(ImageMetadataDto ImageMetadataDto) throws ServiceException;

    void deleteImageMetadata(int id) throws ServiceException;

    ImageMetadataDto getImageMetadataById(int id) throws ServiceException;

    List<ImageMetadataDto> getAllImageMetadata() throws ServiceException;
}
