package a4 ;

public class SeaweedPortion extends IngredientPortionImpl{

	private static Seaweed ingredient = new Seaweed();
	private double amount;
	
	public SeaweedPortion(double amount) {
		super(ingredient, amount);
		
		if (amount <= 0) {
			throw new RuntimeException("amount has to be greater than zero");
		}
		this.amount = amount;
	}
	
	// create specific combine method
	public SeaweedPortion combine(SeaweedPortion other) {
		if (other == null) {
			return this;
		}
		if (!other.getIngredient().equals(this.getIngredient())) {
			throw new RuntimeException("cannot combine amounts of different ingredients");
		}
		return new SeaweedPortion(this.amount + other.getAmount());
	}
}

