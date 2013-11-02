/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.weix.test.zk.components;

import fr.weix.test.zk.entity.Level;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import org.zkoss.composite.Composite;
import org.zkoss.composite.Composites;
import org.zkoss.zk.ui.IdSpace;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Div;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listhead;
import org.zkoss.zul.Listheader;
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
    @Wire private Label infos;
//    @Wire private Button all;
//    @Wire private Button none;
    
//    private List<String> columns;
    private String columns;
    private String name;
    
    
    public MultiSelectBox() {
        Composites.doCompose(this, new HashMap<String, Object>() {
            private static final long serialVersionUID = 1L;
            {
                put("columns", getColumns());
                put("name", getName());
            }
        });
        init();
    }
    
    private void init() {
        select.setItemRenderer(new ListitemRenderer<T>() {

            @Override
            public void render(Listitem item, T bean, int i) throws Exception {
                item.appendChild(new Listcell(((Level) bean).getName()));
                item.appendChild(new Listcell((String.valueOf(((Level) bean).getWeight()))));
                //item.setLabel(getLabel(bean));
            }

        });
    }
     
    public void setDatas(List<T> datas) {
        select.setModel(new ListModelList<>(datas));
      ((ListModelList) select.getModel()).setMultiple(true);
    }
    
    public Collection<T> getSelection() {
        return ((Selectable<T>) select.getModel()).getSelection();
    }

//    public void setColumns(String columns)  {
//        this.columns = null != columns ? Arrays.asList(columns.split(",")) : Arrays.asList("");
//    }
    public void setColumns(String columns)  {
        this.columns = columns;
        Listhead lh = new Listhead();
        for (String column : columns.split(",")) {
            lh.appendChild(new Listheader(column));
        }
        select.appendChild(lh);

    }
    
//    public List<String> getColumns() {
//        return columns;
//    }
    public String getColumns() {
        return columns;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    private String getLabel(T bean) {
        return bean.toString();
    }

    private void updateSelectionInfos() {
        String message = "Unknow state";
        if (0 == select.getSelectedCount()) {
            message = "Empty selection";
        }
        else {
            message = select.getSelectedCount() + " item(s) selected";
        }
        infos.setValue(message);
    }
    
    @Listen("onClick = #all")
    public void selectAll(Event event) {
        select.selectAll();
        updateSelectionInfos();
    }
    
    @Listen("onClick = #none")
    public void emptySelection(Event event) {
        select.clearSelection();
        updateSelectionInfos();
    }
    
    @Listen("onSelect = #select") 
    public void selectItem(Event event) {
        updateSelectionInfos();
    }
    
}
