package edu.ccsu.cs505.finalproject.food;

/**
 * Food decorator to apply discounts to existing food items
 */
public class DiscountedFoodDecorator extends FoodDecorator{
	final private Double percentageDiscount;

	/**
	 * @param discountedFood part of Decorator pattern
	 * @param percentageDiscount 10.0 means 10% discount
	 */
	public DiscountedFoodDecorator(Food discountedFood, Double percentageDiscount){
		super(discountedFood);
		this.percentageDiscount = percentageDiscount;
	}

	/**
	 * @return decorated cost
	 * it subtracts the percentage passed into constructor from the original Food price
	 */
	public double getCost()
	{
		return decoratedFood.getCost() - (decoratedFood.getCost() * (percentageDiscount * 0.01)) ;
	}

	@Override
	public Food clone() {
		DiscountedFoodDecorator clone = new DiscountedFoodDecorator(decoratedFood.clone(), this.percentageDiscount);

		clone.cloneToppings(this);

		clone.isConfigurable = this.isConfigurable;
		clone.menuName = this.menuName;

		return clone;
	}

	@Override
	public String toString(){
		return "DiscountedFood (price: " + this.getCost() + " [decoratedFood=" + decoratedFood.toString() + "])";
	}

	@Override
	public void accept(FoodVisitor visitor) {
		visitor.visitFood(this);
		for(Toppings topping:decoratedFood.getToppings()){
			topping.accept(visitor);
		}
	}
}
