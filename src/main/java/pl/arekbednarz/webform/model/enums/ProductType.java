package pl.arekbednarz.webform.model.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public enum ProductType {
    GRAIN("Grain products"),
    VEGE_FRUITS("Vegetables and fruits"),
    MILK_DAIRY("Milk and dairy products"),
    MEAT_FISH_EGGS("Meat, poultry, cold cuts, fish, eggs."),
    FATS("Fats"),
    SUG_SWEET("Sugar and sweets"),
    OTHER("Other");


    private final String humanReadable;

    ProductType(String humanReadable) {
        this.humanReadable = humanReadable;
    }

    public static List<String> getListOfHumanReadableStrings(){
        return Arrays.stream(ProductType.values())
            .map(ProductType::getHumanReadable).collect(Collectors.toList());

    }

    public static ProductType getProductTypeByHumanReadableString(final String typeString){
        return Arrays.stream(ProductType.values())
                .filter(platform -> platform.getHumanReadable().equalsIgnoreCase(typeString))
                .findFirst()
                .orElse(OTHER);
    }

}
