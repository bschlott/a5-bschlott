package a4 ;

public class AvocadoPortion extends IngredientPortionImpl{

	private static Avocado ingredient = new Avocado();
	private double amount;
	
	public AvocadoPortion(double amount) {
		super(ingredient, amount);
		
		if (amount <= 0) {
			throw new RuntimeException("amount has to be greater than zero");
		}
		
		this.amount = amount;
	}
	
	// hiiii this isn't working cry 
	public AvocadoPortion combine(AvocadoPortion other) {
		if (other == null) {
			return this;
		}
		if (!other.getIngredient().equals(this.getIngredient())) {
			throw new RuntimeException("cannot combine amounts of different ingredients");
		}
		return new AvocadoPortion(this.amount + other.getAmount());
	}
}
