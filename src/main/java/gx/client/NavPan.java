package gx.client;

import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.core.client.util.Padding;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.BoxLayoutContainer.BoxLayoutData;
import com.sencha.gxt.widget.core.client.container.FlowLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VBoxLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VBoxLayoutContainer.VBoxLayoutAlign;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;

public class NavPan extends ContentPanel{
	PanForm panForm = null;
    TextButton bTable = null, bLog = null;
    FlowLayoutContainer contPan = null;
    private String role = "";
    
    public NavPan(final FlowLayoutContainer blc){
	    contPan = blc;
	    setHeadingText("Навигация");
	    getHeader().addStyleName("txt_center");
        VBoxLayoutContainer bc = new VBoxLayoutContainer();
        bc.setPadding(new Padding(1));
        bc.setVBoxLayoutAlign(VBoxLayoutAlign.STRETCH);
        bTable = new TextButton("Form", new SelectHandler(){
	       @Override
	       public void onSelect(SelectEvent event) {
	    	bTable.setEnabled(false);
		    if (panForm == null) panForm = new PanForm();
		    ShowPan(panForm);
	        bTable.setEnabled(true);
	        }});

        bc.add( bTable, new BoxLayoutData(new Margins(0, 0, 1, 0)));
        
//        bLog = new TextButton("Журнал", new SelectHandler(){
//	       @Override
//	       public void onSelect(SelectEvent event) {
//		   if (panLog == null) panLog = new PanLog(fct);
//		   ShowPan(panLog);
//	       }}); 
//        bLog.setEnabled(false);
//        bc.add( bLog, new BoxLayoutData(new Margins(0)));
        
        add(bc);
    }
    
    private void ShowPan(ContentPanel pan){
    	contPan.clear();
    	contPan.add(pan);
    }
}
