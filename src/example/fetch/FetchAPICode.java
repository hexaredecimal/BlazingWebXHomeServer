package example.fetch;

/**
 *
 * @author hexaredecimal
 */
public class FetchAPICode {
	public static String html() {
		return 
"""
<!DOCTYPE html>
<html>
  <head>
    <title>Randomizer</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
		<script type="text/javascript" src="/js/request.js"></script>
  </head>
  <body>
    <div>
			<label>Start</label>
			<input type="number" min="0" id="start"/>
			<label>End</label>
			<input type="number" min="1" id="end"/>
			<button onclick="fetchData()">Get Random number</button>
			<br><!-- comment -->
			<p id="result"></p>
		</div>
  </body>
</html>
"""			
		;
	}
	public static String js() {
		return 
"""
const fetchData = () => {
	const url = '/v1/api/random'; // Replace with your API endpoint
	const data = new URLSearchParams();
	data.append('start', start.value);
	data.append('end', end.value);

	fetch(url, {
		method: 'POST', // Use POST method
		headers: {
			'Content-Type': 'application/json', // Set the content type to JSON
		},
		body: data.toString() // Convert the data to a JSON string
	})
	.then(response => response.json()) // Convert the response to JSON
	.then(data => {
		let _start = start.value; 
		let _end = end.value;
		let value = data.value; 
		result.innerText = `Random number between ${_start} and ${_end} is ${value}`;
	})
	.catch(error => {
		console.error('Error:', error); // Handle errors
	});
}
""";
	}
	public static String entry() {
		return 
"""
		Blazing.createServer(APIServer.class); // Replace APIServer with the class name you chose
""";
	}
	public static String server() {
		return 
"""
import blazing.BlazingResponse;
import blazing.Post;
import blazing.Route;
import blazing.Static;
import blazing.WebServer;
import blazing.fs.FileSystem;
import blazing.json.JSon;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


@WebServer
@Static("/js")
public class APIServer {

	@Route
	public static void home(BlazingResponse response) {
		var page = FileSystem.readFileToString("index.html").unwrap();
		response.sendResponse(page);
	}
	
	@Post("/v1/api/random")
	public static void getRandom(BlazingResponse response) {
		var params = response.params();

		String start = params.get("start");
		String end = params.get("end"); 

		Map<String, Object> result = new HashMap<>();
		
		if (start == null) {
			result.put("status", "err");
			result.put("message", "Start is not defined");
			response.sendResponse(JSon.from(result).unwrap());
			return;
		}

		if (end == null) {
			result.put("status", "err");
			result.put("message", "End is not defined");
			response.sendResponse(JSon.from(result).unwrap());
			return;
		} 

		double _start = Double.parseDouble(start);
		double _end = Double.parseDouble(end);
		Random rnd = new Random(); 
		double random = rnd.nextDouble(_start, _end);
		result.put("status", "ok");
		result.put("value", random); 
		response.sendResponse(JSon.from(result).unwrap());
	}
}

""";
	}
}

