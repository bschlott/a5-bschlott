package a4 ;


public class IngredientPortionImpl implements IngredientPortion {

	private Ingredient ingredient;
//	private String name;
	private double amount;
//	private double calories;
//	private double cost;
//	private boolean isVegetarian;
//	private boolean isRice;
//	private boolean isShellfish;

	
	public IngredientPortionImpl(Ingredient ingredient, double amount) {
		this.ingredient = ingredient;
		this.amount = amount;
	}

	@Override
	public Ingredient getIngredient() {
		// TODO Auto-generated method stub
		return ingredient;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return ingredient.getName();
	}

	@Override
	public double getAmount() {
		// TODO Auto-generated method stub
		return amount;
	}

	@Override
	public double getCalories() {
		// TODO Auto-generated method stub
		return ingredient.getCaloriesPerOunce() * amount;
	}

	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		return ingredient.getPricePerOunce() * amount;
	}

	@Override
	public boolean getIsVegetarian() {
		// TODO Auto-generated method stub
		return ingredient.getIsVegetarian();
	}

	@Override
	public boolean getIsRice() {
		// TODO Auto-generated method stub
		return ingredient.getIsRice();
	}

	@Override
	public boolean getIsShellfish() {
		// TODO Auto-generated method stub
		return ingredient.getIsShellfish();
	}

	@Override
	public IngredientPortion combine(IngredientPortion other) {
		if (other == null) {
			return this;
		}
		if (!other.getIngredient().equals(this.getIngredient())) {
			throw new RuntimeException("cannot combine weights of different ingredients");
		}
		return new IngredientPortionImpl(this.getIngredient(), this.amount + other.getAmount());


	}

}
