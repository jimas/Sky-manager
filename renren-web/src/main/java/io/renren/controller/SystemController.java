package io.renren.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.entity.SystemEntity;
import io.renren.service.SystemService;
import io.renren.utils.PageUtils;
import io.renren.utils.Query;
import io.renren.utils.R;


/**
 * 系统列表
 * 
 * @author jimas
 * @email jimas_jia@126.com
 * @date 2017-05-09 17:40:40
 */
@RestController
@RequestMapping("system")
public class SystemController {
	@Autowired
	private SystemService systemService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("system:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<SystemEntity> systemList = systemService.queryList(query);
		int total = systemService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(systemList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{sysId}")
	@RequiresPermissions("system:info")
	public R info(@PathVariable("sysId") Integer sysId){
		SystemEntity system = systemService.queryObject(sysId);
		
		return R.ok().put("system", system);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("system:save")
	public R save(@RequestBody SystemEntity system){
		systemService.save(system);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("system:update")
	public R update(@RequestBody SystemEntity system){
		systemService.update(system);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("system:delete")
	public R delete(@RequestBody Integer[] sysIds){
		systemService.deleteBatch(sysIds);
		
		return R.ok();
	}
	
}
