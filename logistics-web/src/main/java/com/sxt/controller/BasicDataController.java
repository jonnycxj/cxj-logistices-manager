package com.sxt.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.sxt.dto.BasicDataDto;
import com.sxt.dto.UserDto;
import com.sxt.pojo.BasicData;
import com.sxt.service.IBasicDataService;

@Controller
@RequestMapping("/basicData/")
public class BasicDataController {
	@Resource
	private IBasicDataService basicDataservice;
	
	/**
	 * 跳转增加或者修改页面
	 * @param id
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/addOrUpdate")
	public String addOrUpdate(Integer id,Model model) throws Exception {
		basicDataservice.addOrUpdata(id, model);
		return "basicData/addOrUpdate";
	}
	/**
	 * 保存修改内容或者增加内容
	 * @param basicData
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/saveAddOrUpdate")
	public String saveAddOrUpdate(BasicData basicData,Model model) throws Exception{
		if(basicData.getParentId()==0) {
			basicData.setParentId(null);
		}
		basicDataservice.saveAndOrUpdata(basicData, model);
		return "redirect:/basicData/queryPage";
	}
	/**
	 * 实现分页查询
	 * @param basicDataDto
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryPage")
	public String queryPage(BasicDataDto basicDataDto,Model model) throws Exception {
		PageInfo<BasicData> info = basicDataservice.queryPage(basicDataDto, model);
		model.addAttribute("pageModel", info);
		return "basicData/basicData";
	}
	/**
	 * 根据ID删除信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteBasicData")
	public String deleteBasicData(Integer id ) throws Exception {
		basicDataservice.deleteBasic(id);
		return "redirect:/basicData/queryPage";
	}

}
