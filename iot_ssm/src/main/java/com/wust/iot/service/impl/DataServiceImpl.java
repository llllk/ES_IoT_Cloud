package com.wust.iot.service.impl;

import com.wust.iot.dao.DataMapper;
import com.wust.iot.model.Data;
import com.wust.iot.model.Device;
import com.wust.iot.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DataServiceImpl implements DataService {

    @Autowired
    private DataMapper dataMapper;


    public int insertOneData(Data data) {
        data.setId(null);
        return dataMapper.insert(data);
    }

    public int updateOneData(Data data) {
        return dataMapper.updateByPrimaryKey(data);
    }

    public Data findOneData(Integer id) {
        return dataMapper.selectByPrimaryKey(id);
    }

    public int deleteOneData(Integer id) {
        return dataMapper.deleteByPrimaryKey(id);
    }

    public List<Data> findDataListByDeviceIdOrderByDesc(Integer deviceId) {
        return dataMapper.selectListByDeviceIdOrderByDesc(deviceId);
    }

    public List<Data> findDataListByDeviceId(Integer deviceId) {
        return dataMapper.selectListByDeviceId(deviceId);
    }

    public List<Data> findDataListByDeviceIdDuringTime(Integer deviceId, Date startTime, Date endTime) {
        return dataMapper.selectListByDeviceIdDuringTime(deviceId, startTime, endTime);
    }

    public List<Data> findDataListByDeviceIdDuringTimeOrderByDesc(Integer deviceId, Date startTime, Date endTime) {
        return dataMapper.selectListByDeviceIdDuringTimeOrderByDesc(deviceId, startTime, endTime);
    }

    public int deleteOneDeviceDataList(Integer deviceId) {
        return dataMapper.deleteBydeviceId(deviceId);
    }

    public Data findOneDataLatest(Integer deviceId) {
        return dataMapper.selectDataLatest(deviceId);
    }

    public List<Data> findDataListByDeviceIdLimit(Integer deviceId, Integer startLine, Integer pageSize) {
        return dataMapper.selectListByDeviceIdLimit(deviceId,startLine,pageSize);
    }

    public List<Data> findDataListByDeviceIdOrderByDescLimit(Integer deviceId, Integer startLine, Integer pageSize) {
        return dataMapper.selectListByDeviceIdOrderByDescLimit(deviceId,startLine,pageSize);
    }

    public List<Data> findDataListByDeviceIdDuringTimeLimit(Integer deviceId, Date startTime, Date endTime,Integer startLine,Integer pageSize) {
        return dataMapper.selectListByDeviceIdDuringTimeLimit(deviceId,startTime,endTime,startLine,pageSize);
    }

    public List<Data> findDataListByDeviceIdDuringTimeOrderByDescLimit(Integer deviceId, Date startTime, Date endTime,Integer startLine,Integer pageSize) {
        return dataMapper.selectListByDeviceIdDuringTimeOrderByDescLimit(deviceId,startTime,endTime,startLine,pageSize);
    }

    public int findDataListCountByDeviceIdDuringTime(Integer deviceId, Date startTime, Date endTime) {
        return dataMapper.selectListCountByDeviceIdDuringTime(deviceId,startTime,endTime);
    }

    public int findDataListCountByDeviceId(Integer deviceId) {
        return dataMapper.selectListCountByDeviceId(deviceId);
    }
}
