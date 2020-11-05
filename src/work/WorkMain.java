package work;

import java.util.ArrayList;
import java.util.List;

public class WorkMain {

	public static void main(String[] args) {
	
		String businnesscardId = "120000050202";
	
		List<BcardRelation> bcardRelationItemList = new ArrayList<BcardRelation>();
		bcardRelationItemList.add(new BcardRelation(0,"SA","Simthadom  TEST 회사","120000050202"));
		bcardRelationItemList.add(new BcardRelation(1,"김하나","김하나 과장 TEST 회사","120000070047"));
		bcardRelationItemList.add(new BcardRelation(1,"홍길동","홍길동 과장 TEST 회사","120000060006"));
		bcardRelationItemList.add(new BcardRelation(1,"김부자","김부자 부장 TEST 회사","120000060158"));
		bcardRelationItemList.add(new BcardRelation(1,"두나두","김두나두나  신규회사01 길게길게길게길게","120000070073"));
		bcardRelationItemList.add(new BcardRelation(1,"박사부","박사부  ","120000060091"));
		bcardRelationItemList.add(new BcardRelation(1,"김사부","김사부  TEST 회사","120000060038"));
		bcardRelationItemList.add(new BcardRelation(2,"스트0","테스트002 직책002 TEST 회사","120000050126"));
		bcardRelationItemList.add(new BcardRelation(2,"스트0","테스트005  TEST 회사","120000050197"));
		bcardRelationItemList.add(new BcardRelation(2,"스트0","테스트001  TEST 회사","120000050122"));
		bcardRelationItemList.add(new BcardRelation(2,"스트0","테스트010  ","120000070624"));
		
		
		List<BcardRelation> bcardRelationLinkList = new ArrayList<BcardRelation>();
		
		bcardRelationLinkList.add(new BcardRelation("120000070047","120000060158","돈줄"));
		bcardRelationLinkList.add(new BcardRelation("120000070047","120000070624","010"));
		bcardRelationLinkList.add(new BcardRelation("120000060158","120000060006","의적"));
		bcardRelationLinkList.add(new BcardRelation("120000050202","120000060158","부자"));
		bcardRelationLinkList.add(new BcardRelation("120000050202","120000070047","후배"));
		bcardRelationLinkList.add(new BcardRelation("120000060006","120000050202","아는사이"));
		bcardRelationLinkList.add(new BcardRelation("120000060158","120000060038","사부"));
		bcardRelationLinkList.add(new BcardRelation("120000060091","120000050202","그냥"));
		bcardRelationLinkList.add(new BcardRelation("120000070073","120000050197","3424"));
		bcardRelationLinkList.add(new BcardRelation("120000070073","120000050202","123123"));
		bcardRelationLinkList.add(new BcardRelation("120000050202","120000060006","대도"));
		bcardRelationLinkList.add(new BcardRelation("120000070047","120000050126","002"));
		bcardRelationLinkList.add(new BcardRelation("120000070047","120000060038","사부"));
		bcardRelationLinkList.add(new BcardRelation("120000060091","120000050126","친구"));
		bcardRelationLinkList.add(new BcardRelation("120000050202","120000060038","지인"));
		bcardRelationLinkList.add(new BcardRelation("120000060091","120000050122","그냥"));
		bcardRelationLinkList.add(new BcardRelation("120000070073","120000060006","지인"));
		bcardRelationLinkList.add(new BcardRelation("120000050122","120000060091","이중 연결"));
		
		BcardRelationUtil ut = new BcardRelationUtil();
		
		
		
		List<BcardRelation> bcardRelationList = ut.calBcardRelationExtend(businnesscardId, bcardRelationItemList, bcardRelationLinkList);
		
		int i = 0;
		for(BcardRelation item :bcardRelationList) {
			System.out.println("i : " + ++i);
			System.out.println("blevel : " + item.getBlevel());
			System.out.println("businesscardId : " + item.getBusinesscardId());
			System.out.println("display : " + item.getDisplay());
			System.out.println("rlevel : " + item.getRlevel());
			System.out.println("relationBusinesscardId : " + item.getRelationBusinesscardId());
			System.out.println("display2 : " + item.getDisplay2());
			System.out.println("relation : " + item.getRelation());
			System.out.println("\n\n");
		}
		
		
		
	}

}