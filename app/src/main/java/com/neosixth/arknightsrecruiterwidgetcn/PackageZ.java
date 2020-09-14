package com.neosixth.arknightsrecruiterwidgetcn;

import com.google.android.gms.ads.InterstitialAd;

import java.io.Serializable;

public class PackageZ implements Serializable {
    private InterstitialAd mInterstitialAd;

    public PackageZ(InterstitialAd iad){
        this.mInterstitialAd = iad;
    }

    public InterstitialAd getmInterstitialAd(){
        return mInterstitialAd;
    }
}
