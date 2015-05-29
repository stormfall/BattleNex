package com.battlenex.game.objects;

import com.battlenex.Server;

public class Object {

	public Object(int id, int x, int y, int h, int f, int type) {
		this.id = id;
		this.x = x;
		this.y = y;
		setH(h);
		setF(f);
		this.type = type;
	}
	
	public int objectId;
	public int objectX;
	public int objectY;
	public int height;
	public int face;
	public int newId;
	public int tick;
	public int id, x, y, type;

	public Object(int id, int x, int y, int height, int face, int type,
			int newId, int ticks) {
		this.objectId = id;
		this.objectX = x;
		this.objectY = y;
		this.height = height;
		this.face = face;
		this.type = type;
		this.newId = newId;
		this.tick = ticks;
		Server.objectManager.addObject(this);
	}
	
	public Object(int x, int y){
		setX(x);
		setY(y);
	}

	public Object(int x, int y, int h){
		setX(x);
		setY(y);
		setH(h);
	}
	
	public Object(int x, int y, int h, int f){
		setX(x);
		setY(y);
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	public void setH(int h){
		this.h = h;
	}
	
	public void setF(int f){
		this.f = f;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getH() {
		return h;
	}
	
	public int getF() {
		return f;
	}
	
	private int h = -1;
	private int f = -1;
	
}