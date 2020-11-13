package edu.ccsu.cs505.finalproject.food;

/**
 * Food decorator to apply discounts to existing food items
 */
public class DiscountedFoodDecorator extends FoodDecorator{
	private Double percentageDiscount;

	/**
	 * @param discountedFood part of Decorator pattern
	 * @param percentageDiscount 10.0 means 10% discount
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
			this.cloneToppings(clone);
		}

		return clone;
	}

	/**
	 * @return
	 */
	public double getCost()
	{
		return decoratedFood.getCost() - (decoratedFood.getCost() * (percentageDiscount * 0.01)) ;
	}

	@Override
	protected void setup() throws InterruptedException {
		this.decoratedFood.setup();
	}

	@Override
	protected void cook() throws InterruptedException {
		this.decoratedFood.cook();
	}

	@Override
	protected void slice() throws InterruptedException {
		this.decoratedFood.slice();
	}

	@Override
	public String toString() {
		String test = super.toString();
		return this.decoratedFood.toString();
	}
}
