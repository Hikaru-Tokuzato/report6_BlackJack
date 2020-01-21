package jp.ac.uryukyu.ie.e195748;


import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        blackJack bj = new blackJack();
        bj.random_tramp();
        bj.trumpCard();
        NPC npc = new NPC("COM");
        npc.play();
        PC pc = new PC("Player");
        pc.drawCard();
        pc.drawCard();
        while (true){
            if (pc.ableContinue){
                if (pc.sum != 21) {
                    System.out.println(String.format("現在,%s引いています", pc.pcList));
                    System.out.println(String.format("合計は%dです", pc.sum));
                    System.out.println("選択して下さい\n1:HIT\n2:STAY");
                    Scanner sc = new Scanner(System.in);
                    String st = sc.nextLine();
                    if (st.equals("1")) {
                        pc.drawCard();
                    } else if (st.equals("2")){
                        pc.judge(pc.sum, npc.sum);
                        break;
                    }
                } else {
                    pc.judge(pc.sum, npc.sum);
                    break;
                }
            } else {
                pc.judge(pc.sum, npc.sum);
                break;
            }
        }
        System.out.println("PC:"+pc.sum+"\n"+pc.pcList);
        System.out.println("NPC:"+npc.sum+"\n"+npc.npcList);
    }
}