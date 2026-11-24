package com.citomoltd.namaz_shikkha_bangla;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class V_file3 extends AppCompatActivity {

    TextView textView;
    ImageView back_arrow;

    Button bt1,bt2;

    public static String TITLe="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_vfile3);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textView=findViewById(R.id.stToolbar);
        back_arrow=findViewById(R.id.back_arrow);

        bt1=findViewById(R.id.bt1);
        bt2=findViewById(R.id.bt2);


        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                All_text_file.TL_TEXT="ভূমিকা";
                All_text_file.ALL_TEXT="ধাপে ধাপে নামাজ শিক্ষা\n" +
                        "মহান আল্লাহ রাব্বুল আ'লামীন নারী ও পুরুষকে তাঁর কুদরতে পৃথক পৃথক গড়ণে তৈরি করেছেন। একইভাবে নারী ও পুরুষের ইবাদতেও রেখেছেন কিছু পার্থক্য। এই পার্থক্যসমূহ নারী-পুরুষের সার্বিক মঙ্গল ও কল্যাণের জন্য আল্লাহ তা'আলা কর্তৃক নিজ নিজ উপযুক্ততা ও যোগ্যতা অনুযায়ী নির্ধারিত।\n\n" +
                        "\n" +
                        "অনুরূপ নারী ও পুরুষের নামাজের মধ্যেও কতিপয় পার্থক্য রয়েছে। পূর্বের অধ্যায়ে পুরুষের নামাজের নিয়ম সমূহ ধাপে ধাপে দেখানো হয়েছে। এই অধ্যায়ে নারীর নামাজের যে বিষয়সমূহ পুরুষের নামাজের চাইতে অন্য-রকম, তার বর্ণনা করা হবে। আর যে বিষয়সমূহ নারী-পুরুষের নামাজে একই রকম, তা পুরুষের নামাজের নিয়মের অনুরূপই হবে। অর্থাৎ এই অধ্যায়ের বিষয়সমূহ শুধুমাত্র নারীদের নামাজের জন্য প্রযোজ্য।";
                Intent intent=new Intent(V_file3.this,All_text_file.class);
                startActivity(intent);


            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HtView.TITTLE_Ht="নারীদের নামাজের নিয়ম";
                HtView.DESCRIPTION="file:///android_asset/namaj_female.html";
                Intent intent=new Intent(V_file3.this,HtView.class);
                startActivity(intent);

            }
        });





        textView.setText(TITLe);
        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getOnBackPressedDispatcher().onBackPressed();
            }
        });
    }//======================================




}