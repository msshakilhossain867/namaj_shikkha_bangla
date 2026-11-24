package com.citomoltd.namaz_shikkha_bangla.fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.citomoltd.namaz_shikkha_bangla.AdHelper;
import com.citomoltd.namaz_shikkha_bangla.All_text_file;
import com.citomoltd.namaz_shikkha_bangla.HtView;
import com.citomoltd.namaz_shikkha_bangla.R;

import java.util.ArrayList;
import java.util.HashMap;


public class Dua_hadid_fragment extends Fragment {

    ArrayList<HashMap<String,String>>arrayList=new ArrayList<>();
    HashMap<String,String>hashMap;
    RecyclerView recyclerView;


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_dua_hadid_fragment, container, false);
        recyclerView=view.findViewById(R.id.recyclerView);

            setHashMap();
        DuaRecycler duaRecycler=new DuaRecycler();
        recyclerView.setAdapter(duaRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));




        return view;
    }

    private class DuaRecycler extends RecyclerView.Adapter{


        private  class DuaViewHolder extends RecyclerView.ViewHolder{
            TextView tittleText,numberCount;
            LinearLayout nextLayout;
            public DuaViewHolder(@NonNull View itemView) {
                super(itemView);
                tittleText=itemView.findViewById(R.id.tittleText);
                numberCount=itemView.findViewById(R.id.numberCount);
                nextLayout=itemView.findViewById(R.id.nextLayout);
            }
        }


        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater=getLayoutInflater();
            View view=inflater.inflate(R.layout.item_list,parent,false);


            return new DuaViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
           DuaViewHolder duaViewHolder=(DuaViewHolder) holder;
           hashMap =arrayList.get(position);
           String tittle=hashMap.get("tittle");
           String des=hashMap.get("des");
           String num=hashMap.get("num");

           duaViewHolder.tittleText.setText(tittle);
           duaViewHolder.numberCount.setText(num);
           duaViewHolder.nextLayout.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {

                   AdHelper.showAdIfNeeded(requireActivity(), () -> {

                       if (position==0||position==1||position==3){
                           HtView.TITTLE_Ht=tittle;
                           HtView.DESCRIPTION=des;
                           Intent intent=new Intent(getActivity(),HtView.class);
                           startActivity(intent);

                       }else {
                           All_text_file.TL_TEXT=tittle;
                           All_text_file.ALL_TEXT=des;
                           Intent intent=new Intent(getActivity(),All_text_file.class);
                           startActivity(intent);
                       }

                   });


               }
           });

        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }
    }

    private void setHashMap(){
        hashMap=new HashMap<>();
        hashMap.put("tittle","আল্লাহর ৯৯ নামের আমল ও দোয়া। ");
        hashMap.put("num","0");
        hashMap.put("des","file:///android_asset/99_name.html");
        arrayList.add(hashMap);
        //==============================
        //==============================
        hashMap=new HashMap<>();
        hashMap.put("tittle"," প্রতিদিনের প্রয়োজনীয় ৪০টি দোয়া");
        hashMap.put("num","1");
        hashMap.put("des","file:///android_asset/duaa.html");
        arrayList.add(hashMap);
        //==============================
        //==============================
        hashMap=new HashMap<>();
        hashMap.put("tittle","দোয়া কবুলের সময়");
        hashMap.put("num","2");
        hashMap.put("des","যে সময়ে দোয়া করলে আল্লাহ ১০০% দোয়া কবুল করেন। দোয়া কবুলের শর্ত\n" +
                "\n" +
                "\n" +
                "আল্লাহতায়ালা মুমিন বান্দার দোয়া সব সময় কবুল করে থাকেন। তার পরও প্রিয় নবী (সা.) সুনির্দিষ্ট কিছু সময়ের কথা হাদিসে উল্লেখ করেছেন। যে সময়গুলো দোয়া করলে আল্লাহতায়ালা নিশ্চিতভাবে বান্দার দোয়া কবুল করেন।\n" +
                "\n" +
                "\n" +
                " আর তাহলো-রাতের শেষ তৃতীয়াংশে রাসুলুল্লাহ (সা.) বলেন, প্রত্যেক দিন রাতের শেষ তৃতীয়াংশে আমাদের রব সবচেয়ে নিচের আসমানে নেমে আসেন এবং বলেন, কে আছ?\n" +
                "\n" +
                "\n" +
                " আমাকে ডাক; আমি তোমার ডাকে সাড়া দেব।কে আছ? আমার কাছে চাও; আমি তোমাকে দান করব। কে আছ? আমার কাছে ক্ষমা প্রার্থনাকারী;আমি তোমাকে ক্ষমা করে দেব। (বুখারি)\n" +
                "\n" +
                "\n" +
                "1)আজান ও ইকামতের মধ্যবর্তী সময়ের দোয়া রাসুল (সা.) বলেছেন, আজান ও ইকামতের মধ্যবর্তী সময়ের দোয়া ফিরিয়ে দেয়া হয় না।(আবু দাউদ)\n" +
                "\n" +
                "\n" +
                "2)জুমার দিনের দোয়া  রাসুল (সা.) বলেন,জুমার দিনে একটি সময় আছে যে সময়টা কোনো মুমিন নামাজ পড়া অবস্থায় পায় এবং আল্লাহর কাছে কোনো কিছু প্রার্থনা করে,আল্লাহ অবশ্যই সে চাহিদা পূরণ করবেন। এবং তিনি তার হাত দিয়ে ইশারা করে সে সময়ের সংক্ষিপ্ততার ইঙ্গিত দেন। (বুখারি)\n" +
                "\n" +
                "\n" +
                "3)সেজদার সময়ের দোয়া রাসুল (সা.) বলেছেন,যে সময়টাতে বান্দাআল্লাহর সবচেয়ে কাছে চলে যায়,তাহলো সেজদার সময়।সুতরাং তোমরা তখন আল্লাহর কাছে বেশি বেশি চাও।(মুসলিম)\n" +
                "\n" +
                "\n" +
                "4)ফরজ নামাজের পরের দোয়া রাসুল (সা.) বলেছেন, রাতের শেষ সময়  ফরজ নামাজের পরে দোয়া কবুল হয়।(মুসলিম)\n" +
                "\n" +
                "\n" +
                "5)কদরের রাতের দোয়া রাসুল (সা.) বলেছেন, যে ব্যক্তি ঈমানের সঙ্গে সওয়াব লাভের আশায় লাইলাতুল কদরে রাত জেগে দাঁড়িয়ে নামাজ আদায় করে,তার আগের জীবনের সব গুনাহ ক্ষমা করে দেয়া হয়।(বুখারি)\n" +
                "\n" +
                "\n" +
                "6)বৃষ্টি হওয়ার সময়ের দোয়া রাসুল (সা.) বলেছেন,দুই সময়ের দোয়া ফেরানো হয় না।আজানের সময়ের দোয়া আর বৃষ্টি বর্ষণের সময়ের দোয়া।(আবু দাউদ)\n" +
                "\n" +
                "\n" +
                "7)আরাফাতের দিনের দোয়া রাসুল (সা.) বলেন, দোয়ার মধ্যে শ্রেষ্ঠ হলো আরাফাতের দিনের দোয়া। (তিরমিজি) জিলহজ মাসের প্রথম ১০ দিনের  রাসুল (সা.) বলেছেন, জিলহজ মাসের প্রথম ১০ দিনের আমল অন্য যে কোনো দিনের আমলের চেয়ে উত্তম।(বুখারি)\n" +
                "\n" +
                " \n" +
                "\n" +
                "8)রোজাদার ব্যক্তির ইফতারের সময়ের দোয়া রাসুল (সা.) বলেছেন,৩ ব্যক্তির দোয়া কখনো ফিরিয়ে দেয়া হয় না।এক. যখন রোজাদার ব্যক্তি ইফতার করে।দুই. ন্যায়পরায়ণ শাসক৷তিন. নির্যাতিত ব্যক্তির দোয়া। (মুসনাদে আহমাদ, তিরমিজি,)\n" +
                "\n" +
                "\n" +
                "মুমিন মুসলমানের উচিত এ সময় ও দিনক্ষণগুলোতে বেশি বেশি তাওবা-ইসতেগফারের মাধ্যমে আল্লাহর কাছে ক্ষমা প্রার্থনা করা।নিজের একান্ত চাহিদাগুলো পুরণে আল্লাহর কাছে প্রার্থনা করা।\n" +
                "\n" +
                "\n" +
                "দোয়া কবুলের শর্তঃ-\n" +
                "\n" +
                "মুসলমান হিসেবে আমরা কমেবেশি সবাই দোয়া করি। এটা অনেকটা স্বভাবজাত বিষয়।তবে দোয়া করার সময় বেশ কয়েকটি বিষয়ের প্রতি গভীরভাবে খেয়াল রাখা দরকার। আলেমরা এগুলোকে দোয়া কবুলের শর্ত ও আদব বলে অভিহিত করেছেন।\n" +
                "\n" +
                "\n" +
                "1) আমনত রক্ষা করা\n" +
                "\n" +
                "হিফজু আমানাতিন্ অর্থাৎ বান্দার মধ্যে যার ওপর আমার হক আছে,তা আমানতের সঙ্গে আদায় করা আমানতের ব্যাপারে কারো সঙ্গে প্রতারণা না করা।কারো আমানত নিজের কাছে থাকলে তা তার কাছে যথাযথ পৌঁছে দেওয়া। \n" +
                "\n" +
                "\n" +
                "2)সর্বদা সত্য কথা বলা \n" +
                "\n" +
                "সর্বদা সবসময়  সত্য কথা বলা। মুখ থেকে যেন কোনো মিথ্যা,অবাস্তব এবং ধোঁকাবাজির কথা বের না হয়।মিথ্যা কথা বললে অন্তর কলুষিত হয়ে যায়। \n" +
                "\n" +
                "\n" +
                " 3)উত্তম চরিত্র \n" +
                "\n" +
                "হুছনু খালিকাতি,সর্বোচ্চ উত্তম চরিত্রের অধিকারী হওয়া। অর্থাৎ যে চরিত্র দেখলে আল্লাহও খুশি, বান্দাও খুশি হয়।\n" +
                "\n" +
                "\n" +
                "4)হালাল রিজিক \n" +
                "\n" +
                "রিজকে হালা উপায়ে রিজিক অন্বেষণ করা হালাল উপায়ে রিজিক উপার্জন করা।আল্লাহ তাআলা হালাল খাদ্য ভক্ষণের ওপর গুরুত্বারোপ করে যুগে যুগে তাঁর রাসুলগণকে উদ্দেশ্য করে বলেন, ‘হে রাসুলগণ!\n" +
                "\n" +
                "\n" +
                " আপনারা উত্তম বস্তুকে খাদ্য হিসেবে গ্রহণ করুন এবং নেক কাজ করুন। আপনারা যা করেন সে বিষয়ে আমি পরিজ্ঞাত। (সুরা মুমিনুন : আয়াত ৫১)\n" +
                "\n" +
                "\n" +
                "5)পবিত্রতা অর্জন\n" +
                "\n" +
                " পবিত্রতা অর্জনের পর দোয়া করলে আল্লাহতায়ালা সেই দোয়া কবুল করবেন।\n" +
                "\n" +
                "\n" +
                "6)বিনয়ের সঙ্গে দোয়া করা\n" +
                "\n" +
                "বিনয়ের সঙ্গে দু’হাত তুলে দোয়া করা।হজরত আবদুল্লাহ ইবনে আব্বাস (রা.) থেকে বর্ণিত, হজরত রাসূলুল্লাহ (সা.) বলেন, ‘আল্লাহতায়ালার নিকট হাত তুলে হাতের তালু সামনে রেখে দোয়া কর। হাত উল্টো করো না।\n" +
                "\n" +
                "\n" +
                "হজরত আবু সোলায়মান দারানী (রহ.) বলেন, ‘যে ব্যক্তি আল্লাহর কাছে কোনো দোয়া করে, তার উচিত, প্রথমে দরুদ পড়া এবং দরুদ পড়ে দোয়া শেষ করা। কেননা আল্লাহ উভয় দরুদ কবুল করেন। -কিমিয়ায়ে সাআদাত\n" +
                "\n" +
                "\n");
        arrayList.add(hashMap);
        //==============================
        //==============================
        hashMap=new HashMap<>();
        hashMap.put("tittle","১০০ হাদিস");
        hashMap.put("num","3");
        hashMap.put("des","file:///android_asset/100_hadis.html");
        arrayList.add(hashMap);
        //==============================
        //==============================

    }
}