package a4 ;

public class TunaPortion extends IngredientPortionImpl{

	private static Tuna ingredient = new Tuna();
	private double amount;
	
	public TunaPortion(double amount) {
		super(ingredient, amount);
		
		if (amount <= 0) {
			throw new RuntimeException("amount has to be greater than zero");
		}
		this.amount = amount;
	}
	
	// create specific combine method
	public TunaPortion combine(TunaPortion other) {
		if (other == null) {
			return this;
		}
		if (!other.getIngredient().equals(this.getIngredient())) {
			throw new RuntimeException("cannot combine amounts of different ingredients");
		}
		return new TunaPortion(this.amount + other.getAmount());
	}
}
