package com.qianyang.study.jdk18.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * <br>
 *
 * @author sunzhongshuai
 */
public class Main {

    private static void test1(){
        List<AreaNode> areas = new ArrayList(10);

        AreaNode province1 = new AreaNode("江苏省", "jiangshusheng");
        AreaNode province2 = new AreaNode("安徽省", "anhuisheng");
        AreaNode province3 = new AreaNode("山西省", "shanxisheng");
        areas.add(province1);
        areas.add(province2);
        areas.add(province3);

        AreaNode city1 = new AreaNode("南通", "nantong");
        AreaNode city2 = new AreaNode("无锡", "wuxi");
        AreaNode city3 = new AreaNode("南京", "nanjing");
        AreaNode city4 = new AreaNode("合肥", "hefei");
        AreaNode city5 = new AreaNode("六安", "luan");

        province1.addChild(city1);
        province1.addChild(city2);
        province1.addChild(city3);

        province2.addChild(city4);
        province2.addChild(city5);

        List<AreaNode> manageCities = new ArrayList(10);
        manageCities.add(city5);

        for(AreaNode province : areas){
            List<AreaNode> cityFilter = province.getChildren().stream().filter(city -> {
                for(AreaNode manageCity : manageCities){
                    if(manageCity.getValue().equals(city.getValue())){
                        return true;
                    }
                }
                return false;
            }).collect(Collectors.toList());

            province.setChildren(cityFilter);
        }

        System.out.println(areas.size());

        List<AreaNode> areaNodesFilter = areas.stream().filter(r -> !r.getChildren().isEmpty()).collect(Collectors.toList());

        System.out.println(areaNodesFilter.size());
    }

    public static void main(String[] args){
        test1();
    }
}
