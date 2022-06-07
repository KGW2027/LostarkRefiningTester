package org.hopto.goop.model.enums;

public enum EnumIngredient {

    HONOR_SHARD(getShardPrice()), // 명예의 파편
    DESTRUCTION_CRYSTAL(.7f), // 파괴석 결정
    DESTRUCTION_STONE(3.4f), // 파괴강석
    GUARDIAN_CRYSTAL(.06f), // 수호석 결정
    GUARDIAN_STONE(.06f), // 수호강석
    GRAND_HONOR_STONE(20.f), // 위대한 명예의 돌파석
    MARVELOUS_HONOR_STONE(40.f), // 경이로운 명예의 돌파석
    BASIC_OREHA(14.f), // 중급 오레하 융화 재료
    ADVANCED_OREHA(28.f), // 상급 오레하 융화 재료
    SOLAR_GRACE(62.f), // 태양의 은총
    SOLAR_BLESSING(122.f), // 태양의 축복
    SOLAR_PROTECTION(260.f), // 태양의 가호
    METALLURGY_FIFTEEN(24.f), // 야금술 전설 7~15
    METALLURGY_TWENTY(900.f), // 야금술 유물 16~20
    TAILORING_FIFTEEN(15.f), // 재봉술 전설 7~15
    TAILORING_TWENTY(450.f), // 재봉술 유물 16~20
    SILVER(.0f), // 실링
    GOLD(1.0f); // 골드

    float price;

    EnumIngredient(float p) {
        price = p;
    }

    public float getPrice() {
        return price;
    }

    private static float getShardPrice() {
        float a = 180.0f, b = 350.0f, c = 540.0f;
        return Math.min(a / 500.0f, Math.min(b / 1000.0f, c / 1500.0f));
    }

    public static float testCode() {
        return getShardPrice();
    }
}
