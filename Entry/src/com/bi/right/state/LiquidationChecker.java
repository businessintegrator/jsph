package com.bi.right.state;

import java.util.Date;

import com.bi.right.customer.bo.Liquidation;

public class LiquidationChecker extends Milkshake {

	private Liquidation liquidation;
	private Stateview stateview;

	public LiquidationChecker(Liquidation liquidation, Stateview s) {
		this.liquidation = liquidation;
		this.stateview = s;

	}

	public void process() {
            boolean liquidationReady = false;
		if (isEmpty(this.liquidation.getLiquidateur())) {
			this.stateview.set(Item.LIQUIDATION, 0);
		} else {
			if (isEmpty(this.liquidation.getStartdt())) {
				this.stateview.set(Item.LIQUIDATION, 50);
			} else {
			 this.stateview.set(Item.LIQUIDATION, 100);
                         liquidationReady = true;
                        }
                        
		}
        this.stateview.setLiquidationReady(liquidationReady);
	}

	private boolean isEmpty(Date startdt) {
       if (startdt == null){
    	  return true;
       }
		return false;
	}

}
