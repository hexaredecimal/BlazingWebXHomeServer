package components;

import webx.A;
import webx.WebXElement;
import webx.I;

/**
 *
 * @author hexaredecimal
 */
public class GithubIcon extends WebXElement {

	@Override
	public String render() {
		return new A()
			.href("https://github.com/hexaredecimal/BlazingWebX")
			.attr("title", "BlazingWebX")
			.add(
				new I()
					.className("devicon-github-original-wordmark text-2xl")
			)
			.render();
	}
}
