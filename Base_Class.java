package com.adactin.Adac;

	import java.awt.AWTException;
	import java.awt.Robot;
	import java.awt.event.KeyEvent;
	import java.io.File;
	import java.io.IOException;
	import java.util.List;
	import java.util.Set;
	import java.util.concurrent.TimeUnit;

	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.Alert;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.Select;
	public class Base_Class {

	public static WebDriver driver;
	public static WebElement element;

	//1.send keys
	public static void methodforinput(WebElement input,String str) {
		input.sendKeys(str);
	}

	//2.click
	public static void methodforclick(WebElement element) {
		element.click();
	}

	//3.browser launch
	public static WebDriver browserlaunch(String url)
	{	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ADMIN\\eclipse-workspace\\Adac\\Driver1\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}


	//4.openURL
	public static void getUrlmethod(String url) {
		driver.get(url);
	}

	//5.close
	public static void closemethod() {
		driver.close();
	}

	//6.quit
	public static void quitmethod() {
		driver.quit();
	}

	//7.navigate to
	public static void methodfornavigateto(String URL) {
		driver.navigate().to(URL);
	}

	//8.navigate back
	public static void navigateback() {
		driver.navigate().back();
	}

	//9.navigate forward
	public static void navigateforward() {
		driver.navigate().forward();
	}

	//10.navigate refresh
	public static void navigaterefresh() {
		driver.navigate().refresh();
	}

	//11.get
	public static void methodforget(String st) {
		driver.get(st);
	}

	//12.get title
	public static void gettitle() {
		driver.getTitle();
	}

	//13.get text
	public static void methodforgettext(WebElement element) {
		String text = element.getText();
		System.out.println("Element text:" + text);
	}

	//14.get current url
	public static void methodforcurrenturl() {
		driver.getCurrentUrl();
	}

	//15.wait
	public static void methodforwait(WebElement element) {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	//16.Is Enable
	public static void methodforenable(WebElement element) {
		boolean enabled = element.isEnabled();
		System.out.println("Is Enabled??" + enabled);
	}

	//17.Is Displayed
	public static void methodfordisplayed(WebElement element) {
		boolean displayed = element.isDisplayed();
		System.out.println("Is Enabled??" + displayed);
	}

	//18.Is Selected
	public static void methodforselected(WebElement element) {
		boolean selected = element.isSelected();
		System.out.println("Is Enabled??" + selected);
	}

	//19.get attribute
	public static void methodforgetat(WebElement element,String st) {
		element.getAttribute(st);
	}

	//20.Windowshandle
	/*public static void methodforwindowhandle(String mytitle) {
		Set<String> alltitle = driver.getWindowHandle();
		for(String id: alltitle){
		String title=driver.switchTo().window(id).getTitle();
		System.out.println(title);
		if(driver.switchTo().window(id).getTitle().equals(mytitle)){
		break;}}}*/
		
	//21.Takescreenshot
	public static void methodforscreenshot(String Destination) throws IOException {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File destination=new File(Destination);
		FileUtils.copyFile(source, destination);
	}

	//22.first selected options
	public static void getfirstselected(WebElement element) {
		Select Element1=new Select(element);
		WebElement option = Element1.getFirstSelectedOption();
		System.out.println("first selected option:" +option.getText());
	}

	//23.all selected options
	public static void getallselected(WebElement element) {
		Select Element1=new Select(element);
	 List<WebElement> selectedOptions = Element1.getAllSelectedOptions();
	 for (WebElement webElement : selectedOptions) {
		String text = webElement.getText();;
		System.out.println(text);	
	}
	}

	//24.is multiple
	public static void ismultiple(WebElement element) {
		Select ele=new Select(element);
		boolean multiple = ele.isMultiple();
		System.out.println("Is multiple??" + multiple);
	}

	//25.get options
	public static void methodtogetoptions(WebElement element) {
		Select elem=new Select(element);
		List<WebElement> options = elem.getOptions();
		System.out.println("*****options found******");
		for (WebElement webElement : options) {
			String text = webElement.getText();
			System.out.println(text);
		}
	}

	//26.alert
	public static void methodforalert() {
		Alert al=driver.switchTo().alert();
		al.accept();
	}

	//27.action
	public static void methodforaction(WebElement target) {
		Actions ac=new Actions(driver);
		ac.moveToElement(target).build().perform();
	}

	//28.frames
	public static void methodforframes(WebElement element) {
		driver.switchTo().frame(element);
	}

	public static void frame() {
		driver.switchTo().defaultContent();
	}

	//29.robot
	public static void methodforrobot() throws AWTException {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	//30.Dragndrop
	public static void methodfordragndrop(WebElement ele1,WebElement ele2) {
		Actions sc=new Actions(driver);
		sc.dragAndDrop(ele1, ele2);
	}

	//31.scrollup the input webelement
	public static void scrollupdown(WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",element);
	}

	//32.dropdown
	public static void dropdown(WebElement element,String i,String input) {
		Select s=new Select(element);
		if(i.equalsIgnoreCase("index")) {
			int parseInt = Integer.parseInt(input);
			s.selectByIndex(parseInt);}
			else if(i.equalsIgnoreCase("value")) {
				s.selectByValue(input);
			}}
			
		public static void drop(WebElement element,String name) {
			Select s=new Select(element);
			s.selectByValue(name);
		}
		
		
		
	}


	

