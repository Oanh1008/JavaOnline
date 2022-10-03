package functional;

import bean.Apple;

public class LightWeightApplePredicate2 implements ApplePredicate {

	@Override
	public boolean test(Apple apple) {
		// TODO Auto-generated method stub
		return apple.getWeight()<200;
	}
}
