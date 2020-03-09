package com.lemon.cases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.lemon.pojo.API;
import com.lemon.pojo.Case;
import com.lemon.utils.DataUtils;
import com.lemon.utils.HttpUtils;

public class CreateType {
	@Test(dataProvider="datas")
	public void test(API api,Case c){
		String url=api.getUrl();
		String params=c.getParams();
		String type=api.getType();
		String contentType=api.getContentType();
		HttpUtils.call(url, params, type, contentType);
	}
	
	
	@DataProvider(name="datas")
	public Object[][] datas(){
		Object[][] datas=DataUtils.getAPIAndCasdById("2");
		return datas;
		
	}
}
