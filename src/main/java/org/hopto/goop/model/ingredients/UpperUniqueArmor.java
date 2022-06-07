package org.hopto.goop.model.ingredients;

import org.hopto.goop.model.enums.EnumIngredient;
import org.hopto.goop.model.enums.UpgradeTo;

public class UpperUniqueArmor implements IngredientData{

    @Override
    public EnumIngredient getIngred() {
        return EnumIngredient.GUARDIAN_STONE;
    }

    @Override
    public int[] getIngredQuantity(UpgradeTo upg) {
        switch (upg) {
            case ONE:
                return new int[]{9000, 210, 4, 3, 180, 31500, 430};
            case TWO:
            case THREE:
                return new int[]{9000, 210, 5, 3, 180, 31500, 430};
            case FOUR:
            case FIVE:
                return new int[]{12000, 240, 6, 4, 240, 31500, 450};
            case SIX:
                return new int[]{15000, 240, 7, 4, 300, 31500, 460};
            case SEVEN:
                return new int[]{15000, 270, 7, 4, 300, 31500, 460};
            case EIGHT:
            case NINE:
                return new int[]{18000, 270, 8, 4, 360, 31500, 460};
            case TEN:
            case ELEVEN:
                return new int[]{24000, 330, 10, 4, 480, 31500, 470};
            case TWELVE:
            case THIRTEEN:
                return new int[]{30000, 390, 11, 5, 600, 31500, 480};
            case FOURTEEN:
                return new int[]{42000, 420, 12, 7, 840, 31500, 520};
            case FIFTEEN:
                return new int[]{42000, 450, 12, 7, 840, 31500, 560};
            case SIXTEEN:
                return new int[]{72000, 540, 13, 7, 1440, 35000, 670};
            case SEVENTEEN:
                return new int[]{72000, 570, 14, 7, 1440, 35000, 720};
            case EIGHTEEN:
                return new int[]{108000, 660, 17, 12, 2160, 35000, 810};
            case NINETEEN:
                return new int[]{108000, 690, 18, 12, 2160, 35000, 860};
            case TWENTY:
                return new int[]{150000, 780, 19, 18, 3000, 38500, 960};
            case TWENTY_ONE:
                return new int[]{198000, 810, 20, 18, 3960, 38500, 1020};
            case TWENTY_TWO:
                return new int[]{252000, 900, 23, 18, 5040, 38500, 1130};
            case TWENTY_THREE:
                return new int[]{300000, 930, 25, 18, 6000, 38500, 1200};
            case TWENTY_FOUR:
                return new int[]{360000, 1020, 26, 27, 7200, 38500, 1350};
            case TWENTY_FIVE:
                return new int[]{432000, 1050, 29, 27, 8640, 38500, 1470};
        }

        return new int[0];
    }
}
