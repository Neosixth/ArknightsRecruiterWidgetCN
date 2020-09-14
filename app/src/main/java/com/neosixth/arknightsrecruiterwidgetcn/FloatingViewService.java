package com.neosixth.arknightsrecruiterwidgetcn;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.RectF;
import android.os.Build;
import android.os.IBinder;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.text.style.LineBackgroundSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;


public class FloatingViewService extends Service implements View.OnClickListener{


    private static final String TAG = "FloatingViewService";
    //Base widget variables
    private WindowManager mWindowManager;
    private View mFloatingView;
    private View collapsedView;
    private Boolean collapsedTrue;
    private View currentView;
    //private View currentViewAux;
    //End of Base widget variables


    //Base widget buttons
    private ImageView trueIcon;
    private ImageView bCloseMin;
    private ImageView bKofi;
    private Button bScan;
    private Button bGuaranteed;
    private Button bPrev;
    private Button bManual;
    private Button bEnter;
    private Button bPrevFromManual;
    private Button bReset;
    private WebView bWebview;
    private Button bPrevFromKofi;
    private TextView ocrOutput;
    private TextView kofiText;
    //End of base widget buttons

    private Button senior;
    private Button top;
    private Button melee;
    private Button ranged;
    private Button guard;
    private Button medic;
    private Button vanguard;
    private Button caster;
    private Button sniper;
    private Button defender;
    private Button supporter;
    private Button specialist;
    private Button healing;
    private Button support;
    private Button dps;
    private Button aoe;
    private Button slow;
    private Button survival;
    private Button defense;
    private Button debuff;
    private Button shift;
    private Button crowdcontrol;
    private Button nuker;
    private Button summon;
    private Button fastredeploy;
    private Button dprecovery;
    private Button robot;
    private Button starter;

    //TODO: Customize and add expandedViews as needed
    private View expandedView1;
    private View expandedViewG;
    private View expandedViewManual;
    private View expandedViewKofi;
    //private View expandedView1AUX;
    //End of expandedViews


    Set<String> chosenSet = new HashSet<>();
    ArrayList<CharSequence> mobi = new ArrayList<>();
    ArrayList<CharSequence> guaranteedMobi = new ArrayList<>();

    ArrayAdapter<CharSequence> adapter;
    ArrayAdapter<CharSequence> adapterG;
    //TODO: Customize and add buttons as needed
    //End of buttons

    List<String> ocrListTags = Arrays.asList( "Starter","Senior", "Top", "Melee", "Ranged", "Guard", "Medic", "Vanguard", "Caster", "Sniper", "Defender", "Supporter", "Specialist", "Healing", "Support", "DPS", "AoE", "Slow", "Survival", "Defense", "Debuff", "Shift", "Crowd", "Nuker", "Summon", "Fast", "Recovery");
    List<String> listButtonTagNames = Arrays.asList( "Senior", "Top", "Melee", "Ranged", "Guard", "Medic", "Vanguard", "Caster", "Sniper", "Defender", "Supporter", "Specialist", "Healing", "Support", "DPS", "AoE", "Slow", "Survival", "Defense", "Debuff", "Shift", "Crowd-Control", "Nuker", "Summon", "Fast-Redeploy", "DP-Recovery", "Robot", "Starter");
    //List<String> listTop = Arrays.asList("Skadi", "Ch'en", "Siege", "Shining", "Nightingale", "Ifrit", "Exusiai", "SilverAsh", "Hoshiguma", "Saria");
    //List<String> listSenior = Arrays.asList("Texas", "Zima", "Ptilopsis", "Silence", "Warfarin", "Projekt Red", "Manticore", "Cliffheart", "FEater", "Provence", "Blue Poison", "Firewatch", "Meteorite", "Platinum", "Pramanix", "Istina", "Mayer", "Specter", "Indra", "Nearl", "Liskarm", "Vulcan", "Croissant", "Swire", "Nightmare");
    //List<String> listThreeStar = Arrays.asList("Beagle", "Melantha", "Hibiscus", "Ansel", "Lava", "Steward", "Kroos", "Adnachiel", "Fang", "Vanilla", "Plume", "Orchid", "Spot", "Catapult", "Midnight", "Popukar");

    List<String> listTop;
    List<String> listSenior;
    List<String> listThreeStar;
    List<String> listTwoStar;
    List<String> listOneStar;

    //Make above to get them from TagsFilter class
    List<Button> listTagButtons;

    /*
    //List<String> ocrListTags = Arrays.asList("新手", "资深干员", "高级资深干员", "近战位", "远程位", "近卫干员", "医疗干员", "先锋干员", "术师干员", "狙击干员", "重装干员", "辅助干员", "特种干员", "治疗", "支援", "输出", "群攻", "减速", "生存", "防护", "削弱", "位移", "控场", "爆发", "召唤", "快速复活", "费用回复");
    List<String> listTop = Arrays.asList("推进之王", "闪灵", "夜莺", "伊芙利特", "能天使", "银灰", "星熊", "塞雷娅");
    List<String> listSenior = Arrays.asList("德克萨斯", "凛冬", "白面鸮", "赫默", "华法琳", "红", "狮蝎", "崖心", "食铁兽", "普罗旺斯", "蓝毒", "守林人", "陨星", "白金", "初雪", "真理", "梅尔", "幽灵鲨", "因陀罗", "临光", "雷蛇", "火神", "可颂", "诗怀雅", "夜魔");
    List<String> listThreeStar = Arrays.asList("米格鲁", "玫兰莎", "芙蓉", "安赛尔", "炎熔", "史都华德", "克洛丝", "安德切尔", "芬", "香草", "翎羽", "梓兰", "斑点", "空爆", "月见夜", "泡普卡");


     */








    private static final String CHANNEL_ID = "channel_01";

    public FloatingViewService() {
    }

    private AdView adView;
    AdRequest adRequest;
    //AdmobAdapterWrapper adapterWrapper;



    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        //! Start of Base widget starting code: Do not touch
        super.onCreate();
        //getting the widget layout from xml using layout inflater
        mFloatingView = LayoutInflater.from(this).inflate(R.layout.layout_floating_widget, null);
        //setting the layout parameters
        final WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                Build.VERSION.SDK_INT >= Build.VERSION_CODES.O ? WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY : WindowManager.LayoutParams.TYPE_PHONE,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT);



        /*
        //Instructions for banner ads
        adView = (AdView) mFloatingView.findViewById(R.id.adView);
        adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
         */
        //showInterstitial();
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {}
        });
        //TODO
        //mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd = new com.google.android.gms.ads.InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                // Load the next interstitial.
                Toast.makeText(getApplicationContext(), "Alpha 3", Toast.LENGTH_SHORT).show();
                //mInterstitialAd.show();
                //mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }

            @Override
            public void onAdLoaded(){

                Toast.makeText(getApplicationContext(), "Alpha 4", Toast.LENGTH_SHORT).show();
                //mInterstitialAd.show();
            }
        });



        //getting windows services and adding the floating view to it
        mWindowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        mWindowManager.addView(mFloatingView, params);

        adapter = new ArrayAdapter<CharSequence>(this, R.layout.activity_listview, mobi);
        adapterG = new ArrayAdapter<CharSequence>(this, R.layout.activity_listview, guaranteedMobi);
        ListView listView = (ListView) mFloatingView.findViewById(R.id.outputListView);
        listView.setAdapter(adapter);

        bKofi = mFloatingView.findViewById(R.id.bKofiXML);
        trueIcon = mFloatingView.findViewById(R.id.widgetMainIcon);
        trueIcon.setClipToOutline(true);

        kofiText = mFloatingView.findViewById(R.id.kofiTextXML);
        kofiText.setMovementMethod(new ScrollingMovementMethod());

        //getting the collapsed and expanded view from the floating view
        bCloseMin = mFloatingView.findViewById(R.id.buttonClose);
        collapsedView = mFloatingView.findViewById(R.id.layoutCollapsed);
        //bScan = (Button) mFloatingView.findViewById(R.id.bScanXML);
        bManual = (Button) mFloatingView.findViewById(R.id.bManualXML);
        bWebview = (WebView) mFloatingView.findViewById(R.id.wv1);

        WebSettings webSettings = bWebview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        bWebview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                try{
                    //Uri uri = Uri.parse("https://www.google.com"); // missing 'http://' will cause crashed
                    Intent intent = new Intent(Intent.ACTION_VIEW, request.getUrl());
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    //view.loadUrl("https://www.google.com");
                    startActivity(intent);
                } catch(Exception e){

                }

                return true;
            }
        });
        bWebview.loadUrl("file:///android_asset/kofihtml.html");

        //! End of Base widget starting code
        collapsedTrue = true;
        //Declare Tags
        {
            senior = mFloatingView.findViewById(R.id.bSeniorOperator);
            top = mFloatingView.findViewById(R.id.bTopOperator);
            melee = mFloatingView.findViewById(R.id.bMelee);
            ranged = mFloatingView.findViewById(R.id.bRanged);
            guard = mFloatingView.findViewById(R.id.bGuard);
            medic = mFloatingView.findViewById(R.id.bMedic);
            vanguard = mFloatingView.findViewById(R.id.bVanguard);
            caster = mFloatingView.findViewById(R.id.bCaster);
            sniper = mFloatingView.findViewById(R.id.bSniper);
            defender = mFloatingView.findViewById(R.id.bDefender);
            supporter = mFloatingView.findViewById(R.id.bSupporter);
            specialist = mFloatingView.findViewById(R.id.bSpecialist);
            healing = mFloatingView.findViewById(R.id.bHealing);
            support = mFloatingView.findViewById(R.id.bSupport);
            dps = mFloatingView.findViewById(R.id.bDPS);
            aoe = mFloatingView.findViewById(R.id.bAoE);
            slow = mFloatingView.findViewById(R.id.bSlow);
            survival = mFloatingView.findViewById(R.id.bSurvival);
            defense = mFloatingView.findViewById(R.id.bDefense);
            debuff = mFloatingView.findViewById(R.id.bDebuff);
            shift = mFloatingView.findViewById(R.id.bShift);
            crowdcontrol = mFloatingView.findViewById(R.id.bCrowdControl);
            nuker = mFloatingView.findViewById(R.id.bNuker);
            summon = mFloatingView.findViewById(R.id.bSummon);
            fastredeploy = mFloatingView.findViewById(R.id.bFastRedeploy);
            dprecovery = mFloatingView.findViewById(R.id.bDPRecovery);
            robot = mFloatingView.findViewById(R.id.bRobot);
            starter = mFloatingView.findViewById(R.id.bStarter);
        }

        listTagButtons = Arrays.asList(senior, top, melee, ranged, guard, medic, vanguard, caster, sniper, defender, supporter, specialist, healing, support, dps, aoe, slow, survival, defense,debuff, shift, crowdcontrol, nuker, summon, fastredeploy, dprecovery, robot, starter);

        for(int i = 0; i < listTagButtons.size(); i++){
            final Button currB = listTagButtons.get(i);
            final String nameB = listButtonTagNames.get(i);
            currB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //starter.setBackground("#000000");
                    if (!chosenSet.contains(nameB)) {
                        chosenSet.add(nameB);
                        currB.setBackgroundColor(Color.BLUE);
                    } else {
                        chosenSet.remove(nameB);
                        currB.setBackgroundColor(Color.BLACK);
                    }
                }
            });
        }

        //Customize and add expandedViews here
        expandedView1 = mFloatingView.findViewById(R.id.expanded1);
        expandedViewG = mFloatingView.findViewById(R.id.expandedG);
        expandedViewManual = mFloatingView.findViewById(R.id.expandedManual);
        expandedViewKofi = mFloatingView.findViewById(R.id.expandedKofi);
        bReset = mFloatingView.findViewById(R.id.bResetXML);

        ocrOutput = (TextView) mFloatingView.findViewById(R.id.ocrOutputXML);
        ocrOutput.setMovementMethod(new ScrollingMovementMethod());
        currentView = expandedView1;

        ListView listViewG = (ListView) mFloatingView.findViewById(R.id.outputList6);
        listViewG.setAdapter(adapterG);


        //currentViewAux = expandedView1AUX;
        //End of linking expandedViews

        //adding click listener to close button and expanded view
        mFloatingView.findViewById(R.id.buttonClose).setOnClickListener(this);
        mFloatingView.findViewById(R.id.bKofiXML).setOnClickListener(this);
        mFloatingView.findViewById(R.id.wv1).setOnClickListener(this);
        bReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chosenSet.clear();
                showInterstitial();
                for(int i = 0; i < listTagButtons.size(); i++){
                    final Button currB = listTagButtons.get(i);
                    final String nameB = listButtonTagNames.get(i);
                    currB.setBackgroundColor(Color.BLACK);
                }
                //startActivity(new Intent(this, ScreenCapture.class));
            }
        });

        bManual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //chosenSet.clear();
                //look through chosenSet and change color of buttons that exist.
                for(int i = 0; i < listTagButtons.size(); i++){
                    final Button currB = listTagButtons.get(i);
                    final String nameB = listButtonTagNames.get(i);
                    if (chosenSet.contains(nameB)) {
                        currB.setBackgroundColor(Color.BLUE);
                    } else {
                        currB.setBackgroundColor(Color.BLACK);
                    }
                }
                /*
                mobi.clear();
                guaranteedMobi.clear();
                adapter.notifyDataSetChanged();
                adapterG.notifyDataSetChanged();
                 */
                expandedView1.setVisibility(View.GONE);
                expandedViewManual.setVisibility(View.VISIBLE);
                currentView = expandedViewManual;
                //startActivity(new Intent(this, ScreenCapture.class));
            }
        });


        final Intent intentInterstitialAd = new Intent(this, InterstitialAdCustom.class);
        intentInterstitialAd.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        bEnter = mFloatingView.findViewById(R.id.bEnterXML);
        bEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //showInterstitial();
                mobi.clear();
                guaranteedMobi.clear();
                adapter.notifyDataSetChanged();
                adapterG.notifyDataSetChanged();
                expandedView1.setVisibility(View.VISIBLE);
                expandedViewManual.setVisibility(View.GONE);
                currentView = expandedView1;
                System.out.println("404: starting before class");

                //TODO: Show Ad here.
                //String password = "BluePoison";
                //PackageZ pkz = new PackageZ(mInterstitialAd);
                //intentInterstitialAd.putExtra("object", pkz);
                startActivity(intentInterstitialAd);
                System.out.println("404: end");
                //showInterstitial();


                Translator trs = new Translator();
                TagsFilter tagsFilter = new TagsFilter();
                listTop = tagsFilter.listTop;
                listSenior = tagsFilter.listSenior;
                listThreeStar = tagsFilter.listThreeStar;
                listTwoStar = tagsFilter.listTwoStar;
                listOneStar = tagsFilter.listOneStar;




                HashMap<List, List> output = tagsFilter.filterTags(chosenSet);
                Iterator it3 = output.entrySet().iterator();
                List<String> chosenHolder = new ArrayList<>();
                String h0 = "<span style =\"background-color:#363636;  color:black;  \"> ";
                for (String curr : chosenSet) {
                    //String newCurr = "<font color=#000000>.</font><font color=#FFFFFF>"+h0+curr+" </font>      </span> ";
                    String newCurr = "<font color=#000000>.</font><font color=#FFFFFF>"+h0+trs.translateEN2CN(curr)+" </font>      </span> ";
                    chosenHolder.add(newCurr);
                }
                String joinedChosenTags = TextUtils.join("<font color=#000000>,</font>", chosenHolder);
                mobi.add(Html.fromHtml("♜"+joinedChosenTags));
                //guaranteedMobi.add(Html.fromHtml("♜"+joinedChosenTags));
                //clear the mobi every scan
                while (it3.hasNext()) {
                    Map.Entry ko3 = (Map.Entry) it3.next();

                    //Filter good and bad tags here
                    //Good tags: List.size() > 1, fastredeploy, summon, crowdcontrol, shift, nuker
                    List<String> holder = new ArrayList<String>();
                    List<String> holder2 = new ArrayList<String>();
                    List<String> holderSpan = new ArrayList<>();

                    holder = (List) ko3.getKey();
                    holder2 = (List) ko3.getValue();

                    String h = "<span style =\"background-color:#363636;\"> ";
                    for(int i = 0; i < holder.size(); i++){
                        String curr = holder.get(i);
                        //curr = "<font color=#000000>.</font>"+h+"<font color=#FFFFFF> "+curr+"</font> </span>";
                        curr = "<font color=#000000>.</font>"+h+"<font color=#FFFFFF> "+trs.translateEN2CN(curr)+"</font> </span>";
                        holderSpan.add(curr);
                    }

                    String joinedKeyTags = TextUtils.join("<font color=#000000>,</font>", holderSpan);
                    //Task: Make them go    | Support || Medic |

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
                    List<String> greenOps = new ArrayList<>();
                    List<String> greyOps = new ArrayList<>();

                    for (int i = 0; i < uncoloredOps.length; i++) {
                        if (listTop.contains(uncoloredOps[i])) {
                            //uncoloredOps[i] = "<font color=#FF3300>" + uncoloredOps[i] + "</font>";
                            uncoloredOps[i] = "<font color=#FF3300>" + trs.translateEN2CN(uncoloredOps[i]) + "</font>";
                            redOps.add(uncoloredOps[i]);
                        } else if (listThreeStar.contains(uncoloredOps[i])) {
                            //uncoloredOps[i] = "<font color=#0080FE>" + uncoloredOps[i] + "</font>";
                            uncoloredOps[i] = "<font color=#0080FE>" + trs.translateEN2CN(uncoloredOps[i]) + "</font>";
                            blueOps.add(uncoloredOps[i]);
                        } else if (listSenior.contains(uncoloredOps[i])) {
                            //uncoloredOps[i] = "<font color=#FFD700>" + uncoloredOps[i] + "</font>";
                            uncoloredOps[i] = "<font color=#FFD700>" + trs.translateEN2CN(uncoloredOps[i]) + "</font>";
                            goldOps.add(uncoloredOps[i]);
                        } else if (listTwoStar.contains(uncoloredOps[i])) {
                            //uncoloredOps[i] = "<font color=#FFD700>" + uncoloredOps[i] + "</font>";
                            uncoloredOps[i] = "<font color=#00cc00>" + trs.translateEN2CN(uncoloredOps[i]) + "</font>";
                            greenOps.add(uncoloredOps[i]);
                        } else if (listOneStar.contains(uncoloredOps[i])) {
                            //uncoloredOps[i] = "<font color=#FFD700>" + uncoloredOps[i] + "</font>";
                            uncoloredOps[i] = "<font color=#e0e0eb>" + trs.translateEN2CN(uncoloredOps[i]) + "</font>";
                            greyOps.add(uncoloredOps[i]);
                        } else {
                            //uncoloredOps[i] = "<font color=#CC99ff>" + uncoloredOps[i] + "</font>";
                            uncoloredOps[i] = "<font color=#CC99ff>" + trs.translateEN2CN(uncoloredOps[i]) + "</font>";
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
                        coloredList.addAll(greenOps);
                        coloredList.addAll(greyOps);
                    }
                    String coloredOps = TextUtils.join(", ", coloredList);

                    //TODO: This is what makes colored words work in HTML
                    //String h = "<span style =\"background-color:#4295d6;\">";
                    String listElement = joinedKeyTags +"<br/>" + coloredOps;
                    mobi.add(Html.fromHtml(listElement));
                    if (blueOps.size()==0 && greenOps.size()==0){
                        guaranteedMobi.add(Html.fromHtml(listElement));
                    }
                }//end of hasNext while loop
                //mobi.add(Html.fromHtml("Note: 1* operators like Lancet-2, Castle-3 and Thermal-EX are only available on a 03:50:00 or shorter timer"));
                mobi.add(Html.fromHtml("Note: Lancet-2, Castle-3 和 Thermal-EX 只在 03:50:00 以下才会出现"));
                mobi.add(Html.fromHtml("Data Source: GraueNeko"));

            } //End of onClick function
        });

        bPrevFromKofi = mFloatingView.findViewById(R.id.bPrevKofiXML);
        bPrevFromKofi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandedView1.setVisibility(View.VISIBLE);
                expandedViewKofi.setVisibility(View.GONE);
                currentView = expandedView1;
            }
        });

        bPrevFromManual= mFloatingView.findViewById(R.id.bPrevFromManualXML);
        bPrevFromManual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                chosenSet.clear();
                for(int i = 0; i < listTagButtons.size(); i++){
                    final Button currB = listTagButtons.get(i);
                    currB.setBackgroundColor(Color.BLACK);
                }
                mobi.clear();
                //mobi.add(Html.fromHtml("When in Recruit page, press SCAN to detect the tags.<br/> - The filter is default to 9hours timer. Hence starter and robot tag would not be detected and filtered."));
                mobi.add(Html.fromHtml("When in Recruit page, press SCAN to detect the tags."));
                mobi.add(Html.fromHtml("♜ Scroll downwards to read unshown information."));
                mobi.add(Html.fromHtml("♜ Press MANUAL to manually add or select tags to filter."));
                mobi.add(Html.fromHtml("♜ Press GUARANTEED to see if any Guaranteed tag combinations exist"));
                mobi.add(Html.fromHtml("♜ Since the filter is default to 9hours timer, Starter and Robot tags would not be detected or filtered."));
                guaranteedMobi.clear();
                adapter.notifyDataSetChanged();
                adapterG.notifyDataSetChanged();

                 */
                expandedView1.setVisibility(View.VISIBLE);
                expandedViewManual.setVisibility(View.GONE);
                currentView = expandedView1;
                //startActivity(new Intent(this, ScreenCapture.class));
            }
        });

        bGuaranteed = mFloatingView.findViewById(R.id.bGuaranteedXML);
        bGuaranteed.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                expandedView1.setVisibility(View.GONE);
                expandedViewG.setVisibility(View.VISIBLE);
                currentView = expandedViewG;
                if(guaranteedMobi.isEmpty()){
                    String listElement ="没有4★以上的组合";
                    guaranteedMobi.add(Html.fromHtml(listElement));
                }

            }//end of onClickL of bGuaranteed6
        });

        bPrev = mFloatingView.findViewById(R.id.bPrevXML);
        bPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandedViewG.setVisibility(View.GONE);
                expandedView1.setVisibility(View.VISIBLE);
                currentView = expandedView1;
            }
        });

        //Start of widgetMainIcon functionality code: dragging trueIcon, auto expand and set collapsed view gone.
        mFloatingView.findViewById(R.id.widgetMainIcon).setOnTouchListener(new View.OnTouchListener() {
            private int initialX;
            private int initialY;
            private float initialTouchX;
            private float initialTouchY;
            private static final int MAX_CLICK_DURATION = 200;
            private long startClickTime;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        startClickTime = Calendar.getInstance().getTimeInMillis();
                        //break;
                        initialX = params.x;
                        initialY = params.y;
                        initialTouchX = event.getRawX();
                        initialTouchY = event.getRawY();
                        return true;


                    case MotionEvent.ACTION_UP:
                        long clickDuration = Calendar.getInstance().getTimeInMillis() - startClickTime;
                        if(clickDuration < MAX_CLICK_DURATION) {

                            if (collapsedTrue==true){
                                //when the drag is ended switching the state of the widget
                                collapsedView.setVisibility(View.GONE);
                                collapsedTrue = false;
                                bCloseMin.setVisibility(View.VISIBLE);
                                //bCloseMin.setImageResource(R.drawable.ak_icon_min);
                                //expander1.setVisibility(View.VISIBLE);
                                //expandedView1.setVisibility(View.VISIBLE);
                                //currentViewAux.setVisibility(View.VISIBLE);
                                currentView.setVisibility(View.VISIBLE);
                                bManual.performClick();
                                return true;
                            } else{
                                collapsedView.setVisibility(View.VISIBLE);
                                collapsedTrue = true;
                                bCloseMin.setVisibility(View.GONE);
                                //bCloseMin.setImageResource(R.drawable.ak_icon_off);
                                //expander1.setVisibility(View.VISIBLE);
                                //expandedView1.setVisibility(View.VISIBLE);
                                //currentViewAux.setVisibility(View.VISIBLE);
                                currentView.setVisibility(View.GONE);
                                return true;
                            }
                        }
                    case MotionEvent.ACTION_MOVE:
                        //this code is helping the widget to move around the screen with fingers
                        params.x = initialX + (int) (event.getRawX() - initialTouchX);
                        params.y = initialY + (int) (event.getRawY() - initialTouchY);
                        mWindowManager.updateViewLayout(mFloatingView, params);
                        return true;
                }
                return false;
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mFloatingView != null) mWindowManager.removeView(mFloatingView);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bKofiXML:
                currentView.setVisibility(View.GONE);
                expandedViewKofi.setVisibility(View.VISIBLE);
                currentView = expandedViewKofi;
                break;
            case R.id.expanded1AUX:
                //switching views
                collapsedView.setVisibility(View.VISIBLE);
                currentView.setVisibility(View.GONE);
                break;

            case R.id.buttonClose:
                stopSelf();
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        Log.d(TAG,"App started" );

        mInterstitialAd = new com.google.android.gms.ads.InterstitialAd(this);
        //TEST
        //mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        //REAL
        mInterstitialAd.setAdUnitId("ca-app-pub-7694682114536441/7463328603");
        //Load

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                // Load the next interstitial.
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }

        })
        ;mInterstitialAd.loadAd(new AdRequest.Builder().build());





        String cargo = intent.getStringExtra("ocrOutput");
        //Required for mobi.add to work
        adapter = new ArrayAdapter<CharSequence>(this, R.layout.activity_listview, mobi);
        ListView listView = (ListView) mFloatingView.findViewById(R.id.outputListView);
        listView.setAdapter(adapter);
        if (cargo == "textRecognizer is not operational"){
            mobi.clear();
            adapter.notifyDataSetChanged();
            mobi.add(Html.fromHtml("♜ Error: testRecognizer is not operational. This might mean Google playstore is still downloading the 'com.google.android.gms:play-services-vision:11.8.0' package for OCR function. Please either wait a while and try again or reinstall this app. In the meanwhile please use [manual] instead."));
            return START_STICKY;
        }

        //Not activated in CN and JP version. This is for version with screenshot and scanning
        /*
        if (cargo != null){

            List<String> outputL = new ArrayList<>();

            for(int i = 0; i < ocrListTags.size(); i++){
                String curr  = ocrListTags.get(i);
                if (cargo.indexOf(curr)!=-1){
                    if(curr=="Support"){
                        int letterE = cargo.indexOf(curr)+7;
                        if(cargo.charAt(letterE)!='e'){
                            outputL.add("Support");
                            chosenSet.add("Support");
                        }
                    } else {
                        if(curr=="Fast"){
                            outputL.add("Fast-Redeploy");
                            chosenSet.add("Fast-Redeploy");
                        }
                        else if(curr=="Recovery"){
                            outputL.add("DP-Recovery");
                            chosenSet.add("DP-Recovery");
                        }
                        else if (curr=="Crowd"){
                            outputL.add("Crowd-Control");
                            chosenSet.add("Crowd-Control");
                        }
                        else if (curr=="Starter"){
                            outputL.add("Starter");
                        }
                        else{
                            outputL.add(curr);
                            chosenSet.add(curr);
                        }
                    }
                }
            }//end of for loop

            TagsFilter tagsFilter = new TagsFilter();
            HashMap<List, List> output = tagsFilter.filterTags(chosenSet);
            Iterator it3 = output.entrySet().iterator();
            //ocrOutput.setText(chosenSet.toString());
            List<String> chosenHolder = new ArrayList<>();
            String h0 = "<span style =\"background-color:#363636;  color:black;  \"> ";
            //            String h0 = "<span style =\"background-color:#363636;\"> ";
            for (String curr : chosenSet) {
                //String newCurr = "."+h0+"<font color=#FFFFFF>"+curr+"</font> </span>";
                String newCurr = "<font color=#000000>.</font><font color=#FFFFFF>"+h0+curr+" </font>      </span> ";
                //String newCurr = ".<u>"+h0+curr+"</u></span>";
                chosenHolder.add(newCurr);
            }
            String joinedChosenTags = TextUtils.join("<font color=#000000>,</font>", chosenHolder);
            //setTextWithSpan(ocrOutput, android.graphics.Color.BLUE, "Hellhghghgh ghghghg gggghhhh   ghghghg  yy  tlll hello hogwatrs xion phantasy star ongline", 1.1f);
            //ocrOutput.setPaintFlags(ocrOutput.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            ocrOutput.setText(cargo.toString());
            mobi.clear();
            adapter.notifyDataSetChanged();
            //testing
            guaranteedMobi.clear();
            adapterG.notifyDataSetChanged();
            mobi.add(Html.fromHtml("♜"+joinedChosenTags));
            //clear the mobi every scan



            while (it3.hasNext()) {
                Map.Entry ko3 = (Map.Entry) it3.next();

                //Filter good and bad tags here
                //Good tags: List.size() > 1, fastredeploy, summon, crowdcontrol, shift, nuker
                List<String> holder = new ArrayList<String>();
                List<String> holder2 = new ArrayList<String>();
                List<String> holderSpan = new ArrayList<>();

                holder = (List) ko3.getKey();
                holder2 = (List) ko3.getValue();

                String h = "<span style =\"background-color:#363636;\"> ";
                for(int i = 0; i < holder.size(); i++){
                    String curr = holder.get(i);
                    curr = "<font color=#000000>.</font>"+h+"<font color=#FFFFFF> "+curr+"</font> </span>";
                    holderSpan.add(curr);
                }


                String joinedKeyTags = TextUtils.join("<font color=#000000>,</font>", holderSpan);
                //Task: Make them go    | Support || Medic |


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

                //This is what makes colored words work in HTML
                //String h = "<span style =\"background-color:#4295d6;\">";
                String listElement = joinedKeyTags +"<br/>" + coloredOps;
                mobi.add(Html.fromHtml(listElement));
                //if (blueOps.size()==0){
                guaranteedMobi.add(Html.fromHtml(listElement));
                //}

            }//while loop
        } else{
            //bManual.performClick();
            mobi.add(Html.fromHtml("When in Recruit page, press SCAN to detect the tags."));
            //mobi.add(Html.fromHtml("<script type='text/javascript' src='https://ko-fi.com/widgets/widget_2.js'></script><script type='text/javascript'>kofiwidget2.init('Support Me on Ko-fi', '#29abe0', 'B0B71OFO9');kofiwidget2.draw();</script> "));
            mobi.add(Html.fromHtml("♜ Scroll downwards to read unshown information."));
            mobi.add(Html.fromHtml("♜ Press MANUAL to manually add or select tags to filter."));
            mobi.add(Html.fromHtml("♜ Press GUARANTEED to see if any Guaranteed tag combinations exist"));
            mobi.add(Html.fromHtml("♜ Since the filter is default to 9hours timer, Starter and Robot tags would not be detected or filtered."));
        }
        */
        return START_STICKY;
    }

    private InterstitialAd mInterstitialAd;
    private void showInterstitial()
    {
        if (mInterstitialAd.isLoaded()) {
            Toast.makeText(getApplicationContext(), "Alpha 1", Toast.LENGTH_SHORT).show();
            mInterstitialAd.show();
        } else {
            Toast.makeText(getApplicationContext(), "Alpha 2", Toast.LENGTH_SHORT).show();
            Toast.makeText(getApplicationContext(), "Alpha 2b", Toast.LENGTH_SHORT).show();
            Log.d("TAG", "The interstitial wasn't loaded yet.");
            //mInterstitialAd.show();
        }
    }

}
