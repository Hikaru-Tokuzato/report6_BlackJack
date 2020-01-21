package jp.ac.uryukyu.ie.e195748;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * PCクラス:PCの基本的な思考やデータがある
 * また、ここではジャッジも行っているがmainクラスへの入力情報を減らす（見やすく）している為である
 */
public class PC extends blackJack {

    public List<String> pcList;
    public List<Integer> pcNumList;
    public int pcSum;
    public boolean pcBj = true;

    public PC(String name) {
        super();
        List<String> pcList = new ArrayList<String>();
        List<Integer> pcNumList = new ArrayList<Integer>();
        this.pcList = pcList;
        this.pcNumList = pcNumList;
        System.out.println(name + "のターン！");
    }

    @Override
    public void drawCard() {
        pcList.add(getTrampList().get(getTryNum()));
        pcNumList.add(getNumList().get(getTryNum()));
        sum();
        setTryNum(getTryNum() + 1);
    }

    public void sum() {
        int pcSum = 0;
        for (int i = 0; i < pcNumList.size(); i++) {
            pcSum += pcNumList.get(i);
            this.pcSum = pcSum;
            if (21 < pcSum) {
                if (pcNumList.contains(11)) {
                    for (int j = 0; j < pcNumList.size(); j++) {
                        if (pcNumList.get(j) == 11 && 21 < pcSum) {
                            pcNumList.set(j, 1);
                            if (pcNumList.get(j + 1) != pcNumList.size()) {
                                pcSum -= 10;
                                this.pcSum = pcSum;
                            }
                        }
                    }
                }
            }
        bj();
        }
    }

    public void bj(){
        if (pcNumList.size() != 2 || pcSum != 21) {
            pcBj = false;
        }
    }

    public void play(int npcSum,boolean npcBj) {
        drawCard();
        drawCard();
        while (true) {
            if (pcSum != 21) {
                if (pcSum < 21) {
                    System.out.println(String.format("現在,%s引いています", pcList));
                    System.out.println(String.format("合計は%dです", pcSum));
                    System.out.println("選択して下さい\n1:HIT\n2:STAY");
                    Scanner sc = new Scanner(System.in);
                    String st = sc.nextLine();
                    if (st.equals("1")) {
                        drawCard();
                    } else if (st.equals("2")) {
                        judge(pcSum,npcSum,pcBj,npcBj);
                        break;
                    }
                } else {
                    judge(pcSum, npcSum, false,npcBj);
                    break;
                }
            } else {
                judge(pcSum, npcSum, false,npcBj);
                break;
            }
        }
    }
}