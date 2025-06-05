package com.refactoring.ch11.step01;

import org.apache.logging.log4j.util.Strings;

import java.util.List;

public class VillainDetector {
//    public String findMiscreant(List<String> people) {
//        for (String p : people) {
//            if (p.equals("jocker")){
//				return "jocker";
// 			  }
//			  if (p.equals("saruman")){
//				return "saruman";
//			  }
//        }
//        return "";
//    }

    public String findMiscreant(List<String> people) {
        for (String p : people) {
            if (p.equals("조커") || p.equals("사루만")) {
                return p;
            }
        }
        return Strings.EMPTY;
    }

//    public void alertForMiscreant(List<String> people) {
//        String miscreant = findMiscreant(people);
//        if (!miscreant.isEmpty()) {
//            setOffAlarms();
//        }
//    }

    public void alertForMiscreant(List<String> people) {
        if (!findMiscreant(people).isEmpty()) {
            setOffAlarms();
        }
    }

    private void setOffAlarms() {
        System.out.println("빌런 경고!!");
    }
}