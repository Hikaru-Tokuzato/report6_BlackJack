package jp.ac.uryukyu.ie.e195748;

import java.util.ArrayList;
import java.util.List;

public class NPC extends blackJack {

    public List<String> npcList;
    public List<Integer> npcNumList;
    public int sum;
    public boolean ableContinue;
    public boolean bj = false;

    public NPC(String name) {
        super();
        List<String> pcList = new ArrayList<String>();
        List<Integer> pcNumList = new ArrayList<Integer>();
        this.npcList = pcList;
        this.npcNumList = pcNumList;
        System.out.println(name+"のターン！");
    }

    @Override
    public void drawCard() {
        npcList.add(getTrampList().get(getTryNum()));
        npcNumList.add(getNumList().get(getTryNum()));
        sum();
        setTryNum(getTryNum() + 1);
    }

    public void sum() {
        int sum = 0;
        for (int i = 0;i < npcNumList.size();i++){
            sum += npcNumList.get(i);
            this.sum = sum;
            if (21 < sum){
                if (npcNumList.contains(11)){
                    for (int j = 0;j < npcNumList.size();j++){
                        if (npcNumList.get(j) == 11 && 21 < sum){
                            npcNumList.set(j,1);
                            if (npcNumList.get(j+1) != npcNumList.size()) {
                                sum -= 10;
                                this.sum = sum;
                            }
                        }
                    }
                }
            }
        }
        if (21 < sum){
            ableContinue = false;
        } else {
            ableContinue = true;
        }
        if (npcNumList.size() == 2 && sum == 21){
            bj = true;
        }
    }
    public void play(){
        drawCard();
        while (true){
            if (ableContinue && sum <= 17){
                drawCard();
            } else {
                break;
            }
        }
    }
}