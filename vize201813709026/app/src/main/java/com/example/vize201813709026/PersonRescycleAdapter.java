package com.example.vize201813709026;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PersonRescycleAdapter extends RecyclerView.Adapter<PersonRescycleAdapter.PersonHolder> {

    private ArrayList<Kisi> Kisi;

    public PersonRescycleAdapter(ArrayList<Kisi> Kisi) {
        this.Kisi = Kisi;
    }

    public void setPersons(ArrayList<Kisi> Kisi)
    {
        this.Kisi=Kisi;
    }

    @NonNull
    @Override
    public PersonHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.herbirkisi,viewGroup,false);
        return new PersonHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonHolder personHolder, int i) {
        personHolder.Name.setText(Kisi.get(i).getName());
        personHolder.PhoneNu.setText(Kisi.get(i).getPhoneNu());
        personHolder.Photo.setImageBitmap(Kisi.get(i).getPhoto());

    }

    @Override
    public int getItemCount() {
        return Kisi.size();
    }


    public class PersonHolder extends RecyclerView.ViewHolder{
        TextView Name;
        TextView PhoneNu;
        ImageView Photo;

        public PersonHolder(@NonNull View herbirkisi)
        {
            super(herbirkisi);
            Name=herbirkisi.findViewById(R.id.name);
            PhoneNu=herbirkisi.findViewById(R.id.no);
            Photo=herbirkisi.findViewById(R.id.image);


        }

    }
}