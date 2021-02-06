package hu.beke.smol.service;

import hu.beke.smol.dto.CreateImageDto;
import hu.beke.smol.dto.ImageDto;
import hu.beke.smol.exceptions.ServiceException;

import java.util.List;

public interface ImageService {

    ImageDto createImage(CreateImageDto imageDto) throws ServiceException;

    ImageDto updateImage(ImageDto imageDto) throws ServiceException;

    void deleteImage(int id) throws ServiceException;

    ImageDto getImageById(int id) throws ServiceException;

    List<ImageDto> getAllImages() throws ServiceException;
}
