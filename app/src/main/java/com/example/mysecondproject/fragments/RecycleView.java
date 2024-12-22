package com.example.mysecondproject.fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mysecondproject.R;
import com.example.mysecondproject.classes.CustomeAdapter;
import com.example.mysecondproject.classes.DataArrays;
import com.example.mysecondproject.classes.DataModel;

import java.util.ArrayList;

public class RecycleView extends Fragment {
    private RecyclerView recyclerView;
    private ArrayList<DataModel> dataset;
    private CustomeAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycleview, container, false);

        recyclerView = view.findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        dataset = new ArrayList<>();
        for (int i = 0; i < DataArrays.nameArray.length; i++) {
            dataset.add(new DataModel(
                    DataArrays.nameArray[i],
                    DataArrays.descriptionArray[i],
                    DataArrays.drawableArray[i],
                    DataArrays.id_[i]
            ));
        }

        adapter = new CustomeAdapter(dataset);
        recyclerView.setAdapter(adapter);

        EditText searchEditText = view.findViewById(R.id.searchEditText);

        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                filterList(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });

        return view;
    }

    private void filterList(String query) {
        ArrayList<DataModel> filteredList = new ArrayList<>();
        for (DataModel item : dataset) {
            if (item.getName().toLowerCase().contains(query.toLowerCase())) {
                filteredList.add(item);
            }
        }
        adapter.updateList(filteredList);  // מעדכנים את הנתונים במתאם
    }
}
