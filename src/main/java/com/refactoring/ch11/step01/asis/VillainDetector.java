package com.refactoring.ch11.step01.asis;

import java.util.List;

public class VillainDetector {
    public String findMiscreant(List<String> people) {
        for (String p : people) {
            if (p.equals("조커")) {
                setOffAlarms();
                return "조커";
            }
            if (p.equals("사루만")) {
                setOffAlarms();
                return "사루만";
            }
        }
        return "";
    }

    private void setOffAlarms() {
        System.out.println("🚨 경보 발동!");
    }
}
