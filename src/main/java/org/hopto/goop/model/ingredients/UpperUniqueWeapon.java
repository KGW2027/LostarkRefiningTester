package org.hopto.goop.model.ingredients;

import org.hopto.goop.model.enums.EnumIngredient;
import org.hopto.goop.model.enums.UpgradeTo;

public class UpperUniqueWeapon implements IngredientData {

    @Override
    public EnumIngredient getIngred() {
        return EnumIngredient.DESTRUCTION_STONE;
    }

    @Override
    public int[] getIngredQuantity(UpgradeTo upg) {
        switch (upg) {
            case ONE:
                return new int[]{15000, 350, 6, 5, 300, 45000, 720};
            case TWO:
            case THREE:
                return new int[]{15000, 350, 8, 5, 300, 45000, 720};
            case FOUR:
            case FIVE:
                return new int[]{20000, 400, 10, 6, 400, 45000, 750};
            case SIX:
                return new int[]{25000, 400, 12, 6, 500, 45000, 750};
            case SEVEN:
                return new int[]{25000, 450, 12, 6, 500, 45000, 770};
            case EIGHT:
            case NINE:
                return new int[]{30000, 450, 14, 6, 600, 45000, 770};
            case TEN:
            case ELEVEN:
                return new int[]{40000, 550, 7, 800, 45000, 790};
            case TWELVE:
            case THIRTEEN:
                return new int[]{50000, 650, 18, 8, 1000, 45000, 800};
            case FOURTEEN:
                return new int[]{70000, 700, 20, 12, 1400, 45000, 870};
            case FIFTEEN:
                return new int[]{70000, 750, 20, 12, 1400, 45000, 940};
            case SIXTEEN:
                return new int[]{120000, 900, 22, 12, 2400, 50000, 1200};
            case SEVENTEEN:
                return new int[]{120000, 950, 24, 12, 2400, 50000, 1200};
            case EIGHTEEN:
                return new int[]{180000, 1100, 28, 20, 3600, 50000, 1350};
            case NINETEEN:
                return new int[]{180000, 1150, 30, 20, 3600, 50000, 1440};
            case TWENTY:
                return new int[]{250000, 1300, 32, 30, 5000, 55000, 1600};
            case TWENTY_ONE:
                return new int[]{330000, 1350, 34, 30, 6600, 55000, 1700};
            case TWENTY_TWO:
                return new int[]{420000, 1500, 38, 30, 8400, 55000, 1880};
            case TWENTY_THREE:
                return new int[]{500000, 1550, 42, 30, 10000, 55000, 2000};
            case TWENTY_FOUR:
                return new int[]{600000, 1700, 44, 45, 12000, 55000, 2250};
            case TWENTY_FIVE:
                return new int[]{720000, 1750, 48, 45, 14400, 55000, 2450};
        }

        return new int[0];
    }
}
