package a4;

public class Avocado extends IngredientImpl{

	private static String name = "avocado";
	private static double pricePerOunce = 0.24;
	private static int caloriesPerOunce = 42;
	private static boolean isVegetarian = true;
	private static boolean isRice = false;
	private static boolean isShellfish = false;
	
	public Avocado() {
		super(name, pricePerOunce, caloriesPerOunce, isVegetarian, isRice, isShellfish);
	}

}
