package pkgCore;

import java.util.ArrayList;
import java.util.Collections;
import pkgConstants.*;
import pkgEnum.eCardNo;
import pkgEnum.eHandStrength;
import pkgEnum.eRank;
import pkgEnum.eSuit;

public class HandPoker extends Hand {

	private ArrayList<CardRankCount> CRC = null;

	public HandPoker() {
		this.setHS(new HandScorePoker());
	}

	protected ArrayList<CardRankCount> getCRC() {
		return CRC;
	}

	@SuppressWarnings("unchecked")
	@Override
	public HandScore ScoreHand() {
		// DONE : Implement this method... call each of the 'is' methods (isRoyalFlush,
		// etc) until
		// one of the hands is true, then score the hand

		Collections.sort(super.getCards());
		Frequency();

		if (isRoyalFlush()) {

		} else if (isStraightFlush()) {

		} else if (isFourOfAKind()) {
		    
		} else if (isFullHouse()) {
		    
		} else if (isFlush()) {
		    
		} else if (isStraight()) {
		    
		} else if (isThreeOfAKind()) {
		    
		} else if (isTwoPair()) {
		    
		} else if (isPair()) {
		    
		} else if (isHighCard()) {
		    
		} else {
			
		}

		return null;
	}

	public boolean isRoyalFlush() {
		boolean bisRoyalFlush = false;
		
		if(isStraightFlush() && 
			super.getCards().get(0).geteRank() == eRank.ACE &&
			super.getCards().get(1).geteRank() == eRank.KING) {
			bisRoyalFlush = true;
		} else {
			bisRoyalFlush = false;
		}
		
		if(bisRoyalFlush) {
			
			 HandScorePoker HSP = (HandScorePoker) this.getHS();
             HSP.seteHandStrength(eHandStrength.RoyalFlush);
             
             int iGetCardHi = this.getCRC().get(0).getiCardPosition();
             HSP.setHiCard(this.getCards().get(iGetCardHi));
            
             
             HSP.setLoCard(this.getCards().get(this.getCRC().get(4).getiCardPosition()));
             HSP.setKickers(null);
             this.setHS(HSP);
             
		} else {
			
		}
		
		return bisRoyalFlush;
	}

	public boolean isStraightFlush() {
		boolean bisStraightFlush = false;
		if(isStraight() && isFlush()) {
			bisStraightFlush = true;
		} else {
			bisStraightFlush = false;
		}
		
		if(bisStraightFlush) {
			HandScorePoker HSP = (HandScorePoker) this.getHS();
            HSP.seteHandStrength(eHandStrength.StraightFlush);
            int iGetCardHi = this.getCRC().get(0).getiCardPosition();
            HSP.setHiCard(this.getCards().get(iGetCardHi));
            int iGetCardLo = this.getCRC().get(4).getiCardPosition();
            HSP.setLoCard(this.getCards().get(iGetCardLo));
            HSP.setKickers(null);
            this.setHS(HSP);
		} else {
			
		}
		
		return bisStraightFlush;
	}
	
	// DONE : Implement this method
	public boolean isFourOfAKind() {
		boolean bisFourOfAKind = false;
        if (this.getCRC().size() == 2) {
            if (this.getCRC().get(0).getiCnt() == Constants.FOUR_OF_A_KIND) {
                if (this.getCRC().get(1).getiCnt() == Constants.ONE_OF_A_KIND) {
                	HandScorePoker HSP = (HandScorePoker) this.getHS();
    				HSP.seteHandStrength(eHandStrength.FourOfAKind);
    				int iGetCard = this.getCRC().get(0).getiCardPosition();
    				HSP.setHiCard(super.getCards().get(iGetCard));
    				HSP.setLoCard(null);
    				HSP.setKickers(FindTheKickers(this.getCRC()));
    				this.setHS(HSP);
                    bisFourOfAKind = true;
                }
            }
        }
		return bisFourOfAKind;
	}

	// DONE : Implement this method
	public boolean isFullHouse() {
		boolean bisFullHouse = false;
        if (this.getCRC().size() == 2) {
            if (this.getCRC().get(0).getiCnt() == Constants.THREE_OF_A_KIND) {
                if (this.getCRC().get(1).getiCnt() == Constants.TWO_OF_A_KIND) {
                	HandScorePoker HSP = (HandScorePoker) this.getHS();
    				HSP.seteHandStrength(eHandStrength.FullHouse);
    				int iGetCard = this.getCRC().get(0).getiCardPosition();
    				HSP.setHiCard(this.getCards().get(iGetCard));
    				HSP.setLoCard(this.getCards().get(this.getCRC().get(1).getiCardPosition()));
    				HSP.setKickers(FindTheKickers(this.getCRC()));
    				this.setHS(HSP);
                    bisFullHouse = true;
                }
            }
        }
		return bisFullHouse;

	}

	public boolean isFlush() {
		boolean bisFlush = false;

		int iCardCnt = super.getCards().size();
		int iSuitCnt = 0;

		for (eSuit eSuit : eSuit.values()) {
			for (Card c : super.getCards()) {
				if (eSuit == c.geteSuit()) {
					iSuitCnt++;
				}
			}
			if (iSuitCnt > 0)
				break;
		}

		// Note: to make the methods consistent, I add these.
		if (iSuitCnt == iCardCnt) {
            HandScorePoker HSP = (HandScorePoker) this.getHS();
            HSP.seteHandStrength(eHandStrength.Flush);
            int iGetCardHi = this.getCRC().get(0).getiCardPosition();
            HSP.setHiCard(this.getCards().get(iGetCardHi));
            HSP.setLoCard(null);
            HSP.setKickers(FindTheKickers(this.getCRC()));
            this.setHS(HSP);
		    bisFlush = true;
		}
		else
			bisFlush = false;

		return bisFlush;
	}

	public boolean isStraight() {
		boolean bisStraight = false;
		// DONE : Implement this method
		
		Card highCard = null;
        if (this.getCRC().size() == 5) {
            int FirstCardNrb = this.getCRC().get(0).geteRank().getiRankNbr();
            int LastCardNrb = this.getCRC().get(this.getCRC().size() - 1).geteRank().getiRankNbr();
            int secondCardNrb = this.getCRC().get(1).geteRank().getiRankNbr();
            
            if (!(this.getCRC().get(0).geteRank() == eRank.ACE) && !(this.getCRC().get(1).geteRank() == eRank.FIVE)) {
            	if (LastCardNrb == FirstCardNrb - 4)  {
                
                bisStraight = true;
                highCard = super.getCards().get(0);
            }
            
            } else {
            	if (LastCardNrb == secondCardNrb - 3)  {
                    
                    bisStraight = true;
                    highCard = super.getCards().get(1);
                }
            }
        }
		
		if(bisStraight) {
			HandScorePoker HSP = (HandScorePoker) this.getHS();
			HSP.seteHandStrength(eHandStrength.Straight);
			HSP.setHiCard(highCard);
			HSP.setLoCard(null);
			HSP.setKickers(null);
			this.setHS(HSP);	
		} else {
			
		}
        
		return bisStraight;
	}
        
	

	// This is how to implement one of the 'counting' hand types. Testing to see if
	// there are three of the same rank.
	public boolean isThreeOfAKind() {
		boolean bisThreeOfAKind = false;
		if (this.getCRC().size() == 3) {
			if (this.getCRC().get(0).getiCnt() == Constants.THREE_OF_A_KIND) {
				HandScorePoker HSP = (HandScorePoker) this.getHS();
				HSP.seteHandStrength(eHandStrength.ThreeOfAKind);
				int iGetCard = this.getCRC().get(0).getiCardPosition();
				HSP.setHiCard(this.getCards().get(iGetCard));
				HSP.setLoCard(null);
				HSP.setKickers(FindTheKickers(this.getCRC()));
				this.setHS(HSP);
				bisThreeOfAKind = true;
			}
		}
		return bisThreeOfAKind;
	}

	public boolean isTwoPair() {
		boolean bisTwoPair = false;
        // DONE : Implement this method
        if (this.getCRC().size() == 3) {
            if (this.getCRC().get(0).getiCnt() == Constants.TWO_OF_A_KIND) {
                if (this.getCRC().get(1).getiCnt() == Constants.TWO_OF_A_KIND) {
                	HandScorePoker HSP = (HandScorePoker) this.getHS();
    				HSP.seteHandStrength(eHandStrength.TwoPair);
    				int iGetCard = this.getCRC().get(0).getiCardPosition();
    				HSP.setHiCard(this.getCards().get(iGetCard));
    				HSP.setLoCard(null);
    				HSP.setKickers(FindTheKickers(this.getCRC()));
    				this.setHS(HSP);
                    bisTwoPair = true;
                }
            }
        }
		return bisTwoPair;
	}

	public boolean isPair() {
		boolean bisPair = false;
        // DONE : Implement this method
        if (this.getCRC().size() == 4) {
            if (this.getCRC().get(0).getiCnt() == Constants.TWO_OF_A_KIND) {
            	HandScorePoker HSP = (HandScorePoker) this.getHS();
				HSP.seteHandStrength(eHandStrength.Pair);
				int iGetCard = this.getCRC().get(0).getiCardPosition();
				HSP.setHiCard(this.getCards().get(iGetCard));
				HSP.setLoCard(null);
				HSP.setKickers(FindTheKickers(this.getCRC()));
				this.setHS(HSP);
                bisPair = true;
            }
        }
		return bisPair;
	}

	public boolean isHighCard() {
		boolean bisHighCard = false;
        // DONE : Implement this method
        if (this.getCRC().size() == 5) {
            HandScorePoker HSP = (HandScorePoker) this.getHS();
            HSP.seteHandStrength(eHandStrength.HighCard);
            int iGetCardHi = this.getCRC().get(0).getiCardPosition();
            HSP.setHiCard(this.getCards().get(iGetCardHi));
            HSP.setLoCard(null);
            HSP.setKickers(FindTheKickers(this.getCRC()));
            this.setHS(HSP);
            bisHighCard = true;
        }
		return bisHighCard;
	}

	private ArrayList<Card> FindTheKickers(ArrayList<CardRankCount> CRC) {
		ArrayList<Card> kickers = new ArrayList<Card>();

		for (CardRankCount crcCheck : CRC) {
			if (crcCheck.getiCnt() == 1) {
				kickers.add(this.getCards().get(crcCheck.getiCardPosition()));
			}
		}

		return kickers;
	}

	private void Frequency() {
		CRC = new ArrayList<CardRankCount>();
		int iCnt = 0;
		int iPos = 0;
		for (eRank eRank : eRank.values()) {
			iCnt = (CountRank(eRank));
			if (iCnt > 0) {
				iPos = FindCardRank(eRank);
				CRC.add(new CardRankCount(eRank, iCnt, iPos));
			}
		}
		Collections.sort(CRC);
	}

	private int CountRank(eRank eRank) {
		int iCnt = 0;
		for (Card c : super.getCards()) {
			if (c.geteRank() == eRank) {
				iCnt++;
			}
		}
		return iCnt;
	}

	private int FindCardRank(eRank eRank) {
		int iPos = 0;

		for (iPos = 0; iPos < super.getCards().size(); iPos++) {
			if (super.getCards().get(iPos).geteRank() == eRank) {
				break;
			}
		}
		return iPos;
	}

}
