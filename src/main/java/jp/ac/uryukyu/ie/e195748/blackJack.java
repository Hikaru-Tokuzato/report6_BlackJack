package jp.ac.uryukyu.ie.e195748;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class blackJack {
    private static List<Integer> intList;
    private static int tryNum;
    private static List<String> trampList;
    private static List<Integer> numList;

    public int getTryNum() {
        return tryNum;
    }
    public void setTryNum(int tryNum) {
        this.tryNum = tryNum;
    }
    public List<String> getTrampList() {
        return trampList;
    }
    public List<Integer> getNumList() {
        return numList;
    }

    public void random_tramp() {
        List<Integer> intList = new ArrayList<Integer>();
        blackJack.intList = intList;
        Random random = new Random();
        for (int i = 0; i < 52; i++) {
            intList.add(i);
        }
        //10000回程入れ替え作業を行う。お好みに変更可能だが、多ければ多い程処理が増す分ランダム性が高い。
        for (int n = 1; n < 10000; n++) {
            int x = random.nextInt(52);
            int y = random.nextInt(52);
            int x_get = intList.get(x);
            int y_get = intList.get(y);
            intList.set(x, y_get);
            intList.set(y, x_get);
        }
    }

    public void trumpCard() {
        List<String> trampList = new ArrayList<String>();
        blackJack.trampList = trampList;
        List<Integer> numList = new ArrayList<Integer>();
        blackJack.numList = numList;
        for (int i = 0; i < intList.size(); i++) {
            //番号の識別
            int cardNum = intList.get(i) % 13 + 1;
            //種類の識別
            int typeNum = intList.get(i) % 4 + 1;
            //A,J,Q,Kを代入する為にパースする(int to String)
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
            trampList.add(typeName + "の" + cardName);
            numList.add(cardNum);
        }
    }

    public void drawCard() {
    }

    public void judge(int pcSum, int npcSum) {
        /* 勝利条件は、PCが21以下の時NPCよりも数が多ければ良い。
         * 但し、BJ（ブラックジャック）{10,J,Q,K + A}が最高であり、ディーラーが優先である。
         */
        if (pcSum <= 21) {
            if (npcSum <= 21) {
                if (pcSum > npcSum) {
                    System.out.println("YOU WIN");
                } else if (pcSum == npcSum) {
                    System.out.println("DRAW");
                } else {
                    System.out.println("YOU LOSE");
                }
            } else {
                System.out.println("NPC BUST");
                System.out.println("YOU WIN");
            }
    } else {
        System.out.println("YOU BUST");
        System.out.println("YOU LOSE");
        }
    }
}