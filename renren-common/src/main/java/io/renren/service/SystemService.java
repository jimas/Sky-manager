package io.renren.service;

import io.renren.entity.SystemEntity;

import java.util.List;
import java.util.Map;

/**
 * 系统列表
 * 
 * @author jimas
 * @email jimas_jia@126.com
 * @date 2017-05-09 17:40:40
 */
public interface SystemService {
	
	SystemEntity queryObject(Integer sysId);
	
	List<SystemEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SystemEntity system);
	
	void update(SystemEntity system);
	
	void delete(Integer sysId);
	
	void deleteBatch(Integer[] sysIds);
}
