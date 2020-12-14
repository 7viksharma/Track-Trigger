package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {



    private Context mCtx;
    private List<Category> categoryList;
    private ItemClickListener mClickListener;


    public CategoryAdapter(Context mCtx, List<Category> categoryList) {
        this.mCtx = mCtx;
        this.categoryList = categoryList;
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.categorylayout, null);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {

        Category category = categoryList.get(position);


        holder.textview.setText(category.getText());
        holder.imageview.setImageDrawable(mCtx.getResources().getDrawable(category.getImage()));

    }


    @Override
    public int getItemCount() {
        return categoryList.size();
    }


   public class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textview;
        ImageView imageview;

        public CategoryViewHolder(View itemView) {
            super(itemView);

            textview = itemView.findViewById(R.id.textview);
            imageview = itemView.findViewById(R.id.imageview);

            itemView.setOnClickListener(this);
        }


       @Override
        public void onClick(View view) {
            if (mClickListener != null)
                mClickListener.onItemClick(view, getAdapterPosition());
        }
    }


    String getItem(int id) {
        return  categoryList.get(id).getText();         //category.getText() getter fn
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
