package com.battlenex.game.dialogues;

import com.battlenex.Server;
import com.battlenex.game.Client;

public class DialogueManager {

    private Client c;

    public DialogueManager(Client client) {
        this.c = client;
    }

    public void sendDialogues(int dialogue, int npcId) {
        c.talkingNpc = npcId;
        switch (dialogue) {
        case 0:
            c.talkingNpc = -1;
            c.getPA().removeAllWindows();
            c.nextChat = 0;
            break;
			case 71:
				sendNpcChat1("Welcome to BattleNex, you are about to begin the tutorial.", 945, "BattleNex Guide");
				c.nextChat = 72;
                c.getPA().Tutorial(10);
				c.Unclosable = 1;
                break;
			case 72:
				sendNpcChat3("Hello "+c.playerName+" welcome to BattleNex", "If you want to play in this server I need", "your help with something first.", 945, "BattleNex Guide");
                c.nextChat = 73;
                c.getPA().Tutorial(15);
				c.Unclosable = 1;
				break;
            case 73:
                sendPlayerChat1("Sure... If you really need the help.");
                c.nextChat = 74;
                c.getPA().Tutorial(25);
				c.Unclosable = 1;
                break;
			case 74:
				sendNpcChat3("Thanks "+c.playerName+"! It'll just take a second", "Somewhere on this island, there is a chest", "with items in it! Find it and it's yours!", 945, "BattleNex Guide");
                c.nextChat = 0;
                c.getPA().Tutorial(45);
				c.Unclosable = 1;
				break;
			case 75:
				sendNpcChat3("If you haven't already, equip the gear you got,", "because you're going to need it!", "MWUAHAHAHA", 945, "BattleNex Guide");
                c.nextChat = 76;
                c.tutorial = 2;
                c.getPA().Tutorial(60);
				c.Unclosable = 1;
				break;
			case 76:
				Server.npcHandler.spawnNpc(c, 3493, c.getX(), c.getY() - 1, 0, 1, 3, 1, 1, 1, true, true);
				c.tutorial = 3;
                c.getPA().Tutorial(75);
				c.Unclosable = 1;
				break;
			case 77:                
				c.tutorial = 4;
				sendNpcChat3("*laughing* You probably thought you were gonna die!!", "I'm glad you didn't and my prank is over.", "You can use the portal now.", 945, "BattleNex Guide");
                c.getPA().Tutorial(100);
				c.Unclosable = 1;
				break;
			case 78:
				sendNpcChat3("What are you still doing here?", "Leave before I get annoyed and", "decide to kill you!.", 945, "BattleNex Guide");
				c.nextChat = 0;
                break;
                
        }







    }

    /*
     * Information Box
     */

    public void sendStartInfo(String text, String text1, String text2, String text3, String title) {
        c.getPA().sendFrame126(title, 6180);
        c.getPA().sendFrame126(text, 6181);
        c.getPA().sendFrame126(text1, 6182);
        c.getPA().sendFrame126(text2, 6183);
        c.getPA().sendFrame126(text3, 6184);
        c.getPA().sendFrame164(6179);
    }

    /*
     * Options
     */

    private void sendOption(String s, String s1) {
        c.getPA().sendFrame126("Select an Option", 2470);
        c.getPA().sendFrame126(s, 2471);
        c.getPA().sendFrame126(s1, 2472);
        c.getPA().sendFrame126("Click here to continue", 2473);
        c.getPA().sendFrame164(13758);
    }

    public void sendOption2(String s, String s1) {
        c.getPA().sendFrame126("Select an Option", 2460);
        c.getPA().sendFrame126(s, 2461);
        c.getPA().sendFrame126(s1, 2462);
        c.getPA().sendFrame164(2459);
    }

    private void sendOption3(String s, String s1, String s2) {
        c.getPA().sendFrame126("Select an Option", 2470);
        c.getPA().sendFrame126(s, 2471);
        c.getPA().sendFrame126(s1, 2472);
        c.getPA().sendFrame126(s2, 2473);
        c.getPA().sendFrame164(2469);
    }

    public void sendOption4(String s, String s1, String s2, String s3) {
        c.getPA().sendFrame126("Select an Option", 2481);
        c.getPA().sendFrame126(s, 2482);
        c.getPA().sendFrame126(s1, 2483);
        c.getPA().sendFrame126(s2, 2484);
        c.getPA().sendFrame126(s3, 2485);
        c.getPA().sendFrame164(2480);
    }

    public void sendOption5(String s, String s1, String s2, String s3, String s4) {
        c.getPA().sendFrame126("Select an Option", 2493);
        c.getPA().sendFrame126(s, 2494);
        c.getPA().sendFrame126(s1, 2495);
        c.getPA().sendFrame126(s2, 2496);
        c.getPA().sendFrame126(s3, 2497);
        c.getPA().sendFrame126(s4, 2498);
        c.getPA().sendFrame164(2492);
    }

    /*
     * Statements
     */

    public void sendStatement(String s) { // 1 line click here to continue chat box interface
        c.getPA().sendFrame126(s, 357);
        c.getPA().sendFrame126("Click here to continue", 358);
        c.getPA().sendFrame164(356);
    }

    /*
     * Npc Chatting
     */

    private void sendNpcChat1(String s, int ChatNpc, String name) {
        c.getPA().sendFrame200(4883, 591);
        c.getPA().sendFrame126(name, 4884);
        c.getPA().sendFrame126(s, 4885);
        c.getPA().sendFrame75(ChatNpc, 4883);
        c.getPA().sendFrame164(4882);
    }

    public void sendNpcChat2(String s, String s1, int ChatNpc, String name) {
        c.getPA().sendFrame200(4888, 9847);
        c.getPA().sendFrame126(name, 4889);
        c.getPA().sendFrame126(s, 4890);
        c.getPA().sendFrame126(s1, 4891);
        c.getPA().sendFrame75(ChatNpc, 4888);
        c.getPA().sendFrame164(4887);
    }

    public void sendNpcChat3(String s, String s1, String s2, int ChatNpc, String name) {
        c.getPA().sendFrame200(4894, 9847); //Was 591
        c.getPA().sendFrame126(name, 4895);
        c.getPA().sendFrame126(s, 4896);
        c.getPA().sendFrame126(s1, 4897);
        c.getPA().sendFrame126(s2, 4898);
        c.getPA().sendFrame75(ChatNpc, 4894);
        c.getPA().sendFrame164(4893);
    }


    private void sendNpcChat4(String s, String s1, String s2, String s3, int ChatNpc, String name) {
        c.getPA().sendFrame200(4901, 9847);
        c.getPA().sendFrame126(name, 4902);
        c.getPA().sendFrame126(s, 4903);
        c.getPA().sendFrame126(s1, 4904);
        c.getPA().sendFrame126(s2, 4905);
        c.getPA().sendFrame126(s3, 4906);
        c.getPA().sendFrame75(ChatNpc, 4901);
        c.getPA().sendFrame164(4900);
    }

    /*
     * Player Chating Back
     */

    private void sendPlayerChat1(String s) {
        c.getPA().sendFrame200(969, 591);
        c.getPA().sendFrame126(c.playerName, 970);
        c.getPA().sendFrame126(s, 971);
        c.getPA().sendFrame185(969);
        c.getPA().sendFrame164(968);
    }

    private void sendPlayerChat2(String s, String s1) {
        c.getPA().sendFrame200(974, 591);
        c.getPA().sendFrame126(c.playerName, 975);
        c.getPA().sendFrame126(s, 976);
        c.getPA().sendFrame126(s1, 977);
        c.getPA().sendFrame185(974);
        c.getPA().sendFrame164(973);
    }

    private void sendPlayerChat3(String s, String s1, String s2) {
        c.getPA().sendFrame200(980, 591);
        c.getPA().sendFrame126(c.playerName, 981);
        c.getPA().sendFrame126(s, 982);
        c.getPA().sendFrame126(s1, 983);
        c.getPA().sendFrame126(s2, 984);
        c.getPA().sendFrame185(980);
        c.getPA().sendFrame164(979);
    }

    private void sendPlayerChat4(String s, String s1, String s2, String s3) {
        c.getPA().sendFrame200(987, 591);
        c.getPA().sendFrame126(c.playerName, 988);
        c.getPA().sendFrame126(s, 989);
        c.getPA().sendFrame126(s1, 990);
        c.getPA().sendFrame126(s2, 991);
        c.getPA().sendFrame126(s3, 992);
        c.getPA().sendFrame185(987);
        c.getPA().sendFrame164(986);
    }
    public void itemMessage(String title, String message, int itemid, int size) {
        c.getPA().sendFrame200(4883, 591);
        c.getPA().sendFrame126(title, 4884);
        c.getPA().sendFrame126(message, 4885);
        c.getPA().sendFrame126("Click here to continue.", 4886);
        c.getPA().sendFrame246(4883, size, itemid);
        c.getPA().sendFrame164(4882);
    }
}