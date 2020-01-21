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
        pc.play(npc.npcSum,npc.npcBj);
        System.out.println("PC:" + pc.pcSum + "\n" + pc.pcList);
        System.out.println("NPC:" + npc.npcSum + "\n" + npc.npcList);
    }
}