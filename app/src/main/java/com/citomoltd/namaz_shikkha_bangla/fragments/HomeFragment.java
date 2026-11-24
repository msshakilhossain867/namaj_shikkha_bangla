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
import com.citomoltd.namaz_shikkha_bangla.HomeActivity;
import com.citomoltd.namaz_shikkha_bangla.HtView;
import com.citomoltd.namaz_shikkha_bangla.R;

import java.util.ArrayList;
import java.util.HashMap;


public class HomeFragment extends Fragment {

    ArrayList<HashMap<String,String>>arrayList=new ArrayList<>();
    HashMap<String ,String >hashMap;
    RecyclerView recyclerViewHome;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View hmView = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerViewHome=hmView.findViewById(R.id.recyclerHome);

        setHashMap();
        HomeRecycler recycler=new HomeRecycler();
        recyclerViewHome.setAdapter(recycler);
        recyclerViewHome.setLayoutManager(new LinearLayoutManager(getContext()));







        return hmView;
    }

    private class HomeRecycler extends RecyclerView.Adapter{

        private class HomeViewHolder extends RecyclerView.ViewHolder{

            TextView tittleText,numberCount;
            LinearLayout nextLayout;

            public HomeViewHolder(@NonNull View itemView) {
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
            View iView= inflater.inflate(R.layout.item_list,parent,false);
            return new HomeViewHolder(iView);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
            HomeViewHolder holder1= (HomeViewHolder) holder;

            hashMap=arrayList.get(position);
            String tittle=hashMap.get("tittle");
            String des=hashMap.get("des");
            String number=hashMap.get("num");

            holder1.tittleText.setText(tittle);
            holder1.numberCount.setText(number);

            holder1.nextLayout.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {


                    AdHelper.showAdIfNeeded(requireActivity(),() -> {
                        if (position==2||position==28) {
                            All_text_file.TL_TEXT=tittle;
                            All_text_file.ALL_TEXT=des;
                            Intent intent=new Intent(getActivity(),All_text_file.class);
                            startActivity(intent);

                        } else if (position==4||position==23||position==24||position==25||position==26||position==27) {

                            Intent intent=new Intent(getActivity(), HomeActivity.class);
                            Bundle bundle=new Bundle();
                            bundle.putInt("val",position);
                            intent.putExtras(bundle);
                            startActivity(intent);
                        } else {
                            HtView.TITTLE_Ht=tittle;
                            HtView.DESCRIPTION=des;
                            Intent intent=new Intent(getActivity(),HtView.class);
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
        hashMap.put("tittle","নামায সম্পর্কিত কিছু আয়াত ও হাদীস");
        hashMap.put("des","file:///android_asset/practice.html");
        hashMap.put("num","0");
        arrayList.add(hashMap);
        //=============================
        //=============================

        hashMap=new HashMap<>();
        hashMap.put("tittle","আজান");
        hashMap.put("des","file:///android_asset/azan.html");
        hashMap.put("num","1");
        arrayList.add(hashMap);
        //=============================
        //=============================

         hashMap=new HashMap<>();
        hashMap.put("tittle","পবিত্রতা");
        hashMap.put("num","2");
        hashMap.put("des","ওযুর আগে ও পরে দোয়া পাঠ ও এর ফলে ৮ টি জান্নাত লাভ।\n" +
                "بِسْــــــــــــــــــمِ اﷲِالرَّحْمَنِ اارَّحِيم\n" +
                "السلام عليكم ورحمة الله وبركاته\n" +
                "আসসালামু আলাইকুম ওয়ারাহমতুল্লাহ ওয়াবারাকতুহু ।সকল প্রশংসা একমাত্র আল্লাহর জন্য ।\n" +
                "দুরুদ সালাম বর্ষিত হোক শান্তি ও মানবতা মুক্তি দূত রাসূল( ﷺ ) এর জন্য !!!\n" +
                "ওযুর পূর্বে এবং পরে দোয়া পড়া রাসূলুল্লাহ ﷺ থেকে প্রমাণিত আছে। সুতরাং এই দুই সময়ে দোয়া পড়া সুন্নাত। অযুর পূর্বে দোয়া হল, বিসমিল্লাহ বলে অযু শুরু করা। রাসূলুল্লাহ ﷺ বলেন,\n" +
                "لا وُضُوءَ لِمَنْ لَمْ يَذْكُرْ اسْمَ اللَّهِ عَلَيْهِ\n" +
                "যে ব্যক্তি অযুর শুরুতে বিসমিল্লাহ বলবে না, তার ওযু পরিপূর্ণ হবে না। (তিরমিযি ২৫)\n" +
                "ওযুর পরে দোয়া পাঠ ও এর ফলে ৮ টি জান্নাত লাভ\n" +
                "==================================\n" +
                "১. উমার ইবনে খাত্তাব (রা:) হতে বর্ণিত, নবী (দ:) বলেন: যে ব্যক্তি ওযুর\n" +
                "পর (নিচর দোয়া) বলবে:\n" +
                "«أَشْهَدُ أَنْ لاَ إِلَهَ إِلاَّ اللَّهُ وَحْدَهُ لاَ شَرِيكَ لَهُ وَأَشْهَدُ أَنَّ مُحَمَّداً عَبْدُهُ وَرَسُولُهُ..».\n" +
                "(আশ্\u200Cহাদু আল্লা-ইলাহা ইল্লাল্লাহু ওয়াহ্\u200Cদাহু লা- শারীকা লাহূ ওয়া আশহাদু আন্না মুহাম্মাদান ‘আব্দুহূ ওয়া রাসূলুহূ)\n" +
                "(১) “আমি সাক্ষ্য দিচ্ছি যে, একমাত্র আল্লাহ ছাড়া কোনো হক্ব ইলাহ নেই, তাঁর কোনো শরীক নেই। আমি আরও সাক্ষ্য দিচ্ছি যে, মুহাম্মাদ তাঁর বান্দা ও রাসূল”। [মুসলিম ১/২০৯, নং ২৩৪।] মিশকাতঃ ২৮৯]\n" +
                "তার জন্য জান্নাতের আটটি দরজা খুলে দেয়া হবে, সে যেটি দ্বারা প্রবেশ করতে\n" +
                "চাইবে প্রবেশ করবে।” (মুসলিম হাঃ নং ২৩৪)\n" +
                "কালেমা শাহাদাত পড়ার সময় আকাশের দিকে তাকানোর প্রয়োজন নেই, এ সম্পর্কিত হাদীস মুনকার বা যঈফ। [শায়খ আলবানী, ইরওয়াউল গালীলঃ ১/১৩৫]\n" +
                "(২) «اللَّهُمَّ اجْعَلْنِي مِنَ التَّوَّابِينَ وَاجْعَلْنِي مِنَ الْمُتَطَهِّرِينَ».\n" +
                "(আল্লা-হুম্মাজ‘আলনী মিনাত্ তাওয়াবীনা ওয়াজ‘আলনী মিনাল মুতাতাহ্\u200Cহিরীন)\n" +
                "(২) “হে আল্লাহ! আপনি আমাকে তাওবাকারীদের অন্তর্ভুক্ত করুন এবং পবিত্রতা অর্জনকারীদেরও অন্তর্ভুক্ত করুন।”[তিরিমিযী-১/৭৮, নং ৫৫। আরও দেখুন, সহীহুত তিরমিযী, ১/১৮।]\n" +
                "৩. আবু সাঈদ (রা:) হতে বর্ণিত, তিনি বলেন: রসুলুল্লাহ (দ:) বলেছেন: “যে ব্যক্তি ওযু করে বলে:\n" +
                "«سُبْحانَكَ اللَّهُمَّ وَبِحَمْدِكَ، أَشْهَدُ أَنْ لاَ إِلَهَ إِلاَّ أَنْتَ، أَسْتَغْفِرُكَ وَأَتوبُ إِلَيْكَ».\n" +
                "(সুবহানাকা আল্লা-হুম্মা ওয়া বিহামদিকা আশহাদু আল লা-ইলাহা ইল্লা আন্তা আস্তাগফিরুকা ওয়াআতূবু ইলাইক)।\n" +
                "“হে আল্লাহ! আপনার প্রশংসাসহ পবিত্রতা ও মহিমা ঘোষণা করছি। আমি সাক্ষ্য দেই যে, আপনি ছাড়া কোনো হক্ব ইলাহ নেই, আমি আপনার কাছে ক্ষমা প্রার্থনা করছি এবং তোমার দিকেই আমি প্রত্যাবর্তন করি।”\n" +
                "উল্লেখ্য, এই দুয়াটাকে “বৈঠক খতমের দুয়া” বলা হয়। কারণ, এই দুয়াটা যেকোন সালাত, ক্বুরান তেলাওয়াত, যিকির, দ্বীনি মজলিস শেষে উঠার সময় পড়া সুন্নত। এই দুয়াটা পড়লে সেই বৈঠকে কোন ভুল করলে বা ভুল কিছু বলে ফেললে তার কাফফারা হয়ে যাবে। সুতরাং, বৈঠক শেষে এই দুয়াটা পড়ার অভ্যাস গড়ে তুলুন। \n" +
                "আল্লাহ আমাদের সকলকে আমল করার তোওফিক দান করুন, \n" +
                "আমিন।");
        arrayList.add(hashMap);
        //=============================
        //=============================
        hashMap=new HashMap<>();
        hashMap.put("tittle","চিত্রসহ ওযু");
        hashMap.put("num","3");
        hashMap.put("des","file:///android_asset/ojo.html");
        arrayList.add(hashMap);
        //=============================
        //=============================

         hashMap=new HashMap<>();
        hashMap.put("tittle","চিত্রসহ নামাজ শিক্ষা");
        hashMap.put("num","4");
        hashMap.put("des","");
        arrayList.add(hashMap);
        //=============================
        //=============================
        hashMap=new HashMap<>();
        hashMap.put("tittle","প্রয়োজনীয় ছোট সূরা");
        hashMap.put("num","5");
        hashMap.put("des","file:///android_asset/surah_list.html");
        arrayList.add(hashMap);
        //=============================
        //=============================

         hashMap=new HashMap<>();
        hashMap.put("tittle","নিয়ত");
        hashMap.put("num","6");
        hashMap.put("des","file:///android_asset/niyot.html");
        arrayList.add(hashMap);
        //=============================
        //=============================

        hashMap=new HashMap<>();
        hashMap.put("tittle","নামাজের নিয়ম");
        hashMap.put("num","7");
        hashMap.put("des","file:///android_asset/namaj_niyom.html");
        arrayList.add(hashMap);
        //=============================
        //=============================



         hashMap=new HashMap<>();
        hashMap.put("tittle"," তাকবিরে তাহরিমা");
        hashMap.put("num","8");
        hashMap.put("des","file:///android_asset/tahrima.html");
        arrayList.add(hashMap);
        //=============================
        //=============================

         hashMap=new HashMap<>();
        hashMap.put("tittle","সানা");
        hashMap.put("num","9");
        hashMap.put("des","file:///android_asset/sana.html");
        arrayList.add(hashMap);
        //=============================
        //=============================

         hashMap=new HashMap<>();
        hashMap.put("tittle","ক্বিরাত");
        hashMap.put("num","10");
        hashMap.put("des","file:///android_asset/kerat.html");
        arrayList.add(hashMap);
        //=============================
        //=============================

         hashMap=new HashMap<>();
        hashMap.put("tittle","রুকু");
        hashMap.put("num","11");
        hashMap.put("des","file:///android_asset/roku.html");
        arrayList.add(hashMap);
        //=============================
        //=============================
       hashMap=new HashMap<>();
        hashMap.put("tittle","রকু থেকে উঠার দোয়া  ");
        hashMap.put("num","12");
        hashMap.put("des","file:///android_asset/raku2.html");
        arrayList.add(hashMap);
        //=============================
        //=============================

        hashMap=new HashMap<>();
        hashMap.put("tittle","সিজদাহ");
        hashMap.put("num","13");
        hashMap.put("des","file:///android_asset/sejdah.html");
        arrayList.add(hashMap);
        //=============================
        //=============================

        hashMap=new HashMap<>();
        hashMap.put("tittle","তাশাহুদ (আত্তাহিইয়া-তু)");
        hashMap.put("num","14");
        hashMap.put("des","file:///android_asset/attahiyato.html");
        arrayList.add(hashMap);
        //=============================
        //=============================

        hashMap=new HashMap<>();
        hashMap.put("tittle","দরুদ শরীফ");
        hashMap.put("num","15");
        hashMap.put("des","file:///android_asset/durud.html");
        arrayList.add(hashMap);
        //=============================
        //=============================

        hashMap=new HashMap<>();
        hashMap.put("tittle","দোয়ায়ে মাসূরা");
        hashMap.put("num","16");
        hashMap.put("des","file:///android_asset/masura.html");
        arrayList.add(hashMap);
        //=============================
        //=============================

        hashMap=new HashMap<>();
        hashMap.put("tittle","দোয়ায়ে কূনুত");
        hashMap.put("num","17");
        hashMap.put("des","file:///android_asset/kunut.html");
        arrayList.add(hashMap);
        //=============================
        //=============================

        hashMap=new HashMap<>();
        hashMap.put("tittle","সালাম");
        hashMap.put("num","18");
        hashMap.put("des","file:///android_asset/salam.html");
        arrayList.add(hashMap);
        //=============================
        //=============================

        hashMap=new HashMap<>();
        hashMap.put("tittle","সালামে পরে দোয়া ও জিকির");
        hashMap.put("num","19");
        hashMap.put("des","file:///android_asset/salam2.html");
        arrayList.add(hashMap);
        //=============================
        //=============================

        hashMap=new HashMap<>();
        hashMap.put("tittle","ফরজ নামাজের পর যেসব আমল করবেন");
        hashMap.put("num","20");
        hashMap.put("des","file:///android_asset/amol.html");
        arrayList.add(hashMap);
        //=============================
        //=============================

        hashMap=new HashMap<>();
        hashMap.put("tittle","সূরা হাসরের শেষ তিন আয়াত");
        hashMap.put("num","21");
        hashMap.put("des","file:///android_asset/hasor.html");
        arrayList.add(hashMap);
        //=============================
        //=============================

        hashMap=new HashMap<>();
        hashMap.put("tittle","আয়তুল কুরসি");
        hashMap.put("num","22");
        hashMap.put("des","file:///android_asset/kurshi.html");
        arrayList.add(hashMap);
        //=============================
        //=============================

        hashMap=new HashMap<>();
        hashMap.put("tittle","নামাজের গুরুত্বপূর্ণ বিষয়");
        hashMap.put("des","");
        hashMap.put("num","23");
        arrayList.add(hashMap);
        //=============================
        //=============================

        hashMap=new HashMap<>();
        hashMap.put("tittle","ওযু");
        hashMap.put("num","24");
        hashMap.put("des","");
        arrayList.add(hashMap);
        //=============================
        //=============================

        hashMap=new HashMap<>();
        hashMap.put("tittle","গোছল");
        hashMap.put("des","");
        hashMap.put("num","25");
        arrayList.add(hashMap);
        //=============================
        //=============================

        hashMap=new HashMap<>();
        hashMap.put("tittle","তাহাম্মুম");
        hashMap.put("num","26");
        hashMap.put("des","");
        arrayList.add(hashMap);
        //=============================
        //=============================

        hashMap=new HashMap<>();
        hashMap.put("tittle","সাহু সিজদাহ");
        hashMap.put("num","27");
        hashMap.put("des","");
        arrayList.add(hashMap);
        //=============================
        //=============================

        hashMap=new HashMap<>();
        hashMap.put("tittle","ক্বাযা নামাজ");
        hashMap.put("num","28");
        hashMap.put("des","ক্বাযা নামায\n" +
                "নামাযের নির্ধারিত সময় অতিবাহিত হয়ে যাওয়ার আগে কেউ যদি ইচ্ছায় বা অনিচ্ছায় ওয়াক্বতের নামায না পড়ে, তবে তাকে পরবর্তীতে অন্য সময় এ নামায পড়ে নিতে হবে। এভাবে নামায নির্ধারিত সময় ব্যতীত অন্য সময় পড়াকে ক্বাযা বলে। আর নির্ধারিত সময়ে নামায পড়াকে আদা বলে। ক্বাযা নামাযের সংখ্যা যদি পাঁচ বা তদপেক্ষা কম হয়, তবে তারতীব বা ধারাবাহিকতা রক্ষা করা ওয়াজিব। অর্থাৎ প্রথমে ফজর তারপর যোহর তারপর আছর তারপর মাগরিব ও তারপর এশার নামায ক্বাযা পড়তে হবে। তদ্রƒপ সময় সংকীর্ণ না হলে কিংবা নামায পড়ার বিধি নিষেধ না থাকলে আদা এর পূর্বেই ক্বাযা পালন করতে হবে। শুধু ফরয ও ওয়াজিব নামাযেরই ক্বাযা পড়তে হয়। সুন্নাত ও নফলের ক্বাযা নেই। অবশ্য নিয়্যত করে শুরু করার কারণে সুন্নাত নফলও ওয়াজিব হয়ে যায়। ফজরের দু’রাকাত সুন্নাত নামায অধিকতর তাগিদ বিশিষ্ট সুন্নাত হওয়ার কারণে ক্বাযা হলে সেটার ক্বাযা করতে হয়।\n" +
                "\n" +
                " ");
        arrayList.add(hashMap);







    }



}