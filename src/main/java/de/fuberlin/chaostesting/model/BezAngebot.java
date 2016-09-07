package de.fuberlin.chaostesting.model;

public enum BezAngebot {
	
	QuerDurchsLand("Quer-durchs-Land-Ticket", "QUER-DURCHS-LAND-T"),
	SchoenesWochenende("Schönes-Wochenende-Ticket", "Schönes-Wochenende-T"),
	IREBerlinHamburg("IRE-Berlin-Hamburg-Ticket", "IRE-Berlin-HH-Ticket");
	
	private final String publicName;
	private final String internalName;
	
	BezAngebot(String publicName, String osstInternalName) {
		this.publicName = publicName;
		this.internalName = osstInternalName;
	}
	
	@Override
	public String toString() {
		return publicName;
	}
	
	public String internalName() {
		return internalName;
	}
}
