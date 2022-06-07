package org.hopto.goop.controller;

import org.hopto.goop.model.RefineData;
import org.hopto.goop.model.RefineTable;
import org.hopto.goop.model.enums.UpgradeTo;
import org.hopto.goop.view.ResultView;

import java.util.HashMap;

public class RefineDataManager {

    private static RefineDataManager instance;

    public static RefineDataManager getInstance() {
        if(instance == null) {
            instance = new RefineDataManager();
        }
        return instance;
    }

    private HashMap<UpgradeTo, RefineData> weapon1340;
    private HashMap<UpgradeTo, RefineData> weapon1390;
    private HashMap<UpgradeTo, RefineData> armor1340;
    private HashMap<UpgradeTo, RefineData> armor1390;
    private boolean isMaximum;
    private boolean isStatic;

    private RefineDataManager() {
        initData();
        isMaximum = true;
        isStatic = true;
    }

    public ResultView simulate(UpgradeTo level, boolean isInherited, boolean isWeapon) {
        RefineData data = findData(level, isInherited, isWeapon);

        return isMaximum ? simulateMaximum(data) : simulate(data);
    }

    private ResultView simulate(RefineData data) {
        data.getQty().forEach(System.out::println);

        return null;
    }

    private ResultView simulateMaximum(RefineData data) {
        RefineTable rt = new RefineTable(data);
        rt.startTest();

        return null;
    }

    private RefineData findData(UpgradeTo level, boolean isInherited, boolean isWeapon) {

        if(isInherited)
            return isWeapon ? weapon1390.get(level) : armor1390.get(level);
        else
            return isWeapon ? weapon1340.get(level) : armor1340.get(level);

    }

    private void initData() {
        weapon1340 = new HashMap<>();
        weapon1390 = new HashMap<>();
        armor1340 = new HashMap<>();
        armor1390 = new HashMap<>();

        for(UpgradeTo upg : UpgradeTo.values()) {
            weapon1390.put(upg, new RefineData(upg, true, true));
            weapon1340.put(upg, new RefineData(upg, false, true));
            armor1390.put(upg, new RefineData(upg, true, false));
            armor1340.put(upg, new RefineData(upg, false, false));
        }
    }

    public void setMaximumMode(boolean mode) {
        isMaximum = mode;
    }

    public void setStaticMode(boolean mode) {
        isMaximum = mode;
    }


}
