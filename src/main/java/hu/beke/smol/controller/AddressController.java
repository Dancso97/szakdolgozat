package hu.beke.smol.controller;

import hu.beke.smol.dto.AddressDto;
import hu.beke.smol.dto.CreateAddressDto;
import hu.beke.smol.exceptions.ControllerException;
import hu.beke.smol.exceptions.ServiceException;
import hu.beke.smol.service.AddressService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("address")
@NoArgsConstructor
@CrossOrigin
public class AddressController {

    @Autowired
    private AddressService service;

    @GetMapping
    public List<AddressDto> getAllAddresss() throws ControllerException {
        try{
            return service.getAllAddress();
        }catch (ServiceException e){
            throw new ControllerException("Failed in getAllAddresss controller",e);
        }
    }
    @GetMapping("/{id}")
    public AddressDto getAddressById(@PathVariable int id) throws ControllerException{
        try {
            return service.getAddressById(id);
        }catch (ServiceException e){
            throw new ControllerException("Failed in getAddressById controller",e);
        }
    }

    @PostMapping()
    public HttpStatus createAddress(@RequestBody @Valid CreateAddressDto dto ) throws ControllerException{
        try {
            service.createAddress(dto);
            return HttpStatus.OK;
        }catch (ServiceException e ){
            throw new ControllerException("Failed to createAddress in controller! ",e);
        }
    }

    @PutMapping
    public HttpStatus updateAddress(@Valid @RequestBody AddressDto dto) throws ControllerException{
        try{
            service.updateAddress(dto);
            return HttpStatus.OK;
        }catch (ServiceException e){
            throw new ControllerException("Failed to updateAddress in controller! ",e);
        }
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteAddress(@PathVariable int id) throws ControllerException{
        try{
            System.out.println("Id recieved : "+ id);
            service.deleteAddress(id);
            return HttpStatus.OK;
        }catch (ServiceException e){
            throw new ControllerException("Failed to deleteAddress in controller! ",e);
        }
    }


}
