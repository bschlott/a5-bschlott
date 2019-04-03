package a4 ;

public class YellowtailPortion extends IngredientPortionImpl{

	private static Yellowtail ingredient = new Yellowtail();
	private double amount;
	
	public YellowtailPortion(double amount) {
		super(ingredient, amount);
		
		if (amount <= 0) {
			throw new RuntimeException("amount has to be greater than zero");
		}
		
		this.amount = amount;
	}
	
	// create specific combine method
	public YellowtailPortion combine(YellowtailPortion other) {
		if (other == null) {
			return this;
		}
		if (!other.getIngredient().equals(this.getIngredient())) {
			throw new RuntimeException("cannot combine amounts of different ingredients");
		}
		return new YellowtailPortion(this.amount + other.getAmount());
	}
}

