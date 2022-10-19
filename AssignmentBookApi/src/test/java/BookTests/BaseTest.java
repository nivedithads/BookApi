package BookTests;

import java.io.IOException;
import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v106.network.Network;



import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;




public class BaseTest {
	private static String res;

	public static String getRes() {
		return res;
	}

	public static void setRes(String res) {
		BaseTest.res = res;
	}

	
	public JsonNode jsonNodeofUrl() throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\183599\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonode;
		DevTools devTools = driver.getDevTools();
		devTools.createSession();

		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

		devTools.addListener(Network.responseReceived(), entry -> {
			if (getRes() == null) {
				setRes(devTools.send(Network.getResponseBody(entry.getRequestId())).getBody().toString());


				
			}

		});
		 //driver.get("https://www.googleapis.com/books/v1/volumes?q=shakespeare");
		driver.get("https://www.googleapis.com/books/v1/volumes/nKdJDwAAQBAJ");
		
		Thread.sleep(100);
		 jsonode= getRes() != null?mapper.readTree(getRes()):null;
		
		return jsonode;

	}
	
}
