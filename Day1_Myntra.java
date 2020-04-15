package seleniumPractiseSessions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Day1_Myntra {

	public static void main(String[] args) throws InterruptedException {
		
		//1.launch browser
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.myntra.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//2.mousehover on women
		WebElement women = driver.findElementByXPath("//a[@data-index='1']");
		Actions act=new Actions(driver);
		act.moveToElement(women).perform();
		
		//3.select jackets and coats
		driver.findElementByLinkText("Jackets & Coats").click();
		  Thread.sleep(2000);
		
		//4. Total count of item
		String count = driver.findElementByClassName("title-count").getText();
		int TotalCount = Integer.parseInt(count.replaceAll("\\D", ""));
		System.out.println("Jacket and Coat count is:"+TotalCount);
		
		//5.validate the sum categories count matches
		String JacketsCount=driver.findElementByXPath("(//span[@class='categories-num'])[1]").getText();
		//String jcount = JacketsCount.replaceAll("//D", "");
		int jktcount = Integer.parseInt(JacketsCount.replaceAll("\\D", ""));
		
		String CoatsCount=driver.findElementByXPath("(//span[@class='categories-num'])[2]").getText();
		//String Ccount = CoatsCount.replaceAll("//D", "");
		int Coatcount = Integer.parseInt(CoatsCount.replaceAll("\\D", ""));
		
		 int  ExactCount=jktcount  +  Coatcount;
		 System.out.println("Total count of Jackets and coats are"+ExactCount);
		 
		 if(TotalCount==ExactCount)
		 {
			System.out.println("count is matched"); 
		 }
		 else {
			 System.out.println("count not matched");
		 }
		
	   //6.check coats
		driver.findElementByXPath("(//label[@class='common-customCheckbox vertical-filters-label'])[2]").click();
	 
		//7.click+more option under BRAND
	 driver.findElementByClassName("brand-more").click();
	 
	 //8.Type MANGO and click checkbox
	 driver.findElementByClassName("FilterDirectory-searchInput").sendKeys("MANGO");
	 driver.findElementByXPath("//label[@class=' common-customCheckbox']").click();
	 
	 //9.close pop-up x
	 
	 driver.findElementByXPath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']").click();
	 Thread.sleep(3000);
		 
	 //10.confirm all the coats are of brand Mango
	   List<WebElement> brandList = driver.findElementsByXPath("//h3[@class='product-brand']");
	   int brandCount=0;
		for (WebElement product :brandList ) {
			if(product.getText().equals("MANGO"))
			{
				brandCount=brandCount+1;
			}}
		
		if(brandCount==brandList.size()) {
		System.out.println("All product names  are Mango ");
		}
		
		
		//11. Sort by Better Discount
		WebElement sortBy = driver.findElementByClassName("sort-sortBy");
		Actions sortbyopt=new Actions(driver);
		sortbyopt.moveToElement(sortBy).perform();
	    driver.findElementByXPath("//label[text()='Better Discount']").click();
				
			
		//12. Find the price of first displayed item
		List<WebElement> priceList = driver.findElementsByXPath("//span[@class='product-discountedPrice']");
		String price = priceList.get(0).getText();
	    System.out.println("Price of the first displayed item: "+price);
					   
	    //13. Mouse over on size of the first item
		WebElement eleSize = driver.findElementByXPath("(//div[@class='product-productMetaInfo'])[1]");
		sortbyopt.moveToElement(eleSize).perform();
				
		//14. Click on WishList Now
		driver.findElementByXPath("//span[text()='wishlist now']").click();
				
		 //15. Close Browser
		 driver.close();

		
		
		
		
		
		
	}
	
	
	
	
	}
	   
		
	
	  
		
		
		
		
		
		

	


