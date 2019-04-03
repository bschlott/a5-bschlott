package a4 ;

public class CrabPortion extends IngredientPortionImpl {

	private static Crab ingredient = new Crab();
	private double amount;
	
	public CrabPortion(double amount) {
		super(ingredient, amount);
		
		if (amount <= 0) {
			throw new RuntimeException("amount has to be greater than zero");
		}
		this.amount = amount;
	}
	
	// create specific combine method
	public CrabPortion combine(CrabPortion other) {
		if (other == null) {
			return this;
		}
		if (!other.getIngredient().equals(this.getIngredient())) {
			throw new RuntimeException("cannot combine amounts of different ingredients");
		}
		return new CrabPortion(this.amount + other.getAmount());
	}
}
