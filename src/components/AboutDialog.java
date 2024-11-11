package components;

import webx.A;
import webx.Button;
import webx.Dialog;
import webx.Div;
import webx.Form;
import webx.H3;
import webx.P;
import webx.WebXContainerElement;

/**
 *
 * @author hexaredecimal
 */
public class AboutDialog extends WebXContainerElement {

	@Override
	public String render() {

		var close_btn = new Form()
			.attr("method", "dialog")
			.add(
				new Button("X")
					.className("btn btn-sm btn-circle btn-ghost absolute right-2 top-2")
			);

		return new Dialog()
			.id("about_modal")
			.className("modal")
			.add(
				new Div()
					.className("modal-box")
					.add(
						close_btn,
						new H3("About BlazingWebx")
							.className("p-5 text-2xl text-bold"),
						new P("BlazingWebx ... ")
							.className("p-5"),
						new P("Created by: ")
							.className("p-5")
							.add(
								new A("Gama Sibusiso")
									.href("https://github.com/hexaredecimal")
									.className("text-blue-500")
									.attr("title", "Gama Sibusiso")
							),
						new P("Purpose: Simplify the creation of Single Page Applications using java without any external dependencies.")
							.className("p-5"),
						new P("Repository: ")
							.className("p-5")
							.add(
								new A("BlazingWebx")
									.href("https://github.com/hexaredecimal/BlazingWebX/")
									.className("text-blue-500")
									.attr("title", "BlazingWebX")
							)
					),
				new Form()
					.attr("method", "dialog")
					.className("modal-backdrop")
					.add(
						new Button("close")
					)
			)
			.render();
	}
}
