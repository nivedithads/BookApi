package Book.values;

import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;

public class SelfLink {
	JsonNode js;

	public SelfLink(JsonNode json) {

		this.js = json;
	}

	public String selfLinkData() throws IOException {

		String selfLink = js.get("selfLink").asText().toString();
		return selfLink;

	}
}
