package com.cloopen.rest.demo;

import java.util.HashMap;
import java.util.Set;
import com.cloopen.rest.sdk.CCPRestSDK;
import com.cloopen.rest.sdk.CCPRestSDK.BodyType;



public class QuerySMSTemplate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HashMap<String, Object> result = null;

		CCPRestSDK restAPI = new CCPRestSDK();
		restAPI.init("app.cloopen.com", "8883");// 初始化服务器地址和端口，格式如下，服务器地址不需要写https://
		restAPI.setAccount("aaf98f89493ff1d301494b23d40a064e", "5825ce8126054f4f837b1a8329d66065");// 初始化主帐号和主帐号TOKEN
		restAPI.setAppId("8a48b551493ffbd4014950393d000996");// 初始化应用ID
		result = restAPI.QuerySMSTemplate("10544");//模板Id，不带此参数查询全部可用模板 

		System.out.println("QuerySMSTemplate result=" + result);
		
		if("000000".equals(result.get("statusCode"))){
			//正常返回输出data包体信息（map）
			HashMap<String,Object> data = (HashMap<String, Object>) result.get("data");
			Set<String> keySet = data.keySet();
			for(String key:keySet){
				Object object = data.get(key);
				System.out.println(key +" = "+object);
			}
		}else{
			//异常返回输出错误码和错误信息
			System.out.println("错误码=" + result.get("statusCode") +" 错误信息= "+result.get("statusMsg"));
		}
	}

}
