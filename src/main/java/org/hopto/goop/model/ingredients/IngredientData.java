package org.hopto.goop.model.ingredients;

import org.hopto.goop.model.enums.EnumIngredient;
import org.hopto.goop.model.enums.UpgradeTo;

public interface IngredientData {

    public EnumIngredient getIngred();

    public int[] getIngredQuantity(UpgradeTo upg);
}
