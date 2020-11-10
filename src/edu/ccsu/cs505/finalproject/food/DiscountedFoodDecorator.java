package edu.ccsu.cs505.finalproject.food;

public class DiscountedFoodDecorator extends FoodDecorator{
	private Double percentageDiscount;

	/**
	 * @param discountedFood
	 * @param percentageDiscount 10 means 10% discount
	 */
	public DiscountedFoodDecorator(Food discountedFood, Double percentageDiscount){
		super(discountedFood);
		this.percentageDiscount = percentageDiscount;
	}

	@Override
	public String name() {
		return decoratedFood.name();
	}

	@Override
	public Food clone(Boolean deep) {
		DiscountedFoodDecorator clone = new DiscountedFoodDecorator(decoratedFood, this.percentageDiscount);

		if(deep){
			clone.cloneToppings(this);
		}

		return clone;
	}

	public double getCost()
	{
		return decoratedFood.getCost() - (decoratedFood.getCost() * (percentageDiscount * 0.01)) ;
	}

	@Override
	protected void setup() throws InterruptedException {

	}

	@Override
	protected void cook() throws InterruptedException {

	}

	@Override
	protected void slice() throws InterruptedException {

	}

	@Override
	public String toString() {
		return super.toString();
	}
}
