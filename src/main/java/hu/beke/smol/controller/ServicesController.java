package hu.beke.smol.controller;

import hu.beke.smol.dto.CreateServicesDto;
import hu.beke.smol.dto.ServicesDto;
import hu.beke.smol.exceptions.ControllerException;
import hu.beke.smol.exceptions.ServiceException;
import hu.beke.smol.service.ServicesService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("service")
@NoArgsConstructor
@CrossOrigin
public class ServicesController {

    @Autowired
    private ServicesService service;

    @GetMapping
    public List<ServicesDto> getAllServicess() throws ControllerException {
        try{
            return service.getAllServices();
        }catch (ServiceException e){
            throw new ControllerException("Failed in getAllServicess controller",e);
        }
    }
    @GetMapping("/{id}")
    public ServicesDto getServicesById(@PathVariable int id) throws ControllerException{
        try {
            return service.getServicesById(id);
        }catch (ServiceException e){
            throw new ControllerException("Failed in getServicesById controller",e);
        }
    }

    @PostMapping()
    public HttpStatus createServices(@RequestBody @Valid CreateServicesDto dto ) throws ControllerException{
        try {
            service.createServices(dto);
            return HttpStatus.OK;
        }catch (ServiceException e ){
            throw new ControllerException("Failed to createServices in controller! ",e);
        }
    }

    @PutMapping
    public HttpStatus updateServices(@Valid @RequestBody ServicesDto dto) throws ControllerException{
        try{
            service.updateServices(dto);
            return HttpStatus.OK;
        }catch (ServiceException e){
            throw new ControllerException("Failed to updateServices in controller! ",e);
        }
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteServices(@PathVariable int id) throws ControllerException{
        try{
            service.deleteServices(id);
            return HttpStatus.OK;
        }catch (ServiceException e){
            throw new ControllerException("Failed to deleteServices in controller! ",e);
        }
    }
}
