package hu.beke.smol.controller;

import hu.beke.smol.dto.BuildingDto;
import hu.beke.smol.dto.CreateBuildingDto;
import hu.beke.smol.exceptions.ControllerException;
import hu.beke.smol.exceptions.ServiceException;
import hu.beke.smol.service.BuildingService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("building")
@NoArgsConstructor
@CrossOrigin
public class BuildingController {

    @Autowired
    private BuildingService service;

    @GetMapping
    public List<BuildingDto> getAllBuildings() throws ControllerException {
        try{
            return service.getAllBuilding();
        }catch (ServiceException e){
            throw new ControllerException("Failed in getAllBuildings controller",e);
        }
    }
    @GetMapping("/{id}")
    public BuildingDto getBuildingById(@PathVariable int id) throws ControllerException{
        try {
            return service.getBuildingById(id);
        }catch (ServiceException e){
            throw new ControllerException("Failed in getBuildingById controller",e);
        }
    }

    @PostMapping()
    public HttpStatus createBuilding(@RequestBody @Valid CreateBuildingDto dto ) throws ControllerException{
        try {
            service.createBuilding(dto);
            return HttpStatus.OK;
        }catch (ServiceException e ){
            throw new ControllerException("Failed to createBuilding in controller! ",e);
        }
    }

    @PutMapping
    public HttpStatus updateBuilding(@Valid @RequestBody BuildingDto dto) throws ControllerException{
        try{
            service.updateBuilding(dto);
            return HttpStatus.OK;
        }catch (ServiceException e){
            throw new ControllerException("Failed to updateBuilding in controller! ",e);
        }
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteBuilding(@PathVariable int id) throws ControllerException{
        try{
            service.deleteBuilding(id);
            return HttpStatus.OK;
        }catch (ServiceException e){
            throw new ControllerException("Failed to deleteBuilding in controller! ",e);
        }
    }
}
