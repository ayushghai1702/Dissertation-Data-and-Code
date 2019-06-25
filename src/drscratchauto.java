	import org.openqa.selenium.By;
	import java.io.BufferedReader;
	import java.io.FileNotFoundException;
	import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.io.FileWriter; 

import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.firefox.*;
	import org.openqa.selenium.WebElement;
	import java.util.concurrent.TimeUnit;
	import com.opencsv.*;
import com.sun.java_cup.internal.runtime.Scanner;
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
		        	String Final_Score=driver.findElement(By.xpath("//*[@id=\"score\"]")).getText();
		        	String Flow_Control_Score=driver.findElement(By.xpath("/html/body/div/div[2]/	div/section/div/div/div/div/table/tbody/tr[1]/td[2]/div/div[1]")).getText();
		        	String Data_Representation_Score= driver.findElement(By.xpath("/html/body/div/div[2]/div/section/div/div/div/div/table/tbody/tr[2]/td[2]/div/div[1]/span/strong")).getText();
		        	String Abstraction_Score= driver.findElement(By.xpath("/html/body/div/div[2]/div/section/div/div/div/div/table/tbody/tr[3]/td[2]/div/div[1]/span/strong")).getText();
		        	String User_Interactivity_Score= driver.findElement(By.xpath("/html/body/div/div[2]/div/section/div/div/div/div/table/tbody/tr[4]/td[2]/div/div[1]/span/strong")).getText();
		        	String Synchronization_Score= driver.findElement(By.xpath("/html/body/div/div[2]/div/section/div/div/div/div/table/tbody/tr[5]/td[2]/div/div[1]/span/strong")).getText();
		        	String Parallelism_Score= driver.findElement(By.xpath("/html/body/div/div[2]/div/section/div/div/div/div/table/tbody/tr[6]/td[2]/div/div[1]/span/strong")).getText();
		        	String Logic_Score= driver.findElement(By.xpath("/html/body/div/div[2]/div/section/div/div/div/div/table/tbody/tr[7]/td[2]/div/div[1]/span/strong")).getText();
		        	
		        	String[] Final_Score_Array= new String [] {Final_Score};
		            FileWriter outputfile = new FileWriter("C:\\\\Users\\\\ayush\\\\eclipse-workspace\\\\ScratchAutoDissert\\\\Scratch_Score.csv"); 
		        	CSVWriter writer = new CSVWriter(outputfile, ';', 
                            CSVWriter.NO_QUOTE_CHARACTER, 
                            CSVWriter.DEFAULT_ESCAPE_CHARACTER, 
                            CSVWriter.DEFAULT_LINE_END); 
		        	
		        	
		        	System.out.println(Final_Score);
		        	System.out.println(Flow_Control_Score);
		        	System.out.println(Data_Representation_Score);
		        	System.out.println(Abstraction_Score);
		        	System.out.println(User_Interactivity_Score);
		        	System.out.println(Synchronization_Score);
		        	System.out.println(Parallelism_Score);
		        	System.out.println(Logic_Score);

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
