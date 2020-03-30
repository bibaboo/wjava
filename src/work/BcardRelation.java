package work;

public class BcardRelation {
	
	
	BcardRelation(int blevel, String display, String display2, String relationBusinesscardId) {
		this.blevel = blevel;
		this.display = display;
		this.display2 = display2;
		this.relationBusinesscardId = relationBusinesscardId;
	}
	
	BcardRelation(String businesscardId, String relationBusinesscardId, String relation) {
		this.businesscardId = businesscardId;
		this.relationBusinesscardId = relationBusinesscardId;
		this.relation = relation;
	}
	
	
	private String businesscardId;	
	private String relationBusinesscardId;
	private String relation;

	private int blevel = 0;
	private int rlevel = 0;
	private int rowspan = 0;

	private String display;

	private String display2;

	public String getBusinesscardId() {
		return businesscardId;
	}

	public void setBusinesscardId(String businesscardId) {
		this.businesscardId = businesscardId;
	}

	public String getRelationBusinesscardId() {
		return relationBusinesscardId;
	}

	public void setRelationBusinesscardId(String relationBusinesscardId) {
		this.relationBusinesscardId = relationBusinesscardId;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public int getBlevel() {
		return blevel;
	}

	public void setBlevel(int blevel) {
		this.blevel = blevel;
	}

	public int getRlevel() {
		return rlevel;
	}

	public void setRlevel(int rlevel) {
		this.rlevel = rlevel;
	}

	public int getRowspan() {
		return rowspan;
	}

	public void setRowspan(int rowspan) {
		this.rowspan = rowspan;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public String getDisplay2() {
		return display2;
	}

	public void setDisplay2(String display2) {
		this.display2 = display2;
	}

	

}