package org.hopto.goop.model;

import org.hopto.goop.controller.IngredManager;
import org.hopto.goop.model.enums.EnumIngredient;
import org.hopto.goop.model.enums.UpgradeTo;
import org.hopto.goop.model.ingredients.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RefineData {

    private List<EnumIngredient> ingredients;
    private List<Integer> qty;
    private UpgradeTo upg;
    private boolean isWeapon;
    private boolean isInherit;

    public RefineData(UpgradeTo upg, boolean isInherit, boolean isWeapon) {
        this.upg = upg;
        IngredientData id = IngredManager.getInstance().getIngredientData(isInherit, isWeapon);
        mkIngredList(
                id.getIngred(),
                isInherit ? EnumIngredient.MARVELOUS_HONOR_STONE : EnumIngredient.GRAND_HONOR_STONE,
                isInherit ? EnumIngredient.ADVANCED_OREHA : EnumIngredient.BASIC_OREHA
        );
        this.qty = Arrays.stream(id.getIngredQuantity(upg)).boxed().collect(Collectors.toList());
        this.isWeapon = isWeapon;
        this.isInherit = isInherit;
    }

    private void mkIngredList(EnumIngredient i1, EnumIngredient i2, EnumIngredient i3) {
        List<EnumIngredient> list = new ArrayList<>();

        list.add(EnumIngredient.HONOR_SHARD); // 경험치 명파

        list.add(i1); // 강석
        list.add(i2); // 명돌
        list.add(i3); // 오레하

        list.add(EnumIngredient.HONOR_SHARD); // 사용 명파
        list.add(EnumIngredient.SILVER); // 실링
        list.add(EnumIngredient.GOLD); // 골드

        this.ingredients = list;
    }

    public List<EnumIngredient> getIngredients() {
        return ingredients;
    }

    public List<Integer> getQty() {
        return qty;
    }

    public boolean isWeapon() {
        return isWeapon;
    }

    public UpgradeTo getUpg() {
        return upg;
    }

    public boolean isInherit() {
        return isInherit;
    }
}
