/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.weix.test.zk.components;

import java.util.Collection;
import java.util.List;
import org.zkoss.composite.Composite;
import org.zkoss.composite.Composites;
import org.zkoss.zk.ui.IdSpace;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Div;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import org.zkoss.zul.ext.Selectable;

/**
 *
 * @author caskdor
 */
@Composite(name = "multiselectbox", macroURI = "/zul/components/MultiSelectBox.zul")
public class MultiSelectBox<T extends Object>  extends Div implements IdSpace {
    
    @Wire private Listbox select;

    public MultiSelectBox() {
        Composites.doCompose(this, null);
        init();
    }
    
    private void init() {
        select.setItemRenderer(new ListitemRenderer<T>() {

            @Override
            public void render(Listitem item, T bean, int i) throws Exception {
                item.setLabel(getLabel(bean));
            }

        });
    }
     
    public void setDatas(List<T> datas) {
        select.setModel(new ListModelList<>(datas));
    }
    
    public Collection<T> getSelection() {
        return ((Selectable<T>) select).getSelection();
    }

    private String getLabel(T bean) {
        return bean.toString();
    }

}
