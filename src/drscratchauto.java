	import org.openqa.selenium.By;
	import java.io.BufferedReader;
	import java.io.FileNotFoundException;
	import java.io.FileReader;
	import java.io.IOException;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.firefox.*;
	import org.openqa.selenium.WebElement;
	import java.util.concurrent.TimeUnit;
public class drscratchauto {


public static void main(String[] args) {

        String csvFile = "C:\\Users\\ayush\\eclipse-workspace\\ScratchAutoDissert\\ScratchExplore CLoud.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] Project_url = line.split(cvsSplitBy);

                System.out.println(Project_url[1]);
                //Creating a driver object referencing WebDriver interface
		        WebDriver driver;
		        System.setProperty("webdriver.gecko.driver", "C:\\Users\\ayush\\eclipse-workspace\\Webdriver_Setup\\geckodriver.exe");
		        	        
		        //Instantiating driver object and launching browser
		        driver = new FirefoxDriver();
		        
		        //Using get() method to open a webpage
		        driver.get("http:\\www.drscratch.org");
		        
		        WebElement projinput= driver.findElement(By.id("cf-name"));
		        WebElement Analyzebutton= driver.findElement(By.id("url"));
		  
		        projinput.sendKeys(Project_url[1]);
		        
		        Analyzebutton.click();
		        //WebElement score=driver.findElement(By.xpath("//*[@id=\"score\"]"));
		       //The code below has error which needs to be handled
		        Boolean textval=driver.findElement(By.xpath("//*[@id=\"score\"]")).isDisplayed();
		        if(textval== true)
		        {
		        	String textvalue=driver.findElement(By.xpath("//*[@id=\"score\"]")).getText();
		        	System.out.print(textvalue);
		        }
		        else
		        {
			        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		        	String textvalue=driver.findElement(By.xpath("//*[@id=\"score\"]")).getText();
		        	System.out.print(textvalue);

		        }
		        
		        System.out.println(textval);
		       
		        		
		        driver.close();


            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }



		        
		       
		    }
		 
		}
}
