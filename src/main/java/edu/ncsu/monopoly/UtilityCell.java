package edu.ncsu.monopoly;

public class UtilityCell extends Cell {

	public static final String COLOR_GROUP = "UTILITY";
	private static int PRICE;

	public static void setPrice(int price) {
		UtilityCell.PRICE = price;
	}

	public int getPrice() {
		return UtilityCell.PRICE;
	}

	public int getRent(int diceRoll) {
		if(proprietary.numberOfUtil() == 1) {
			return diceRoll * 4;
		} else if (proprietary.numberOfUtil() >= 2) {
			return diceRoll * 10;
		}
		return 0;
	}

	public void playAction() {
		Player currentPlayer = null;
		if(!isAvailable()) {
			currentPlayer = GameMaster.instance().getCurrentPlayer();
			if(proprietary != currentPlayer) {
				GameMaster.instance().utilRollDice();
				int diceRoll = GameMaster.instance().getUtilDiceRoll();
				currentPlayer.payRentTo(proprietary, getRent(diceRoll));
			}
		}
	}
}
