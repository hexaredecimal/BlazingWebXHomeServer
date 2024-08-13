package BlazingWebx;

import blazing.BlazingResponse;
import blazing.Get;
import blazing.Initializer;
import blazing.Post;
import blazing.WebServer;
import blazing.Route;
import blazing.Static;
import blazing.fs.FileSystem;
import webx.Button;
import webx.Div;
import webx.P;
import webx.H2;
import webx.H3;
import webx.Html;
import components.*;

/**
 *
 * @author hexaredecimal
 */
@WebServer
@Static("/javadoc")
@Static("/images")
public class HomeServer {
	
	@Route
	public static void home(BlazingResponse response) {

		String intro
			= """
BlazingWebx is a cutting-edge HTML UI creation library for Java designed to bridge 
the gap between traditional desktop Java applications and modern web interfaces. 
In an era where web applications dominate, Java developers often face the 
challenge of translating complex desktop UIs into intuitive, responsive web 
designs. BlazingWebx solves this problem by providing a seamless, programmatic 
approach to generating HTML directly from Java code. With BlazingWebx, developers 
 can leverage the full power of Java while effortlessly crafting dynamic, 
interactive web interfaces, eliminating the need to juggle between multiple 
languages or frameworks. This library streamlines the development process, 
making it easier than ever to build robust, scalable web applications without 
sacrificing the flexibility and familiarity of Java.
""";
		String code
			= """
@WebServer("6900")
public class YourServer {
	@Route("/")
	public static void home(BlazingResponse respose) {
		response.sendUiResponse(
			new Html()
				.addChild(
					new H1("Hello, from BlazingWebx :)")
				)
		);
	}
}
""";

		var page = new Html()
			.addHeaderStyleLink("https://cdn.jsdelivr.net/npm/daisyui@4.12.10/dist/full.min.css")
			.addHeaderStyleLink("https://cdn.jsdelivr.net/gh/devicons/devicon@latest/devicon.min.css")
			.addHeaderScript("https://cdn.tailwindcss.com")
			.title("BlazingWebx | Home")
			.addChild(new NavigationBar())
			.addChildren(
				new Hero(),
				new Div()
					.className("flex w-full p-5")
					.addChildren(
						new Div()
							.className("card bg-base-300 flex-grow ")
							.addChild(
								new CodeBlock(code)
							),
						new Div()
							.className("divider divider-horizontal"),
						new Div()
							.className("card bg-base-300 flex-grow p-10")
							.addChildren(
								new H2("Why another library?")
									.className("text-3xl"),
								new P(intro)
									.className("py-6 text-xl")
							)
					),
				new FooterComponent()
			);

		response.sendUiRespose(page);
	}

	@Get("/download")
	public static void downloads(BlazingResponse response) {
		String codeSnippet
			= """
    <target name="-post-jar">
        <echo message="Building standalone jar file: ${dist.dir}/yourserver-dist.jar"/>
        <jar destfile="${dist.dir}/yourserver-tmp-fat.jar" filesetmanifest="skip">
            <zipgroupfileset dir="${dist.dir}"  includes="*.jar*"/>
            <zipgroupfileset dir="${dist.dir}/lib"  includes="*.jar*"/>
            <manifest>
                <attribute name="Main-Class" value="yourserver.MainClass" />
            </manifest>
        </jar>
        <zip destfile="${dist.dir}/yourserver-dist.jar">
            <zipfileset src="${dist.dir}/yourserver-tmp-fat.jar" 
                excludes="META-INF/*.SF, META-INF/*.DSA, META-INF/*.RSA"/>
        </zip>
        <delete file="${dist.dir}/yourserver-tmp-fat.jar" />
    </target>
""";

		var page = new Html()
			.addHeaderStyleLink("https://cdn.jsdelivr.net/npm/daisyui@4.12.10/dist/full.min.css")
			.addHeaderStyleLink("https://cdn.jsdelivr.net/gh/devicons/devicon@latest/devicon.min.css")
			.addHeaderScript("https://cdn.tailwindcss.com")
			.title("BlazingWebx | Download")
			.addChildren(
				new NavigationBar(),
				new Div()
					.className("w-full h-20"),
				new Div()
					.addChildren(
						new H3("BlazingWebx | 100% Java WebApps | Lets Go")
							.className("p-5 text-center items-center")
					),
				new DownloadSectionMarker("Latest Version"),
				new Div()
					.className("p-5")
					.addChildren(
						new Div()
							.attr("tabindex", "0")
							.className("collapse collapse-plus border-base-300 bg-base-200 border")
							.addChildren(
								new P("Version 0.0.1")
									.className("collapse-title text-xl font-medium"),
								new Div()
									.className("p-2 collapse-content")
									.addChild(
										new Button("Download")
											.className("btn btn-neutral")
									)
							)
					),
				new DownloadSectionMarker("Previous versions"),
				new Div()
					.className("p-5")
					.addChildren(
						new Div()
							.attr("tabindex", "0")
							.className("collapse collapse-plus border-base-300 bg-base-200 border")
							.addChildren(
								new P("Version 0.0.1")
									.className("collapse-title text-xl font-medium"),
								new Div()
									.className("p-2 collapse-content")
									.addChild(
										new Button("Download")
											.className("btn btn-neutral")
									)
							)
					),
				new Div()
					.addChildren(
						new H3("Note: By default BlazingWebx uses Ant as the build system and assumes you also do. If you are following then"
							+ " Add the following code to your build.xml file")
							.className("p-5"),
						new CodeBlock(codeSnippet),
						new H3("This will allow you to build fat jar files for your applications. This makes application deployment simple.")
							.className("p-5")
					)
					.className("p-5 border-base-300 bg-base-200 border"),
				new FooterComponent()
			);

		response.sendUiRespose(page);
	}

	@Get("/examples")
	public static void example(BlazingResponse response) {
		var page = new Html()
			.addHeaderStyleLink("https://cdn.jsdelivr.net/npm/daisyui@4.12.10/dist/full.min.css")
			.addHeaderStyleLink("https://cdn.jsdelivr.net/gh/devicons/devicon@latest/devicon.min.css")
			.addHeaderScript("https://cdn.tailwindcss.com")
			.title("BlazingWebx | Examples")
			.addChildren(
				new NavigationBar(),
				new Div()
					.className("w-full h-20"),
				new Div()
					.addChildren(
						new H3("BlazingWebx | 100% Java WebApps | Lets Go")
							.className("p-5 text-center items-center")
					),
				new DownloadSectionMarker("Examples"),
				new Div()
					.addChildren(
						new P("Coming soon")
							.className("text-center text-3xl")
					)
			);

		response.sendUiRespose(page);
		
	}
}
