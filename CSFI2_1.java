import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


public class CSFI2_1 {

	@Test
	public void csfi21() {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:/workspace/SeleniumPractice/external exe/chromedriver.exe");

		ChromeDriver fdriver= new ChromeDriver();
		String uname="";
		String pass= "";



		fdriver.manage().window().maximize();
		fdriver.get("http://s-login.cengage.com");
		fdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		fdriver.findElementById("emailId").sendKeys(uname);

		//Or second way of writing the input is below
		/*WebElement uid = fdriver.findElementByName("email");
		uid.sendKeys("");*/

		//Now entering the password.
		WebElement pwd=fdriver.findElementById("password");
		pwd.sendKeys(pass);

		//Now Login button
		fdriver.findElementByXPath("//input[@type='submit']").click();
		fdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//catching the name of Institute.
		String inst= fdriver.findElementById("welcomeBox").getText();
		//System.out.print(inst);  //prints both the instructor and institutes names
		//extracting the institutename.
		boolean adamsT= inst.contains("ADAMS");
		if(adamsT==true)
			System.out.println("ADAMS");

		fdriver.findElementById("productISBN").click();
		fdriver.findElementByXPath("//option[contains(text(),'Staley, FOCUS on College Success, 4th Edition')]").click();

		//clicking on the book title
		fdriver.findElementByXPath("//span[contains(text(),' CSFI 2.0 for Staley’s FOCUS on College Success ')]").click();

		fdriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		fdriver.manage().window().maximize();
		String currenturl = fdriver.getCurrentUrl();
		System.out.println(currenturl);

		nextWindow(adamsT,fdriver);
	}

	//Method to work inside CNOW application.
	public static void nextWindow(boolean institute, ChromeDriver fdriver)
	{
		String winHandleBefore=fdriver.getWindowHandle();

		for(String winHandle:fdriver.getWindowHandles())
		{
			fdriver.switchTo().window(winHandle);
		}
	


		  String url=fdriver.getCurrentUrl();
		  System.out.println(url);
		  
		  courseCreation(fdriver);
		 }

		 //Method for course creation
		 public static void courseCreation(ChromeDriver fdriver)
		 {
			  fdriver.findElementByLinkText("Courses").click();
			  fdriver.findElementByLinkText("Create a New Course").click();
			  fdriver.findElementByXPath("//label[contains(text(),'Build a Course Manually')]").click();
			  fdriver.findElementById("createCourseNextStepButton").click();
			  fdriver.findElementById("bookSelector").click();
			  
			  fdriver.findElementByXPath("//option[contains(text(),'Staley: FOCUS on College Success, 4th Edition')]").click();
			  
			  //Above code is transitive to following one liner.
			  Select textBook=new Select(fdriver.findElementById("bookSelector"));
			  
//			  String btitle="Warren/Reeve/Duchac: Accounting, 24th Edition";
//			  
//			  textBook.selectByVisibleText(btitle);
			  String coursenm = "CSFICourse10";
			  
			  
			  fdriver.findElementById("name").sendKeys(coursenm);
			  fdriver.findElementById("startDateTimeFormat").click();
			  //fdriver.findElementByClassName("ui-state-default ui-state-highlight");	//Example of how compound class name is not permitted.	
			  fdriver.findElementByLinkText("12").click();
			  fdriver.findElementByXPath("//button[contains(text(),'Done')]").click();
			  
			  fdriver.findElementById("endDateTimeFormat").click();
			  //, mnth=12;
//			  int year=2016;
			  
			  WebElement yd=fdriver.findElementByXPath("//select[@class='ui-datepicker-year']");
			  Select yeardrop= new Select(yd);
			  yeardrop.selectByVisibleText("2016");
			  
			  fdriver.findElementByLinkText("12").click();
			  fdriver.findElementByXPath("//button[contains(text(),'Done')]").click();

//			  Sometimes the date picker doesn't work as the date element doesn't get enabled in time 115ms
			  
//			  Clicking on Create course button and course creation.
			  fdriver.findElementByLinkText("Create Course").click();
			  
//			  Extracting information at Course Created page.
			  String ekey = fdriver.findElementByXPath("//a[contains(text(),'E-')]").getText();
			  
//			  String ekey = fdriver.findElementByXPath("//div[@class='pageContentBody']//strong[contains(text(),'E-')]").getText();
			  System.out.println("Course is created and Details are as follows");
			  System.out.println("Course Name: "+coursenm+" and key is: "+ekey);

			  
//			  Attempt to extract only course key from the ekey URL. Unsuccessful. Created course click seizes.
			  //			  String rkey=ekey.concat("E");
//			  System.out.println(rkey);
////			  String key=ekey.substring(40, 55);
//			  System.out.println(key);
//		 }
			  
// Now navigating to Assignments tab to create a CSFI 2.1 assignment 
			  Assign_nav(fdriver);
		}
		 
		 //method to navigate to Assignments tab
		 public static void Assign_nav(ChromeDriver fdriver)
		 {
			 fdriver.findElementByLinkText("Assignments").click();
		 }
		 
		 //method to creted CSFI 2.1 assignment using first flow.
		 public static void CSFI21acw1()
		 {
			 
		 }
		  
}
	