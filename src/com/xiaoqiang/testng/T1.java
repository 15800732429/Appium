package com.xiaoqiang.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

/*
*百度搜索：小强测试品牌
*性能测试实战班、自动化测试开发实战班长期招生中
*咨询QQ：2083503238 或微信：qiangfans
*所有学员享有免费、不限次数学习的机会，无任何额外费用
*官网与博客：www.xqtesting.com
*对应的xml为testng_base_t1.xml
*/
public class T1 {
  @Test
  public void f() {
	  System.out.println("小强好丑");
  }
  
  @Test
  public void ff(){
	  System.out.println("小强好帅");
  }
  
  @BeforeClass
  public void beforeClass() {
	  System.out.println("i am before class");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("i am after class");
  }

}
