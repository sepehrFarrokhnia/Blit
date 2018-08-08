package com.blit.blit.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blit.blit.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class BlitRecyclerViewAdapter extends RecyclerView.Adapter<BlitRecyclerViewAdapter.TicketViewHolder> {
    private ArrayList<String> prices =new ArrayList<>();
    private ArrayList<String> ticketImageurls =new ArrayList<>();
    private ArrayList<String> details =new ArrayList<>();
    private ArrayList<String> destinationCity =new ArrayList<>();
    private ArrayList<String> beginningCity =new ArrayList<>();
    private ArrayList<String> calendar =new ArrayList<>();
    private ArrayList<String> ticketType =new ArrayList<>();
    private ArrayList<String> ticketCompony =new ArrayList<>();
    Context context ;

    public BlitRecyclerViewAdapter(ArrayList<String> prices, ArrayList<String> ticketImageurls, ArrayList<String> details, ArrayList<String> destinationCity, ArrayList<String> beginningCity, ArrayList<String> calendar, ArrayList<String> ticketType, Context context) {
        this.prices = prices;
        this.ticketImageurls = ticketImageurls;
        this.details = details;
        this.destinationCity = destinationCity;
        this.beginningCity = beginningCity;
        this.calendar = calendar;
        this.ticketType = ticketType;
        this.context = context;
    }
    @NonNull
    @Override
    public TicketViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.blitrecyclerview_listshape,viewGroup,false);
        TicketViewHolder ticketViewHolder = new TicketViewHolder(view);
        return ticketViewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull TicketViewHolder ticketViewHolder, int i) {
        ticketViewHolder.detail.setText(details.get(i));
        ticketViewHolder.price.setText(prices.get(i));
        ticketViewHolder.destinationCity.setText(destinationCity.get(i));
        ticketViewHolder.beginningCity.setText(beginningCity.get(i));
        ticketViewHolder.calendar.setText(calendar.get(i));
        ticketViewHolder.ticketType.setText(ticketType.get(i));
        ticketViewHolder.company.setText(ticketCompony.get(i));
    }

    @Override
    public int getItemCount() {
        return beginningCity.size();
    }

    public class TicketViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout tickerLayout;
        CircleImageView ticketImage;
        TextView price;
        TextView detail;
        TextView destinationCity;
        TextView beginningCity;
        TextView calendar;
        TextView company;
        TextView ticketType;


        public TicketViewHolder(@NonNull View itemView) {
            super(itemView);
            tickerLayout=itemView.findViewById(R.id.blitListShapeLayout);
            price=itemView.findViewById(R.id.priceText);
            destinationCity=itemView.findViewById(R.id.destinationCity);
            beginningCity=itemView.findViewById(R.id.beginningCityText);
            calendar=itemView.findViewById(R.id.calendarText);
            company=itemView.findViewById(R.id.companyNameText);
            ticketType=itemView.findViewById(R.id.ticketTypeText);
            ticketImage=itemView.findViewById(R.id.ticketImageView);
            detail=itemView.findViewById(R.id.detailText);

        }
    }
}
