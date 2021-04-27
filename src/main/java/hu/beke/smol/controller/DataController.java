package hu.beke.smol.controller;

import hu.beke.smol.dto.*;
import hu.beke.smol.exceptions.ControllerException;
import hu.beke.smol.exceptions.ServiceException;
import hu.beke.smol.service.DataService;
import hu.beke.smol.service.ImageMetadataService;
import hu.beke.smol.service.ImageService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("data")
@NoArgsConstructor
@CrossOrigin
public class DataController {

    @Autowired
    private DataService service;

    @Autowired
    private ImageService imageService;

    @Autowired
    private ImageMetadataService metadataService;

    @GetMapping
    public List<DataDto> getAllData() throws ControllerException{
        try {
            return service.getAllData();
        }catch (ServiceException e){
            throw new ControllerException("Failed in getAllData controller",e);
        }
    }
    @GetMapping("/{id}")
    public DataDto getDataById(@Valid  @PathVariable int id) throws ControllerException{
        try {
            return service.getDataById(id);
        }catch (ServiceException e){
            throw new ControllerException("Failed in getDataById controller",e);
        }
    }

    @PostMapping("/upload")
    public HttpStatus createData(@RequestPart(value = "plate", required = true) String plate ,@RequestPart(value = "file", required=true) MultipartFile file, @RequestPart(required=true) CreateImageMetadataDto metadata) throws ControllerException {
        try {
            CreateDataDto dataDto = new CreateDataDto();
            CreateImageDto imageDto = new CreateImageDto();
            ImageMetadataDto metadataDto = metadataService.createImageMetadata(metadata);

            imageDto.setImage(file.getBytes());
            imageDto.setPictureMetadata(metadataDto);
            ImageDto createdImage = imageService.createImage(imageDto);

            dataDto.setPlate(plate);
            dataDto.setImage(createdImage);

            DataDto returned = service.createData(dataDto);

            return HttpStatus.OK;
        }catch (ServiceException | IOException e){
            throw new ControllerException("Failed in createData controller ",e);
        }


    }
    @PutMapping
    public HttpStatus updateDataDto(@RequestBody @Valid DataDto dataDto) throws ControllerException {
        try {
            DataDto returned = service.updateData(dataDto);
            return HttpStatus.OK;
        }catch (ServiceException e){
            throw new ControllerException("Failed to updateDataDto in controller! ",e);
        }
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteDataById(@Valid @PathVariable int id) throws ControllerException {
        try {
            service.deleteData(id);
            return HttpStatus.OK;

        }catch (ServiceException e){
            throw new ControllerException("Failed to delete Data in controller!",e);
        }
    }





}
