package org.hopto.goop.view;

import org.hopto.goop.model.enums.EnumIngredient;

import java.util.HashMap;

public class Result {

    HashMap<EnumIngredient, Integer> usedIngreds;

    public Result() {
        usedIngreds = new HashMap<>();

    }

}
