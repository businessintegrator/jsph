package com.bi.right.state;

import java.util.ArrayList;
import java.util.Iterator;

import com.bi.right.customer.bo.Demande;
import com.bi.right.customer.bo.GUIManager;

public class DemandesChecker extends Milkshake{

	private ArrayList<Demande> list;
	private Stateview stateView;

	public DemandesChecker(GUIManager parent, Stateview s) {
		this.list = parent.getDemandes();
		this.stateView = s;
	}

	public void process() {
            boolean demandesReady = false;
            boolean discussionsReady = false;
		if (list == null || list.isEmpty()){
			this.stateView.set(Item.DEMANDES,0);
		} else {
			int size = list.size();
                        int seleted = 0;
                        int ndDiscussions = 0;
			for (Iterator<Demande> iterator = list.iterator(); iterator.hasNext();) {
				Demande type = iterator.next();
                                if (type.isSelected()){
                                    seleted++;
				  if (isEmpty(type)){
					size--;	
					
				  } else {
                                      if (type.isArgumented()){
                                        ndDiscussions++;
                                      }
                                  }
                                } else {
                                    size--;	
                                }
				
			}
			if (seleted == size){
                          this.stateView.set(Item.DEMANDES,100);
                          if (ndDiscussions == seleted){
                              discussionsReady = true;
                          }
                          demandesReady = true;
                        } else {
                            this.stateView.set(Item.DEMANDES,size);
                        }
		}
		stateView.setDemandesReady(demandesReady);
                stateView.setDiscussionsReady(discussionsReady);
	}

	protected boolean isEmpty(Demande dem) {
             if(!dem.isSelected()){return true;}
             if (isEmpty(dem.getArgFait())){
             } else {
                 dem.setArgumented(true);
             }
             
		if (isEmpty(dem.getArgDroit()) || isEmpty(dem.getLbl())){
			return true;	
		}
		if (dem.getAmount() == null || dem.getAmount() == 0){
			this.stateView.set(Item.DEMANDE_AMOUNT, 0);
			return true;
		} 
		return false;
		
		
	}

}
