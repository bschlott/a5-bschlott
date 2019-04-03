package a4 ;

public class EelPortion extends IngredientPortionImpl{

	private static Eel ingredient = new Eel();
	private double amount;
	
	public EelPortion(double amount) {
		super(ingredient, amount);
		
		if (amount <= 0) {
			throw new RuntimeException("amount has to be greater than zero");
		}
		this.amount = amount;
	}
	
	// create specific combine method
	public EelPortion combine(EelPortion other) {
		if (other == null) {
			return this;
		}
		if (!other.getIngredient().equals(this.getIngredient())) {
			throw new RuntimeException("cannot combine amounts of different ingredients");
		}
		return new EelPortion(this.amount + other.getAmount());
	}
}
