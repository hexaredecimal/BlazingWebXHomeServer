package components;

import genz.A;
import genz.Button;
import genz.Div;
import genz.GenZContainerElement;
import genz.Li;
import genz.Ul;

/**
 *
 * @author hexaredecimal
 */
public class NavigationBar extends GenZContainerElement {
	@Override
	public String render() {
		String[] navs = {"Download", "Examples", "Documentation", "About"}; 
		var dropdown = new Div()
			.className("dropdown");

		var ul = new Ul()
			.attr("tabindex", "0")
			.className("menu menu-sm dropdown-content bg-base-100 rounded-box z-[1] mt-3 w-52 p-2 shadow");
		
		dropdown
			.addChild(new NavIcon())
			.addChild(ul);
		
		for (String nav: navs) {
			ul
				.addChild(
					new Li()
						.addChild(new A(nav))
				);
		}

		var nav_start = new Div()
			.className("navbar-start")
			.addChild(dropdown);

		var nav_center = new Div()
			.className("navbar-center")
			.addChildren(
				new A("JediGenZ")
					.href("/")
					.className("btn btn-ghost text-xl")
			);

		var nav_end = new Div()
			.className("navbar-end")
			.addChildren(
				new Button()
					.className("btn btn-ghost btn-circle")
					.addChild(new GithubIcon())
			);
		
		return new Div()
			.className("fixed navbar bg-base-100 z-10")
			.addChildren(
				nav_start, 
				nav_center,
				nav_end
			)
			.render();
	}
}
