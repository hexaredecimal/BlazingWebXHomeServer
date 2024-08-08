package jedigenzhomeserver;

import jedi.Jedi; 

/**
 *
 * @author hexaredecimal
 */
public class Application {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		Jedi.createServer(HomeServer.class);
	}
}
