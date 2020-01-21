package jp.ac.uryukyu.ie.e195748;

import java.util.ArrayList;
import java.util.List;

public class NPC extends blackJack {

    public List<String> npcList;
    public List<Integer> npcNumList;
    public int npcSum;
    public boolean npcBj = true;

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
        int npcSum = 0;
        for (int i = 0;i < npcNumList.size();i++){
            npcSum += npcNumList.get(i);
            this.npcSum = npcSum;
            if (21 < npcSum){
                if (npcNumList.contains(11)){
                    for (int j = 0;j < npcNumList.size();j++){
                        if (npcNumList.get(j) == 11 && 21 < npcSum){
                            npcNumList.set(j,1);
                            if (npcNumList.get(j+1) != npcNumList.size()) {
                                npcSum -= 10;
                                this.npcSum = npcSum;
                            }
                        }
                    }
                }
            }
            bj();
        }
    }
    public void bj(){
        if (npcNumList.size() != 2 || npcSum != 21){
            this.npcBj = false;
        }
    }
    public void play(){
        drawCard();
        while (true){
            if (npcSum <= 17){
                drawCard();
            } else {
                break;
            }
        }
    }
}