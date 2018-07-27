package com.example.expenditureapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ExpenditureAdapter extends RecyclerView.Adapter<ExpenditureAdapter.ExpenditureViewHolder> {


    private List<Expenditure> expenditureList;
    private Context mContext;
   public expenditurelistOnclick eric;

   public ExpenditureAdapter(Context mContext, expenditurelistOnclick Listlistner ) {
        this.mContext = mContext;
        this.eric =Listlistner;

    }

    // remember this interface for items on click

    public interface expenditurelistOnclick{
        void itemClicklistner(int itemId);
    }

    @Override
    public ExpenditureAdapter.ExpenditureViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.expenditurelist,parent,false);
        return new ExpenditureViewHolder(view);

    }

    @Override
    public void
    onBindViewHolder(ExpenditureAdapter.ExpenditureViewHolder holder, int position) {
        Expenditure expenditure = expenditureList.get(position);
        String amount = expenditure.getAmount();
        String item = expenditure.getItem();
        String status = expenditure.getStatus();
        String comment = expenditure.getComment();

        holder.amount.setText(amount);
        holder.item.setText(item);
        holder.status.setText(status);
        holder.comment.setText(comment);
    }

    @Override
    public int getItemCount() {
        if (expenditureList == null) {
            return 0;
        } else {

            return expenditureList.size();
        }
    }

    public void setExpenditureList(List<Expenditure> expenditures){
        expenditureList = expenditures;
        notifyDataSetChanged();

    }

    public class ExpenditureViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView amount;
        private TextView  item;
        private  TextView status;
        private TextView comment;

        public  ExpenditureViewHolder (View itemview){

            super(itemview);
            amount = itemview.findViewById(R.id.amounts);
            item = itemview.findViewById(R.id.items);
            status= itemview.findViewById(R.id.stat);
            comment = itemview.findViewById(R.id.comments);
            itemview.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            int itemId = expenditureList.get(getAdapterPosition()).getExpid();
            eric.itemClicklistner(itemId);

        }
    }
   





}







