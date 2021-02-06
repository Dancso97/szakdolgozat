package hu.beke.smol.service;

import hu.beke.smol.dto.CreateDataDto;
import hu.beke.smol.dto.DataDto;
import hu.beke.smol.exceptions.ServiceException;

import java.util.List;

public interface DataService {

    DataDto createData(CreateDataDto createDataDto) throws ServiceException;

    DataDto updateData(DataDto dataDto) throws ServiceException;

    void deleteData(int id) throws ServiceException;

    DataDto getDataById(int id) throws ServiceException;

    List<DataDto> getAllData() throws ServiceException;
}
