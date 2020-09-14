package com.neosixth.arknightsrecruiterwidgetcn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class TagsFilter {

    //TODO: listTags must align perfectly with listListTags and listTopListTags
    List<String> listTags = Arrays.asList("Senior", "Top", "Melee", "Ranged", "Guard", "Medic", "Vanguard", "Caster", "Sniper", "Defender", "Supporter", "Specialist", "Healing", "Support", "DPS", "AoE", "Slow", "Survival", "Defense", "Debuff", "Shift", "Crowd-Control", "Nuker", "Summon", "Fast-Redeploy", "DP-Recovery", "Robot", "Starter");

    List<String> listSenior = Arrays.asList("Texas", "Zima", "Ptilopsis", "Silence", "Warfarin", "Projekt Red", "Manticore", "Cliffheart", "FEater", "Provence", "Blue Poison", "Firewatch", "Meteorite", "Platinum", "Pramanix", "Istina", "Mayer", "Specter", "Indra", "Nearl", "Liskarm", "Vulcan", "Croissant", "Nightmare", "Swire");
    List<String> listMelee = Arrays.asList("Texas", "Zima", "Projekt Red", "Manticore", "Cliffheart", "FEater", "Specter", "Indra", "Nearl", "Liskarm", "Vulcan", "Croissant", "Swire", "Scavenger", "Vigna", "Gravel", "Rope", "Shaw", "Dobermann", "Estelle", "Mousse", "Frostleaf", "Matoimaru", "Cuora", "Gummy", "Matterhorn", "Beehunter", "Fang", "Vanilla", "Plume", "Melantha", "Beagle", "Midnight", "Popukar", "Spot", "Castle-3", "Thermal-EX", "Yato", "Noir Corne");
    List<String> listRanged = Arrays.asList("Ptilopsis", "Silence", "Warfarin", "Provence", "Blue Poison", "Firewatch", "Meteorite", "Platinum", "Pramanix", "Istina", "Mayer", "Nightmare", "Myrrh", "Perfumer", "Haze", "Gitano", "ShiraYuki", "Meteor", "Jessica", "Earthspirit", "Grey", "Hibiscus", "Ansel", "Lava", "Steward", "Kroos", "Adnachiel", "Orchid", "Catapult", "Lancet-2", "Durin", "12F", "Rangers");
    List<String> listGuard = Arrays.asList("Specter", "Indra", "Swire", "Dobermann", "Estelle", "Mousse", "Frostleaf", "Matoimaru", "Beehunter", "Melantha", "Midnight", "Popukar", "Castle-3");
    List<String> listMedic = Arrays.asList("Ptilopsis", "Silence", "Warfarin", "Myrrh", "Perfumer", "Hibiscus", "Ansel", "Lancet-2");
    List<String> listVanguard = Arrays.asList("Texas", "Zima", "Scavenger", "Vigna", "Fang", "Vanilla", "Plume", "Yato");
    List<String> listCaster = Arrays.asList("Nightmare", "Haze", "Gitano", "Greyy", "Lava", "Steward", "Durin", "12F");
    List<String> listSniper = Arrays.asList("Provence", "Blue Poison", "Firewatch", "Meteorite", "Platinum", "ShiraYuki", "Meteor", "Jessica", "Kroos", "Adnachiel", "Catapult", "Rangers");
    List<String> listDefender = Arrays.asList("Nearl", "Liskarm", "Vulcan", "Croissant", "Cuora", "Gummy", "Matterhorn", "Beagle", "Spot", "Noir Corne");
    List<String> listSupporter = Arrays.asList("Pramanix", "Istina", "Mayer", "Earthspirit", "Orchid", "Thermal-EX");
    List<String> listSpecialist = Arrays.asList("Projekt Red", "Manticore", "Cliffheart", "FEater", "Gravel", "Rope", "Shaw");
    List<String> listHealing = Arrays.asList("Ptilopsis", "Silence", "Warfarin", "Nearl", "Myrrh", "Perfumer", "Gummy", "Hibiscus", "Ansel", "Spot", "Lancet-2");
    List<String> listSupport = Arrays.asList("Warfarin", "Zima", "Ptilopsis", "Swire", "Dobermann", "Castle-3");
    List<String> listDPS = Arrays.asList("Manticore", "Swire", "Cliffheart", "Provence", "Blue Poison", "Firewatch", "Platinum", "Istina", "Indra", "Liskarm", "Vulcan", "Scavenger", "Vigna", "Haze", "Meteor", "Jessica", "Dobermann", "Mousse", "Frostleaf", "Matoimaru", "Plume", "Steward", "Kroos", "Adnachiel", "Melantha", "Beehunter", "Midnight");
    List<String> listAOE = Arrays.asList("Meteorite", "Specter", "Gitano", "ShiraYuki", "Estelle", "Lava", "Greyy", "Catapult", "Popukar");
    List<String> listSlow = Arrays.asList("FEater", "Istina", "ShiraYuki", "Earthspirit", "Frostleaf", "Greyy", "Orchid");
    List<String> listSurvival = Arrays.asList("Manticore", "Specter", "Indra", "Vulcan", "Jessica", "Estelle", "Matoimaru", "Melantha", "Popukar");
    List<String> listDefense = Arrays.asList("Nearl", "Liskarm", "Vulcan", "Croissant", "Gravel", "Cuora", "Gummy", "Matterhorn", "Beagle", "Spot");
    List<String> listDebuff = Arrays.asList("Meteorite", "Pramanix", "Haze", "Meteor");
    List<String> listShift = Arrays.asList("Cliffheart", "FEater", "Croissant", "Rope", "Shaw");
    List<String> listCrowdControl = Arrays.asList("Texas", "Projekt Red", "Mayer");
    List<String> listNuker = Arrays.asList("Firewatch", "Thermal-EX");
    List<String> listSummon = Arrays.asList("Mayer");
    List<String> listFastRedeploy = Arrays.asList("Projekt Red", "Gravel");
    List<String> listDPRecovery = Arrays.asList("Texas", "Zima", "Scavenger", "Vigna", "Fang", "Vanilla", "Plume");
    List<String> listRobot = Arrays.asList("Lancet-2", "Castle-3", "Thermal-EX");
    List<String> listThreeStar = Arrays.asList("Beagle", "Melantha", "Hibiscus", "Ansel", "Lava", "Steward", "Kroos", "Adnachiel", "Fang", "Vanilla", "Plume", "Orchid", "Spot", "Catapult", "Midnight", "Popukar");
    List<String> listTwoStar = Arrays.asList("Durin", "12F", "Rangers", "Yato", "Noir Corne");
    List<String> listStarter = Arrays.asList("Durin", "12F", "Rangers", "Yato", "Noir Corne");
    List<String> listOneStar = Arrays.asList("Lancet-2", "Castle-3", "Thermal-EX");

    /*
    //List<String> listTags = Arrays.asList("资深干员", "高级资深干员", "近战位", "远程位", "近卫干员", "医疗干员", "先锋干员", "术师干员", "狙击干员", "重装干员", "辅助干员", "特种干员", "治疗", "支援", "输出", "群攻", "减速", "生存", "防护", "削弱", "位移", "控场", "爆发", "召唤", "快速复活", "费用回复");
    List<String> listSenior = Arrays.asList("德克萨斯", "凛冬", "白面鸮", "赫默", "华法琳", "红", "狮蝎", "崖心", "食铁兽", "普罗旺斯", "蓝毒", "守林人", "陨星", "白金", "初雪", "真理", "梅尔", "幽灵鲨", "因陀罗", "临光", "雷蛇", "火神", "可颂", "夜魔", "诗怀雅");
    List<String> listMelee = Arrays.asList("德克萨斯", "凛冬", "红", "狮蝎", "崖心", "食铁兽", "幽灵鲨", "因陀罗", "临光", "雷蛇", "火神", "可颂", "诗怀雅", "清道夫", "红豆", "砾", "暗索", "阿消", "杜宾", "艾丝黛尔", "慕斯", "霜叶", "缠丸", "蛇屠箱", "古米", "角峰", "猎蜂", "芬", "香草", "翎羽", "玫兰莎", "米格鲁", "月见夜", "泡普卡", "斑点");
    List<String> listRanged = Arrays.asList("白面鸮", "赫默", "华法琳", "普罗旺斯", "蓝毒", "守林人", "陨星", "白金", "初雪", "真理", "梅尔", "夜魔", "末药", "调香师", "夜烟", "远山", "白雪", "流星", "杰西卡", "地灵", "芙蓉", "安赛尔", "炎熔", "史都华德", "克洛丝", "安德切尔", "梓兰", "空爆");
    List<String> listGuard = Arrays.asList("幽灵鲨", "因陀罗", "诗怀雅", "杜宾", "艾丝黛尔", "慕斯", "霜叶", "缠丸", "猎蜂", "玫兰莎", "月见夜", "泡普卡");
    List<String> listMedic = Arrays.asList("白面鸮", "赫默", "华法琳", "末药", "调香师", "芙蓉", "安赛尔");
    List<String> listVanguard = Arrays.asList("德克萨斯", "凛冬", "清道夫", "红豆", "芬", "香草", "翎羽");
    List<String> listCaster = Arrays.asList("夜魔", "夜烟", "远山", "格雷伊", "炎熔", "史都华德");
    List<String> listSniper = Arrays.asList("普罗旺斯", "蓝毒", "守林人", "陨星", "白金", "白雪", "流星", "杰西卡", "克洛丝", "安德切尔", "空爆");
    List<String> listDefender = Arrays.asList("临光", "雷蛇", "火神", "可颂", "蛇屠箱", "古米", "角峰", "米格鲁", "斑点");
    List<String> listSupporter = Arrays.asList("华法琳", "凛冬", "白面鸮", "诗怀雅", "杜宾");
    List<String> listSpecialist = Arrays.asList("红", "狮蝎", "崖心", "食铁兽", "砾", "暗索", "阿消");
    List<String> listHealing = Arrays.asList("白面鸮", "赫默", "华法琳", "临光", "末药", "调香师", "古米", "芙蓉", "安赛尔", "斑点");
    List<String> listSupport = Arrays.asList("华法琳", "凛冬", "白面鸮", "诗怀雅", "杜宾");
    List<String> listDPS = Arrays.asList("狮蝎", "诗怀雅", "崖心", "普罗旺斯", "蓝毒", "守林人", "白金", "真理", "因陀罗", "雷蛇", "火神", "清道夫", "红豆", "夜烟", "流星", "杰西卡", "杜宾", "慕斯", "霜叶", "缠丸", "翎羽", "史都华德", "克洛丝", "安德切尔", "玫兰莎", "猎蜂", "月见夜");
    List<String> listAOE = Arrays.asList("陨星", "幽灵鲨", "远山", "白雪", "艾丝黛尔", "炎熔", "格雷伊", "空爆", "泡普卡");
    List<String> listSlow = Arrays.asList("食铁兽", "真理", "白雪", "地灵", "霜叶", "格雷伊", "梓兰");
    List<String> listSurvival = Arrays.asList("狮蝎", "幽灵鲨", "因陀罗", "火神", "杰西卡", "艾丝黛尔", "缠丸", "玫兰莎", "泡普卡");
    List<String> listDefense = Arrays.asList("临光", "雷蛇", "火神", "可颂", "砾", "蛇屠箱", "古米", "角峰", "米格鲁", "斑点");
    List<String> listDebuff = Arrays.asList("陨星", "初雪", "夜烟", "流星");
    List<String> listShift = Arrays.asList("崖心", "食铁兽", "可颂", "暗索", "阿消");
    List<String> listCrowdControl = Arrays.asList("德克萨斯", "红", "梅尔");
    List<String> listNuker = Arrays.asList("守林人");
    List<String> listSummon = Arrays.asList("梅尔");
    List<String> listFastRedeploy = Arrays.asList("红", "砾");
    List<String> listDPRecovery = Arrays.asList("德克萨斯", "凛冬", "清道夫", "红豆", "芬", "香草", "翎羽");

     */


    //Shared between top and bottom list section
    List<String> listTop = Arrays.asList("Skadi", "Ch'en", "Siege", "Shining", "Nightingale", "Ifrit", "Exusiai", "SilverAsh", "Hoshiguma", "Saria");

    //Tags only for top operators
    List<String> listTopSenior = Arrays.asList();
    List<String> listTopMelee = Arrays.asList("Skadi", "Ch'en", "Siege", "SilverAsh", "Hoshiguma", "Saria");
    List<String> listTopRanged = Arrays.asList("Ifrit", "Exusiai", "Shining", "Nightingale");
    List<String> listTopGuard = Arrays.asList("Skadi", "Ch'en", "SilverAsh");
    List<String> listTopMedic = Arrays.asList("Shining", "Nightingale");
    List<String> listTopVanguard = Arrays.asList("Siege");
    List<String> listTopCaster = Arrays.asList("Ifrit");
    List<String> listTopSniper = Arrays.asList("Exusiai");
    List<String> listTopDefender = Arrays.asList("Hoshiguma", "Saria");
    List<String> listTopSupporter = Arrays.asList();
    List<String> listTopSpecialist = Arrays.asList();
    List<String> listTopHealing = Arrays.asList("Shining", "Nightingale", "Saria");
    List<String> listTopSupport = Arrays.asList("Shining", "Nightingale", "Saria", "SilverAsh");
    List<String> listTopDPS = Arrays.asList("Skadi", "Ch'en", "Siege", "Exusiai", "SilverAsh", "Hoshiguma");
    List<String> listTopAOE = Arrays.asList("Ifrit");
    List<String> listTopSlow = Arrays.asList();
    List<String> listTopSurvival = Arrays.asList("Skadi");
    List<String> listTopDefense = Arrays.asList("Hoshiguma", "Saria");
    List<String> listTopDebuff = Arrays.asList("Ifrit");
    List<String> listTopShift = Arrays.asList();
    List<String> listTopCrowdControl = Arrays.asList();
    List<String> listTopNuker = Arrays.asList("Ch'en");
    List<String> listTopSummon = Arrays.asList();
    List<String> listTopFastRedeploy = Arrays.asList();
    List<String> listTopDPRecovery = Arrays.asList("Siege");
    List<String> listTopRobot = Arrays.asList();
    List<String> listTopStarter = Arrays.asList();

    /*
    List<String> listTop = Arrays.asList("推进之王", "闪灵", "夜莺", "伊芙利特", "能天使", "银灰", "星熊", "塞雷娅");
    List<String> listTopSenior = Arrays.asList();
    List<String> listTopMelee = Arrays.asList("推进之王", "银灰", "星熊", "塞雷娅");
    List<String> listTopRanged = Arrays.asList("伊芙利特", "能天使", "闪灵", "夜莺");
    List<String> listTopGuard = Arrays.asList("银灰");
    List<String> listTopMedic = Arrays.asList("闪灵", "夜莺");
    List<String> listTopVanguard = Arrays.asList("推进之王");
    List<String> listTopCaster = Arrays.asList("伊芙利特");
    List<String> listTopSniper = Arrays.asList("能天使");
    List<String> listTopDefender = Arrays.asList("星熊", "塞雷娅");
    List<String> listTopSupporter = Arrays.asList();
    List<String> listTopSpecialist = Arrays.asList();
    List<String> listTopHealing = Arrays.asList("闪灵", "夜莺", "塞雷娅");
    List<String> listTopSupport = Arrays.asList("闪灵", "夜莺", "塞雷娅", "银灰");
    List<String> listTopDPS = Arrays.asList("推进之王", "能天使", "银灰", "星熊");
    List<String> listTopAOE = Arrays.asList("伊芙利特");
    List<String> listTopSlow = Arrays.asList();
    List<String> listTopSurvival = Arrays.asList();
    List<String> listTopDefense = Arrays.asList("星熊", "塞雷娅");
    List<String> listTopDebuff = Arrays.asList("伊芙利特");
    List<String> listTopShift = Arrays.asList();
    List<String> listTopCrowdControl = Arrays.asList();
    List<String> listTopNuker = Arrays.asList();
    List<String> listTopSummon = Arrays.asList();
    List<String> listTopFastRedeploy = Arrays.asList();
    List<String> listTopDPRecovery = Arrays.asList("推进之王");

     */





    //Rare tags: fastredeploy, summon, crowdcontrol, shift, nuker,
    List<List<String>> listListTags;
    //listMedic, listVanguard, listCaster, listSniper, listDefender, listSupporter, listSpecialist, listHealing

    //Top operator only version of listListTags. share use of listTop
    List<List<String>> listTopListTags;
    //roster is the calculated output of chosen tags, like Zima, [support, vanguard]
    HashMap<String, List> roster = new HashMap<String, List>();
    HashMap<List, List> output = new HashMap<List, List>();
    Set<String> chosenSet = new HashSet<>();


    public HashMap<List, List> filterTags(Set<String> chosenSet0) {
        chosenSet = chosenSet0;
        listListTags = Arrays.asList(listSenior, listTop, listMelee, listRanged, listGuard, listMedic, listVanguard, listCaster, listSniper, listDefender
                , listSupporter, listSpecialist, listHealing, listSupport, listDPS, listAOE, listSlow, listSurvival, listDefense, listDebuff, listShift, listCrowdControl, listNuker, listSummon, listFastRedeploy, listDPRecovery, listRobot, listStarter);

        listTopListTags = Arrays.asList(listTopSenior, listTop, listTopMelee, listTopRanged, listTopGuard, listTopMedic, listTopVanguard, listTopCaster, listTopSniper, listTopDefender
                , listTopSupporter, listTopSpecialist, listTopHealing, listTopSupport, listTopDPS, listTopAOE, listTopSlow, listTopSurvival, listTopDefense, listTopDebuff, listTopShift, listTopCrowdControl, listTopNuker, listTopSummon, listTopFastRedeploy, listTopDPRecovery, listTopRobot, listTopStarter);

        String listElement = "";
        if (chosenSet.contains("Top")) {
            //chosenSet contains 'top operator' tag
            //hence, manually check if other present tags will help narrow down possible top operator
            //only 6* will be shown
            for (int i = 0; i < listTopListTags.size(); i++) {
                if (chosenSet.contains(listTags.get(i))) {
                    for (int j = 0; j < listTopListTags.get(i).size(); j++) {
                        if (!roster.containsKey(listTopListTags.get(i).get(j))) {
                            List<String> newL = new ArrayList<String>();
                            newL.add(listTags.get(i));
                            roster.put(listTopListTags.get(i).get(j), newL);
                        } else {
                            List<String> existedL = new ArrayList<String>();
                            existedL = roster.get(listTopListTags.get(i).get(j));
                            existedL.add(listTags.get(i));
                            roster.put(listTopListTags.get(i).get(j), existedL);
                        }
                    }
                }
            }
        } else {
            //Do calculations here: for non 6*
            for (int i = 0; i < listListTags.size(); i++) {
                if (chosenSet.contains(listTags.get(i))) {

                    //looping through respective tag lists, like listDPS = {"Manticore", "Cliffheart"...}
                    for (int j = 0; j < listListTags.get(i).size(); j++) {
                        if (!roster.containsKey(listListTags.get(i).get(j))) {
                            List<String> newL = new ArrayList<String>();
                            newL.add(listTags.get(i));
                            roster.put(listListTags.get(i).get(j), newL);
                        } else {
                            List<String> existedL = new ArrayList<String>();
                            existedL = roster.get(listListTags.get(i).get(j));
                            existedL.add(listTags.get(i));
                            roster.put(listListTags.get(i).get(j), existedL);
                        }
                    }
                }
            }
        }
        //Reverse roster<String:OperatorName, List:Tags> into output<List:TagCombinations, List:QualifiedOperators>
        for (Map.Entry<String, List> entry : roster.entrySet()) {
            String key = entry.getKey();
            List<String> value = new ArrayList<String>();
            value = entry.getValue();
            //if output has not have this tag yet
            //note, value can be ["aoe", "caster", "ranged"]
            List<List<String>> valueCombi = getAllCombinations(value);
            for (int i = 0; i < valueCombi.size(); i++) {
                if (!output.containsKey(valueCombi.get(i))) {
                    //note, value can be ["aoe", "caster", "ranged"]
                    List<String> newL = new ArrayList<String>();
                    newL.add(key); //add operator to a newly created array
                    //put operator list into this tag
                    //check if filtering 6*
                    if (chosenSet.contains("Top")) {
                        List<String> topL = new ArrayList<>();
                        topL.add("Top");
                        //if (valueCombi.get(i).equals(topL) || !valueCombi.get(i).contains("Top")) {
                        if (!valueCombi.get(i).contains("Top")) {
                        } else {
                            output.put(valueCombi.get(i), newL);
                        }
                    } else {
                        output.put(valueCombi.get(i), newL);
                    }
                } else {
                    List<String> existedL = new ArrayList<String>();
                    existedL = output.get(valueCombi.get(i));
                    existedL.add(key);
                    //output.put(valueCombi.get(i), existedL);

                    if (chosenSet.contains("Top")) {
                        List<String> topL = new ArrayList<>();
                        topL.add("Top");
                        //if (valueCombi.get(i).equals(topL) || !valueCombi.get(i).contains("Top")) {
                        if (!valueCombi.get(i).contains("Top")) {

                        } else {
                            output.put(valueCombi.get(i), existedL);
                        }
                    } else {
                        output.put(valueCombi.get(i), existedL);
                    }
                }
            }
        }//End of for(Map.Entry...

        return output;
        //ArrayList<String> listOutputGood = new ArrayList<>();
        /*
        Iterator it3 = output.entrySet().iterator();
        while (it3.hasNext()) {
            Map.Entry ko3 = (Map.Entry) it3.next();

            //Filter good and bad tags here
            //Good tags: List.size() > 1, fastredeploy, summon, crowdcontrol, shift, nuker
            List<String> holder = new ArrayList<String>();
            List<String> holder2 = new ArrayList<String>();

            holder = (List) ko3.getKey();
            holder2 = (List) ko3.getValue();


            String joinedKeyTags = TextUtils.join("+", holder);
            String joinedValueOperators = TextUtils.join(",", holder2);
            //{Mayer(Purple), Gravel(Purple), Projekt Red(Gold), Siege(Red)
            // joinedValueOperators = "Gravel, Projekt Red"
            String[] uncoloredOps = joinedValueOperators.split(",");
            //StringJoiner sb = new StringJoiner(", ");
            //List<String> coloredList = new ArrayList<String>();

            List<String> redOps = new ArrayList<String>();
            List<String> goldOps = new ArrayList<String>();
            List<String> purpleOps = new ArrayList<String>();
            List<String> blueOps = new ArrayList<String>();


            for (int i = 0; i < uncoloredOps.length; i++) {
                if (listTop.contains(uncoloredOps[i])) {
                    uncoloredOps[i] = "<font color=#FF3300>" + uncoloredOps[i] + "</font>";
                    redOps.add(uncoloredOps[i]);
                } else if (listThreeStar.contains(uncoloredOps[i])) {
                    uncoloredOps[i] = "<font color=#0080FE>" + uncoloredOps[i] + "</font>";
                    blueOps.add(uncoloredOps[i]);
                } else if (listSenior.contains(uncoloredOps[i])) {
                    uncoloredOps[i] = "<font color=#FFD700>" + uncoloredOps[i] + "</font>";
                    goldOps.add(uncoloredOps[i]);
                } else {
                    uncoloredOps[i] = "<font color=#CC99ff>" + uncoloredOps[i] + "</font>";
                    purpleOps.add(uncoloredOps[i]);
                }
                //coloredList.add(uncoloredOps[i]);
            }

            List<String> coloredList = new ArrayList<String>();
            if (redOps.size() > 0) {
                coloredList.addAll(redOps);
            } else {
                coloredList.addAll(goldOps);
                coloredList.addAll(purpleOps);
                coloredList.addAll(blueOps);
            }
            String coloredOps = TextUtils.join(", ", coloredList);

            //TODO: This is what makes colored words work in HTML
            listElement = "[" + joinedKeyTags + "]<br/>" + coloredOps;

        }//end of while loop

        return listElement;
        */
    }

    public List<List<String>> getAllCombinations(List<String> elements) {
        List<List<String>> combinationList = new ArrayList<List<String>>();
        for (long i = 1; i < Math.pow(2, elements.size()); i++) {
            List<String> list = new ArrayList<String>();
            for (int j = 0; j < elements.size(); j++) {
                if ((i & (long) Math.pow(2, j)) > 0) {
                    list.add(elements.get(j));
                }
            }
            combinationList.add(list);
        }
        return combinationList;
    }

}
