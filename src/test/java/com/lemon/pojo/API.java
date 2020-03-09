package com.lemon.pojo;

import javax.validation.constraints.NotNull;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class API {
 @Excel(name="接口编号")
 @NotNull
 private String apiId;
 @Excel(name="接口名称")
 private String name;
 @Excel(name="接口提交方式")
private String type;
 @Excel(name="接口地址")
private String url;
 @Excel(name="参数类型")
private String contentType;

public String getApiId() {
	return apiId;
}
public void setApiId(String apiId) {
	this.apiId = apiId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}
public String getContentType() {
	return contentType;
}
public void setContentType(String contentType) {
	this.contentType = contentType;
}
public API() {
	super();
	
}
@Override
public String toString() {
	return "API [apiId=" + apiId + ", name=" + name + ", type=" + type + ", url=" + url + ", contentType="
			+ contentType + "]";
}


}
