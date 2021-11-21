package com.seawayproject.injplastapp;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : Alexandr Onuferco
 * @created : 21/11/2021, Sunday
 * This project was created for educational purposes
 * all the referenced works are properties of respected copyright owners
 **/
public class CardItemAdapter extends RecyclerView.Adapter<CardItemAdapter.ViewHolder>  {

    private ArrayList<CardItem> cardList;
    private Context mContext;
    private Map<String, String> classMap = new HashMap<>();


    public CardItemAdapter(Context context, ArrayList<CardItem> cardList) {
        this.cardList = cardList;
        this.mContext = context;

        classMap.put("Operator", "com.seawayproject.injplastapp.main.Operator");
        classMap.put("Process Technician", "com.seawayproject.injplastapp.main.ProcessTechnician");
        classMap.put("Material Handler", "com.seawayproject.injplastapp.main.MaterialHandler");
        classMap.put("Cleanroom Environment", "com.seawayproject.injplastapp.main.operator.Cleanroom");
        classMap.put("Calculators", "com.seawayproject.injplastapp.main.Calculators");
        classMap.put("Production Rate", "com.seawayproject.injplastapp.main.calculators.ProductionRate");
        classMap.put("Production Time", "com.seawayproject.injplastapp.main.calculators.ProductionTime");
        classMap.put("Material Required", "com.seawayproject.injplastapp.main.calculators.MaterialRequired");
        classMap.put("Shot Weight", "com.seawayproject.injplastapp.main.calculators.ShotWeight");
        classMap.put("Volume", "com.seawayproject.injplastapp.main.calculators.Volume");
        classMap.put("Defects", "com.seawayproject.injplastapp.main.operator.Defects");
        classMap.put("Operator Safety", "com.seawayproject.injplastapp.main.operator.Safety");
        classMap.put("Defects Solutions", "com.seawayproject.injplastapp.main.proctech.DefectSolutions");
        classMap.put("Tips & Learning", "com.seawayproject.injplastapp.main.proctech.Tips");
        classMap.put("Water Flow Table", "com.seawayproject.injplastapp.main.proctech.Waterflow");
        classMap.put("Learning Center", "com.seawayproject.injplastapp.main.mathandler.LearningCenter");
        classMap.put("Drying Temperature Table", "com.seawayproject.injplastapp.main.mathandler.DryingTable");
        classMap.put("Drying", "com.seawayproject.injplastapp.main.mathandler.learning.Drying");
        classMap.put("Nozzle Body & Tip", "com.seawayproject.injplastapp.main.proctech.tips.Nozzle");
        classMap.put("Feed-Throat Temp Control", "com.seawayproject.injplastapp.main.proctech.tips.FeedThroat");
        classMap.put("Scientific Molding", "com.seawayproject.injplastapp.main.proctech.tips.ScientificMolding");
        classMap.put("Barrel Zone", "com.seawayproject.injplastapp.main.proctech.tips.BarrelZone");
        classMap.put("Gate Seal", "com.seawayproject.injplastapp.main.proctech.tips.GateSeal");
        classMap.put("Cycle Optimization", "com.seawayproject.injplastapp.main.proctech.tips.CycleOptimization");
        classMap.put("Purging", "com.seawayproject.injplastapp.main.proctech.tips.Purging");
        classMap.put("Polymer Flow", "com.seawayproject.injplastapp.main.proctech.tips.PolymerFlow");
        classMap.put("Shutdown Fundamentals", "com.seawayproject.injplastapp.main.proctech.tips.Shutdown");
        classMap.put("Preventive Maintenance Schedule", "com.seawayproject.injplastapp.main.proctech.tips.Maintenance");
        classMap.put("Pellet Size & Shape", "com.seawayproject.injplastapp.main.mathandler.learning.PelletSize");
    }


    @Override
    public CardItemAdapter.ViewHolder onCreateViewHolder(
            ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).
                inflate(R.layout.list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(CardItemAdapter.ViewHolder holder,
                                 int position) {
        CardItem item = cardList.get(position);

        holder.bindTo(item);
    }

    @Override
    public int getItemCount() {
        return cardList.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mTitleText;
        private TextView mInfoText;

        private ImageView imageView;

        ViewHolder(View itemView) {
            super(itemView);

            mTitleText = itemView.findViewById(R.id.title);
            mInfoText = itemView.findViewById(R.id.subTitle);
            imageView = (ImageView) itemView.findViewById(R.id.image);

            itemView.setOnClickListener(this);
        }

        void bindTo(CardItem item){
            mTitleText.setText(item.getTitle());
            mInfoText.setText(item.getInfo());

            Glide.with(mContext).load(item.getImageResource()).into(imageView);
        }

        @Override
        public void onClick(View view) {
            CardItem item = cardList.get(getAdapterPosition());
            for (Map.Entry<String, String> entry : classMap.entrySet()) {
                if (entry.getKey().equals(item.getTitle())) {
                    try {
                        Class<?> cls = Class.forName(entry.getValue());
                        mContext.startActivity(new Intent(mContext, cls));
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }
}