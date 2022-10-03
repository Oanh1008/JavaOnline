package functional;

import bean.Apple;

public class GreenApplePredicate implements ApplePredicate {
@Override
public boolean test(Apple apple) {
	// TODO Auto-generated method stub
	return "green".equals(apple.getColor());
}
}
