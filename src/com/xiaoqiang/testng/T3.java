package com.xiaoqiang.testng;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
/*
*百度搜索：小强测试品牌
*性能测试实战班、自动化测试开发实战班长期招生中
*咨询QQ：2083503238 或微信：qiangfans
*所有学员享有免费、不限次数学习的机会，无任何额外费用
*官网与博客：www.xqtesting.com
*对应的xml为testng_params_t3.xml
*/
public class T3 {
	private static AppiumDriver driver;

  @BeforeClass
  public void beforeClass() throws MalformedURLException {
	  System.out.println("before class");
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

  @AfterClass
  public void afterClass() {
      System.out.println("after class");
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
      driver.quit();
  }
  
  /*
   * 参数化第一种方法
   * 通过xml传递参数给代码。好处是参数化数据和代码分离，好维护
   */
  @Test(enabled=false)
  @Parameters({"p1","p2"})
  public void search1(String p1, String p2) {    	
  	  //广告页的跳过
      //driver.findElementById("com.xiaomi.shop:id/skip").click();
      //业务很重要啊，如果你不做这个点击就没办法输入关键字搜索
      driver.findElementById("com.xiaomi.shop.plugin.homepage:id/fragment_search_swither").click();
      driver.findElementById("com.xiaomi.shop2.plugin.search:id/input").sendKeys(p1);
      driver.findElementById("com.xiaomi.shop2.plugin.search:id/search_fragment_search_btn").click();
  }
  
  /*
   * 参数化第二种方法
   * 通过注解@DataProvider。好处是灵活性好，可以构造复杂的参数化数据。
   */
  @DataProvider(name="searchParams")
  public Object[][] searchParams() {
    return new Object[][] {
      new Object[] { "电视", "记录仪" },
      //new Object[] {"鼠标"},
      //new Object[] { 2, "b" },
    };
  }
  @Test(dataProvider="searchParams")
  public void search2(String p1, String p2) throws InterruptedException{
	  //广告页的跳过
      //driver.findElementById("com.xiaomi.shop:id/skip").click();
      //业务很重要啊，如果你不做这个点击就没办法输入关键字搜索
      driver.findElementById("com.xiaomi.shop.plugin.homepage:id/fragment_search_swither").click();
      driver.findElementById("com.xiaomi.shop2.plugin.search:id/input").sendKeys(p1);
      driver.findElementById("com.xiaomi.shop2.plugin.search:id/search_fragment_search_btn").click();
      Reporter.log("完成第一次搜索");
     
      driver.findElementById("com.xiaomi.shop2.plugin.search:id/input").clear();
      driver.findElementById("com.xiaomi.shop2.plugin.search:id/input").sendKeys(p2);
      driver.findElementById("com.xiaomi.shop2.plugin.search:id/search_fragment_search_btn").click();
      Reporter.log("完成第二次搜索");

  }

}
