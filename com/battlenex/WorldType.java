package com.battlenex;

public enum WorldType {

	REGULAR("Regular"),
	PVP("PVP"),
	MEMBERS("Members"),
	OLD_SCHOOL("Old School"),
	TEST("TEST");
	
	private final String directory;

	WorldType(String directory) {
		this.directory = directory;
	}

	public String getDirectory() {
		return directory;
	}
}
