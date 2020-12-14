package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class QuantityAdapter extends RecyclerView.Adapter<QuantityAdapter.QuantityViewHolder> {



    private Context mCtx;
    private List<Quantity> quantityList;
   private ItemClickListener mClickListener;


    public QuantityAdapter(Context mCtx, List<Quantity> quantityList) {
        this.mCtx = mCtx;
        this.quantityList = quantityList;
    }

    @Override
    public QuantityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.inventorylayout, null);
        return new QuantityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(QuantityViewHolder holder, int position) {

        Quantity quantity = quantityList.get(position);


        holder.textview.setText(quantity.getText());
        holder.imageview.setImageDrawable(mCtx.getResources().getDrawable(quantity.getImage()));
        holder.edittext.setText(quantity.getNum());

    }


    @Override
    public int getItemCount() {
        return quantityList.size();
    }


    public class QuantityViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textview;
        ImageView imageview;
        EditText edittext;

        public QuantityViewHolder(View itemView) {
            super(itemView);

            textview = itemView.findViewById(R.id.textview);
            imageview = itemView.findViewById(R.id.imageview);
            edittext = itemView.findViewById(R.id.edittext);

           itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            if (mClickListener != null)
                       mClickListener.onItemClick(view, getAdapterPosition());


        }


    }


    String getItem(int id) {
        return  quantityList.get(id).getText();         //category.getText() getter fn
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }


}
