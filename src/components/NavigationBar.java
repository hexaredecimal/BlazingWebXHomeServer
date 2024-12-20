package components;

import webx.A;
import webx.Button;
import webx.Div;
import webx.WebXContainerElement;
import webx.Li;
import webx.Ul;
import webx.WebXElement;

/**
 *
 * @author hexaredecimal
 */
public class NavigationBar extends WebXContainerElement {

	@Override
	public String render() {
		String[] navs = {"Download", "Examples", "Documentation", "About"};
		var dropdown = new Div()
			.className("dropdown");

		var ul = new Ul()
			.attr("tabindex", "0")
			.className("menu menu-sm dropdown-content bg-base-100 rounded-box z-[1] mt-3 w-52 p-2 shadow");

		dropdown
			.add(new NavIcon())
			.add(ul);

		for (String nav : navs) {
			String url = String.format("/%s", nav.toLowerCase());
			WebXElement child = new Button(nav)
				.hxGet(url)
				.hxSwap("outerHTML")
				.hxTarget("#main")
				.attr("title", url);

			if (nav.equals("Documentation")) {
				url = "/javadoc/index.html";
				child = new A(nav)
					.href(url)
					.attr("title", "Documentation");
			} else if (nav.equals("About")) {
				child = new Button(nav)
					.attr("onclick", "about_modal.showModal();");
			}

			ul
				.add(
					new Li()
						.add(
							child
						)
				);
		}

		var nav_start = new Div()
			.className("navbar-start")
			.add(dropdown);

		var nav_center = new Div()
			.className("navbar-center")
			.add(
				new A("BlazingWebX")
					.href("/")
					.className("btn btn-ghost text-xl")
			);

		var nav_end = new Div()
			.className("navbar-end")
			.add(
				new Button()
					.className("btn btn-ghost btn-circle")
					.add(new GithubIcon()),
				new ThemeSwitcher()
			);

		return new Div()
			.className("fixed navbar bg-base-100 z-10")
			.add(
				nav_start,
				nav_center,
				nav_end
			)
			.render();
	}
}
