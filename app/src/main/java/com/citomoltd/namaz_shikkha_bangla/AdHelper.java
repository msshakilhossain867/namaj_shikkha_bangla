package com.citomoltd.namaz_shikkha_bangla;

import android.app.Activity;
import android.util.Log;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class AdHelper {

    private static final String TAG = "AdHelper";

    // 3 minutes interval
    private static final long AD_INTERVAL = 3 * 60 * 1000L;

    // ============================================================
    // TEST AD UNIT IDs
    // ============================================================

    private static final String INTERSTITIAL_AD_UNIT_ID = "ca-app-pub-3940256099942544/1033173712";
   // private static final String INTERSTITIAL_AD_UNIT_ID = "ca-app-pub-5488667449529842/9310577446";

    private static final String BANNER_AD_UNIT_ID = "ca-app-pub-3940256099942544/6300978111";
    //private static final String BANNER_AD_UNIT_ID = "ca-app-pub-5488667449529842/3725565500";


    // ============================================================
    // INTERSTITIAL VARIABLES
    // ============================================================

    private static long lastAdTime = 0;

    private static InterstitialAd mInterstitialAd;

    private static boolean isAdLoading = false;


    // ============================================================
    // BANNER VARIABLES
    // ============================================================

    private static AdView mAdView;

    private static boolean isBannerAdLoading = false;


    // ============================================================
    // AD LISTENER
    // ============================================================

    public interface AdListener {

        void onAdClosed();

    }


    // ============================================================
    // INITIALIZE / PRELOAD INTERSTITIAL
    // ============================================================

    public static void initializeAd(Activity activity) {

        if (activity == null || activity.isFinishing()) {
            return;
        }

        loadNewAd(activity);
    }


    // ============================================================
    // SHOW INTERSTITIAL IF NEEDED
    // ============================================================

    public static void showAdIfNeeded(
            Activity activity,
            AdListener listener
    ) {

        if (activity == null || activity.isFinishing()) {

            if (listener != null) {
                listener.onAdClosed();
            }

            return;
        }


        long currentTime = System.currentTimeMillis();


        // ========================================================
        // CHECK 3 MINUTE INTERVAL
        // ========================================================

        if (lastAdTime != 0 &&
                currentTime - lastAdTime < AD_INTERVAL) {

            Log.d(TAG, "Ad interval not completed.");

            if (listener != null) {
                listener.onAdClosed();
            }

            return;
        }


        // ========================================================
        // CHECK AD READY
        // ========================================================

        if (mInterstitialAd != null) {

            mInterstitialAd.setFullScreenContentCallback(
                    new FullScreenContentCallback() {

                        @Override
                        public void onAdShowedFullScreenContent() {

                            Log.d(
                                    TAG,
                                    "Interstitial ad showed."
                            );

                            // Prevent same ad from showing again
                            mInterstitialAd = null;

                            // Update last show time
                            lastAdTime =
                                    System.currentTimeMillis();
                        }


                        @Override
                        public void onAdDismissedFullScreenContent() {

                            Log.d(
                                    TAG,
                                    "Interstitial ad dismissed."
                            );

                            // Load next ad
                            loadNewAd(activity);


                            if (listener != null) {
                                listener.onAdClosed();
                            }
                        }


                        @Override
                        public void onAdFailedToShowFullScreenContent(
                                AdError adError
                        ) {

                            Log.d(
                                    TAG,
                                    "Interstitial failed to show: "
                                            + adError.getMessage()
                            );

                            mInterstitialAd = null;


                            // Try loading another ad
                            loadNewAd(activity);


                            if (listener != null) {
                                listener.onAdClosed();
                            }
                        }
                    }
            );


            mInterstitialAd.show(activity);

        } else {

            Log.d(
                    TAG,
                    "Interstitial not ready. Loading..."
            );

            loadNewAd(activity);


            if (listener != null) {
                listener.onAdClosed();
            }
        }
    }


    // ============================================================
    // LOAD INTERSTITIAL
    // ============================================================

    private static void loadNewAd(Activity activity) {

        if (activity == null || activity.isFinishing()) {
            return;
        }


        // Already loading
        if (isAdLoading) {

            Log.d(
                    TAG,
                    "Interstitial ad is already loading."
            );

            return;
        }


        // Already loaded
        if (mInterstitialAd != null) {

            Log.d(
                    TAG,
                    "Interstitial ad already available."
            );

            return;
        }


        isAdLoading = true;


        AdRequest adRequest =
                new AdRequest.Builder().build();


        InterstitialAd.load(
                activity,
                INTERSTITIAL_AD_UNIT_ID,
                adRequest,

                new InterstitialAdLoadCallback() {

                    @Override
                    public void onAdLoaded(
                            @NonNull InterstitialAd interstitialAd
                    ) {

                        Log.d(
                                TAG,
                                "Interstitial ad loaded."
                        );

                        mInterstitialAd =
                                interstitialAd;

                        isAdLoading = false;
                    }


                    @Override
                    public void onAdFailedToLoad(
                            @NonNull LoadAdError loadAdError
                    ) {

                        Log.d(
                                TAG,
                                "Interstitial failed to load: "
                                        + loadAdError.getMessage()
                        );

                        mInterstitialAd = null;

                        isAdLoading = false;
                    }
                }
        );
    }


    // ============================================================
    // LOAD BANNER
    // ============================================================

    public static void loadBannerAd(
            Activity activity,
            FrameLayout adContainer
    ) {

        if (activity == null ||
                activity.isFinishing() ||
                adContainer == null) {

            return;
        }


        if (isBannerAdLoading) {

            Log.d(
                    TAG,
                    "Banner ad is already loading."
            );

            return;
        }


        // Remove previous banner
        clearBannerAd();


        isBannerAdLoading = true;


        // ========================================================
        // CREATE BANNER
        // ========================================================

        mAdView = new AdView(activity);

        mAdView.setAdSize(AdSize.BANNER);

        mAdView.setAdUnitId(
                BANNER_AD_UNIT_ID
        );


        adContainer.removeAllViews();

        adContainer.addView(mAdView);


        // ========================================================
        // AD LISTENER
        // ========================================================

        mAdView.setAdListener(
                new com.google.android.gms.ads.AdListener() {

                    @Override
                    public void onAdLoaded() {

                        isBannerAdLoading = false;

                        Log.d(
                                TAG,
                                "Banner ad loaded."
                        );
                    }


                    @Override
                    public void onAdFailedToLoad(
                            LoadAdError loadAdError
                    ) {

                        isBannerAdLoading = false;

                        Log.d(
                                TAG,
                                "Banner ad failed to load: "
                                        + loadAdError.getMessage()
                        );
                    }
                }
        );


        // ========================================================
        // LOAD AD
        // ========================================================

        AdRequest adRequest =
                new AdRequest.Builder().build();

        mAdView.loadAd(adRequest);
    }


    // ============================================================
    // CLEAR BANNER
    // ============================================================

    public static void clearBannerAd() {

        if (mAdView != null) {

            try {

                mAdView.destroy();

            } catch (Exception e) {

                Log.e(
                        TAG,
                        "Banner destroy error: "
                                + e.getMessage()
                );
            }

            mAdView = null;
        }


        isBannerAdLoading = false;
    }


    // ============================================================
    // CLEAR INTERSTITIAL
    // ============================================================

    public static void clearInterstitialAd() {

        mInterstitialAd = null;

        isAdLoading = false;
    }
}