package com.lemon.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONObject;
import com.beust.jcommander.Parameters;

public class HttpUtils {
	public static BasicHeader covheader=new BasicHeader("AppId", "31");

	public static BasicHeader v2header=new BasicHeader("X-Lemonban-Media-Type", "lemonban.v2");
	public static void call(String url, String params,String type,String contentType){
		  if("json".equals(contentType)){
		    	if("post".equals(type)){
		    		HttpUtils.testPostJson(url, params);
		    	}else if("get".equals(type)){
		    		HttpUtils.testGetJson(url, params);
		    	}
		    	
				
		    }else if("form".equals(contentType)){
		    	//json格式的参数转换为key-value格式
		    	//1.先把json转换成map对象，hashmap是map的父接口
		    	String str = jsonKeyValue(params);
		    	HttpUtils.testPostForm(url, str);
		    }
	}

	private static String jsonKeyValue(String params) {
		HashMap<String, String> hashMap = JSONObject.parseObject(params, HashMap.class);
		//2.再把map对象转换成字符串，然后拼接成key-value
		String str="";
		Set<String> keySet = hashMap.keySet();
		for (String key : keySet) {
			String value = hashMap.get(key);
			str+=key+"="+value+"&";
		}
		return str;
	}

	public static void testGetJson(String url, String params) {

		// 创建request连接
		HttpGet get = new HttpGet(url);
		// 设置请求头
		get.addHeader(v2header);
		get.addHeader("Content-Type", "application/json");
		// 创建客户端
		HttpClient client = HttpClients.createDefault();
		try {
			// 发送请求并获取相应报文
			HttpResponse response = client.execute(get);
			// 获取相应状态码
			int code = response.getStatusLine().getStatusCode();
			// 获取相应头信息
			Header[] allHeaders = response.getAllHeaders();
			String headers = Arrays.toString(allHeaders);
			// 获取响应体
			HttpEntity entity = response.getEntity();
			String result = EntityUtils.toString(entity);
			System.out.println("响应头信息：" + headers);
			System.out.println("报文信息：" + result);
			System.out.println("状态码信息：" + code);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void testPostJson(String url, String params) {
     System.out.println(params);
		// 创建request连接
		HttpPost post = new HttpPost(url);
		// 设置相应头
	
		post.addHeader("Content-Type", "application/json");
		post.addHeader(covheader);
        AuthorizationUtils.addToken(post);
		try {
			// 添加参数
			StringEntity requestEntity = new StringEntity(params);
			post.setEntity(requestEntity);
			HttpClient client = HttpClients.createDefault();
			HttpResponse response = client.execute(post);
			int code = response.getStatusLine().getStatusCode();
			Header[] allHeaders = response.getAllHeaders();
			String headers = Arrays.toString(allHeaders);
			HttpEntity entity = response.getEntity();
			String result = EntityUtils.toString(entity);
			AuthorizationUtils.storeToken(result);
			System.out.println("响应头信息：" + headers);
            System.out.println("报文信息：" + result);
			System.out.println("状态码信息：" + code);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public static void testPostForm(String url, String params) {

		// 创建request连接
		HttpPost post = new HttpPost(url);
		// 设置相应头
		post.addHeader(v2header);
		post.addHeader("Content-Type", "application/x-www-form-urlencoded");
        AuthorizationUtils.addToken(post);
		try {
			// 添加参数
			StringEntity requestEntity = new StringEntity(params);
			post.setEntity(requestEntity);
			HttpClient client = HttpClients.createDefault();
			HttpResponse response = client.execute(post);
			int code = response.getStatusLine().getStatusCode();
			Header[] allHeaders = response.getAllHeaders();
			String headers = Arrays.toString(allHeaders);
			HttpEntity entity = response.getEntity();
			String result = EntityUtils.toString(entity);
			AuthorizationUtils.storeToken(result);
			System.out.println("响应头信息：" + headers);
			System.out.println("报文信息：" + result);
			System.out.println("状态码信息：" + code);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void testPatch(String url, String params) {

		HttpPatch patch = new HttpPatch(url);
		patch.addHeader(v2header);
		patch.addHeader("Content-Type", "application/json");
        AuthorizationUtils.addToken(patch);
		try {
			// 添加参数
			StringEntity requestEntity = new StringEntity(params);
			patch.setEntity(requestEntity);
			HttpClient client = HttpClients.createDefault();
			HttpResponse response = client.execute(patch);
			int code = response.getStatusLine().getStatusCode();
			Header[] allHeaders = response.getAllHeaders();
			String headers = Arrays.toString(allHeaders);
			HttpEntity entity = response.getEntity();
			String result = EntityUtils.toString(entity);
			//token存储
            AuthorizationUtils.storeToken(result);
			System.out.println("响应头信息：" + headers);
			System.out.println("报文信息：" + result);
			System.out.println("状态码信息：" + code);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	

}
