package com.sxt.service;

import java.security.spec.ECFieldF2m;
import java.util.List;

import org.springframework.ui.Model;

import com.github.pagehelper.PageInfo;
import com.sxt.dto.BasicDataDto;
import com.sxt.pojo.BasicData;

public interface IBasicDataService {
	/**
	 * 跳转增加或者修改信息
	 * @param basicData
	 * @return
	 * @throws Exception
	 */
	public void addOrUpdata(Integer id,Model model) throws Exception;
	
	/**
	 * 保存增加或者修改信息
	 * @param basicData
	 * @return
	 * @throws Exception
	 */
	public boolean saveAndOrUpdata(BasicData basicData,Model model) throws Exception;
	
	
	/**
	 * 删除信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean deleteBasic(Integer id) throws Exception;
	

	
	/**
	 * 查询基本数据
	 * @param basicData
	 * @return
	 * @throws Exception
	 */
	public List<BasicData> query(BasicData basicData)throws Exception;
	
	/**
	 * 实现分页查询
	 * @param basicDto
	 * @return
	 * @throws Exception
	 */
	public PageInfo<BasicData> queryPage(BasicDataDto basicDataDto,Model model) throws Exception;
	/**
	 * 根据id查询信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public BasicData selectByBasicDataId( Integer id) throws Exception;

	
}
