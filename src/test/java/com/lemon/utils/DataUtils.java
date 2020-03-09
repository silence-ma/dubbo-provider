package com.lemon.utils;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.lemon.constant.Constant;
import com.lemon.pojo.API;
import com.lemon.pojo.Case;

public class DataUtils {

	//成员变量
	public static List<Case> caseList = ExcelUtils.read(Constant.EXCEL_PATH, 1, Case.class);
	public static List<API> APIList = ExcelUtils.read(Constant.EXCEL_PATH, 0, API.class);
	//{{API,Case},{API,Case}}
	//根据ApiId获取一个接口，和对应的多个case
	public static Object[][] getAPIAndCasdById(String apiId){
	API  wantApi=new API();
	ArrayList<Case> wantCases=new ArrayList<Case>();
	for (API api : APIList) {
		if(apiId.equals(api.getApiId())){
			wantApi=api;
			break;
		}
	}
	for (Case c : caseList) {
		if(apiId.equals(c.getApiId())){
			wantCases.add(c);
		}
	}
	Object[][] datas=new Object[wantCases.size()][2];
	for(int i=0;i<wantCases.size();i++){
	datas[i][0]=wantApi;
	datas[i][1]=wantCases.get(i);
	
	}
	return datas;
	
		
		
	}
}
