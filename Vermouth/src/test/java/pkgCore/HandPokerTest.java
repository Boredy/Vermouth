package pkgCore;

import static org.junit.Assert.*;

import org.junit.Test;

import pkgEnum.eRank;
import pkgEnum.eSuit;

public class HandPokerTest {
    
    // Royal Flush: 1 test
    @Test
    public void RoyalFlushTest1() {
        System.out.println("Royal Flush:");
        System.out.println("10,J,Q,K,A");
        HandPoker hp = new HandPoker();
        hp.AddCard(new Card(eSuit.CLUBS,eRank.TEN));
        hp.AddCard(new Card(eSuit.CLUBS,eRank.JACK));
        hp.AddCard(new Card(eSuit.CLUBS,eRank.QUEEN));
        hp.AddCard(new Card(eSuit.CLUBS,eRank.KING));
        hp.AddCard(new Card(eSuit.CLUBS,eRank.ACE));
        hp.ScoreHand();
        
        assertEquals(hp.isRoyalFlush(), true);
        
        System.out.println("");
    }
    
    // Royal Flush: negative test
    @Test
    public void RoyalFlushNegTest1() {
        System.out.println("Fake Royal Flush:");
        System.out.println("9,10,J,Q,K");
        HandPoker hp = new HandPoker();
        hp.AddCard(new Card(eSuit.CLUBS,eRank.NINE));
        hp.AddCard(new Card(eSuit.CLUBS,eRank.TEN));
        hp.AddCard(new Card(eSuit.CLUBS,eRank.JACK));
        hp.AddCard(new Card(eSuit.CLUBS,eRank.QUEEN));
        hp.AddCard(new Card(eSuit.CLUBS,eRank.KING));
        hp.ScoreHand();
        
        assertEquals(hp.isRoyalFlush(), false);
        
        System.out.println("");
    }
    
    // Straight Flush: 1 test
    @Test
    public void StraightFlushTest1() {
        System.out.println("Straight Flush:");
        System.out.println("9,10,J,Q,K");
        HandPoker hp = new HandPoker();
        hp.AddCard(new Card(eSuit.CLUBS,eRank.NINE));
        hp.AddCard(new Card(eSuit.CLUBS,eRank.TEN));
        hp.AddCard(new Card(eSuit.CLUBS,eRank.JACK));
        hp.AddCard(new Card(eSuit.CLUBS,eRank.QUEEN));
        hp.AddCard(new Card(eSuit.CLUBS,eRank.KING));
        hp.ScoreHand();
        
        assertEquals(hp.isStraightFlush(), true);
        
        System.out.println("");
    }
    // Four Of a Kind: 2 tests
    @Test
    public void FourOfAKindTest1() {
        System.out.println("Four of a Kind");
        System.out.println("KKKKA");
        HandPoker hp = new HandPoker();
        hp.AddCard(new Card(eSuit.CLUBS,eRank.KING));
        hp.AddCard(new Card(eSuit.HEARTS,eRank.KING));
        hp.AddCard(new Card(eSuit.DIAMONDS,eRank.KING));
        hp.AddCard(new Card(eSuit.SPADES,eRank.KING));
        hp.AddCard(new Card(eSuit.CLUBS,eRank.ACE));
        hp.ScoreHand();
        
        assertEquals(hp.isFourOfAKind(), true);
        
        System.out.println("");
    }
    
    @Test
    public void FourOfAKindTest2() {
        System.out.println("Four of a Kind");
        System.out.println("JQQQQ");
        HandPoker hp = new HandPoker();
        hp.AddCard(new Card(eSuit.CLUBS,eRank.JACK));
        hp.AddCard(new Card(eSuit.CLUBS,eRank.QUEEN));
        hp.AddCard(new Card(eSuit.HEARTS,eRank.QUEEN));
        hp.AddCard(new Card(eSuit.DIAMONDS,eRank.QUEEN));
        hp.AddCard(new Card(eSuit.SPADES,eRank.QUEEN));
        hp.ScoreHand();
        
        assertEquals(hp.isFourOfAKind(), true);
        
        System.out.println("");
    }
    
    // Full house: 2 tests
    @Test
    public void FullHouseTest1() {
        System.out.println("Full House");
        System.out.println("22555");
        HandPoker hp = new HandPoker();
        hp.AddCard(new Card(eSuit.CLUBS,eRank.TWO));
        hp.AddCard(new Card(eSuit.HEARTS,eRank.TWO));
        hp.AddCard(new Card(eSuit.DIAMONDS,eRank.FIVE));
        hp.AddCard(new Card(eSuit.SPADES,eRank.FIVE));
        hp.AddCard(new Card(eSuit.CLUBS,eRank.FIVE));
        hp.ScoreHand();
        
        assertEquals(hp.isFullHouse(), true);
        
        System.out.println("");
    }
    
    @Test
    public void FullHouseTest2() {
        System.out.println("Full house");
        System.out.println("KKKAA");
        HandPoker hp = new HandPoker();
        hp.AddCard(new Card(eSuit.CLUBS,eRank.KING));
        hp.AddCard(new Card(eSuit.HEARTS,eRank.KING));
        hp.AddCard(new Card(eSuit.DIAMONDS,eRank.KING));
        hp.AddCard(new Card(eSuit.CLUBS,eRank.ACE));
        hp.AddCard(new Card(eSuit.SPADES,eRank.ACE));
        hp.ScoreHand();

        assertEquals(hp.isFullHouse(), true);
        
        System.out.println("");
    }
    
    // Flush: 1 test
    @Test
    public void FlushTest1() {
        System.out.println("Flush");
        System.out.println("C2 C3 C4 C6 C7");
        HandPoker hp = new HandPoker();
        hp.AddCard(new Card(eSuit.CLUBS,eRank.TWO));
        hp.AddCard(new Card(eSuit.CLUBS,eRank.THREE));
        hp.AddCard(new Card(eSuit.CLUBS,eRank.FOUR));
        hp.AddCard(new Card(eSuit.CLUBS,eRank.SIX));
        hp.AddCard(new Card(eSuit.CLUBS,eRank.SEVEN));
        hp.ScoreHand();

        assertEquals(hp.isFlush(), true);
        
        System.out.println("");
    }
    
    // Straight: 2 test
    @Test
    public void StraightTest1() {
        System.out.println("Straight");
        System.out.println("C-Ace C2 S3 C4 C5");
        HandPoker hp = new HandPoker();
        hp.AddCard(new Card(eSuit.CLUBS,eRank.ACE));
        hp.AddCard(new Card(eSuit.CLUBS,eRank.TWO));
        hp.AddCard(new Card(eSuit.SPADES,eRank.THREE));
        hp.AddCard(new Card(eSuit.CLUBS,eRank.FOUR));
        hp.AddCard(new Card(eSuit.CLUBS,eRank.FIVE));
        hp.ScoreHand();

        assertEquals(hp.isStraight(), true);
        
        System.out.println("");
    }
    
    @Test
    public void StraightTest2() {
        System.out.println("Straight");
        System.out.println("C10 C9 S8 C7 C6");
        HandPoker hp = new HandPoker();
        hp.AddCard(new Card(eSuit.CLUBS,eRank.TEN));
        hp.AddCard(new Card(eSuit.CLUBS,eRank.NINE));
        hp.AddCard(new Card(eSuit.SPADES,eRank.EIGHT));
        hp.AddCard(new Card(eSuit.CLUBS,eRank.SEVEN));
        hp.AddCard(new Card(eSuit.CLUBS,eRank.SIX));
        hp.ScoreHand();

        assertEquals(hp.isStraight(), true);
        
        System.out.println("");
    }
    
    // Three of a kind: 3 tests
    @Test
    public void ThreeOfAKindTest1() {
        System.out.println("Three of a Kind");
        System.out.println("22253");
        HandPoker hp = new HandPoker();
        hp.AddCard(new Card(eSuit.CLUBS,eRank.TWO));
        hp.AddCard(new Card(eSuit.HEARTS,eRank.TWO));
        hp.AddCard(new Card(eSuit.DIAMONDS,eRank.TWO));
        hp.AddCard(new Card(eSuit.CLUBS,eRank.THREE));
        hp.AddCard(new Card(eSuit.SPADES,eRank.FIVE));
        hp.ScoreHand();
        
        assertEquals(hp.isThreeOfAKind(), true);
        
        System.out.println("");
    }
    
    @Test
    public void ThreeOfAKindTest2() {
        System.out.println("Three of a Kind");
        System.out.println("23335");
        HandPoker hp = new HandPoker();
        hp.AddCard(new Card(eSuit.CLUBS,eRank.TWO));
        hp.AddCard(new Card(eSuit.HEARTS,eRank.THREE));
        hp.AddCard(new Card(eSuit.DIAMONDS,eRank.THREE));
        hp.AddCard(new Card(eSuit.CLUBS,eRank.THREE));
        hp.AddCard(new Card(eSuit.SPADES,eRank.FIVE));
        hp.ScoreHand();
        
        assertEquals(hp.isThreeOfAKind(), true);
        
        System.out.println("");
    }
    
    @Test
    public void ThreeOfAKindTest3() {
        System.out.println("Three of a Kind");
        System.out.println("23555");
        HandPoker hp = new HandPoker();
        hp.AddCard(new Card(eSuit.DIAMONDS,eRank.TWO));
        hp.AddCard(new Card(eSuit.CLUBS,eRank.THREE));
        hp.AddCard(new Card(eSuit.CLUBS,eRank.FIVE));
        hp.AddCard(new Card(eSuit.HEARTS,eRank.FIVE));
        hp.AddCard(new Card(eSuit.SPADES,eRank.FIVE));
        hp.ScoreHand();
        
        assertEquals(hp.isThreeOfAKind(), true);
        
        System.out.println("");
    }
	
    // Two pairs: 3 tests
    @Test
    public void TwoPairTest1() {
        System.out.println("Two Pairs");
        System.out.println("23355");
        HandPoker hp = new HandPoker();
        hp.AddCard(new Card(eSuit.CLUBS,eRank.TWO));
        hp.AddCard(new Card(eSuit.HEARTS,eRank.THREE));
        hp.AddCard(new Card(eSuit.CLUBS,eRank.THREE));
        hp.AddCard(new Card(eSuit.DIAMONDS,eRank.FIVE));
        hp.AddCard(new Card(eSuit.SPADES,eRank.FIVE));
        hp.ScoreHand();
        
        assertEquals(hp.isTwoPair(), true);
        
        System.out.println("");
    }

    @Test
    public void TwoPairTest2() {
        System.out.println("Two Pairs");
        System.out.println("22355");
        HandPoker hp = new HandPoker();
        hp.AddCard(new Card(eSuit.CLUBS,eRank.TWO));
        hp.AddCard(new Card(eSuit.HEARTS,eRank.TWO));
        hp.AddCard(new Card(eSuit.CLUBS,eRank.THREE));
        hp.AddCard(new Card(eSuit.DIAMONDS,eRank.FIVE));
        hp.AddCard(new Card(eSuit.SPADES,eRank.FIVE));
        hp.ScoreHand();
        
        assertEquals(hp.isTwoPair(), true);
        
        System.out.println("");
    }

    @Test
    public void TwoPairTest3() {
        System.out.println("Two Pairs");
        System.out.println("22335");
        HandPoker hp = new HandPoker();
        hp.AddCard(new Card(eSuit.CLUBS,eRank.TWO));
        hp.AddCard(new Card(eSuit.HEARTS,eRank.TWO));
        hp.AddCard(new Card(eSuit.CLUBS,eRank.THREE));
        hp.AddCard(new Card(eSuit.DIAMONDS,eRank.THREE));
        hp.AddCard(new Card(eSuit.SPADES,eRank.FIVE));
        hp.ScoreHand();
        
        assertEquals(hp.isTwoPair(), true);
        
        System.out.println("");
    }
   
    // One pair: 4 tests
    @Test
    public void OnePairTest1() {
        System.out.println("One Pair");
        System.out.println("22345");
        HandPoker hp = new HandPoker();
        hp.AddCard(new Card(eSuit.CLUBS,eRank.TWO));
        hp.AddCard(new Card(eSuit.HEARTS,eRank.TWO));
        hp.AddCard(new Card(eSuit.CLUBS,eRank.THREE));
        hp.AddCard(new Card(eSuit.DIAMONDS,eRank.FOUR));
        hp.AddCard(new Card(eSuit.SPADES,eRank.FIVE));
        hp.ScoreHand();
        
        assertEquals(hp.isPair(), true);
        
        System.out.println("");
    }
    
    @Test
    public void OnePairTest2() {
        System.out.println("One Pair");
        System.out.println("23345");
        HandPoker hp = new HandPoker();
        hp.AddCard(new Card(eSuit.CLUBS,eRank.TWO));
        hp.AddCard(new Card(eSuit.HEARTS,eRank.THREE));
        hp.AddCard(new Card(eSuit.CLUBS,eRank.THREE));
        hp.AddCard(new Card(eSuit.DIAMONDS,eRank.FOUR));
        hp.AddCard(new Card(eSuit.SPADES,eRank.FIVE));
        hp.ScoreHand();
        
        assertEquals(hp.isPair(), true);
        
        System.out.println("");
    }
    
    @Test
    public void OnePairTest3() {
        System.out.println("One Pair");
        System.out.println("23445");
        HandPoker hp = new HandPoker();
        hp.AddCard(new Card(eSuit.CLUBS,eRank.TWO));
        hp.AddCard(new Card(eSuit.CLUBS,eRank.THREE));
        hp.AddCard(new Card(eSuit.HEARTS,eRank.FOUR));
        hp.AddCard(new Card(eSuit.DIAMONDS,eRank.FOUR));
        hp.AddCard(new Card(eSuit.SPADES,eRank.FIVE));
        hp.ScoreHand();
        
        assertEquals(hp.isPair(), true);
        
        System.out.println("");
    }
    
    @Test
    public void OnePairTest4() {
        System.out.println("One Pair");
        System.out.println("23455");
        HandPoker hp = new HandPoker();
        hp.AddCard(new Card(eSuit.CLUBS,eRank.TWO));
        hp.AddCard(new Card(eSuit.CLUBS,eRank.THREE));
        hp.AddCard(new Card(eSuit.DIAMONDS,eRank.FOUR));
        hp.AddCard(new Card(eSuit.HEARTS,eRank.FIVE));
        hp.AddCard(new Card(eSuit.SPADES,eRank.FIVE));
        hp.ScoreHand();
        
        assertEquals(hp.isPair(), true);
        
        System.out.println("");
    }

    // High card: 1 test
    @Test
    public void HighCardTest4() {
        System.out.println("High Card");
        System.out.println("24568");
        HandPoker hp = new HandPoker();
        hp.AddCard(new Card(eSuit.CLUBS,eRank.TWO));
        hp.AddCard(new Card(eSuit.CLUBS,eRank.FOUR));
        hp.AddCard(new Card(eSuit.DIAMONDS,eRank.FIVE));
        hp.AddCard(new Card(eSuit.HEARTS,eRank.SEVEN));
        hp.AddCard(new Card(eSuit.SPADES,eRank.EIGHT));
        hp.ScoreHand();
        
        assertEquals(hp.isHighCard(), true);
        
        System.out.println("");
    }
}
