package hu.beke.smol.mapper;

import hu.beke.smol.dto.CreateImageMetadataDto;
import hu.beke.smol.dto.ImageMetadataDto;
import hu.beke.smol.entity.ImageMetadataEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public abstract class ImageMetadataMapper {

    public abstract ImageMetadataEntity mapCreateImageMetadataDtoToEntity(CreateImageMetadataDto ImageMetadataDto);

    public abstract ImageMetadataEntity mapImageMetadataDtoToEntity(ImageMetadataDto ImageMetadataDto);

    public abstract List<ImageMetadataEntity> mapImageMetadataDtosToEntities(List<ImageMetadataDto> ImageMetadataDtos);

    public abstract ImageMetadataDto mapImageMetadataEntityToDto(ImageMetadataEntity entity);

    public abstract List<ImageMetadataDto> mapImageMetadataEntitiesToDtos(List<ImageMetadataEntity> entityList);
}
