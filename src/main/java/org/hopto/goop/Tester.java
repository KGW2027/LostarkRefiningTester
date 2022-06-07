package org.hopto.goop;


import org.hopto.goop.controller.RefineDataManager;
import org.hopto.goop.model.enums.EnumIngredient;
import org.hopto.goop.model.enums.UpgradeTo;
import org.hopto.goop.view.ResultView;

public class Tester {

    public static void main(String[] args) {
        RefineDataManager rdm = RefineDataManager.getInstance();
        System.out.println(EnumIngredient.testCode());
        ResultView view1 = rdm.simulate(UpgradeTo.TWENTY_FIVE, true, true);
    }

}
