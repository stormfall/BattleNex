package com.battlenex.game.players.skills.prayer;

import java.util.HashMap;

import com.battlenex.game.Client;
import com.battlenex.game.settings.Constants;
import com.battlenex.utils.Utils;

public class Prayer {

	
	/**
	 * Types of bones listed into the server.
	 */
        Client c;
               enum Bones {
                REGULAR(526, 5, "Bones"),
                BIG(532, 15, "Big Bones"),
                BABY_DRAG(534, 30, "Baby Dragon Bones"),
                DRAG(536, 72, "Dragon Bones"),
                DAG(6729, 125, "Dagannoth Bones"),
                BAT(530, 5, "Bat Bones"),
                WOLF(2859, 5, "Wolf Bones"),
                MONKEY(3179, 5, "Monkey Bones"),
                FROST(18830, 180, "Frost Dragon Bones"),
                ANCIENT(15410, 200, "Ancient Bones"),
                JOGRE(3125, 15, "Jogre Bones");

               
                static HashMap<Integer, Bones> BoneInfo = new HashMap<Integer, Bones>();

                int ID, XP;
                String Name;

                static {
                        for (final Bones b : BoneInfo.values())
                                Bones.BoneInfo.put(b.XP, b);
                }

                /**
                 *
                 * @param ID
                 * @param XP
                 * @param Name
                 */
                Bones(final int ID, final int XP, final String Name) {
                        this.ID = ID;
                        this.XP = XP;
                        this.Name = Name;
                }

                /**
                 *
                 * @return
                 */
                int getID() {
                        return ID;
                }

                /**
                 *
                 * @return
                 */
                int getXP() {
                        return XP;
                }

                /**
                 *
                 * @return
                 */
                String getName() {
                        return Name;
                }

        }

        public Prayer(Client c) {
                this.c = c;
        }
        

        /**
         * The ID of the bone.
         */
        public boolean IsABone(int ID) {
                for (final Bones b : Bones.values()) {
                        if (c.getItems().playerHasItem(b.getID(), 1)) {
                                if (b.getID() == ID) {
                                        return true;
                                }
                        }
                }
                return false;
        }

        /**
         * Burying bones.
         * @param itemSlot 
         */
        public void buryBone(int ID, int itemSlot) {
                if (System.currentTimeMillis() - c.buryDelay > 1500) {
                        for (final Bones b : Bones.values()) {
                                if (ID == b.getID()) {
                                        int doubleExperience = Utils.random(20);
                                        if (doubleExperience >= 1) {
                                                c.getItems().deleteItem(ID, 1);
                                                c.sendMessage("You bury some " + b.getName()+".");
                                                c.getPA().addSkillXP(b.getXP() * Constants.PRAYER_EXPERIENCE, 5);
                                                c.buryDelay = System.currentTimeMillis();
                                                c.startAnimation(827);
                                        } else if (doubleExperience == 0) {
                                                c.getItems().deleteItem(ID, 1);
                                                c.sendMessage("You bury some " + b.getName() + " and get double xp!");
                                                c.getPA().addSkillXP(b.getXP() * 2 * Constants.PRAYER_EXPERIENCE, 5);
                                                c.buryDelay = System.currentTimeMillis();
                                                c.startAnimation(827);
                                        }
                                }
                        }
                }
        }

        /**
         * Using bones on an altar.
         */
        public void bonesOnAltar(int ID) {
        int     Failure = Utils.random(40);
                for (final Bones b : Bones.values()) {
                        if (ID == b.getID()) {
                                if (Failure >= 1) {
                                        c.getItems().deleteItem(ID, 1);
                                        c.sendMessage("The God's accept your offering of " + b.getName()+".");
                                        c.getPA().addSkillXP(b.getXP() * 4 * Constants.PRAYER_EXPERIENCE, 5);
                                } else if (Failure == 0) {
                                        c.gfx100(287);
                                        c.startAnimation(3103);
                                        c.forcedChat("I'm sorry!");
                                        c.sendMessage("The gods are not satisfied with your offering.");
                                        c.setHitUpdateRequired2(true);
                                        c.setHitDiff2(10);
                                        c.updateRequired = true;
                                }
                        }
                }
        }
}