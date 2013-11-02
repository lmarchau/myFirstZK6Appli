/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.weix.test.zk;

import fr.weix.test.zk.components.MultiSelectBox;
import fr.weix.test.zk.entity.Level;
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
    
    @Wire private MultiSelectBox<Level> tags;
    
    @Wire private Label choice;
    @Wire private Button check;
    
    @Override
    public void doAfterCompose(Window win) throws Exception {
        super.doAfterCompose(win);
        tags.setDatas(Arrays.asList(new Level("TRACE", 0), new Level("INFO", 1), new Level("DEBUG", 2), new Level("WARN", 3), new Level("ERROR", 4), new Level("DATA", 5), new Level("PERSO", 6), new Level("JOB", 7), new Level("CONF", 8), new Level("FAIL", 9), new Level("CRASH", 10)));
    }
    
    @Listen("onClick=#check")
    public void selectTag() {
        choice.setValue(tags.getSelection().toString());
    }
    
    
}
