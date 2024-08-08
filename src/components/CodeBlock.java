package components;

import genz.Div;
import genz.GenZContainerElement;
import genz.Pre;

/**
 *
 * @author hexaredecimal
 */
public class CodeBlock extends GenZContainerElement {

	private String text;

	public CodeBlock(String text) {
		this.text = text;
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
