package com.giffing.wicket.clipboardjs;

import org.apache.wicket.request.resource.JavaScriptResourceReference;

public class ClipboardResourceReference extends JavaScriptResourceReference{

	private static final ClipboardResourceReference instance = new ClipboardResourceReference();
	
	/**
	 * @return the singleton instance
	 */
	public static ClipboardResourceReference get()
	{
		return instance;
	}
	
	public ClipboardResourceReference() {
		super(ClipboardResourceReference.class, "js/clipboard.js");
	}

}
