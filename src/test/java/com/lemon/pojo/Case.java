package com.lemon.pojo;

import javax.validation.constraints.NotNull;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class Case {
@Excel(name="用例编号")
@NotNull
private String caseId;
@Excel(name="用例描述")
private String desc;
@Excel(name="参数")
private String params;
@Excel(name="接口编号")
private String apiId;
public Case() {
	super();
	
}
public String getCaseId() {
	return caseId;
}
public void setCaseId(String caseId) {
	this.caseId = caseId;
}
public String getDesc() {
	return desc;
}
public void setDesc(String desc) {
	this.desc = desc;
}
public String getParams() {
	return params;
}
public void setParams(String params) {
	this.params = params;
}
public String getApiId() {
	return apiId;
}
public void setApiId(String apiId) {
	this.apiId = apiId;
}
@Override
public String toString() {
	return "Case [caseId=" + caseId + ", desc=" + desc + ", params=" + params + ", apiId=" + apiId + "]";
}



}
