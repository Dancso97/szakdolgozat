package hu.beke.smol.controller;

import hu.beke.smol.dto.CreateDataDto;
import hu.beke.smol.dto.CreateImageDto;
import hu.beke.smol.dto.DataDto;
import hu.beke.smol.dto.ImageDto;
import hu.beke.smol.exceptions.ControllerException;
import hu.beke.smol.exceptions.ServiceException;
import hu.beke.smol.service.DataService;
import hu.beke.smol.service.ImageService;
import lombok.Data;
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
    private ImageService img_service;

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
    public HttpStatus createData(@RequestParam("file") MultipartFile file) throws ControllerException {
        try {

            CreateImageDto imageDto = new CreateImageDto();
            imageDto.setName(file.getOriginalFilename());
            imageDto.setType(file.getContentType());
            imageDto.setData(file.getBytes());

            System.out.println(imageDto.getType());

            if(imageDto.getType() == null ){
                imageDto.setType("img/jpg");
            }
            ImageDto createdImage = img_service.createImage(imageDto);

            CreateDataDto createDataDto = new CreateDataDto();
            createDataDto.setPlate_number(file.getOriginalFilename());


            createDataDto.setPicture(createdImage);

            DataDto returned = service.createData(createDataDto);

            return HttpStatus.OK;

        }catch (ServiceException | IOException e){
            throw new ControllerException("Failed in createData in upload controller! ", e);
        }
    }

    @PutMapping
    public HttpStatus updateDataDto(@RequestParam @Valid DataDto dataDto) throws ControllerException {
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
