package a5;

import a4.Sushi;

public class RedPlate extends PlateImpl {

	private Sushi contents;

	public RedPlate(Sushi contents) throws PlatePriceException{
		super(contents, Plate.Color.RED, 1.0);
		if (contents == null) {
			this.contents = null;
		} else {
			if (contents.getCost() > 1.0) {
				throw new PlatePriceException();
			}
			this.contents = contents;
		}
	}

//	@Override
//	public double getPrice() {
//		if (hasContents()) {
//			return 1.0;
//		} else {
//			return 0.0;
//		}
//	}
//
//	@Override
//	public Color getColor() {
//		// TODO Auto-generated method stub
//		return Color.RED;
//	}

}
