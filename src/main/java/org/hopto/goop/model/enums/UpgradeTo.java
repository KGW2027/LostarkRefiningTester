package org.hopto.goop.model.enums;

public enum UpgradeTo {

    ONE(100.0f, 100),
    TWO(100.0f, 100),
    THREE(100.0f, 100),
    FOUR(100.0f, 45.0f),
    FIVE(100.0f, 45.0f),
    SIX(100.0f, 45.0f),
    SEVEN(60.0f, 30.0f),
    EIGHT(45.0f, 30.0f),
    NINE(30.0f, 30.0f),
    TEN(30.0f, 15.0f),
    ELEVEN(30.0f, 15.0f),
    TWELVE(15.0f, 10.0f),
    THIRTEEN(15.0f, 10.0f),
    FOURTEEN(15.0f, 5.0f),
    FIFTEEN(10.0f, 5.0f),
    SIXTEEN(10.0f, 4.0f),
    SEVENTEEN(10.0f, 4.0f),
    EIGHTEEN(5.0f, 3.0f),
    NINETEEN(5.0f, 3.0f),
    TWENTY(3.0f, 1.5f),
    TWENTY_ONE(3.0f, 1.5f),
    TWENTY_TWO(1.0f, 1.0f),
    TWENTY_THREE(1.0f, 1.0f),
    TWENTY_FOUR(0.5f, 0.5f),
    TWENTY_FIVE(0.5f, 0.5f);

    float l1, l2;

    UpgradeTo(float base, float inherit) {
        l1 = base;
        l2 = inherit;
    }

    public float getChance(boolean isInherited) {
        return isInherited ? l2 : l1;
    }

    public int getMaxGrace(boolean isInherited) {
        float chance = getChance(isInherited);
        if(chance >= 30) return 12;
        if(chance >= 10) return 24;
        if(chance >= 3) return 36;
        return 48;
    }
}
