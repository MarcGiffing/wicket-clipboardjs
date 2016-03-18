package com.giffing.wicket.clipboardjs;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.head.OnDomReadyHeaderItem;

public class ClipboardBehavior extends AttributeAppender {
	
	public ClipboardBehavior(Component componentTOCopy) {
		super(getDataTargetAttributeName(), getDataTargetValue(componentTOCopy.getMarkupId()));
	}
	
	public ClipboardBehavior(String target){
		super(getDataTargetAttributeName(), getDataTargetValue(target));
	}
	
	@Override
	public void renderHead(Component component, IHeaderResponse response) {
		super.renderHead(component, response);
		response.render(JavaScriptHeaderItem.forReference(ClipboardResourceReference.get()));
		initializeJavascriptClipboard(component, response);
	}

	protected void initializeJavascriptClipboard(Component component, IHeaderResponse response) {
		String javaScript = clipboardJavascript(htmlSelector() + component.getMarkupId());
		OnDomReadyHeaderItem onDomReadyJavascript = OnDomReadyHeaderItem.forScript(javaScript);
		response.render(onDomReadyJavascript);
	}

	protected String clipboardJavascript(String target) {
		return "new Clipboard('" + target + "');";
	}

	protected static String htmlSelector() {
		return "#";
	}
	
	protected static String getDataTargetAttributeName() {
		return "data-clipboard-target";
	}

	protected static String getDataTargetValue(String markupId) {
		return htmlSelector()+markupId;
	}

}