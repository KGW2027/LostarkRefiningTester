package org.hopto.goop.model.ingredients;

import org.hopto.goop.model.enums.EnumIngredient;
import org.hopto.goop.model.enums.UpgradeTo;

public class LowerUniqueWeapon implements IngredientData {

    @Override
    public EnumIngredient getIngred() {
        return EnumIngredient.DESTRUCTION_CRYSTAL;
    }

    @Override
    public int[] getIngredQuantity(UpgradeTo upg) {
        switch (upg) {
            case ONE:
                return new int[]{3526, 358, 6, 4, 84, 27600, 600};
            case TWO:
                return new int[]{3526, 358, 8, 4, 84, 28280, 600};
            case THREE:
                return new int[]{3526, 358, 8, 4, 84, 28980, 600};
            case FOUR:
                return new int[]{5068, 516, 10, 6, 120, 29680, 600};
            case FIVE:
                return new int[]{5068, 516, 10, 6, 120, 30420, 600};
            case SIX:
                return new int[]{5068, 516, 12, 6, 120, 31160, 640};
            case SEVEN:
                return new int[]{6610, 672, 12, 6, 156, 31920, 640};
            case EIGHT:
                return new int[]{6610, 672, 14, 6, 156, 32700, 640};
            case NINE:
                return new int[]{6610, 672, 14, 8, 156, 33520, 640};
            case TEN:
                return new int[]{8152, 830, 16, 8, 192, 34340, 640};
            case ELEVEN:
                return new int[]{8152, 830, 16, 8, 192, 35180, 660};
            case TWELVE:
                return new int[]{8152, 830, 18, 8, 192, 36040, 660};
            case THIRTEEN:
                return new int[]{9696, 986, 18, 10, 228, 36940, 660};
            case FOURTEEN:
                return new int[]{9696, 986, 20, 10, 228, 37840, 660};
            case FIFTEEN:
                return new int[]{9696, 986, 20, 100, 228, 38760, 660};
            case SIXTEEN:
                return new int[]{13014, 1144, 22, 12, 310, 39720, 680};
            case SEVENTEEN:
                return new int[]{17714, 1144, 24, 14, 422, 40580, 680};
            case EIGHTEEN:
                return new int[]{24012, 1144, 28, 16, 572, 41460, 680};
            case NINETEEN:
                return new int[]{32774, 1300, 30, 18, 776, 42360, 710};
            case TWENTY:
                return new int[]{44514, 1300, 32, 20, 1054, 43260, 730};
            case TWENTY_ONE:
                return new int[]{60480, 1300, 34, 22, 1432, 44200, 750};
            case TWENTY_TWO:
                return new int[]{82372, 1458, 38, 26, 1944, 45160, 780};
            case TWENTY_THREE:
                return new int[]{111862, 1458, 42, 28, 2640, 46140, 810};
            case TWENTY_FOUR:
                return new int[]{151946, 1458, 44, 42, 3586, 47160, 840};
            case TWENTY_FIVE:
                return new int[]{206688, 1614, 48, 36, 4868, 48180, 870};
        }

        return new int[0];
    }

}
