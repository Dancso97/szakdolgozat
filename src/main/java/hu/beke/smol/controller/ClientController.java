package hu.beke.smol.controller;

import hu.beke.smol.dto.ClientDto;
import hu.beke.smol.dto.CreateClientDto;
import hu.beke.smol.dto.CreateImageMetadataDto;
import hu.beke.smol.dto.ImageMetadataDto;
import hu.beke.smol.exceptions.ControllerException;
import hu.beke.smol.exceptions.ServiceException;
import hu.beke.smol.service.ClientService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("client")
@NoArgsConstructor
@CrossOrigin
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping
    public List<ClientDto> getAllClients() throws ControllerException {
        try{
            return service.getAllClient();
        }catch (ServiceException e){
            throw new ControllerException("Failed in getAllClients controller",e);
        }
    }
    @GetMapping("/{id}")
    public ClientDto getClientById(@PathVariable int id) throws ControllerException{
        try {
            return service.getClientById(id);
        }catch (ServiceException e){
            throw new ControllerException("Failed in getClientById controller",e);
        }
    }

    @PostMapping()
    public HttpStatus createClient(@RequestBody @Valid CreateClientDto dto ) throws ControllerException{
        try {
            service.createClient(dto);
            return HttpStatus.OK;
        }catch (ServiceException e ){
            throw new ControllerException("Failed to createClient in controller! ",e);
        }
    }

    @PutMapping
    public HttpStatus updateClient(@Valid @RequestBody ClientDto dto) throws ControllerException{
        try{
            service.updateClient(dto);
            return HttpStatus.OK;
        }catch (ServiceException e){
            throw new ControllerException("Failed to updateClient in controller! ",e);
        }
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteClient(@PathVariable int id) throws ControllerException{
        try{
            service.deleteClient(id);
            return HttpStatus.OK;
        }catch (ServiceException e){
            throw new ControllerException("Failed to deleteClient in controller! ",e);
        }
    }

}
