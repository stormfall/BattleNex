package com.battlenex.cycle;

import com.battlenex.game.players.Player;

public final class BlockAnimationEvent extends CycleEvent {
	
	private final Player player;

	public BlockAnimationEvent(Player player) {
		super(1);
		this.player = player;
	}

	@Override
	public void execute() {
		player.blockAnim = true;
	}
}
