package a4 ;

public class ShrimpPortion extends IngredientPortionImpl{

	private static Shrimp ingredient = new Shrimp();
	private double amount;
	
	public ShrimpPortion(double amount) {
		super(ingredient, amount);
		
		if (amount <= 0) {
			throw new RuntimeException("amount has to be greater than zero");
		}
		this.amount = amount;
	}
	
	// create specific combine method
	public ShrimpPortion combine(ShrimpPortion other) {
		if (other == null) {
			return this;
		}
		if (!other.getIngredient().equals(this.getIngredient())) {
			throw new RuntimeException("cannot combine amounts of different ingredients");
		}
		return new ShrimpPortion(this.amount + other.getAmount());
	}
}
