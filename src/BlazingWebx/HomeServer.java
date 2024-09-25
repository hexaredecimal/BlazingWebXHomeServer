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
import examples.clockserver.ClockCode;
import webx.A;
import webx.H1;
import webx.Input;
import webx.Main;
import webx.Meta;

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
			.addHeaderChildren(
				new Meta()
					.attr("property", "og:type")
					.attr("content", "website"),
				new Meta()
					.attr("property", "og:title")
					.attr("content", "BlazingWebx"),
				new Meta()
					.attr("property", "og:description")
					.attr("content", "A Java library for simplifying the creation of web applications"),
				new Meta()
					.attr("property", "og:image")
					.attr("content", "/images/new.jpg"),
				new Meta()
					.attr("property", "og:url")
					.attr("content", "https://blazingwebx.onrender.com/"),
				new Meta()
					.attr("name", "description")
					.attr("content", "A java library for simplifying the creationg of Web applications"),
				new Meta()
					.attr("name", "keywords")
					.attr("content", "Java, WebApp, WebApplication, SPA, HTMX, Blazing"),
				new Meta()
					.attr("name", "author")
					.attr("content", "Gama Sibusiso"),
				new Meta()
					.attr("charset", "UTF-8")
			)
      .addHeaderStyleLink("https://cdn.jsdelivr.net/npm/daisyui@4.12.10/dist/full.min.css")
      .addHeaderStyleLink("https://cdn.jsdelivr.net/gh/devicons/devicon@latest/devicon.min.css")
      .addHeaderScript("https://cdn.tailwindcss.com")
      .favicon("/images/newtiny.jpg")
      .title("BlazingWebx - Simplifying Java Web Application Development")
      .attr("data-theme", "dracula")
      .addChild(new NavigationBar())
      .addChildren(
        new AboutDialog(),
        new Main()
          .id("main")
          .addChildren(
            new Hero(),
            new Div()
              .className("flex w-full p-5 flex-col md:flex-row")
              .addChildren(
                new Div()
                  .className("card bg-base-300 flex-grow ")
                  .addChild(
                    new CodeBlock(code)
                  ),
                new Div()
                  .className("divider md:divider-horizontal"),
                new Div()
                  .className("card bg-base-300 flex-grow p-10")
                  .addChildren(
                    new H2("Why another library?")
                      .className("text-3xl"),
                    new P(intro)
                      .className("py-6 text-xl")
                  )
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

    var page = new Main()
      .id("main")
      .addChildren(
        new NavigationBar(),
        new Div()
          .className("w-full h-20"),
        new Div()
          .addChildren(
            new H3("BlazingWebx | 100% Java WebApps | Lets Go")
              .className("p-5 text-center items-center")
          ),
        new DownloadSectionMarker("Download"),
        new Div()
          .className("p-5")
          .addChildren(
            new Div()
              .attr("tabindex", "0")
              .className("collapse collapse-plus border-base-300 bg-base-200 border")
              .addChildren(
								new Input()
									.attr("type", "checkbox"),
                new P("Latest")
                  .className("collapse-title text-xl font-medium"),
                new Div()
                  .className("p-2 collapse-content")
                  .addChildren(
                    new P("Previous versions can be obtained from the release page on github. ")
                      .className("p-2"),
                    new P("Building from source is recommended for users who want to use the experimenat version. Note that the experimental features may be removed. ")
                      .className("p-2"),
                    new A("Download")
                      .href("https://github.com/hexaredecimal/BlazingWebX/releases")
                      .className("btn btn-neutral"),
                    new P("Or click ")
                      .addChild(
                        new A("here")
                          .href("https://github.com/hexaredecimal/BlazingWebX/releases")
													.className("text-blue-500")
                      )
                      .className("p-5 text-light")
                  )
              )
          ),
        new DownloadSectionMarker("Note"),
        new Div()
          .addChildren(
            new H3("Note: By default BlazingWebx uses Ant as the build system and assumes you also do. If you are following then"
              + " Add the following code to your build.xml file")
              .className("p-5"),
            new CodeBlock(codeSnippet),
            new H3("This will allow you to build fat jar files for your applications. This makes application deployment simple.")
              .className("p-5")
          )
          .className("p-5 border-base-300 bg-base-200 border")
      );

    response.sendUiRespose(page);
  }

  @Get("/examples")
  public static void example(BlazingResponse response) {
    var page = new Main()
      .id("main")
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
          .id("examples")
          .addChildren(
            new A("Server Side Digital Clock")
              .className("px-5 py-10 text-xl")
              .hxGet("/clock-example")
              .hxTarget("#examples")
              .hxSwap("outerHTML")
          )
      );

    response.sendUiRespose(page);
  }

  @Get("/clock-example")
  public static void clock_example(BlazingResponse response) {

    var page = new Div()
      .id("examples")
      .addChildren(
        new P("Server Side Digital Clock Using BlazingWebX")
          .className("p-10 text-2xl text-center border-b-white"),
        new P("This is a an example of how to use BlazingWebX to create a simple server side clock application 100% in java")
          .className("p-5 text-lg"),
        new SectionMarker("Project Setup"),
        new P("Create a new java project in your favourite IDE or Text Editor. This example is based on Netbeans")
          .className("p-2"),
        new P("NetBeans > New Project > Java with Ant")
          .className("p-2"),
        new P("Give your project any name and click on Finish")
          .className("p-2"),
        new SectionMarker("Implementation"),
        new P("Add a new class aside the one Netbeans created for you and name it ClockServer or whatever name your like")
          .className("p-2"),
        new P("Open the class containing your main method and type the following inside the main method")
          .className("p-2"),
        new CodeBlock(ClockCode.mainMethodBody()),
        new P("The code above registers the class <b>ClockServer</b> as a WebServer class")
          .className("p-2"),
        new P("Add the following to the server class")
          .className("p-2"),
        new CodeBlock(ClockCode.serverClassCode()),
        new P("The code above defines the class <b>ClockSever</b> and implements a Get request route to the path at `/`")
          .className("p-2"),
        new P("Add a new class called ClockComponent and add the following")
          .className("p-2"),
        new CodeBlock(ClockCode.serverClockComponent()), 
        new P("The class above represents a digital clock component that sends Get requests to `/hour`, `/minute` `/second` and `/ampm` every 1 second ")
          .className("p-2"), 
        new P("To use the component you just created remove the Paragraph with `Hello, world` and add the following")
          .className("p-2"), 
        new CodeBlock(ClockCode.serverClockUsage()), 
        new P("Very straight forward. Now since it sends requests every second it needs to have responses. For excersise I will implement one method and you can try the rest")
          .className("p-2"), 
        new P("To respond to the incoming requests add the following code")
          .className("p-2"), 
        new CodeBlock(ClockCode.serverClockResponses()), 
        new P("The response will replace the innerHTML of the element that made the request. In this case we are simply updating the hour")
          .className("p-2"), 
        new SectionMarker("Running"),
        new P("Assumming there are no error, you can run the project and visit http://localhost:6900, you clock should be live")
          .className("p-5 text-lg"), 
        new P("Note that when you stop the server the clock also stops updating. To visualise what I am saying open the networking tab in your browser")
          .className("p-5 text-lg"), 
        new H1("Going beyong this example")
          .className("p-5 text-lg"), 
        new P("You can style the clock they way you want using your favourite css library or your own css scripts. More on those later")
          .className("p-5 text-lg"), 
        new SectionMarker("Deployment"),
        new P("The clock server example is available for live preview at: ")
          .addChild(
            new A("https://clock-sd1x.onrender.com")
              .href("https://clock-sd1x.onrender.com")
							.className("text-blue-500")
          )
          .className("p-5 text-lg")
      );

    response.sendUiRespose(page);
  }
}
