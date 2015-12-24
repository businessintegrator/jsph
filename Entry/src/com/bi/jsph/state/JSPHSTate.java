package com.bi.jsph.state;

public enum JSPHSTate {
	EMPTY("droite-inactif"),
	FULL("droite-actif"),
	PARTIAL("droite-waiting"),
	ERRORED("droite-error")
	;
	
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	private JSPHSTate(String value) {
		this.value = value;
	}
	
	

}
