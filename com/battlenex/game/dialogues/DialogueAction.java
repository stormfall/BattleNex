package com.battlenex.game.dialogues;

public abstract class DialogueAction {
	
	public abstract void execute(DialogueContainer container);

	public void preExecution(DialogueContainer container) {
	
	};
}
