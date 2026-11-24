package com.citomoltd.namaz_shikkha_bangla;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class Content_list2 extends AppCompatActivity {


    ImageView back_arrow;
    TextView textView;
    public static String L2TITTLE="";
    Button bt1,bt2,bt3,bt4,bt5,bt6,bt7;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_content_list2);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        back_arrow=findViewById(R.id.back_arrow);
        textView=findViewById(R.id.stToolbar);
        bt1=findViewById(R.id.bt1);
        bt2=findViewById(R.id.bt2);
        bt3=findViewById(R.id.bt3);
        bt4=findViewById(R.id.bt4);
        bt5=findViewById(R.id.bt5);
        bt6=findViewById(R.id.bt6);
        bt7=findViewById(R.id.bt7);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                All_text_file.TL_TEXT="ভূমিকা";
                All_text_file.ALL_TEXT="ধাপে ধাপে নামাজ শিক্ষা\n\n" +
                        "মহান আল্লাহ রাব্বুল আ'লামীন বান্দা'র জন্য ইবাদতকে সহজ করে দিয়েছেন। জ্বীন এবং মানব জাতিকে কেবলমাত্র তাঁর ইবাদতের জন্য সৃষ্টি করলেও দৈনিক ফরজ করেছেন মাত্র পাঁচ ওয়াক্ত নামাজ। তার পরেও সময় ও সুযোগের অভাবে আমাদের অনেকেরই সহীহ নিয়মে সুন্দরভাবে নামাজ আদায়ের নিয়মসমূহ শেখা হয় না। তাই আমরা অ্যাপলিকেশনের এই অংশে ধাপে ধাপে নামাজের বিষয়গুলো সহজভাবে উপস্থাপনের চেষ্টা করেছি।\n" +
                        "\n" +
                        "এই অংশে নামাজের ধাপগুলো কীভাবে আদায় করতে হবে, সেই দিকে অধিক গুরুত্ব দেওয়া হয়েছে। কিন্তু এর জন্য প্রয়োজনীয় সূরা ও অন্যান্য দোয়া ও তাসবীহ-এর জন্য সম্পূর্ণ অ্যাপলিকেশনের সকল অধ্যায় পাঠ করা জরুরি। আমরা আশা করছি যে ব্যবহারকারী আমাদের অ্যাপলিকেশনের সমগ্র অংশই পুনঃপুন পাঠের মাধ্যমে সহীহ ও সুন্দরভাবে নামাজ আদায় করতে সক্ষম হবে ইনশা-আল্লাহ।";
                Intent intent=new Intent(Content_list2.this,All_text_file.class);
                startActivity(intent);

            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HtView.TITTLE_Ht="নামাজে দাড়ানোর নিয়ম";
                HtView.DESCRIPTION="file:///android_asset/namaj_man.html";
                Intent intent=new Intent(Content_list2.this,HtView.class);
                startActivity(intent);

            }
        });


        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HtView.TITTLE_Ht="তাকবীরে তাহরিমা";
                HtView.DESCRIPTION="file:///android_asset/namaj_man2.html";
                Intent intent=new Intent(Content_list2.this,HtView.class);
                startActivity(intent);

            }
        });

        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HtView.TITTLE_Ht="কেরাত পাঠের আদব";
                HtView.DESCRIPTION="file:///android_asset/namaj_man3.html";
                Intent intent=new Intent(Content_list2.this,HtView.class);
                startActivity(intent);

            }
        });

        bt5 .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HtView.TITTLE_Ht="রুকু করার নিয়ম";
                HtView.DESCRIPTION="file:///android_asset/namaj_man4.html";
                Intent intent=new Intent(Content_list2.this,HtView.class);
                startActivity(intent);

            }
        });



        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HtView.TITTLE_Ht="সিজদাহ করার নিয়ম";
                HtView.DESCRIPTION="file:///android_asset/namaj_man5.html";
                Intent intent=new Intent(Content_list2.this,HtView.class);
                startActivity(intent);

            }
        });


        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HtView.TITTLE_Ht="নামাজের বৈঠকের আদব";
                HtView.DESCRIPTION="file:///android_asset/namaj_man6.html";
                Intent intent=new Intent(Content_list2.this,HtView.class);
                startActivity(intent);

            }
        });




        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getOnBackPressedDispatcher().onBackPressed();
            }
        });
        textView.setText(L2TITTLE);

    }






}