package com.battlenex.world;

public class Tile
{
	public Tile(int x, int y){
		setX(x);
		setY(y);
	}

	public Tile(int x, int y, int h){
		setX(x);
		setY(y);
		setH(h);
	}
	
	public Tile(int x, int y, int h, int f){
		setX(x);
		setY(y);
		setH(h);
		setF(f);
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
	
	private int x = -1;
	private int y = -1;
	private int h = -1;
	private int f = -1;
	public int[] getTile() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private int[] pointer = new int[3];
		
		
	public int getTileX() {
		return pointer[0];
	}
		
	public int getTileY() {
		return pointer[1];
	}
		
	public int getTileHeight() {
		return pointer[2];
	}

	}

