package io.renren.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 系统列表
 * 
 * @author jimas
 * @email jimas_jia@126.com
 * @date 2017-05-09 17:40:40
 */
public class SystemEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer sysId;
	//
	private String sysCode;
	//
	private String sysDesc;
	//
	private String sysUrl;
	//
	private Date createTime;
	//
	private Date updateTime;

	/**
	 * 设置：
	 */
	public void setSysId(Integer sysId) {
		this.sysId = sysId;
	}
	/**
	 * 获取：
	 */
	public Integer getSysId() {
		return sysId;
	}
	/**
	 * 设置：
	 */
	public void setSysCode(String sysCode) {
		this.sysCode = sysCode;
	}
	/**
	 * 获取：
	 */
	public String getSysCode() {
		return sysCode;
	}
	/**
	 * 设置：
	 */
	public void setSysDesc(String sysDesc) {
		this.sysDesc = sysDesc;
	}
	/**
	 * 获取：
	 */
	public String getSysDesc() {
		return sysDesc;
	}
	/**
	 * 设置：
	 */
	public void setSysUrl(String sysUrl) {
		this.sysUrl = sysUrl;
	}
	/**
	 * 获取：
	 */
	public String getSysUrl() {
		return sysUrl;
	}
	/**
	 * 设置：
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
}
