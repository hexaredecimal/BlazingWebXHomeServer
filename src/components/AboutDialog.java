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
			.addChild(
				new Button("X")
					.className("btn btn-sm btn-circle btn-ghost absolute right-2 top-2")
			);

		return new Dialog()
			.id("about_modal")
			.className("modal")
			.addChildren(
				new Div()
					.className("modal-box")
					.addChildren(
						close_btn,
						new H3("About BlazingWebx")
							.className("p-5 text-2xl text-bold"),
						new P("BlazingWebx ... ")
							.className("p-5"),
						new P("Created by: ")
							.className("p-5")
							.addChild(
								new A("Gama Sibusiso")
									.href("https://github.com/hexaredecimal")
									.className("text-blue-500")
									.attr("title", "Gama Sibusiso")
							),
						new P("Purpose: Simplify the creation of Single Page Applications using java without any external dependencies.")
							.className("p-5"),
						new P("Repository: ")
							.className("p-5")
							.addChild(
								new A("BlazingWebx")
									.href("https://github.com/hexaredecimal/BlazingWebX/")
									.attr("title", "BlazingWebX")
                  .className("text-blue-500")
							)
					),
				new Form()
					.attr("method", "dialog")
					.className("modal-backdrop")
					.addChild(
						new Button("close")
					)
			)
			.render();
	}
}
