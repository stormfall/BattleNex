package com.battlenex.game;

public abstract class Entity {
	
	public int absX, absY;
	public double attackMultiplier, rangedMultiplier, defenceMultiplier, magicMultiplier, strengthMultiplier, curseOdds;

	public void resetMultipliers() {
		attackMultiplier = rangedMultiplier = defenceMultiplier = magicMultiplier = strengthMultiplier = 1.0;
		curseOdds = 0.0;
	}

	public Entity() {
		resetMultipliers();
	}

	public int getX() {
		return absX;
	}

	public int getY() {
		return absY;
	}

	public abstract void setHitDiff(int value);
	public abstract void setHitDiff2(int value);
	public abstract int getHitDiff();
	public abstract boolean getHitUpdateRequired();
	public abstract boolean getHitUpdateRequired2();
	public abstract void setUpdateRequired(boolean value);
	public abstract void setHitUpdateRequired(boolean value);
	public abstract void setHitUpdateRequired2(boolean value);
	public abstract void forceAnim(int animId);
	public abstract void gfx100(int gfx);
	public abstract void gfx0(int gfx);
}
