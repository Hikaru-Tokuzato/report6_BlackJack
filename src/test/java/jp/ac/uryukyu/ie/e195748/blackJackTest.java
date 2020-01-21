package jp.ac.uryukyu.ie.e195748;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class blackJackTest {
    //試しにジョーカーのカードを作成し、認識してみる
    @Test
    public void trumpCard() {
        List<Integer> intList = new ArrayList<Integer>();
        intList.add(53);
        List<String> trampList = new ArrayList<String>();
        List<Integer> numList = new ArrayList<Integer>();

        for (int i = 0; i < intList.size(); i++) {
            int cardNum = intList.get(i) % 13 + 1;
            int typeNum = intList.get(i) % 4 + 1;
            boolean jokerNum = intList.get(i) > 52;
            String cardName = String.valueOf(cardNum);
            switch (cardNum) {
                case 1:
                    cardName = "A";
                    cardNum = 11;
                    break;
                case 11:
                    cardNum = 10;
                    cardName = "J";
                    break;
                case 12:
                    cardNum = 10;
                    cardName = "Q";
                    break;
                case 13:
                    cardNum = 10;
                    cardName = "K";
                    break;
            }
            String typeName = "";
            switch (typeNum) {
                case 1:
                    typeName += "Spade";
                    break;
                case 2:
                    typeName += "Hart";
                    break;
                case 3:
                    typeName += "Dia";
                    break;
                case 4:
                    typeName += "Club";
                    break;
            }
            if (jokerNum){
                trampList.add("joker");
                numList.add(0);
            } else {
                trampList.add(typeName + "の" + cardName);
                numList.add(cardNum);
            }
        }
        System.out.println(trampList);
        System.out.println(numList);
    }
}