package a5;

import a4.Sushi;

public abstract class PlateImpl implements Plate {

	private Sushi contents;
	private Color col;
	private double price;

	public PlateImpl(Sushi contents, Color col, double price) {
		if (contents == null) {
			this.contents = null;
		} else {
			this.contents = contents;
		}
		this.col = col;
		this.price = price;

	}
	@Override
	public Sushi getContents() {
		// TODO Auto-generated method stub
		return contents;
	}

	@Override
	public Sushi removeContents() {
		if (getContents() == null) {
			return null;
		} else {
			Sushi oldContents = contents;
			contents = null;
			return oldContents;
		}
	}

	@Override
	public void setContents(Sushi s) throws PlatePriceException {
		if (s == null) {
			throw new IllegalArgumentException();
		}
		if (getPrice() < s.getCost()) {
			throw new PlatePriceException();
		}
		contents = s;

	}
	@Override
	public boolean hasContents() {
		if (contents == null) {
			return false;
		} else {
			return true;
		}
	}
	
	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public Color getColor() {
		return col;
	}
	
	@Override
	public double getProfit() {
		if (hasContents()) {
			return getPrice() - contents.getCost();
		} else {
			return 0.0;
		}
	}

}
