package com.blit.blit.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blit.blit.R;
import com.blit.blit.models.Ticket;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class BlitRecyclerViewAdapter extends RecyclerView.Adapter<BlitRecyclerViewAdapter.TicketViewHolder> {
    private ArrayList<Ticket> tickets = new ArrayList<>();

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }

    public BlitRecyclerViewAdapter() {
    }

    @NonNull
    @Override
    public TicketViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.ticket_layout,
                viewGroup,
                false
        );
        return new TicketViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull TicketViewHolder ticketViewHolder, int i) {
        Ticket ticket = tickets.get(i);

        ticketViewHolder.price.setText(Long.toString(ticket.getPrice()));
        ticketViewHolder.detail.setText(ticket.getDetail());
        ticketViewHolder.destinationCity.setText(ticket.getDestinationCity().toString());
        ticketViewHolder.beginningCity.setText(ticket.getBeginningCity().toString());
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

    class TicketViewHolder extends RecyclerView.ViewHolder {
        CircleImageView image;
        TextView price;
        TextView detail;
        TextView destinationCity;
        TextView beginningCity;
        TextView time;
        TextView date;
        TextView company;
        TextView ticketType;
        TicketViewHolder(@NonNull View itemView) {
            super(itemView);
            price=itemView.findViewById(R.id.ticketPrice);
            destinationCity=itemView.findViewById(R.id.ticketDestinationCity);
            beginningCity=itemView.findViewById(R.id.ticketBeginningCity);
            company=itemView.findViewById(R.id.ticketCompany);
            ticketType=itemView.findViewById(R.id.ticketType);
            image =itemView.findViewById(R.id.ticketImageView);
            detail=itemView.findViewById(R.id.ticketDetail);
            time=itemView.findViewById(R.id.ticketTime);
            date=itemView.findViewById(R.id.ticketDate);
        }
    }
}
