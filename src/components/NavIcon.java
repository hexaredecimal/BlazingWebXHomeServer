package components;

import genz.Div;
import genz.GenZContainerElement;
import genz.Path;
import genz.Svg;

/**
 *
 * @author hexaredecimal
 */
public class NavIcon extends GenZContainerElement {
	@Override
	public String render() {
		return new Div()
			.attr("tabindex", "0")
			.attr("role", "button")
			.className("btn btn-ghost btn-circle")
			.addChild(
				new Svg()
					.attr("xmlns", "http://www.w3.org/2000/svg")
					.attr("fill", "none")
					.attr("viewBox", "0 0 24 24")
					.attr("stroke", "currentColor")
					.className("h-5 w-5")
					.addChild(
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
