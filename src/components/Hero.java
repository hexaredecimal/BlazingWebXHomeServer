package components;

import webx.A;
import webx.Button;
import webx.Div;
import webx.WebXContainerElement;
import webx.H1;
import webx.P;

/**
 *
 * @author hexaredecimal
 */
public class Hero extends WebXContainerElement {
	
	@Override
	public String render() {
		return new Div()
					.className("hero min-h-screen")
					.attr(
						"style", 
						"background-image: url(https://assets.entrepreneur.com/content/3x2/2000/1631038470-Ent-JavaProgramming.jpg?format=pjeg&auto=webp&crop=16:9&width=675&height=380);")
					.addChildren(
						new Div()
							.className("hero-overlay bg-opacity-60"),
						new Div()
							.className("hero-content text-neutral-content text-center")
							.addChild(
								new Div()
									.className("max-w-md")
									.addChildren(
										new H1("BlazingWebx")
											.className("mb-5 text-5xl font-bold"), 
										new P("Create your next web application 100% in Java! Build fast, ship fast")
											.className("mb-5"),
										new A("Get Started")
											.href("/download")
											.className("btn btn-primary")
									)
							)
					)
					.render();
	}
}
