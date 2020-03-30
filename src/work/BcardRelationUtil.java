package work;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class BcardRelationUtil {

	//넘겨줄 리스트
	private List<BcardRelation> bcardRelationList = new ArrayList<BcardRelation>();

	private List<BcardRelation> bcardRelationItemList = new ArrayList<BcardRelation>();
	private List<BcardRelation> bcardRelationLinkList = new ArrayList<BcardRelation>();
	
	private String businnesscardId;
	private List<BcardRelation> bcardRelationCheckList = new ArrayList<BcardRelation>();

	private HashMap<String, Integer> itemMap = new HashMap<String, Integer>();
	
	public List<BcardRelation> calBcardRelation(String bid, List<BcardRelation> itemList, List<BcardRelation> linkList){
		this.businnesscardId = bid;
		this.bcardRelationItemList = itemList;
		this.bcardRelationLinkList = linkList;
		
		getItemlevel(bid);
		findBcardList(bid, "out");
		
		int outSize = bcardRelationCheckList.size();
		
		//out bind
		for(int i=0; i<outSize; i++) {
			BcardRelation out = bcardRelationCheckList.get(i);
			if(!hasItemId(out.getRelationBusinesscardId())) {
				findBcardList(out.getRelationBusinesscardId(), "out");
				outSize = bcardRelationCheckList.size();
			}
			out.setRlevel(getItemlevel(out.getRelationBusinesscardId()));
			bcardRelationList.add(out);
		}
		
		//in bind
		bcardRelationCheckList.clear();
		findBcardList(bid, "in");
		int inSize1 = bcardRelationCheckList.size();
		int inSize2 = bcardRelationCheckList.size();
		
		//in bind
		for(int j=0; j<inSize1; j++) {
			BcardRelation in = bcardRelationCheckList.get(j);
			if(j<inSize2) {
				findBcardList(in.getBusinesscardId(), "out");
				inSize1 = bcardRelationCheckList.size();
			}else {
				if(!hasItemId(in.getRelationBusinesscardId())) {
					findBcardList(in.getRelationBusinesscardId(), "out");
					inSize1 = bcardRelationCheckList.size();
					
				}
			}
			
			in.setRlevel(getItemlevel(in.getRelationBusinesscardId()));
			bcardRelationList.add(in);
		}
		
		
		return bcardRelationList;
	}
	
	private void findBcardList(String bid, String bind) {
		for(BcardRelation link : bcardRelationLinkList){
			String tid = "out".equals(bind)?link.getBusinesscardId():link.getRelationBusinesscardId();
			if(bid.equals(tid)){
				link.setBlevel(getItemlevel(link.getBusinesscardId()));
				link.setDisplay(getDisplay(link.getBusinesscardId()));
				link.setDisplay2(getDisplay(link.getRelationBusinesscardId()));
				bcardRelationCheckList.add(link);
			}
		}
	}
	
	
	private boolean hasItemId(String itemId) {
		return itemMap.containsKey(itemId);
	}
	
	private Integer getItemlevel(String itemId) {
		Integer level;
		if(hasItemId(itemId)) {
			level = itemMap.get(itemId);
		}else {
			level = itemMap.size()+1;
			itemMap.put(itemId, level);
		}
		
		return level;
	}
	
	
	private String getDisplay(String bid) {
		String display = "";
		for(BcardRelation item : bcardRelationItemList){
			if(bid.equals(item.getRelationBusinesscardId())){
				display = item.getDisplay();
				break;
			}
		}
		return display;
	}
	
}
