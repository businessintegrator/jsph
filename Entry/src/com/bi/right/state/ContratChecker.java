package com.bi.right.state;

import java.util.Date;

import com.bi.right.customer.bo.Contrat;

public class ContratChecker extends Milkshake {

	private Contrat contrat;
	private Stateview stateView;

	public ContratChecker(Contrat contrat, Stateview s) {
		this.contrat = contrat;
		this.stateView = s;
	}

	public void process() {
            boolean contratReady = false;
		Date date = this.contrat.getStartdt();
		if (date == null) {
			stateView.set(Item.CONTRAT_START, 0);
                        contratReady = false;
		} else {
                    contratReady = true;
			boolean rompu = this.contrat.getRompu();
			if (rompu) {
				Date endDate = this.contrat.getEnddt();
				if (endDate != null) {
					boolean res = endDate.before(date);
					if (res ){
					 stateView.set(Item.CONTRAT_START_BEFORE_ENDDATE, 0);
                                         contratReady = false;
					} else {
						stateView.set(Item.CONTRAT_START_BEFORE_ENDDATE, 100);
                                                contratReady = true;
					}
				} else {
					stateView.set(Item.CONTRAT_END, 0);
                                        contratReady = false;
				}
			}
		}
                stateView.setContratReady(contratReady);
        }

}
