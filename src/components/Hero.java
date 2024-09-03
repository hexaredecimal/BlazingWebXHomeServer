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
				"background-image: url(images/cool.jpg);")
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
								new Button("Get Started")
									.hxGet("/download")
									.hxSwap("outerHTML")
									.hxTarget("#main")
									.className("btn btn-primary")
							)
					)
			)
			.render();
	}
}
