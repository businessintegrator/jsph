package com.bi.jsph.state;

import com.bi.right.state.Item;
import com.bi.right.state.Stateview;
import java.util.*;

public class StateManager {

    private Map<String, Integer> elements = new HashMap<String, Integer>();
    private Stateview stateView = null;

    public StateManager() {
    }

    public void mapAll(){
        if (stateView == null) {return;}
        Map<Item, Integer> states = stateView.getStates(); 
        for (Map.Entry<Item, Integer> entry : states.entrySet()) {
            Item item = entry.getKey();
            Integer integer = entry.getValue();
            if (integer == null) {continue;}
            String name = item.name();
            Integer result = elements.get(name);
            if (result != null){
                elements.put(name, integer.intValue());
                //System.out.println(" Valeurs "+name+"="+integer.intValue());
            }
        }
    }
    private JSPHSTate getColor(String name) {
        Integer result = elements.get(name);
        if (result == null) {
            return JSPHSTate.EMPTY;
        }
        if (result.intValue() < 0) {
            return JSPHSTate.ERRORED;
        }
        if (result.intValue() > 0 && result.intValue() < 100) {
            return JSPHSTate.PARTIAL;
        }
        if (result.intValue() >= 100) {
            return JSPHSTate.FULL;
        }
        return JSPHSTate.EMPTY;
    }

    public void setColor(String name, int value) {
        elements.put(name, value);
    }

    public String getResources(String prefix, String name, String suffix) {
        JSPHSTate state = getColor(name);
        return prefix + state.getValue() + suffix;
    }

    public void setStateView(Stateview pstateView) {
        this.stateView = pstateView;
    }
}
