package org.hopto.goop.model;

import org.hopto.goop.model.enums.EnumIngredient;
import org.hopto.goop.model.enums.UpgradeTo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RefineTable {

    private class TryData {
        public int grace, bless, guard, book;
        public float chance, artisan, addArtisan, price, accumulatePrice;

        public TryData(int a, int b, int c, int d, float e, float f, float g, float h, float i) {
            grace = a;
            bless = b;
            guard = c;
            book = d;
            chance = e;
            artisan = f;
            addArtisan = g;
            price = h;
            accumulatePrice = i;
        }

        public String toString() {
            return String.format("성공확률 : %.2f [ 은총 : %d, 축복 : %d, 가호 : %d, 책 : %d ] 장인의 기운 +%.2fp (%.2f) | 총 사용금액 : %,3.2f골드 (+%,3.2f골드)", chance, grace, bless, guard, book, addArtisan, artisan, accumulatePrice, price);
        }
    }

    private List<TryData> trys;
    private float artisan;
    private float thisprice;

    private float baseChance;
    private float graceExtra;
    private float blessExtra;
    private float guardExtra;
    private int bookExtra;

    private RefineData data;

    public RefineTable(RefineData rd) {
        this.data = rd;
        init();
    }

    public void startTest() {

        HashMap<Float, List<List<TryData>>> testTable = new HashMap<>();
        List<EnumIngredient> priority = calcPriority();

        for(int i1 = 0 ; i1 <= getMaxQty(priority.get(0)) ; i1++) {
            for(int i2 = 0 ; i2 <= getMaxQty(priority.get(1)) ; i2++) {
                for(int i3 = 0 ; i3 <= getMaxQty(priority.get(2)) ; i3++) {
                    for(int i4 = 0 ; i4 <= getMaxQty(priority.get(3)) ; i4++) {
                        if(!connectTest(priority, new int[] {i1, i2, i3, i4})) continue;
                        calcPostPrice();
                        List<List<TryData>> o = testTable.getOrDefault(thisprice, new ArrayList<>());
                        o.add(trys);
                        testTable.put(thisprice, o);
                    }
                }
            }
        }

        float mini = Float.MAX_VALUE;
        for(float keys : testTable.keySet()) {
            if(keys < mini) mini = keys;
        }

        List<TryData> tdl = testTable.get(mini).get(0);
        int grace = 0, bless = 0, guard = 0, book = 0;
        for(int i = 0 ; i < tdl.size() ; i++) {
            System.out.println("Attemp " + i + ". " + tdl.get(i).toString());
            grace += tdl.get(i).grace;
            bless += tdl.get(i).bless;
            guard += tdl.get(i).guard;
            book += tdl.get(i).book;
        }

        float total = 0.0f;
        for(int i = 1 ; i < data.getIngredients().size() ; i++) {
            System.out.println(data.getIngredients().get(i) + " >>> 1 트당 " + data.getQty().get(i) + "개 사용 >>> " + (data.getQty().get(i) * tdl.size()) + " >> " + (data.getQty().get(i) * data.getIngredients().get(i).getPrice() * tdl.size()));
            total += (data.getQty().get(i) * data.getIngredients().get(i).getPrice() * tdl.size());
        }
        float expPrice = data.getQty().get(0) * data.getIngredients().get(0).getPrice();
        System.out.printf("제련재료 비용 : %,3.0f, 숨 비용 : %,3.0f, 경험치 명파 비용 : %,3.0f, 총 비용 : %,3.0f ( 경험치 제외 %,3.0f 골드) \n", total, mini-(total+expPrice),expPrice, mini, (mini-expPrice));
        System.out.printf("숨 사용 : 은총 %d개, 축복 %d개, 가호 %d개, 책 %d개\n", grace, bless, guard, book);
    }

    private void calcPrePrice(int a, int b, int c, int d) {
        thisprice += a * EnumIngredient.SOLAR_GRACE.getPrice();
        thisprice += b * EnumIngredient.SOLAR_BLESSING.getPrice();
        thisprice += c * EnumIngredient.SOLAR_PROTECTION.getPrice();
        thisprice += d * getBookPrice().getPrice();
        thisprice += getAttempPrice();
    }

    private float getAttempPrice() {
        float ap = 0.0f; // Attempt Price
        for(int i = 1 ; i < data.getIngredients().size() ; i++) {
            ap += data.getIngredients().get(i).getPrice() * data.getQty().get(i);
        }
        return ap;
    }

    private void calcPostPrice() {
        thisprice *= trys.size();
        thisprice += data.getQty().get(0) * data.getIngredients().get(0).getPrice();
    }

    private boolean connectTest(List<EnumIngredient> priority, int[] args) {
        int grace = 0, bless = 0 , protect = 0, book = 0;
        for(int i = 0 ; i < priority.size() ; i++) {
            switch (priority.get(i)) {
                case SOLAR_GRACE:
                    grace = args[i];
                    break;
                case SOLAR_BLESSING:
                    bless = args[i];
                    break;
                case SOLAR_PROTECTION:
                    protect = args[i];
                    break;
                default:
                    book = args[i];
            }
        }
        float bonusChance = grace * graceExtra + bless * blessExtra + protect * guardExtra;
        if(bonusChance > Math.max(baseChance, 1.0f)) return false;

        init();
        calcPrePrice(grace, bless, protect, book);
        while(doUpgrade(grace, bless, protect, book));
        return true;
    }

    private void init() {
        resetValue();
        this.baseChance = data.getUpg().getChance(data.isInherit());
        int maxGrace = data.getUpg().getMaxGrace(data.isInherit());

        float divideThree = baseChance / 3.0f;

        graceExtra = roundSecond(divideThree / maxGrace);
        blessExtra = roundSecond(divideThree / (maxGrace /2.0f));
        guardExtra = roundSecond(divideThree / (maxGrace /6.0f));
        bookExtra = 0;

        if(data.isInherit()) {
            if (data.getUpg() == UpgradeTo.TWENTY || data.getUpg() == UpgradeTo.TWENTY_ONE) {
                graceExtra = 0.01f; blessExtra = 0.02f; guardExtra = 0.07f;
            } else if (data.getUpg() == UpgradeTo.TWENTY_TWO || data.getUpg() == UpgradeTo.TWENTY_THREE || data.getUpg() == UpgradeTo.TWENTY_FOUR || data.getUpg() == UpgradeTo.TWENTY_FIVE) {
                graceExtra = 0.01f; blessExtra = 0.02f; guardExtra = 0.04f;
            }
        }

        if(!data.isInherit()) {
            switch(data.getUpg()) {
                case SEVEN:
                case EIGHT:
                case NINE:
                case TEN:
                case ELEVEN:
                case TWELVE:
                case THIRTEEN:
                case FOURTEEN:
                case FIFTEEN:
                case SIXTEEN:
                case SEVENTEEN:
                    bookExtra = 10;
                    break;
                case EIGHTEEN:
                case NINETEEN:
                    bookExtra = 5;
                    break;
                case TWENTY:
                    bookExtra = 3;
                    break;
            }
        }
    }

    private void resetValue() {
        this.trys = new ArrayList<>();
        this.artisan = 0.0f;
        this.thisprice = 0.0f;
    }

    private boolean doUpgrade(int grace, int bless, int guard, int book) {
        float thisChance = baseChance;
        thisChance += ( baseChance / 10 ) * Math.min(trys.size(), 10);
        thisChance += grace * graceExtra;
        thisChance += bless * blessExtra;
        thisChance += guard * guardExtra;
        thisChance += book * bookExtra;

        float extraArtisan = roundSecond(thisChance/2.15f);

        thisChance = roundSecond(thisChance);
        artisan = roundSecond(artisan);
        TryData td = new TryData(grace, bless, guard, book, thisChance, artisan, extraArtisan, thisprice, thisprice * trys.size());

        artisan += extraArtisan;

        trys.add(td);

        return artisan < 100;
    }

    private List<EnumIngredient> calcPriority() {
        List<EnumIngredient> priority = new ArrayList<>();

        HashMap<EnumIngredient, Float> compareMap = new HashMap<>();
        compareMap.put(EnumIngredient.SOLAR_GRACE, EnumIngredient.SOLAR_GRACE.getPrice() / (graceExtra / 0.01f));
        compareMap.put(EnumIngredient.SOLAR_BLESSING, EnumIngredient.SOLAR_BLESSING.getPrice() / (blessExtra / 0.01f));
        compareMap.put(EnumIngredient.SOLAR_PROTECTION, EnumIngredient.SOLAR_PROTECTION.getPrice() / (guardExtra / 0.01f));

        if( bookExtra > 0 )
            compareMap.put(getBookPrice(), getBookPrice().getPrice() / (bookExtra / 0.01f));
        else
            priority.add(EnumIngredient.SILVER);

        while(compareMap.size() > 0) {
            EnumIngredient key = EnumIngredient.SILVER;
            float val = -1.0f;
            for(EnumIngredient target : compareMap.keySet()) {
                if(compareMap.get(target) >= val) {
                    key = target;
                    val = compareMap.get(target);
                }
            }
            priority.add(key);
            compareMap.remove(key);
        }

        return priority;
    }

    private int getMaxQty(EnumIngredient e) {
        int maxGrace = data.getUpg().getMaxGrace(data.isInherit());
        switch(e){
            case SOLAR_GRACE:
                return maxGrace;
            case SOLAR_BLESSING:
                return maxGrace / 2;
            case SOLAR_PROTECTION:
                return maxGrace / 6;
            case TAILORING_FIFTEEN:
            case TAILORING_TWENTY:
            case METALLURGY_FIFTEEN:
            case METALLURGY_TWENTY:
                return 1;
        }
        return 0;
    }

    private float roundSecond(float v) {
        return ((float) (Math.round(v*100)) / 100.0f);
    }

    private EnumIngredient getBookPrice() {
        if(!data.isInherit()) {
            switch(data.getUpg()) {
                case SEVEN:
                case EIGHT:
                case NINE:
                case TEN:
                case ELEVEN:
                case TWELVE:
                case THIRTEEN:
                case FOURTEEN:
                case FIFTEEN:
                    return data.isWeapon() ? EnumIngredient.METALLURGY_FIFTEEN : EnumIngredient.TAILORING_FIFTEEN;
                case SIXTEEN:
                case SEVENTEEN:
                case EIGHTEEN:
                case NINETEEN:
                case TWENTY:
                    return data.isWeapon() ? EnumIngredient.METALLURGY_TWENTY : EnumIngredient.TAILORING_TWENTY;
            }
        }
        return EnumIngredient.SILVER;
    }

}
