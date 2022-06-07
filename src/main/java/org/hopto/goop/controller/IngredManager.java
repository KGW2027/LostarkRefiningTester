package org.hopto.goop.controller;

import org.hopto.goop.model.ingredients.*;

import java.util.ArrayList;
import java.util.List;

public class IngredManager {

    private static IngredManager instance;

    private List<IngredientData> datas;

    public static IngredManager getInstance() {
        if(instance == null) {
            instance = new IngredManager();
        }
        return instance;
    }

    private IngredManager() {
        datas = new ArrayList<>();
        datas.add(new LowerUniqueArmor());
        datas.add(new LowerUniqueWeapon());
        datas.add(new UpperUniqueArmor());
        datas.add(new UpperUniqueWeapon());

    }

    public IngredientData getIngredientData(boolean isInherit, boolean isWeapon) {
        if(isInherit)
            return isWeapon ? datas.get(3) : datas.get(2);
        else
            return isWeapon ? datas.get(1) : datas.get(0);
    }
}
