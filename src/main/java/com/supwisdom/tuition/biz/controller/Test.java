package com.supwisdom.tuition.biz.controller;

/**
 * @author hanlei
 * @date 2022/04/11
 */
public class Test {
	public static void main(String[] args) throws Exception {
		System.out.println("t3");
	}

	public static void read(String s) throws Exception {
		if (!"a.txt".equals(s)) {
			throw new Exception("文件异常");
		}
	}
}