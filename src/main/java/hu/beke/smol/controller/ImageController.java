package hu.beke.smol.controller;

import hu.beke.smol.dto.CreateImageDto;
import hu.beke.smol.dto.ImageDto;
import hu.beke.smol.exceptions.ControllerException;
import hu.beke.smol.exceptions.ServiceException;
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
@RequestMapping("image")
@NoArgsConstructor
@CrossOrigin
public class ImageController {

    @Autowired
    private ImageService service;

    @GetMapping
    public List<ImageDto> getAllImages() throws ControllerException {
        try{
            return service.getAllImages();
        }catch (ServiceException e){
            throw new ControllerException("Failed in getAllImages() controller ! \n ",e);
        }
    }

    @GetMapping("/{id}")
    public ImageDto getImageById(@Valid @PathVariable int id) throws ControllerException {
        try{
            return service.getImageById(id);
        }catch (ServiceException e){
            throw new ControllerException("Failed in getImageById() controller with id: "+ id + "! \n", e);
        }
    }

    /*
    @PostMapping
    public ImageDto createImage(@RequestBody @Valid CreateImageDto imageDto) throws ControllerException {
        try {
            return service.createImage(imageDto);
        }catch (ServiceException e){
            throw new ControllerException("Failed in createImage", e);
        }
    }
    */

    @PostMapping("/upload")
    public HttpStatus createImage(@RequestParam("file") MultipartFile file) throws ControllerException {
        try {

            CreateImageDto imageDto = new CreateImageDto();
            imageDto.setName(file.getOriginalFilename());
            imageDto.setType(file.getContentType());
            imageDto.setData(file.getBytes());

            ImageDto returned = service.createImage(imageDto);

            return HttpStatus.OK;
        }catch (ServiceException | IOException e){
            throw new ControllerException("Failed in createImage", e);
        }
    }


    @PutMapping
    public HttpStatus updateImage(@RequestParam @Valid ImageDto imageDto) throws ControllerException {
        try {
            ImageDto returned = service.updateImage(imageDto);
            return HttpStatus.OK;
        }catch (ServiceException e){
            throw new ControllerException("Failed in updateImage in controller", e);
        }
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteImageById(@Valid @PathVariable int id) throws ControllerException {
        try{
            service.deleteImage(id);
            return HttpStatus.OK;
        }catch (ServiceException e){
            throw new ControllerException("Failed in getImageById() with id: "+ id + "! \n", e);
        }
    }

}