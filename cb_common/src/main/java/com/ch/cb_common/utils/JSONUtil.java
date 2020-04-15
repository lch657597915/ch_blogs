package com.ch.cb_common.utils;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

/**
 * @author lch
 * @date 2019-08-08
 **/
public class JSONUtil {

	/**
	 * 将json字符串优雅的打印格式化json
	 * @param jsonString json字符串
	 * @author lch
	 * @date 2019-08-08
	 */
	@SneakyThrows
	public static void printPretyJsonForString(String jsonString){
		ObjectMapper mapper = new ObjectMapper();
		Object obj = mapper.readValue(jsonString, Object.class);
		//格式化/美化/优雅的输出
		System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj));
	}

	/**
	 * 将对象优雅的打印格式化json
	 * @param obj Object对象
	 * @author lch
	 * @date 2019-08-08
	 */
	@SneakyThrows
	public static void printPretyJsonForObject(Object obj){
		ObjectMapper mapper = new ObjectMapper();
		//格式化/美化/优雅的输出
		System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj));
	}

	/**
	 * 将对象打印成json字符串
	 * @param obj Object对象
	 * @author lch
	 * @date 2019-08-08
	 */
	@SneakyThrows
	public static void printJsonForObject(Object obj){
		String s = JSON.toJSONString(obj);
		System.out.println(s);
	}
}
