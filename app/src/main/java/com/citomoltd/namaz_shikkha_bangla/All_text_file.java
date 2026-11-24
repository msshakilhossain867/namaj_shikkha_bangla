package com.citomoltd.namaz_shikkha_bangla;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;



public class All_text_file extends AppCompatActivity {

    TextView toolbar,txtAll;
    public static String TL_TEXT="";
    public static String ALL_TEXT="";
    ImageView back_arrow;

    float userRate=0;
    Dialog dialog;


    int anInt=0;
    SharedPreferences sharedPreferences;


    //hello world
    //hello worldg




    @SuppressLint({"MissingInflatedId", "ClickableViewAccessibility"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_all_text_file);


        FrameLayout adContainer = findViewById(R.id.adContainer);

        AdHelper.loadBannerAd(
                this,
                adContainer
        );




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        toolbar=findViewById(R.id.stToolbar);
        txtAll=findViewById(R.id.txtAll);
        back_arrow=findViewById(R.id.back_arrow);

        toolbar.setText(TL_TEXT);
        txtAll.setText(ALL_TEXT);




   txtAll.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           if (txtAll.isClickable()){
               setUserRateUs();
           }



       }
   });


        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getOnBackPressedDispatcher().onBackPressed();
            }
        });


    }


    private void  setUserRateUs(){
        dialog =new Dialog(this);
        dialog.setContentView(R.layout.rate_us_dialog_layout);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);
        dialog.getWindow().getAttributes().windowAnimations=R.style.animation;

        final AppCompatButton rateNowBtn= dialog.findViewById(R.id.rateNowBtn);
        final AppCompatButton laterBtn=dialog.findViewById(R.id.laterBtn);
        final AppCompatRatingBar ratingBar= dialog.findViewById(R.id.ratingBar);
        final ImageView ratingImage= dialog.findViewById(R.id.imageIcon);



        rateNowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id="+getPackageName())));
                }catch (ActivityNotFoundException e){
                    startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://play.google.com/store/apps/details?id="+getPackageName())));
                }


            }
        });

        laterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });


        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                if (rating<=1){
                    ratingImage.setImageResource(R.drawable.one_star);
                } else if (rating<=2) {
                    ratingImage.setImageResource(R.drawable.two_star);
                }else if (rating<=3) {
                    ratingImage.setImageResource(R.drawable.three_star);
                }else if (rating<=4) {
                    ratingImage.setImageResource(R.drawable.four_star);
                }else if (rating<=5) {
                    ratingImage.setImageResource(R.drawable.five_star);
                }
                animatedImage(ratingImage);
                userRate=rating;
            }
        });
        dialog.show();
    }

    private void animatedImage(ImageView ratingImage){
        ScaleAnimation scaleAnimation=new ScaleAnimation(0,1f,0,1f, Animation.RELATIVE_TO_SELF,
                0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(200);
        ratingImage.startAnimation(scaleAnimation);

    }

    @Override
    protected void onDestroy() {
        AdHelper.clearBannerAd();
        super.onDestroy();
    }


}