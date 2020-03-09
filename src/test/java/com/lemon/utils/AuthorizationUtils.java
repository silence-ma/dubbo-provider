package com.lemon.utils;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;

import com.alibaba.fastjson.JSONPath;

public class AuthorizationUtils {
	public static Map<String, String> env = new HashMap<String, String>();

	public static void main(String[] args) {
		String s = "";
		storeToken(s);
	}

	public static void storeToken(String response) {
		// 1.取出token
		Object token = JSONPath.read(response, "$.result.accessToken");
		// System.out.println(token);

		// 2.存储token
		if (token != null) {
			env.put("token", token.toString());
		}
	}

	// 添加token到请求头
	public static void addToken(HttpRequestBase request) {
		String token = env.get("token");
		if (token != null) {
			request.addHeader("Authorization", "Bearer " + token);
		}

	}

}
