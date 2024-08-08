package components;

import genz.Aside;
import genz.Footer;
import genz.GenZContainerElement;
import genz.P;
import java.util.Calendar;

/**
 *
 * @author hexaredecimal
 */
public class FooterComponent extends GenZContainerElement {
	
	@Override
	public String render() {
		int year = Calendar.getInstance().get(Calendar.YEAR); 
		
		return new Footer()
			.className("footer footer-center bg-base-300 text-base-content p-4")
			.addChild(
				new Aside()
					.addChild(
						new P(String.format("Copyright %d © JediGenZ - Hexarevision - Built 100%% in JediGenZ", year))
					)
			)
			.render();
	}
}
