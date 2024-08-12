package components;

import webx.Div;
import webx.WebXContainerElement;
import webx.Pre;

/**
 *
 * @author hexaredecimal
 */
public class CodeBlock extends WebXContainerElement {

	private String text;

	public CodeBlock(String text) {
		this.text = text
			.replaceAll("<", "&lt;")
			.replaceAll(">", "&gt;");
	}

	@Override
	public String render() {
		var block = new Div()
			.className("mockup-code text-xs");
		var lines = this.text.split("\n");

		for (int i = 0; i < lines.length; i++) {
			String line = lines[i];
			block
				.addChild(
					new Pre(line)
						.attr("data-prefix", String.valueOf(i + 1))
				);
		}

		return block.render();
	}
}
