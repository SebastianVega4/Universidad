package conbinations;

public class Conbinations {
	
	private short elements;
	private byte groups ;
	private int calcFact;
	private short conbinations;
	
	
	public short getElements() {
		return elements;
	}
	public void setElements(short elements) {
		this.elements = elements;
	}
	
	public byte getGroups() {
		return groups;
	}
	public void setGroups(byte groups) {
		this.groups = groups;
	}
	
	private int calcFact(int numer) {
		return numer==0 || numer==1 ? 1 : numer*calcFact(numer-1);
	}
	
	
	public short getConbinations() {
		conbinations=(short) ((short) calcFact(elements)/(calcFact(groups)*calcFact(elements-groups)));
		return conbinations;
	}
}
