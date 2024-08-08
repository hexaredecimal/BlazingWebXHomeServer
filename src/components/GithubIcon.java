package components;

import genz.GenZElement;
import genz.I;

/**
 *
 * @author hexaredecimal
 */
public class GithubIcon extends GenZElement {
	@Override
	public String render() {
		return new I()
			.className("devicon-github-original-wordmark text-2xl")
			.render();
	}
}
