package a4 ;

public class RicePortion extends IngredientPortionImpl{

	private static Rice ingredient = new Rice();
	private double amount;
	
	public RicePortion(double amount) {
		super(ingredient, amount);
		
		if (amount <= 0) {
			throw new RuntimeException("amount has to be greater than zero");
		}
		this.amount = amount;
	}
	
	// create specific combine method
	public RicePortion combine(RicePortion other) {
		if (other == null) {
			return this;
		}
		if (!other.getIngredient().equals(this.getIngredient())) {
			throw new RuntimeException("cannot combine amounts of different ingredients");
		}
		return new RicePortion(this.amount + other.getAmount());
	}
}

