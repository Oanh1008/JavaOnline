package functional;

import bean.Apple;

public class RedApplePredicate  implements ApplePredicate{
@Override
public boolean test(Apple apple) {
	// TODO Auto-generated method stub
	return "red".equals(apple.getColor());
}
}
