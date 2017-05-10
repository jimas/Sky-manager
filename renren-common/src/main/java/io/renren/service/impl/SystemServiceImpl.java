package io.renren.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.renren.dao.SystemDao;
import io.renren.entity.SystemEntity;
import io.renren.service.SystemService;



@Service("systemService")
public class SystemServiceImpl implements SystemService {
	@Autowired
	private SystemDao systemDao;
	
	@Override
	public SystemEntity queryObject(Integer sysId){
		return systemDao.queryObject(sysId);
	}
	
	@Override
	public List<SystemEntity> queryList(Map<String, Object> map){
		return systemDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return systemDao.queryTotal(map);
	}
	
	@Override
	public void save(SystemEntity system){
		systemDao.save(system);
	}
	
	@Override
	public void update(SystemEntity system){
		systemDao.update(system);
	}
	
	@Override
	public void delete(Integer sysId){
		systemDao.delete(sysId);
	}
	
	@Override
	public void deleteBatch(Integer[] sysIds){
		systemDao.deleteBatch(sysIds);
	}
	
}
