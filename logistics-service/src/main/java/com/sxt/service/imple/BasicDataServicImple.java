package com.sxt.service.imple;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sxt.dto.BasicDataDto;
import com.sxt.mapper.BasicDataMapper;
import com.sxt.pojo.BasicData;
import com.sxt.pojo.BasicDataExample;
import com.sxt.service.IBasicDataService;
@Service
public class BasicDataServicImple implements IBasicDataService {

	@Resource 
	private BasicDataMapper basicDataDAO;
	
	
	@Override
	public void addOrUpdata(Integer id, Model model) throws Exception {
		// TODO Auto-generated method stub
		if(id!=null&&id>0) {
			//这是数据修改模块
			//1、查询改ID的所有信息
			//2、页面的跳转
			BasicData basicData = basicDataDAO.selectByPrimaryKey(id);
			
			model.addAttribute("basicData", basicData);
		}
		
			//这是数据增加模式
			//1、查询出所有的父级菜单栏
			//2、页面的跳转
			
			BasicDataExample example =new BasicDataExample();
			example.createCriteria().andParentIdIsNull();
			List<BasicData> list = basicDataDAO.selectByExample(example );
			model.addAttribute("listBasic", list);
	
		
	}

	@Override
	public boolean saveAndOrUpdata(BasicData basicData, Model model) throws Exception {
		// TODO Auto-generated method stub
		if(basicData!=null&&basicData.getBaseId()!=null&&basicData.getBaseId()>0) {
			//进入的是修改模式
			return basicDataDAO.updateByPrimaryKeySelective(basicData)>0;
		}else {
		//进入增加模式
		
		return basicDataDAO.insertSelective(basicData)>0;}
	}

	@Override
	public boolean deleteBasic(Integer id) throws Exception {
		// TODO Auto-generated method stub
		//删除的时候增加了在mapper.xml中增加了or  parent_id=Id  语句
		
		BasicData basicData = basicDataDAO.selectByPrimaryKey(id);
		
		if(basicData.getParentId()!=null&& basicData.getParentId()>0) {
			
			return basicDataDAO.deleteByPrimaryKey(id)>0;
			
		}else {
			BasicDataExample example=new BasicDataExample();
			
			example.createCriteria().andParentIdEqualTo(basicData.getBaseId());
			
			basicDataDAO.deleteByExample(example);
			
			return basicDataDAO.deleteByPrimaryKey(id)>0;
		}
		
		
		
	}

	@Override
	public List<BasicData> query(BasicData basicData) throws Exception {
		// TODO Auto-generated method stub
		BasicDataExample example=new BasicDataExample();
		example.createCriteria();
		List<BasicData> result = basicDataDAO.selectByExample(example);

		return result;
	}

	@Override
	public PageInfo<BasicData>  queryPage(BasicDataDto basicDataDto,Model model) throws Exception {
		// TODO Auto-generated method stub
		PageHelper.startPage(basicDataDto.getPageNum(), basicDataDto.getPageSize());
		
		BasicData basicData = basicDataDto.getBasicData();
		List<BasicData> list = this.query(basicData);
	
		PageInfo<BasicData> info = new PageInfo<BasicData>(list);
		return info;
	}

	@Override
	public BasicData selectByBasicDataId(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
