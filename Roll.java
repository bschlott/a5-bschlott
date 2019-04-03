package a4 ;

import java.util.ArrayList;

import java.util.List;

public class Roll implements Sushi {

	private String name;
	private IngredientPortion[] roll_ingredients;

	public Roll(String name, IngredientPortion[] roll_ingredients) {
		this.name = name;
		
		if (roll_ingredients == null) {
			throw new RuntimeException ("ingredient portion array cannot be null");
		}
		
		for (int i = 0; i < roll_ingredients.length; i++) {
			if (roll_ingredients[i] == null) {
				throw new RuntimeException("ingredient portion cannot be null");
			}
		}
		
		// this.roll_ingredients = roll_ingredients.clone();
		
		// combining any repeated ingredients 
		List<IngredientPortion> ingredients = new ArrayList<IngredientPortion>();
		for (int i = 0; i < roll_ingredients.length; i++) {
			IngredientPortion currentIngredient = roll_ingredients[i];
			if (ingredients.size() == 0) {
				ingredients.add(currentIngredient);
			} else {
				boolean hasCurrentIngredient = false;
				for (int j = 0; j < ingredients.size(); j++) {
					if (ingredients.get(j).getName().equals(currentIngredient.getName())) {
						ingredients.set(j, ingredients.get(j).combine(currentIngredient));
						hasCurrentIngredient = true;
					} 
				}
				if (!hasCurrentIngredient) {
					ingredients.add(currentIngredient);
				}
				
			}
		}
		
		// checking for/ adding minimum amount of seaweed
		boolean hasSeaweed = false;
		for(int i = 0; i < ingredients.size(); i++) {
			IngredientPortion currentIng = ingredients.get(i);
			if (currentIng.getName().equals("seaweed")) {
				hasSeaweed = true;
				if (currentIng.getAmount() < 0.1) {
					ingredients.set(i, new SeaweedPortion(0.1));
				}
			}
		}
		if (!hasSeaweed) {
			ingredients.add(new SeaweedPortion(0.1));
		}
		
		IngredientPortion[] ing = ingredients.toArray(new IngredientPortion[ingredients.size()]);
		this.roll_ingredients = ing.clone();

	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public IngredientPortion[] getIngredients() {
		// TODO Auto-generated method stub
		return roll_ingredients.clone();
	}

	@Override
	public int getCalories() {
		double totalCalories = 0;
		for (int i = 0; i < roll_ingredients.length; i++) {
			totalCalories += getIngredients()[i].getCalories();
		}
		return (int) Math.round(totalCalories);
	}

	@Override
	public double getCost() {
		double totalCost = 0;
		for (int i = 0; i < roll_ingredients.length; i++) {
			totalCost += getIngredients()[i].getCost();
		}
		return Math.round(totalCost * 100.0) / 100.0;
	}

	@Override
	public boolean getHasRice() {
		for (int i = 0; i < roll_ingredients.length; i++) {
			if (getIngredients()[i].getIsRice()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean getHasShellfish() {
		for (int i = 0; i < roll_ingredients.length; i++) {
			if (roll_ingredients[i].getIsShellfish()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean getIsVegetarian() {
		for (int i = 0; i < roll_ingredients.length; i++) {
			if (roll_ingredients[i].getIsVegetarian()) {
				return true;
			}
		}
		return false;
	}

}
