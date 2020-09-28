package ct;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
public class Solution_D4_9760_U카드놀이 {
	static int T;
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		T=scann.nextInt();
		for (int t = 1; t <= T; t++) {
			Card[] cards=new Card[5];
			for (int i = 0; i < 5; i++) {
				cards[i]=new Card(scann.next());
			}
			System.out.println("#"+t+" "+CardRanking.toRankName2(cards));
		}
	}
	public static class CardUtil {
		 public static final String[] 
		   SUIT={"S","D","H","C"};
		 public static final String[]
		   RANK={"A","2","3","4","5",
			 "6","7","8","9",
			 "T","J","Q","K"};     
		 
		 public static int toVal(Card c){
			 return toVal(c.card.charAt(1));
		 }
		 public static int toVal(char cc){
			 int tot=0;
			 switch (cc) {
			 	case 'A':tot=1;break;
			 	case 'T':tot=10;break;
			 	case 'J':tot=11;break;
			 	case 'Q':tot=12;break;
			 	case 'K':tot=13;break;
			 	default: tot=cc-'0';break;
			}
			 return tot;
		 }
		}
	public static class CardSuitComp implements Comparator<Card> {
		@Override
		public int compare(Card o1, Card o2) {
			char c1=o1.card.charAt(0);
			char c2=o2.card.charAt(0);
			if(c1-c2>0){
				return 1;//asc
			}else if(c1-c2<0){
				return -1;
			}else{
				int cc1=CardUtil.toVal(o1.card.charAt(1));
				int cc2=CardUtil.toVal(o2.card.charAt(1));
				if(cc1-cc2>0){
					return 1;//asc
				}else if(cc1-cc2<0){
					return -1;
				}else{
					return 0;
				}
			}
		}
	}

	public static class CardRankComp implements Comparator<Card> {
		@Override
		public int compare(Card o1, Card o2) {
			int c1=CardUtil.toVal(o1.card.charAt(1));
			int c2=CardUtil.toVal(o2.card.charAt(1));
			if(c1-c2>0){
				return 1;//asc
			}else if(c1-c2<0){
				return -1;
			}else{
				return 0;
			}
		}
	}
	public static  class CardRanking {

		public static String fiveSuit(Card[] cd){
			//String s="";
			StringBuffer sb=new StringBuffer();
			for (int i = 0; i < cd.length; i++) {
				//s=s+cd[i].card.charAt(0);
				sb.append(cd[i].card.charAt(0));
			}
			return sb.toString();
		}
		public static String fiveRank(Card[] cd){
			StringBuffer sb=new StringBuffer();
			for (int i = 0; i < cd.length; i++) {
				sb.append(cd[i].card.charAt(1));
			}
			return sb.toString();
		}
		
		public static int[] sameSuits(String s){
			int[] t=new int[4];
			for (int i = 0; i < s.length(); i++) {
				switch(s.charAt(i)){
					case 'C': t[0]+=1;break;
					case 'D': t[1]+=1;break;
					case 'H': t[2]+=1;break;
					case 'S': t[3]+=1;break;
				}
			}
			return t;
		}
		public static int sameSuit(String s, char c){
			int t=0;
			for (int i = 0; i < s.length(); i++) {
				if(s.charAt(i)==c){
					t+=1;
				}
			}
			return t;
		}
		public static int sameRank(String s, char c){
			int t=0;
			for (int i = 0; i < s.length(); i++) {
				if(s.charAt(i)==c){
					t+=1;
				}
			}
			return t;
		}
		//---------------------------------------
		
		public static String toRankName2(Card[] ccd){
			String s="High card";	
			boolean isAllFlush=false;
			Arrays.sort(ccd,new CardSuitComp());
			String fs=  CardRanking.fiveSuit(ccd);
			int[] ss=sameSuits(fs);
			for (int i = 0; i < ss.length; i++) {
				if(ss[i]==5){
					isAllFlush=true;
					break;
				}
			}
			boolean isAllStraight=false;
			Arrays.sort(ccd,new CardRankComp());
			String fr= CardRanking.fiveRank(ccd);
			String basement="A23456789TJQK";
			for (int i = 0; i < 9; i++) {
				String ts=basement.substring(i,5+i);
				if(ts.equals(fr)){
					isAllStraight=true;
					break;
				}
			}
			//TJQKA 일때 Royal Straight
			if("ATJQK".equals(fr)){
				isAllStraight=true;
			}
			
			if(isAllStraight && isAllFlush){
				return "Straight Flush";
			}else if(isAllStraight && !isAllFlush){
				return "Straight";
			}else if(!isAllStraight && isAllFlush){
				return "Flush";
			}
			
			boolean isFourKind=false;
			ss=new int[CardUtil.RANK.length];
			for (int i = 0; i < ss.length; i++) {
				ss[i]=sameRank(fr,CardUtil.RANK[i].charAt(0));
			}	
			
			for (int i = 0; i < ss.length; i++) {
				if(ss[i]==4){
					isFourKind=true;
					break;
				}
			}
			
			if(isFourKind){
				return "Four of a Kind";
			}
			
			boolean isAllThreeKind=false;
			for (int i = 0; i < ss.length; i++) {
				if(ss[i]==3){
					isAllThreeKind=true;
					break;
				}
			}
			boolean isAllOnePair=false;
			boolean isTwoPairs=false;
			
			int count=0;
			for (int i = 0; i < ss.length; i++) {
				if(ss[i]==2){
					count++;
				}
			}
			isAllOnePair=(count==1?true:false);
			isTwoPairs=(count==2?true:false);
			if(!isAllOnePair && isAllThreeKind){
				return "Three of a kind";
			}else if(isAllOnePair && isAllThreeKind){
				return "Full House";
			}else if(isAllOnePair  && !isAllThreeKind){
				return "One pair";
			}else if(isTwoPairs){
				return "Two pair";
			}else return s;
		}
	}

	public static  class Card {
		String card; //H8
		public Card(String s) {
			this.card=s;
		}
	}//

}
