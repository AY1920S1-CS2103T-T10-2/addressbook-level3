package seedu.address.testutil;

import seedu.address.model.person.Person;

/**
 * A utility class to help with building Person objects.
 */
public class FoodBuilder {

    public static final String DEFAULT_NAME = "chicken rice";
    public static final int DEFAULT_TIMES = 3;


    private String foodName;
    private int foodTimes;

    public FoodBuilder() {
        foodName = DEFAULT_NAME;
        foodTimes = DEFAULT_TIMES;
    }

    /**
     * Initializes the PersonBuilder with the data of {@code personToCopy}.
     */
    public FoodBuilder(Food foodToCopy) {
        foodName = foodToCopy.getFoodName();
        foodTimes = foodToCopy.getTimes();
    }


    public Food build() {
        return new Food(foodName, foodTimes);
    }

}
