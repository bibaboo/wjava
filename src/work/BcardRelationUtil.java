package work;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BcardRelationUtil {

	//넘겨줄 리스트
	private List<BcardRelation> bcardRelationList = new ArrayList<BcardRelation>();

	private List<BcardRelation> bcardRelationItemList = new ArrayList<BcardRelation>();
	private List<BcardRelation> bcardRelationLinkList = new ArrayList<BcardRelation>();
	private List<BcardRelation> bcardRelationCheckList = new ArrayList<BcardRelation>();

	private HashMap<String, Integer> itemMap = new HashMap<String, Integer>();
	public List<BcardRelation> calBcardRelation(String bid, List<BcardRelation> itemList, List<BcardRelation> linkList){
		this.bcardRelationItemList = itemList;
		this.bcardRelationLinkList = linkList;
		
		//out bind
		if(hasBcardOutList(bid)) {
			getItemlevel(bid);
			findBcardOutList(bid);
			setBcardRelationList();
		}

		//in bind
		List<String> inList = getInlist(bid);
		for(String bid2 : inList) {
			bcardRelationCheckList.clear();
			findBcardOutList(bid2);
			setBcardRelationList();
		}
				
		return bcardRelationList;
	}
	
	public List<BcardRelation> calBcardRelationExtend(String bid, List<BcardRelation> itemList, List<BcardRelation> linkList){
		this.bcardRelationItemList = itemList;
		this.bcardRelationLinkList = linkList;
		
		//out bind
		if(hasBcardOutList(bid)) {
			getItemlevel(bid);
			findBcardOutList(bid);
			setBcardRelationList();
		}

		//extend bind
		List<String> inList = getExtendlist();
		for(String bid2 : inList) {
			bcardRelationCheckList.clear();
			findBcardOutList(bid2);
			setBcardRelationList();
		}
				
		return bcardRelationList;
	}
	
	
	private void setBcardRelationList() {
		int outSize = bcardRelationCheckList.size();
		for(int i=0; i<outSize; i++) {
			BcardRelation out = bcardRelationCheckList.get(i);
			if(!hasItemId(out.getRelationBusinesscardId())) {
				findBcardOutList(out.getRelationBusinesscardId());
				outSize = bcardRelationCheckList.size();
			}
			out.setRlevel(getItemlevel(out.getRelationBusinesscardId()));
			bcardRelationList.add(out);
		}
	}
	
	//out bind
	private void findBcardOutList(String bid) {
		for(BcardRelation link : bcardRelationLinkList){
			if(bid.equals(link.getBusinesscardId()) && !containBcardRelationList(link)){
				link.setBlevel(getItemlevel(link.getBusinesscardId()));
				link.setDisplay(getDisplay(link.getBusinesscardId()));
				link.setDisplay2(getDisplay(link.getRelationBusinesscardId()));
				bcardRelationCheckList.add(link);
			}
		}
	}
	
	private boolean hasBcardOutList(String bid) {
		boolean b = false;
		for(BcardRelation link : bcardRelationLinkList){
			if(bid.equals(link.getBusinesscardId())){
				b = true;
				break;
			}
		}
		return b;
	}
	
	//in bound
	private List<String> getInlist(String bid) {
		List<String> result = new ArrayList<String>();
		
		for(BcardRelation link : bcardRelationLinkList){
			if(bid.equals(link.getRelationBusinesscardId()) && !containBcardRelationList(link)){
				result.add(link.getBusinesscardId());
			}
		}
		return result;
	}
	
	//extend bound
	private List<String> getExtendlist() {
		List<String> result = new ArrayList<String>();
		for(BcardRelation item : bcardRelationItemList){
			if(!hasItemId(item.getRelationBusinesscardId())){
				result.add(item.getRelationBusinesscardId());
			}
		}
		return result;
	}
	
	//중복 데이터 체크
	private boolean containBcardRelationList(BcardRelation link) {
		boolean b = false;
		for(BcardRelation bcard : bcardRelationList){
			if(link.getBusinesscardId().equals(bcard.getBusinesscardId()) && link.getRelationBusinesscardId().equals(bcard.getRelationBusinesscardId())) {
				b = true;
				break;
			}
		}
		return b;
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