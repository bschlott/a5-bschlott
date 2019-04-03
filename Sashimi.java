package a4;

public class Sashimi implements Sushi {

	// composed of .75 oz of seafood
	public enum SashimiType {TUNA, YELLOWTAIL, EEL, CRAB, SHRIMP};
	
	private SashimiType type;
	
	public Sashimi(SashimiType type) {
		this.type = type;
	}

	@Override
	public String getName(){
		String rollName = type + " sashimi";
		return rollName.toLowerCase();
	}

	@Override
	public IngredientPortion[] getIngredients() {
		switch(type) {
		case TUNA:
			return new IngredientPortion[] { new TunaPortion(0.75)};
		case YELLOWTAIL:
			return new IngredientPortion[] { new YellowtailPortion(0.75)};
		case EEL:
			return new IngredientPortion[] { new EelPortion(0.75)};
		case CRAB:
			return new IngredientPortion[] { new CrabPortion(0.75)};
		case SHRIMP:
			return new IngredientPortion[] { new ShrimpPortion(0.75)};
		default:
			return new IngredientPortion[] {};
		}
	}

	@Override
	public int getCalories() {
		double totalCalories = 0;
		for (int i = 0; i < getIngredients().length; i++) {
			totalCalories += getIngredients()[i].getCalories();
		}
		return (int) Math.round(totalCalories);
	}

	@Override
	public double getCost() {
		double totalCost = 0;
		for (int i = 0; i < getIngredients().length; i++) {
			totalCost += getIngredients()[i].getCost();
		}
		return Math.round(totalCost * 100.0) / 100.0;
	}

	@Override
	public boolean getHasRice() {
		for (int i = 0; i < getIngredients().length; i++) {
			if (getIngredients()[i].getIsRice()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean getHasShellfish() {
		for (int i = 0; i < getIngredients().length; i++) {
			if (getIngredients()[i].getIsShellfish()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean getIsVegetarian() {
		for (int i = 0; i < getIngredients().length; i++) {
			if (getIngredients()[i].getIsVegetarian()) {
				return true;
			}
		}
		return false;
	}

}
