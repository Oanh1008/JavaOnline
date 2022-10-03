package functional;

import bean.Apple;

public class HeavyWeightApplePredicate implements ApplePredicate {

	@Override
	public boolean test(Apple apple) {
		// TODO Auto-generated method stub
		return apple.getWeight()>150;
	}
}
