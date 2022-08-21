package mainPkg;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
	public static Properties prop;
	public static WebDriver driver;
	
	public Base() {
		try {
			prop = new Properties();
				// 2. FileInputStream class -> read config.properties
			FileInputStream fis = new FileInputStream("C:\\Users\\User\\eclipse-workspace\\"
					+ "JanFebTDDPOM\\src\\main\\java\\configProperties\\config.properties");
				// 3. load all the value read to Properties class
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void intitialization() {
		String browser = prop.getProperty("browser");
		
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty(prop.getProperty("chromeKey"), prop.getProperty("chromePath"));
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox") || browser.equalsIgnoreCase("ff")) {
			System.setProperty(browser, prop.getProperty("ffPath"));
			driver = new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("internet explorer") || prop.getProperty("browser")
				.equalsIgnoreCase("ie")) {
			System.setProperty(prop.getProperty("ieKey"), prop.getProperty("iePath"));
			driver = new InternetExplorerDriver();
		}else if(browser.equalsIgnoreCase("msedge") || browser.equalsIgnoreCase("edge")) {
			System.setProperty(prop.getProperty("edgeKey"), prop.getProperty("edgePath"));
			driver = new EdgeDriver();
		}else {
			System.err.println(prop.getProperty("notSupportedBrowser"));
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Long.valueOf(prop.
				getProperty("pageLoadTimeout"))));
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.valueOf(prop.
				getProperty("implicitWaitDuration"))));
	}
	
	public void tearDown() {
		driver.close();
	}

}
