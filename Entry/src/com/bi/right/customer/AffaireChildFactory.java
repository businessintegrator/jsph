/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer;

import com.bi.right.customer.bo.GUIManager;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javax.swing.Action;
import org.openide.actions.DeleteAction;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.ChildFactory;
import org.openide.nodes.Children;
import org.openide.nodes.Node;
import org.openide.util.actions.SystemAction;
import org.openide.util.lookup.Lookups;

/**
 *
 * @author rafaralahitsimba tiaray
 */
public class AffaireChildFactory extends ChildFactory<GUIManager> {

    private List<GUIManager> resultList;

    public AffaireChildFactory(List<GUIManager> resultList) {
        this.resultList = resultList;
    }

    @Override
    protected boolean createKeys(List<GUIManager> list) {
        for (GUIManager gUIManager : resultList) {
            list.add(gUIManager);
        }
        return true;
    }

    @Override
    protected Node createNodeForKey(final GUIManager c) {
        Node node = new AbstractNode(Children.LEAF, Lookups.singleton(c)) {
            @Override
            public Action[] getActions(boolean context) {
                Action[] result = new Action[]{
                    SystemAction.get(DeleteAction.class)
		   // new OpenAffaireAction(resultList,c)
                    //SystemAction.get(org.openide.actions.EditAction.class),
                    //SystemAction.get(PropertiesAction.class)
                };
                return result;
            }

            @Override
            public boolean canDestroy() {
                GUIManager customer = this.getLookup().lookup(GUIManager.class);
                return customer != null;
            }

            @Override
            public void destroy() throws IOException {
                if (deleteGUIManager(this.getLookup().lookup(GUIManager.class).getAffaire())) {
                super.destroy();
                GUIManagerTopComponent.refreshNode();
                }
                
            }
               
            
            
        };
        node.setDisplayName(c.getAffaire()+" "+c.getDemandeur().getPersonId().getIndividu().getNm()+" contre "+c.getDefendeur().getSociete().getNm());
        node.setShortDescription(c.getUniqueId());
	
        return node;
    }

    private static boolean deleteGUIManager(String affaire) {
        GUIManager gUIManager = null;
        List<GUIManager> list = GUIManagerTopComponent.getResultList();
        for (Iterator<GUIManager> it = list.iterator(); it.hasNext();) {
            gUIManager = it.next();
            if (gUIManager.getAffaire().equals(affaire)) {
                break;
            }

        }
        if (gUIManager != null) {
            list.remove(gUIManager);
            //gUIManager = null;
            GUIManagerTopComponent.refreshNode();
            return true;
        }
        return false;

    }
}
