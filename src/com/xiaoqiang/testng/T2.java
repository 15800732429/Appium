package com.xiaoqiang.testng;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
/*
*百度搜索：小强测试品牌
*性能测试实战班、自动化测试开发实战班长期招生中
*咨询QQ：2083503238 或微信：qiangfans
*所有学员享有免费、不限次数学习的机会，无任何额外费用
*官网与博客：www.xqtesting.com
*对应的xml为testng_a_t2.xml
*/
public class T2 {
	
	private static AppiumDriver driver;
		
    @BeforeSuite
    public void beforesuite() {
        System.out.println("before suite");
    }
    @AfterSuite
    public void aftersuite() {
        System.out.println("after suite");
    }
    
    @BeforeTest
    public void beforetest() {
        System.out.println("before test");
    }
    @AfterTest
    public void AfterTest() {
        System.out.println("after test");
    }
    

    @BeforeClass
    public void beforeclass() throws MalformedURLException {
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
    public void aftertclass() {
        System.out.println("after class");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
        driver.quit();
    }
    
    @BeforeMethod
    public void beforemethod() {
        System.out.println("before method");
    }
    
    @AfterMethod
    public void aftertmethod() {
        System.out.println("after method");
    }
    
    @Test
    public void search() {    	
    	//广告页的跳过
        //driver.findElementById("com.xiaomi.shop:id/skip").click();
        //业务很重要啊，如果你不做这个点击就没办法输入关键字搜索
        driver.findElementById("com.xiaomi.shop.plugin.homepage:id/fragment_search_swither").click();
        driver.findElementById("com.xiaomi.shop2.plugin.search:id/input").sendKeys("空气净化器");
        driver.findElementById("com.xiaomi.shop2.plugin.search:id/search_fragment_search_btn").click();
    }
        
    //普通方法，没有注解，所以testng不会执行
    public void test3() {
        System.out.println("test3");
    }
    
    //忽略测试，跳过该方法不会执行
    @Test(enabled=false)
    public void skip(){
    	System.out.println("不会打印我");
    }
    
    
    //如果测试花费的时间超过指定的毫秒数，那么TestNG将会中止ta并标记为失败
    @Test(timeOut = 1000)
    public void time() throws InterruptedException {
    	Thread.sleep(2000);
    	System.out.println("你猜猜");
    }
   
    

        
    /*所谓依赖就是测试用例之间有先后顺序，
     * 比如方法1成功之后才能执行方法2，如果方法1失败，则不会执行方法2
     */
    @Test(dependsOnMethods = {"search"})
    public void bye(){
    	System.out.println("byebye");
    }
    
    
    
    
    
    
    
    
    
    //演示失败时候report里显示
    //@Test
    public void fail(){
    	driver.get("http://www.baidu.com");
    	driver.findElement(By.id("kkkkk")).sendKeys("小强测试品牌");
    }
    
    //分组
    //@Test(groups="groupsDemo")
    public void g1(){
    	System.out.println("g1");
    }
    //@Test(groups="groupsDemo")
    public void g2(){
    	System.out.println("g2");
    }
	
}
