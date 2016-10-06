package com.salmannazir.namelist.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.salmannazir.namelist.R;
import com.salmannazir.namelist.models.Person;


import java.util.ArrayList;

public class NamesListAdapter extends RecyclerView
        .Adapter<NamesListAdapter
        .PersonObjectHolder> {

    private ArrayList<Person> mDataSet;
    private Context mContext;


    public static class PersonObjectHolder extends RecyclerView.ViewHolder{

        TextView mPersonNameText ;

        public PersonObjectHolder(View itemView) {
            super(itemView);
            mPersonNameText = (TextView) itemView.findViewById(R.id.person_name_text);
        }
    }


    public NamesListAdapter(Context ctx, ArrayList<Person> myDataset) {
        mDataSet = myDataset;
        mContext = ctx;

    }

    @Override
    public PersonObjectHolder onCreateViewHolder(ViewGroup parent,
                                                 int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.person_list_view_item, parent, false);

        return new PersonObjectHolder(view);

    }

    @Override
    public void onBindViewHolder(final PersonObjectHolder holder, final int position) {

        Person mPerson = mDataSet.get(position);

        holder.mPersonNameText.setText(mPerson.getLastName()+", "+mPerson.getFirstName());

    }

    public void addItem(Person dataObj) {

        mDataSet.add(dataObj);
        notifyDataSetChanged();

    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

}