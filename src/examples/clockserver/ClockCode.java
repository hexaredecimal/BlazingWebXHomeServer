package examples.clockserver;

/**
 *
 * @author ERC
 */
public class ClockCode {

	public static String mainMethodBody() {
		return """
public static void main(String[] args) {
  Blazing.createServer(ClockServer.class); // Use your class name if you did not name it as in the example      
}
      """;
	}

	public static String serverClassCode() {
		return """
@WebServer("6900")
class ClockServer {
  @Get("/")
  public static void homepage(BlazingResponse response) {
    var page = new Html()
       .addChild(new P("hello, world"));
    response.sendUiRespose(page);    
  }      
}
      """;
	}

	public static String serverClockUsage() {
		return """
@WebServer
class ClockServer {
  @Get("/")
  public static void homepage(BlazingResponse response) {
    var page = new Html()
       .addChild(new ClockComponent());
    response.sendUiRespose(page);    
  }      
}
      """;
	}

	public static String serverClockResponses() {
		return """
@WebServer
class ClockServer {
  @Get("/")
  public static void homepage(BlazingResponse response) {
    var page = new Html()
      .addChild(new ClockComponent());
    response.sendUiRespose(page);    
  }      
            
  @Route("/hour")
  public static void hour(BlazingRespose reponse) {
    int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
    response.sendResponse(String.format("%d", hour)); // 
  } 
}     
      """;
	}

	public static String serverClockComponent() {
		return """
package components;

import webx.Br;
import webx.Div;
import webx.GenZElement;
import webx.H1;
import webx.Html;
import webx.P;
import java.util.Calendar;

public class ClockComponent extends WebXElement {
	private int hour;
	private int minute;
	private int second;
	private String amPm;

	@Override
	public String render() {
		hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		minute = Calendar.getInstance().get(Calendar.MINUTE);
		second = Calendar.getInstance().get(Calendar.SECOND);

		var _hour = hour < 10 ? "0" + hour : String.valueOf(hour);
		var _minute = minute < 10 ? "0" + minute : String.valueOf(minute);
		var _second = second < 10 ? "0" + second : String.valueOf(second);

		if (hour >= 0 && hour < 12) {
			amPm = "AM";
		} else {
			amPm = "PM";
		}

		return new Div()
			.addChildren(
				new P(_hour)
					.hxTrigger("every 1s")
					.hxGet("/hour"),
				new P(":"),
				new P(_minute)
					.hxTrigger("every 1s")
					.hxGet("/minute"),
				new P(":"),
				new P(_second)
					.hxTrigger("every 1s")
					.hxGet("/second"),
				new P(amPm)
					.hxTrigger("every 1s")
					.hxGet("/ampm")
			)
			.className("flex flex-row text-lx")
			.render();
	}
}
      """;
	}

}
