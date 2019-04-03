package a4 ;

public class IngredientImpl implements Ingredient {

	private String name;
	private double pricePerOunce;
	private int caloriesPerOunce;
	private boolean isVegetarian;
	private boolean isRice;
	private boolean isShellfish;
	
	public IngredientImpl(String name, double pricePerOunce, int caloriesPerOunce,
			boolean isVegetarian, boolean isRice, boolean isShellfish) {
		this.name = name;
		this.pricePerOunce = pricePerOunce;
		this.caloriesPerOunce = caloriesPerOunce;
		this.isVegetarian = isVegetarian;
		this.isRice = isRice;
		this.isShellfish = isShellfish;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public double getCaloriesPerDollar() {
		// TODO Auto-generated method stub
		return caloriesPerOunce/pricePerOunce;
	}

	@Override
	public int getCaloriesPerOunce() {
		// TODO Auto-generated method stub
		return caloriesPerOunce;
	}

	@Override
	public double getPricePerOunce() {
		// TODO Auto-generated method stub
		return pricePerOunce;
	}

	@Override
	// why isn't this getting called
	public boolean equals(Ingredient other) {
		if (this.name.equals(other.getName()) && Math.abs(this.caloriesPerOunce - other.getCaloriesPerOunce()) < .01) {
			return true;
		}
		return false;
	}

	@Override
	public boolean getIsVegetarian() {
		// TODO Auto-generated method stub
		return isVegetarian;
	}

	@Override
	public boolean getIsRice() {
		// TODO Auto-generated method stub
		return isRice;
	}

	@Override
	public boolean getIsShellfish() {
		// TODO Auto-generated method stub
		return isShellfish;
	}

}
