package gx.client;

import com.google.gwt.user.client.ui.VerticalPanel;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.form.ValueBaseField;
import com.sencha.gxt.widget.core.client.info.Info;

public class PanForm extends ContentPanel{
	private VerticalPanel vp;
	 
	  public PanForm() {
	    if (vp == null) {
	      vp = new VerticalPanel();
	      vp.setSpacing(10);
	      PanForm1();
	    }
	    setWidget(vp);
	  }
	  
	public void PanForm1() {
		FramedPanel panel = new FramedPanel();
	    panel.setHeadingText("Simple Form");
	    panel.setWidth(300);
	    panel.setBodyStyle("background: none; padding: 15px");
	 
	    VerticalLayoutContainer p = new VerticalLayoutContainer();
	    panel.add(p);
	    
	    final TextField email = new TextField();
	    email.setAllowBlank(false);
	    email.getCell().getInputElement(email.getElement()).setMaxLength(20);
	    p.add(new FieldLabel(email, "Email"), new VerticalLayoutData(1, -1));
	    panel.addButton(new TextButton("Save", new SelectHandler(){
		       @Override
		       public void onSelect(SelectEvent event) {
		    	   Info.display("Music Changed", "email = " + email.getValue());
		        }}));
	    vp.add(panel);
	}

	private void setTxtVal(ValueBaseField F, String V, int len){
		F.setValue(V); 
		F.getCell().getInputElement(F.getElement()).setMaxLength(len);
	    }
}
