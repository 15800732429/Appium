package com.xiaoqiang.po;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import io.appium.java_client.AppiumDriver;

/*
*百度搜索：小强测试品牌
*性能测试实战班、自动化测试开发实战班长期招生中
*咨询QQ：2083503238 或微信：qiangfans
*所有学员享有免费、不限次数学习的机会，无任何额外费用
*官网与博客：www.xqtesting.com
*
*搜索元素和对应的操作
*/
public class SearchPage extends BasePage{//继承basepage，这样就可以用ta里面的方法了

	public SearchPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	/*
	 * 通过PageFactory来进行元素注解
	 * 和PageObject的思想一样，只是表现形式不一样而已
	 */
	@FindBy(id="com.xiaomi.shop.plugin.homepage:id/fragment_search_swither") 
	WebElement search_swither;

	@FindBy(id="com.xiaomi.shop2.plugin.search:id/input") 
	WebElement search_input;
	
	@FindBy(id="com.xiaomi.shop2.plugin.search:id/search_fragment_search_btn") 
	WebElement search_button;
	
	public void search(String p){
		search_swither.click();
		//调用basepage里的方法，入参element和搜索关键字
		clear_input(search_input,p);
		Reporter.log("输入关键字："+p);
		search_button.click();
		Reporter.log("点击搜索");

		
	}

}
