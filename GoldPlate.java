package a5;

import a4.Sushi;

	public class GoldPlate extends PlateImpl{
	
	private Sushi contents;

	public GoldPlate(Sushi contents, double price) throws PlatePriceException{
		super(contents, Plate.Color.GOLD, price);
		if (contents == null) {
			this.contents = null;
		} else {
			if (price < contents.getCost()) {
				throw new PlatePriceException();
			}
			this.contents = contents;
		}
		if (price < 5.0) {
			throw new IllegalArgumentException();
		}
	}

//	@Override
//	public double getPrice() {
//		if (hasContents()) {
//			return 2.0;
//		} else {
//			return 0.0;
//		}
//	}
//
//	@Override
//	public Color getColor() {
//		// TODO Auto-generated method stub
//		return Color.GOLD;
//	}

}

