package hu.beke.smol.controller;

import hu.beke.smol.dto.CreateImageMetadataDto;
import hu.beke.smol.dto.ImageMetadataDto;
import hu.beke.smol.exceptions.ControllerException;
import hu.beke.smol.exceptions.ServiceException;
import hu.beke.smol.service.ImageMetadataService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("metadata")
@NoArgsConstructor
@CrossOrigin
public class ImageMetadataController {

    @Autowired
    private ImageMetadataService service;

    @GetMapping()
    public List<ImageMetadataDto> getAllMetadata() throws ControllerException {
        try {
            return service.getAllImageMetadata();
        }catch (ServiceException e){
            throw new ControllerException("Failed in getAllImageMetadata controller",e);
        }
    }

    @GetMapping("/{id}")
    public ImageMetadataDto getImageMetadataById(@PathVariable int id) throws ControllerException{
        try {
            return service.getImageMetadataById(id);
        }catch (ServiceException e){
            throw new ControllerException("Failed in getImageMetadataById controller",e);
        }
    }

    @PostMapping()
    public HttpStatus createImageMetadata(@RequestBody @Valid CreateImageMetadataDto dto ) throws ControllerException{
        try {
            service.createImageMetadata(dto);
            return HttpStatus.OK;
        }catch (ServiceException e ){
            throw new ControllerException("Failed to createImageMetadata in controller! ",e);
        }
    }

    @PutMapping
    public HttpStatus updateImageMetadata(@Valid @RequestBody ImageMetadataDto dto) throws ControllerException{
        try{
            service.updateImageMetadata(dto);
            return HttpStatus.OK;
        }catch (ServiceException e){
            throw new ControllerException("Failed to updateImageMetadata in controller! ",e);
        }
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteImageMetadata(@PathVariable int id) throws ControllerException{
        try{
            service.deleteImageMetadata(id);
            return HttpStatus.OK;
        }catch (ServiceException e){
            throw new ControllerException("Failed to updateImageMetadata in controller! ",e);
        }
    }
}
