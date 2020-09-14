package com.neosixth.arknightsrecruiterwidgetcn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;


public class InterstitialAdCustom extends AppCompatActivity {
    private com.google.android.gms.ads.InterstitialAd mInterstitialAd;

    private PackageZ pkz2;

    private void showInterstitial()
    {
        //System.out.println("404: starting"+mInterstitialAd.isLoaded());
        Log.i("UMP","starting "+mInterstitialAd.isLoaded() );
        Toast.makeText(getApplicationContext(), "Ad status: "+mInterstitialAd.isLoaded(), Toast.LENGTH_SHORT).show();
        if (mInterstitialAd.isLoaded()) {
            Toast.makeText(getApplicationContext(), "Ad should have loaded", Toast.LENGTH_SHORT).show();
            Log.d("UMP404","loaded, before show");
            mInterstitialAd.show();
        } else {
            Log.d("UMP404","not loaded");
            Toast.makeText(getApplicationContext(), "Ad failed to load", Toast.LENGTH_SHORT).show();
            //showInterstitial();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //getWindow().addFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        getWindow().addFlags(
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                        | WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                        | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);




        //Toast.makeText(getApplicationContext(), "Alpha 1", Toast.LENGTH_SHORT).show();
        mInterstitialAd = new com.google.android.gms.ads.InterstitialAd(this);
        //TEST
        //mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        //REAL：a-app-pub-7694682114536441/7463328603
        mInterstitialAd.setAdUnitId("ca-app-pub-7694682114536441/7463328603");
        //mInterstitialAd.setAdUnitId("ca-app-pub-7033225971919657/2032796155");
        //test: ca-app-pub-3940256099942544/1033173712
        // real : ca-app-pub-7694682114536441/7463328603
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                // Load the next interstitial.
                //mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }

            @Override
            public void onAdLoaded(){
                Toast.makeText(getApplicationContext(), "onAdLoaded()", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onAdFailedToLoad(LoadAdError loadAdError) {
                String error =
                        String.format(
                                "domain: %s, code: %d, message: %s",
                                loadAdError.getDomain(), loadAdError.getCode(), loadAdError.getMessage());
                Toast.makeText(
                        getApplicationContext(), "onAdFailedToLoad() with error: " + error, Toast.LENGTH_SHORT)
                        .show();
            }

        });

        Intent intent=new Intent(InterstitialAdCustom.this,EmptyAct.class);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                // yourMethod();
            }
        }, 10000);   //5 seconds

        startActivityForResult(intent, 2);


        //finish();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        showInterstitial();




        // check if the request code is same as what is passed  here it is 2
        if(requestCode==2)
        {
            finish();
        }
    }


}
