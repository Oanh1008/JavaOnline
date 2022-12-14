package bean;

import java.util.Objects;

public class Dish {
	// internal enum in class
    public enum Kind {
        MEAT, FISH, OTHER
    }

    private String id;
    private String name;
    private double calories;
    private Kind kind;
    private boolean vegetarian;

    public Dish() {
    }

    public Dish(String id, String name, double calories, Kind kind, boolean vegetarian) {
        this.id = id;
        this.name = name;
        this.calories = calories;
        this.kind = kind;
        this.vegetarian = vegetarian;
    }
    public Dish(String name, double calories) {
    	
    	this.name = name;
    	this.calories = calories;
    	
    }

    public static Dish maxClr(Dish d1, Dish d2) {
        return d1.getCalories() > d2.getCalories() ? d1 : d2;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public Kind getKind() {
        return kind;
    }

    public void setKind(Kind kind) {
        this.kind = kind;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Dish)) {
            return false;
        }

        Dish dish = (Dish) o;
        // legacy business >>> bug
        // return getCalories() == dish.getCalories();
        // Comparable, Comparator
        return getId() == dish.getId();
    }
    
    @Override
    public int hashCode() {
    	return Objects.hash(id);
    }

    @Override
    public String toString() {
        return id + ", " + name + ", " + calories + ", " + kind + ", " + vegetarian;
    }
    
    public static class NameCaloriesParameter {
    	private String name;
    	private double calories;
    	
    	public NameCaloriesParameter(String name, double calories) {
    		this.name = name;
    		this.calories = calories;
    	}
    	
    	public String getName() {
			return name;
		}
    	
    	public void setName(String name) {
			this.name = name;
		}
    	
    	public double getCalories() {
			return calories;
		}
    	
    	public void setCalories(double calories) {
			this.calories = calories;
		}
    	
    	@Override
    	public String toString() {
    		return name + ", " + calories;
    	}
    }
}
