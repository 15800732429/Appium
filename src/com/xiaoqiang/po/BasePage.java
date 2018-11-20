package com.xiaoqiang.po;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import io.appium.java_client.AppiumDriver;
/*
*百度搜索：小强测试品牌
*性能测试实战班、自动化测试开发实战班长期招生中
*咨询QQ：2083503238 或微信：qiangfans
*所有学员享有免费、不限次数学习的机会，无任何额外费用
*官网与博客：www.xqtesting.com
*/
public class BasePage {
	  private static AppiumDriver driver;


	//构造方法，初始化driver
	public BasePage(AppiumDriver driver) {
		BasePage.driver=driver;
		//对elements进行初始化，这句不能丢
		PageFactory.initElements(BasePage.driver, this);
	}
	
	
	
	//文本框输入
	public void input_text(WebElement element , String text){
		element.sendKeys(text);
	}
	
	//先清空，再输入
	public void clear_input(WebElement element,String text){
		element.clear();
		Reporter.log("清空");
		element.sendKeys(text);
	}
	
	
	//获取当前activity
	public String getCurrentActivity(){
		String ca=BasePage.driver.currentActivity();
		Reporter.log("当前activity="+ca);
		return ca;
	}
	

	
	//获取元素文本内容
	public String getResult(WebElement element) throws InterruptedException{
		Thread.sleep(2000);
		return element.getText();
		
	}
	
	//其他的通用操作都可以在这里进行二次封装

}
