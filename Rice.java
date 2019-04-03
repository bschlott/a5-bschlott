package a4 ;

public class Rice extends IngredientImpl{

	private static String name = "rice";
	private static double pricePerOunce = 0.13;
	private static int caloriesPerOunce = 34;
	private static boolean isVegetarian = true;
	private static boolean isRice = true;
	private static boolean isShellfish = false;

	public Rice() {
		super(name, pricePerOunce, caloriesPerOunce, isVegetarian, isRice, isShellfish);
		// TODO Auto-generated constructor stub
	}

}
