package org.hopto.goop.model.ingredients;

import org.hopto.goop.model.enums.EnumIngredient;
import org.hopto.goop.model.enums.UpgradeTo;

public class LowerUniqueArmor implements IngredientData{

    @Override
    public EnumIngredient getIngred() {
        return EnumIngredient.GUARDIAN_CRYSTAL;
    }

    @Override
    public int[] getIngredQuantity(UpgradeTo upg) {
        switch (upg) {
            case ONE:
                return new int[]{2464, 216, 4, 4, 58, 19320, 320};
            case TWO:
                return new int[]{2464, 216, 6, 4, 57, 19800, 320};
            case THREE:
                return new int[]{2464, 216, 6, 4, 58, 20300, 330};
            case FOUR:
                return new int[]{3544, 310, 6, 4, 82, 20800, 330};
            case FIVE:
                return new int[]{3544, 310, 6, 4, 82, 21300, 330};
            case SIX:
                return new int[]{3544, 310, 8, 4, 82, 21820, 330};
            case SEVEN:
                return new int[]{4622, 404, 8, 6, 108, 22380, 330};
            case EIGHT:
                return new int[]{4622, 404, 10, 6, 108, 22920, 330};
            case NINE:
                return new int[]{4622, 404, 10, 6, 108, 23480, 330};
            case TEN:
                return new int[]{5700, 498, 10, 8, 132, 24040, 330};
            case ELEVEN:
                return new int[]{5700, 498, 10, 8, 132, 24640, 330};
            case TWELVE:
                return new int[]{5700, 498, 12, 8, 132, 25240, 330};
            case THIRTEEN:
                return new int[]{6778, 592, 12, 8, 158, 25860, 330};
            case FOURTEEN:
                return new int[]{6778, 592, 12, 8, 158, 26500, 330};
            case FIFTEEN:
                return new int[]{6778, 592, 12, 8, 158, 27160, 350};
            case SIXTEEN:
                return new int[]{9178, 686, 14, 10, 216, 27820, 350};
            case SEVENTEEN:
                return new int[]{12406, 686, 16, 10, 292, 28420, 350};
            case EIGHTEEN:
                return new int[]{16824, 686, 16, 12, 396, 29040, 350};
            case NINETEEN:
                return new int[]{23166, 780, 18, 14, 536, 29660, 350};
            case TWENTY:
                return new int[]{31464, 780, 20, 14, 728, 30320, 350};
            case TWENTY_ONE:
                return new int[]{42702, 780, 22, 16, 988, 30980, 360};
            case TWENTY_TWO:
                return new int[]{57348, 874, 24, 18, 1340, 31640, 380};
            case TWENTY_THREE:
                return new int[]{77804, 874, 26, 20, 1818, 32320, 390};
            case TWENTY_FOUR:
                return new int[]{105536, 874, 28, 22, 2466, 33040, 400};
            case TWENTY_FIVE:
                return new int[]{144488, 968, 30, 24, 3346, 33740, 420};
        }

        return new int[0];
    }
}
