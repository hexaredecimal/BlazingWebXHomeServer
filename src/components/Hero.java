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
				"background-image: url(images/new.jpg);")
			.add(
				new Div()
					.className("hero-overlay bg-opacity-60"),
				new Div()
					.className("hero-content text-neutral-content text-center")
					.add(
						new Div()
							.className("max-w-md")
							.add(
								new H1("BlazingWebx")
									.className("mb-5 text-5xl font-bold"),
								new P("Pure Java, Pure Speed. Code with fire, deliver with lightning.")
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
