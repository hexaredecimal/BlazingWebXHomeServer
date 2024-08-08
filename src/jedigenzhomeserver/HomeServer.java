package jedigenzhomeserver;

import components.*;
import jedi.*;
import genz.*;

/**
 *
 * @author hexaredecimal
 */
@WebServer("6900")
public class HomeServer {

	@Route
	public static void home(JediResponse response) {

		String intro
			= """
JediGenZ is a cutting-edge HTML UI creation library for Java designed to bridge the gap between traditional desktop Java applications and modern web interfaces. In an era where web applications dominate, Java developers often face the challenge of translating complex desktop UIs into intuitive, responsive web designs. JediGenZ solves this problem by providing a seamless, programmatic approach to generating HTML directly from Java code. With JediGenZ, developers can leverage the full power of Java while effortlessly crafting dynamic, interactive web interfaces, eliminating the need to juggle between multiple languages or frameworks. This library streamlines the development process, making it easier than ever to build robust, scalable web applications without sacrificing the flexibility and familiarity of Java.
""";
		String code
			= """
@WebServer("6900")
public class YourServer {
	@Route("/")
	public static void home(JediResponse response) {
		
		response.sendUiResponse(
			new Html()
				.addChild(
					new H1("Hello, from JediGenZ :)")
				)
		);
	}
}
""";

		var page = new Html()
			.addHeaderStyleLink("https://cdn.jsdelivr.net/npm/daisyui@4.12.10/dist/full.min.css")
			.addHeaderStyleLink("https://cdn.jsdelivr.net/gh/devicons/devicon@latest/devicon.min.css")
			.addHeaderScript("https://cdn.tailwindcss.com")
			.addChild(new NavigationBar())
			.addChildren(
				new Hero(),
				new Div()
					.className("flex w-full p-5")
					.addChildren(
						new Div()
							.className("card bg-base-300 flex-grow ")
							.addChild(
								new CodeBlock(code)
							),
						new Div()
							.className("divider divider-horizontal"),
						new Div()
							.className("card bg-base-300 flex-grow p-10")
							.addChildren(
								new H2("Why another library"),
								new P(intro)
									.className("py-6")
							)
					),
				new FooterComponent()
			);

		response.sendUiRespose(page);
	}
	/*
	
	 */
}
