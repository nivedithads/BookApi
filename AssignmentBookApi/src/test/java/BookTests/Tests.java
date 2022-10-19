package BookTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonNode;


import Book.values.Id;
import Book.values.SelfLink;



public class Tests extends BaseTest {

	@Test
	public void selfLinkValidationTest() throws IOException, InterruptedException {
		JsonNode js=jsonNodeofUrl();
		
		SelfLink selfLink=new SelfLink(js);
		String selfLinkValue=selfLink.selfLinkData().toString();
		System.out.println(selfLinkValue);
		Assert.assertEquals(selfLinkValue, "https://www.googleapis.com/books/v1/volumes/nKdJDwAAQBAJ");
		
	}	
	
	
	@Test
	public void idValidationTest() throws IOException, InterruptedException {
		JsonNode js=jsonNodeofUrl();
		
		Id id=new Id(js);
		String idValue=id.idData().toString();
		System.out.println(idValue);
		Assert.assertEquals(idValue, "nKdJDwAAQBAJ");
			
		}
	
}
/*@Test
	public void eTagValidationTest() throws IOException, InterruptedException {
		JsonNode js=jsonNodeofUrl();
		
		Etag publisher =new Etag (js);
		String publisherValue=publisher.publisherData().toString();
		System.out.println(publisherValue);
		Assert.assertEquals(publisherValue, "BOOK");
			
		}
	
	
	}*/
