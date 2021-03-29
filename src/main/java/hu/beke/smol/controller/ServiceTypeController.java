package hu.beke.smol.controller;

import hu.beke.smol.dto.CreateServiceTypeDto;
import hu.beke.smol.dto.ServiceTypeDto;
import hu.beke.smol.exceptions.ControllerException;
import hu.beke.smol.exceptions.ServiceException;
import hu.beke.smol.service.ServiceTypeService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("servicetype")
@NoArgsConstructor
@CrossOrigin
public class ServiceTypeController {

    @Autowired
    private ServiceTypeService service;

    @GetMapping
    public List<ServiceTypeDto> getAllServiceTypes() throws ControllerException {
        try{
            return service.getAllServiceType();
        }catch (ServiceException e){
            throw new ControllerException("Failed in getAllServiceTypes controller",e);
        }
    }
    @GetMapping("/{id}")
    public ServiceTypeDto getServiceTypeById(@PathVariable int id) throws ControllerException{
        try {
            return service.getServiceTypeById(id);
        }catch (ServiceException e){
            throw new ControllerException("Failed in getServiceTypeById controller",e);
        }
    }

    @PostMapping()
    public HttpStatus createServiceType(@RequestBody @Valid CreateServiceTypeDto dto ) throws ControllerException{
        try {
            service.createServiceType(dto);
            return HttpStatus.OK;
        }catch (ServiceException e ){
            throw new ControllerException("Failed to createServiceType in controller! ",e);
        }
    }

    @PutMapping
    public HttpStatus updateServiceType(@Valid @RequestBody ServiceTypeDto dto) throws ControllerException{
        try{
            service.updateServiceType(dto);
            return HttpStatus.OK;
        }catch (ServiceException e){
            throw new ControllerException("Failed to updateServiceType in controller! ",e);
        }
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteServiceType(@PathVariable int id) throws ControllerException{
        try{
            service.deleteServiceType(id);
            return HttpStatus.OK;
        }catch (ServiceException e){
            throw new ControllerException("Failed to deleteServiceType in controller! ",e);
        }
    }
}
