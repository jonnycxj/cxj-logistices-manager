package com.sxt.dto;

import com.sxt.pojo.BasePage;
import com.sxt.pojo.BasicData;

public class BasicDataDto extends BasePage {
	
	private BasicData basicData;

	public BasicData getBasicData() {
		return basicData;
	}

	public void setBasicData(BasicData basicData) {
		this.basicData = basicData;
	}

	@Override
	public String toString() {
		return "BasicDataDto [basicData=" + basicData + "]";
	}
	

}
