package com.guilhermeprohaska.wirecardchallengeandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.guilhermeprohaska.wirecardchallengeandroid.R;
import com.guilhermeprohaska.wirecardchallengeandroid.entities.Orders;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {

    private List<Orders> ordersList;
    private Context mCtx;

    public OrderAdapter(List<Orders> ordersList, Context mCtx) {
        this.ordersList = ordersList;
        this.mCtx = mCtx;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new OrderViewHolder(LayoutInflater.from(mCtx)
                .inflate(R.layout.cardview_orders, null, false));
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {

        if (ordersList != null){
            holder.textViewOwnId.setText(ordersList.get(position).getOwnId());
            holder.textViewEmail.setText(ordersList.get(position).getCustomer());
            holder.textViewCurrentStatus.setText(ordersList.get(position).getStatus());
            holder.textViewCurrentStatusDate.setText(ordersList.get(position).getUpdateAt());
            holder.textViewTotalAmount.setText(ordersList.get(position).getAmount());
        }
        else {
            Toast.makeText(mCtx,"Orders is null!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public int getItemCount() {
        return ordersList.size();
    }

    public class OrderViewHolder extends RecyclerView.ViewHolder {

        TextView textViewOwnId, textViewEmail, textViewCurrentStatus, textViewCurrentStatusDate, textViewTotalAmount;

        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewOwnId = itemView.findViewById(R.id.textViewOwnId);
            textViewEmail = itemView.findViewById(R.id.textViewEmailId);
            textViewCurrentStatus = itemView.findViewById(R.id.textViewCurrentStatusId);
            textViewCurrentStatusDate = itemView.findViewById(R.id.textViewCurrentStatusDateId);
            textViewTotalAmount = itemView.findViewById(R.id.textViewTotalAmountId);
        }
    }
}
