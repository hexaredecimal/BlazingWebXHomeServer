package components;

import genz.Button;
import genz.Div;
import genz.GenZContainerElement;
import genz.H1;
import genz.P;

/**
 *
 * @author hexaredecimal
 */
public class Hero extends GenZContainerElement {
	
	@Override
	public String render() {
		return new Div()
					.className("hero min-h-screen")
					.attr("style", "background-image: url(https://img.daisyui.com/images/stock/photo-1507358522600-9f71e620c44e.webp);")
					.addChildren(
						new Div()
							.className("hero-overlay bg-opacity-60"),
						new Div()
							.className("hero-content text-neutral-content text-center")
							.addChild(
								new Div()
									.className("max-w-md")
									.addChildren(
										new H1("Hello, there")
											.className("mb-5 text-5xl font-bold"), 
										new P("Creating web application in 100% Java! Build fast, ship fast")
											.className("mb-5"),
										new Button("Get Started")
											.className("btn btn-primary")
									)
							)
					)
					.render();
	}
}
