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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;
import com.opencsv.*;
import com.sun.java_cup.internal.runtime.Scanner;

public class drscratchauto {


	public static void main(String[] args) throws IOException {

		String projectId_csvFile = "./ScratchExplore CLoud.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");

		// Instantiating driver object and launching browser
		driver = new ChromeDriver();
		FileWriter outputfile = new FileWriter(
				"./Scratch_Score.csv");
		CSVWriter writer = new CSVWriter(outputfile, ';', CSVWriter.NO_QUOTE_CHARACTER,
				CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);
		
		String[] headerRecord = { "Final_Score", "Flow_Control_Score", "Data_Representation_Score",
				"Abstraction_Score", "User_Interactivity_Score", "Synchronization_Score",
				"Parallelism_Score", "Logic_Score" };
		
		writer.writeNext(headerRecord);
		
		try {


			br = new BufferedReader(new FileReader(projectId_csvFile));
			while ((line = br.readLine()) != null) {

				driver.get("http:\\www.drscratch.org");
				WebElement projinput = driver.findElement(By.id("cf-name"));
				WebElement Analyzebutton = driver.findElement(By.id("url"));


				String[] project_url =  line.split(cvsSplitBy);
				projinput.sendKeys(project_url[1]);
				
				Analyzebutton.click();
				
				boolean textval = driver.findElement(By.xpath("//*[@id=\"score\"]")).isDisplayed();
				System.out.println(textval+"   roman");

				if (textval == true) {
					String Final_Score = driver.findElement(By.xpath("//*[@id=\"score\"]")).getText();
					String Flow_Control_Score = driver
							.findElement(By
									.xpath("/html/body/div/div[2]/	div/section/div/div/div/div/table/tbody/tr[1]/td[2]/div/div[1]"))
							.getText();
					String Data_Representation_Score = driver
							.findElement(By
									.xpath("/html/body/div/div[2]/div/section/div/div/div/div/table/tbody/tr[2]/td[2]/div/div[1]/span/strong"))
							.getText();
					String Abstraction_Score = driver
							.findElement(By
									.xpath("/html/body/div/div[2]/div/section/div/div/div/div/table/tbody/tr[3]/td[2]/div/div[1]/span/strong"))
							.getText();
					String User_Interactivity_Score = driver
							.findElement(By
									.xpath("/html/body/div/div[2]/div/section/div/div/div/div/table/tbody/tr[4]/td[2]/div/div[1]/span/strong"))
							.getText();
					String Synchronization_Score = driver
							.findElement(By
									.xpath("/html/body/div/div[2]/div/section/div/div/div/div/table/tbody/tr[5]/td[2]/div/div[1]/span/strong"))
							.getText();
					String Parallelism_Score = driver
							.findElement(By
									.xpath("/html/body/div/div[2]/div/section/div/div/div/div/table/tbody/tr[6]/td[2]/div/div[1]/span/strong"))
							.getText();
					String Logic_Score = driver
							.findElement(By
									.xpath("/html/body/div/div[2]/div/section/div/div/div/div/table/tbody/tr[7]/td[2]/div/div[1]/span/strong"))
							.getText();

					writer.writeNext(new String[] { Final_Score, Flow_Control_Score, Data_Representation_Score,
							Abstraction_Score, User_Interactivity_Score, Synchronization_Score, Parallelism_Score,
							Logic_Score });

					System.out.println(Final_Score);
					System.out.println(Flow_Control_Score);
					System.out.println(Data_Representation_Score);
					System.out.println(Abstraction_Score);
					System.out.println(User_Interactivity_Score);
					System.out.println(Synchronization_Score);
					System.out.println(Parallelism_Score);
					System.out.println(Logic_Score);

				}else{
					
				}
				System.out.println(textval);
			}

			driver.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			writer.close();

		} catch (IOException e) {
			
			e.printStackTrace();
			driver.close();
		} finally {
			if (br != null) {
				try {
					br.close();
					driver.close();
				} catch (IOException e) {
					e.printStackTrace();
					driver.close();

				}
			}
			writer.close();

		}

	}
}
