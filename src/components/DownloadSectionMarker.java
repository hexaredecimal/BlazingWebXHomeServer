/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import webx.Div;
import webx.WebXContainerElement;
import webx.H3;

/**
 *
 * @author hexaredecimal
 */
public class DownloadSectionMarker extends WebXContainerElement {
	private String label; 

	public DownloadSectionMarker(String label) {
		this.label = label; 
	}
	
	@Override
	public String render() {
		return 
				new Div()
					.attr(
						"style", 
						"background-image: url(https://assets.entrepreneur.com/content/3x2/2000/1631038470-Ent-JavaProgramming.jpg?format=pjeg&auto=webp&crop=16:9&width=675&height=380);")
					.addChildren(
						new H3(this.label)
					)
					.className("hero p-5 w-full h-30")
					.render();
	}
}
