package com.blit.blit.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blit.blit.R;
import com.blit.blit.models.Ticket;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class BlitRecyclerViewAdapter extends RecyclerView.Adapter<BlitRecyclerViewAdapter.TicketViewHolder> {
    private ArrayList<Ticket> tickets = new ArrayList<>();

    public BlitRecyclerViewAdapter(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
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
        Ticket ticket = tickets.get(i);
        ticketViewHolder.price.setText(Long.toString(ticket.getPrice()));
        ticketViewHolder.detail.setText(ticket.getDetail());
        ticketViewHolder.destinationCity.setText(ticket.getDestinationCity().toString());
        ticketViewHolder.beginningCity.setText(ticket.getBeginningCity().toString());
        ticketViewHolder.calendar.setText((ticket.getCalendar()).toString());
        ticketViewHolder.company.setText(ticket.getCompany());
        switch (ticket.getTicketType()){
            case BUS: ticketViewHolder.ticketType.setText(R.string.Bus);
                break;
            case TRAIN:ticketViewHolder.ticketType.setText(R.string.Train);
                break;
            case AIRPLANE:ticketViewHolder.ticketType.setText(R.string.AirPlane);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return tickets.size() ;
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
