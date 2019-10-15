package seedu.address.model.person;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

public class Food {
    private String foodName;
    private int times;

    public Food(String f, int t) {
        requireAllNonNull(f, t);
        foodName = f;
        times = t;
    }

    public Food getFood() {
        return new Food(foodName, times);
    }

    public String getFoodName() {
        return foodName;
    }

    public int getTimes() {
        return times;
    }

    public boolean isSameFood(Food otherFood) {
        if (otherFood == this) {
            return true;
        }

        return otherFood != null
                && otherFood.getFoodName().equals(getFoodName());
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Food)) {
            return false;
        }

        Food otherFood = (Food) other;
        return otherFood.getFoodName().equals(getFoodName());
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getFoodName());
        return builder.toString();
    }

}
