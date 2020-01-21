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
    public int sum;
    public boolean ableContinue;
    public boolean bj = false;

    public PC(String name) {
        super();
        List<String> pcList = new ArrayList<String>();
        List<Integer> pcNumList = new ArrayList<Integer>();
        this.pcList = pcList;
        this.pcNumList = pcNumList;
        System.out.println(name+"のターン！");
    }

    @Override
    public void drawCard() {
        pcList.add(getTrampList().get(getTryNum()));
        pcNumList.add(getNumList().get(getTryNum()));
        sum();
        setTryNum(getTryNum() + 1);
    }

    public void sum() {
        int sum = 0;
        for (int i = 0; i < pcNumList.size(); i++) {
            sum += pcNumList.get(i);
            this.sum = sum;
            if (21 < sum) {
                if (pcNumList.contains(11)) {
                    for (int j = 0; j < pcNumList.size(); j++) {
                        if (pcNumList.get(j) == 11 && 21 < sum) {
                            pcNumList.set(j, 1);
                            if (pcNumList.get(j + 1) != pcNumList.size()) {
                                sum -= 10;
                                this.sum = sum;
                            }
                        }
                    }
                }
            }

        }
        if (21 < sum) {
            ableContinue = false;
        } else {
            ableContinue = true;
        }
        if (pcNumList.size() == 2 && sum == 21) {
            bj = true;
        }
    }
}
