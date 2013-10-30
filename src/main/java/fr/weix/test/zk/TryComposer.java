/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.weix.test.zk;

import fr.weix.test.zk.components.MultiSelectBox;
import java.util.Arrays;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zkplus.spring.DelegatingVariableResolver;
import org.zkoss.zul.Button;
import org.zkoss.zul.Label;
import org.zkoss.zul.Window;

/**
 *
 * @author caskdor
 */
@VariableResolver(DelegatingVariableResolver.class)
public class TryComposer extends SelectorComposer<Window> {
    
    @Wire private MultiSelectBox<String> tags;
    
    @Wire private Label choice;
    @Wire private Button check;
    
    @Override
    public void doAfterCompose(Window win) throws Exception {
        super.doAfterCompose(win);
        tags.setDatas(Arrays.asList("TRACE", "INFO"));
    }
    
    @Listen("onClick=#check")
    public void selectTag() {
        choice.setValue(tags.getSelection().toString());
    }
    
    
}
