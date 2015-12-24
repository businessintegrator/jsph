package com.bi.jsph.uploa.txns.rw;


final public class BusinessClass {

    static BusinessClass ESSAY = new BusinessClass(new Double(0), "C");
    static BusinessClass OUTOFDATE = new BusinessClass(new Double(-1), "D");
    private Double amount;
    private String boclass;

    public BusinessClass(Double pamount, String txt) {
	this.amount = pamount;
	this.boclass = txt;
    }

    public Double getAmount() {
	return amount;
    }

    public void setAmount(Double amount) {
	this.amount = amount;
    }

    public String getBoclass() {
	return boclass;
    }

    public void setBoclass(String boclass) {
	this.boclass = boclass;
    }

    @Override
    public String toString() {
	return "BusinessClass [amount=" + amount + ", boclass=" + boclass + "]";
    }
}
