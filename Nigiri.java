package a4 ;

public class Nigiri implements Sushi {

	// composed of .75 oz of seafood and .5 oz of rice.
	public enum NigiriType {TUNA, YELLOWTAIL, EEL, CRAB, SHRIMP};
	
	private NigiriType type;
	
	public Nigiri(NigiriType type) {
		this.type = type;
	}
	
	@Override
	public String getName() {
		String rollName = type + " nigiri";
		return rollName.toLowerCase();
	}

	@Override
	public IngredientPortion[] getIngredients() {
		switch(type) {
		case TUNA:
			return new IngredientPortion[] { new TunaPortion(0.75), new RicePortion(0.5)};
		case YELLOWTAIL:
			return new IngredientPortion[] { new YellowtailPortion(0.75), new RicePortion(0.5)};
		case EEL:
			return new IngredientPortion[] { new EelPortion(0.75), new RicePortion(0.5)};
		case CRAB:
			return new IngredientPortion[] { new CrabPortion(0.75), new RicePortion(0.5)};
		case SHRIMP:
			return new IngredientPortion[] { new ShrimpPortion(0.75), new RicePortion(0.5)};
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
