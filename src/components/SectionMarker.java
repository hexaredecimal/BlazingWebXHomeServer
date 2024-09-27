package components;

import webx.Div;
import webx.WebXContainerElement;
import webx.H3;

/**
 *
 * @author hexaredecimal
 */
public class SectionMarker extends WebXContainerElement {

	private String label;

	public SectionMarker(String label) {
		this.label = label;
	}

	@Override
	public String render() {
		return new Div()
			.attr(
				"style",
				"background-image: url(images/newtiny.jpg);")
			.addChildren(
				new H3(this.label)
			)
			.className("p-5 w-full h-30")
			.render();
	}
}
