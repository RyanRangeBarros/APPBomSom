package com.ryanandvinicius.bomsomapp.menulateral;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.ryanandvinicius.bomsomapp.R;

import java.util.List;

public class MenuEdit extends RecyclerView.Adapter<MenuEdit.MenuViewHolder> {

    List<ItensDoMenu> DadosMenu;
    Callback listener;

    public MenuEdit(List<ItensDoMenu> mdata, Callback listener) {
        this.DadosMenu = mdata;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu, parent, false);
        return new MenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuEdit.MenuViewHolder holder, int position) {

        holder.icon.setImageResource(DadosMenu.get(position).getIcon());

        if (DadosMenu.get(position).isSelected()) {
            holder.selecionado.setVisibility(View.VISIBLE);
        }
        else {
            holder.selecionado.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        return DadosMenu.size();
    }

    public class MenuViewHolder extends RecyclerView.ViewHolder {

        ImageView icon, selecionado;

        public MenuViewHolder(@NonNull  View itemView) {
            super(itemView);

            icon = itemView.findViewById(R.id.MenuItemIcone);
            selecionado = itemView.findViewById(R.id.ItemMenuSelecionado);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v){
                    listener.onSideMenuItemClick(getAdapterPosition());
                }
            });

        }
    }
}
