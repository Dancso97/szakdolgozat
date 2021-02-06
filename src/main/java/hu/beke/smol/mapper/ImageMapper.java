package hu.beke.smol.mapper;

import hu.beke.smol.dto.CreateImageDto;
import hu.beke.smol.dto.ImageDto;
import hu.beke.smol.entity.ImageEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public abstract class ImageMapper {

    public abstract ImageEntity mapCreateImageDtoToEntity(CreateImageDto createImageDto);

    public abstract ImageDto mapImageEntityToDto(ImageEntity entity);

    public abstract List<ImageDto> mapImageEntitiesToDtos(List<ImageEntity> entityList);

    public abstract ImageEntity mapImageDtoToEntity(ImageDto imageDto);

    public abstract List<ImageEntity> mapImageDtosToEntities(List<ImageDto> imageDtos);


}
