package components;

import webx.Aside;
import webx.Footer;
import webx.WebXContainerElement;
import webx.P;
import java.util.Calendar;

/**
 *
 * @author hexaredecimal
 */
public class FooterComponent extends WebXContainerElement {

	@Override
	public String render() {
		int year = Calendar.getInstance().get(Calendar.YEAR);

		return new Footer()
			.className("footer footer-center bg-base-300 text-base-content p-4")
			.addChild(
				new Aside()
					.addChild(
						new P(String.format("Copyright &copy; %d BlazingWebx - Hexarevision - Built 100%% in BlazingWebx", year))
					)
			)
			.render();
	}
}
