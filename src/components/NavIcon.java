package components;

import webx.Div;
import webx.WebXContainerElement;
import webx.Path;
import webx.Svg;

/**
 *
 * @author hexaredecimal
 */
public class NavIcon extends WebXContainerElement {

	@Override
	public String render() {
		return new Div()
			.attr("tabindex", "0")
			.attr("role", "button")
			.className("btn btn-ghost btn-circle")
			.add(
				new Svg()
					.attr("xmlns", "http://www.w3.org/2000/svg")
					.attr("fill", "none")
					.attr("viewBox", "0 0 24 24")
					.attr("stroke", "currentColor")
					.className("h-5 w-5")
					.add(
						new Path()
							.attr("stroke-linecap", "round")
							.attr("stroke-linejoin", "round")
							.attr("stroke-width", "2")
							.attr("d", "M4 6h16M4 12h16M4 18h7")
					)
			)
			.render();
	}
}
