package Book.values;

import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;

public class Id {
	JsonNode js;

	public Id(JsonNode json) {

		this.js = json;
	}

	public String idData() throws IOException {

		String id = js.get("id").asText().toString();
		return id;

	}
}
