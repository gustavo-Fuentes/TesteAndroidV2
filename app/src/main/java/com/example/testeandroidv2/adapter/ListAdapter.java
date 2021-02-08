package com.example.testeandroidv2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testeandroidv2.R;


public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder>{
    String []data;
    String []preco;
    String [] conta;
    Context context;

    public ListAdapter(Context ct, String [] data, String [] preco, String [] conta){
        this.context = ct;
        this.data = data;
        this.preco = preco;
        this.conta = conta;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.client_item, parent, false);

        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        holder.date.setText(data[position]);
        holder.price.setText(preco[position]);
        holder.accountType.setText(conta[position]);
    }

    @Override
    public int getItemCount() {
        return 10; // deixar dinamico dps
    }

    class ListViewHolder extends RecyclerView.ViewHolder{
        TextView date, price, accountType;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            date = itemView.findViewById(R.id.datePayment);
            price = itemView.findViewById(R.id.price);
            accountType = itemView.findViewById(R.id.accountType);


        }
    }

}

