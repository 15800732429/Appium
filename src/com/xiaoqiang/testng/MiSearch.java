package com.xiaoqiang.testng;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;

import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
/*
*百度搜索：小强测试品牌
*性能测试实战班、自动化测试开发实战班长期招生中
*咨询QQ：2083503238 或微信：qiangfans
*所有学员享有免费、不限次数学习的机会，无任何额外费用
*官网与博客：www.xqtesting.com
*对应的xml为testng_misearch.xml
*/
public class MiSearch {
	private static AppiumDriver driver;

  @Test(dataProvider = "searchParams")
  public void search(String p) throws InterruptedException {
	  //广告页的跳过
      //driver.findElementById("com.xiaomi.shop:id/skip").click();
      //业务很重要啊，如果你不做这个点击就没办法输入关键字搜索
      driver.findElementById("com.xiaomi.shop.plugin.homepage:id/fragment_search_swither").click();
      driver.findElementById("com.xiaomi.shop2.plugin.search:id/input").sendKeys(p);
      Reporter.log("搜索关键字="+p);
      driver.findElementById("com.xiaomi.shop2.plugin.search:id/search_fragment_search_btn").click();
      Reporter.log("搜索完成");
      
      Thread.sleep(5000);
	  try{
		  Assert.assertTrue(driver.getPageSource().contains(p));
		  Reporter.log("搜索成功");
	  }
	  catch(Exception e){
		  e.printStackTrace();
	  }
  }
  
  @BeforeMethod
  public void beforeMethod() throws MalformedURLException {
	  DesiredCapabilities capabilities = new DesiredCapabilities();  
      capabilities.setCapability(CapabilityType.BROWSER_NAME, "");  
      capabilities.setCapability("platformName", "Android");  
      capabilities.setCapability("deviceName","Android Emulator");  
      capabilities.setCapability("platformVersion", "4.4.4");  
      //包名和activity名
      capabilities.setCapability("appPackage", "com.xiaomi.shop");  
      capabilities.setCapability("appActivity", "com.xiaomi.shop.activity.MainTabActivity");  
      //不重置数据
      capabilities.setCapability("noReset", true);
      //隐藏手机中的软键盘,让手机中可以输入中文
      capabilities.setCapability("unicodeKeyboard",true);
      capabilities.setCapability("resetKeyboard",true);
      
      driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);  
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
  
  }

  @AfterMethod
  public void afterMethod() {
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
      driver.quit();
  }


  @DataProvider(name="searchParams")
  public Object[][] searchParams() {
    return new Object[][] {
      new Object[] { "手机" },
      new Object[] { "电视" },
      new Object[] { "路由器" },
    };
  }
}
