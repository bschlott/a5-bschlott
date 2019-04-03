package a5;

import a4.Sushi;

	public class GreenPlate extends PlateImpl{
	
	private Sushi contents;

	public GreenPlate(Sushi contents) throws PlatePriceException{
		super(contents, Plate.Color.GREEN, 2.0);
		if (contents == null) {
			this.contents = null;
		} else {
			if (contents.getCost() > 2.0) {
				throw new PlatePriceException();
			}
			this.contents = contents;
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
//		return Color.GREEN;
//	}

}

