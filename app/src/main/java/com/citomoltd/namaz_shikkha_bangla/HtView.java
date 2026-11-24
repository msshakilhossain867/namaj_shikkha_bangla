package com.citomoltd.namaz_shikkha_bangla;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

public class HtView extends AppCompatActivity {

    private WebView webView;

    private TextView toolbar;

    private ImageView back_arrow;

    private Dialog dialog;

    private float userRate = 0;

    public static String TITTLE_Ht = "";
    public static String DESCRIPTION = "";

    private Toolbar toolbar2;

    private LinearLayout webLoadingLayout;

    private ProgressBar webProgressBar;


    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_ht_view);


        ViewCompat.setOnApplyWindowInsetsListener(
                findViewById(R.id.layout),
                (v, insets) -> {

                    Insets systemBars =
                            insets.getInsets(
                                    WindowInsetsCompat.Type.systemBars()
                            );

                    v.setPadding(
                            systemBars.left,
                            systemBars.top,
                            systemBars.right,
                            systemBars.bottom
                    );

                    return insets;
                }
        );


        // ============================================================
        // FIND VIEWS
        // ============================================================

        webView = findViewById(R.id.webView);

        toolbar = findViewById(R.id.stToolbar);

        back_arrow = findViewById(R.id.back_arrow);

        toolbar2 = findViewById(R.id.toolbar2);

        webLoadingLayout =
                findViewById(R.id.webLoadingLayout);

        webProgressBar =
                findViewById(R.id.webProgressBar);


        // ============================================================
        // TOOLBAR TITLE
        // ============================================================

        toolbar.setText(TITTLE_Ht);


        // ============================================================
        // BANNER AD
        // ============================================================

        FrameLayout adContainer =
                findViewById(R.id.adContainer);

        AdHelper.loadBannerAd(
                this,
                adContainer
        );


        // ============================================================
        // BACK BUTTON
        // ============================================================

        back_arrow.setOnClickListener(v -> {

            getOnBackPressedDispatcher()
                    .onBackPressed();

        });


        // ============================================================
        // WEBVIEW SETTINGS
        // ============================================================

        webView.getSettings()
                .setJavaScriptEnabled(true);

        webView.setNestedScrollingEnabled(true);

        webView.getSettings()
                .setDomStorageEnabled(true);


        // ============================================================
        // WEBVIEW CLIENT
        // ============================================================

        webView.setWebViewClient(
                new WebViewClient() {

                    @Override
                    public void onPageStarted(
                            WebView view,
                            String url,
                            Bitmap favicon
                    ) {

                        super.onPageStarted(
                                view,
                                url,
                                favicon
                        );

                        showLoading();
                    }


                    @Override
                    public void onPageFinished(
                            WebView view,
                            String url
                    ) {

                        super.onPageFinished(
                                view,
                                url
                        );

                        hideLoading();
                    }


                    @Override
                    public void onReceivedError(
                            WebView view,
                            WebResourceRequest request,
                            WebResourceError error
                    ) {

                        super.onReceivedError(
                                view,
                                request,
                                error
                        );

                        // Only hide loading for main page
                        if (request.isForMainFrame()) {

                            hideLoading();
                        }
                    }
                }
        );


        // ============================================================
        // LOAD WEB PAGE
        // ============================================================

        showLoading();

        webView.loadUrl(DESCRIPTION);


        // ============================================================
        // TOOLBAR MENU
        // ============================================================

        toolbar2.setOnMenuItemClickListener(
                item -> {

                    try {

                        startActivity(
                                new Intent(
                                        Intent.ACTION_VIEW,
                                        Uri.parse(
                                                "market://details?id="
                                                        + getPackageName()
                                        )
                                )
                        );

                    } catch (ActivityNotFoundException e) {

                        startActivity(
                                new Intent(
                                        Intent.ACTION_VIEW,
                                        Uri.parse(
                                                "https://play.google.com/store/apps/details?id="
                                                        + getPackageName()
                                        )
                                )
                        );
                    }

                    return true;
                }
        );


        // ============================================================
        // WEBVIEW CLICK
        // ============================================================

        webView.setOnClickListener(v -> {

            if (webView.isClickable()) {

                setUserRateUs();
            }
        });



        getOnBackPressedDispatcher().addCallback(
                this,
                new OnBackPressedCallback(true) {

                    @Override
                    public void handleOnBackPressed() {

                        if (webView != null &&
                                webView.canGoBack()) {

                            webView.goBack();

                        } else {

                            finish();
                        }
                    }
                }
        );


    }


    // ============================================================
    // SHOW LOADING
    // ============================================================

    private void showLoading() {

        if (webLoadingLayout != null) {

            webLoadingLayout.setVisibility(
                    View.VISIBLE
            );
        }

        if (webProgressBar != null) {

            webProgressBar.setVisibility(
                    View.VISIBLE
            );
        }

        if (webView != null) {

            webView.setVisibility(
                    View.INVISIBLE
            );
        }
    }


    // ============================================================
    // HIDE LOADING
    // ============================================================

    private void hideLoading() {

        if (webLoadingLayout != null) {

            webLoadingLayout.setVisibility(
                    View.GONE
            );
        }

        if (webProgressBar != null) {

            webProgressBar.setVisibility(
                    View.GONE
            );
        }

        if (webView != null) {

            webView.setVisibility(
                    View.VISIBLE
            );
        }
    }


    // ============================================================
    // RATE US
    // ============================================================

    private void setUserRateUs() {

        dialog = new Dialog(this);

        dialog.setContentView(
                R.layout.rate_us_dialog_layout
        );

        if (dialog.getWindow() != null) {

            dialog.getWindow().setLayout(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            );

            dialog.getWindow()
                    .getAttributes()
                    .windowAnimations =
                    R.style.animation;
        }

        dialog.setCancelable(false);


        AppCompatButton rateNowBtn =
                dialog.findViewById(
                        R.id.rateNowBtn
                );

        AppCompatButton laterBtn =
                dialog.findViewById(
                        R.id.laterBtn
                );

        AppCompatRatingBar ratingBar =
                dialog.findViewById(
                        R.id.ratingBar
                );

        ImageView ratingImage =
                dialog.findViewById(
                        R.id.imageIcon
                );


        // ============================================================
        // RATE NOW
        // ============================================================

        rateNowBtn.setOnClickListener(v -> {

            try {

                startActivity(
                        new Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse(
                                        "market://details?id="
                                                + getPackageName()
                                )
                        )
                );

            } catch (ActivityNotFoundException e) {

                startActivity(
                        new Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse(
                                        "https://play.google.com/store/apps/details?id="
                                                + getPackageName()
                                )
                        )
                );
            }
        });


        // ============================================================
        // LATER
        // ============================================================

        laterBtn.setOnClickListener(v -> {

            if (dialog != null &&
                    dialog.isShowing()) {

                dialog.dismiss();
            }
        });


        // ============================================================
        // RATING CHANGE
        // ============================================================

        ratingBar.setOnRatingBarChangeListener(
                (ratingBar1, rating, fromUser) -> {

                    if (rating <= 1) {

                        ratingImage.setImageResource(
                                R.drawable.one_star
                        );

                    } else if (rating <= 2) {

                        ratingImage.setImageResource(
                                R.drawable.two_star
                        );

                    } else if (rating <= 3) {

                        ratingImage.setImageResource(
                                R.drawable.three_star
                        );

                    } else if (rating <= 4) {

                        ratingImage.setImageResource(
                                R.drawable.four_star
                        );

                    } else if (rating <= 5) {

                        ratingImage.setImageResource(
                                R.drawable.five_star
                        );
                    }


                    animatedImage(ratingImage);

                    userRate = rating;
                }
        );


        dialog.show();
    }


    // ============================================================
    // RATING IMAGE ANIMATION
    // ============================================================

    private void animatedImage(
            ImageView ratingImage
    ) {

        ScaleAnimation scaleAnimation =
                new ScaleAnimation(
                        0,
                        1f,
                        0,
                        1f,
                        Animation.RELATIVE_TO_SELF,
                        0.5f,
                        Animation.RELATIVE_TO_SELF,
                        0.5f
                );

        scaleAnimation.setFillAfter(true);

        scaleAnimation.setDuration(200);

        ratingImage.startAnimation(
                scaleAnimation
        );
    }


    // ============================================================
    // BACK HANDLING FOR WEBVIEW
    // ============================================================




    // ============================================================
    // DESTROY
    // ============================================================

    @Override
    protected void onDestroy() {

        AdHelper.clearBannerAd();


        if (webView != null) {

            webView.stopLoading();

            webView.loadUrl("about:blank");

            webView.clearHistory();

            webView.removeAllViews();

            webView.destroy();

            webView = null;
        }


        if (dialog != null &&
                dialog.isShowing()) {

            dialog.dismiss();
        }


        super.onDestroy();
    }
}