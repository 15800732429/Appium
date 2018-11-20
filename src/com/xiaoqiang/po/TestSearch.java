package com.xiaoqiang.po;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
/*
*百度搜索：小强测试品牌
*性能测试实战班、自动化测试开发实战班长期招生中
*咨询QQ：2083503238 或微信：qiangfans
*所有学员享有免费、不限次数学习的机会，无任何额外费用
*官网与博客：www.xqtesting.com
*对应的xml为testng_all.xml
*/
public class TestSearch {

  private static AppiumDriver driver;

  @Test(dataProvider = "searchParams")
  public void testSearch(String p) {
	  new SearchPage(driver).search(p);
      
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
  public void afterMethod() throws InterruptedException {
	  driver.quit();
  }
  
  @DataProvider(name="searchParams")
  public Object[][] searchParams() {
    return new Object[][] {
      new Object[] { "手机" },
      new Object[] { "路由器" },
    };
  }

}
