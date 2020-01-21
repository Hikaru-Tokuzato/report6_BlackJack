package jp.ac.uryukyu.ie.e195748;

/** @author e195748 */

public class main {
    /**
     * メインメソッド
     * @param args
     */
    public static void main(String[] args) {
        blackJack bj = new blackJack();
        bj.random_tramp();
        bj.trumpCard();
        NPC npc = new NPC("COM");
        npc.play();
        PC pc = new PC("Player");
        pc.play(npc.sum);
        System.out.println("PC:"+pc.sum+"\n"+pc.pcList);
        System.out.println("NPC:"+npc.sum+"\n"+npc.npcList);
    }
}