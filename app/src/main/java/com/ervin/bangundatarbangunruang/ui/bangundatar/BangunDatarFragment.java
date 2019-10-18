package com.ervin.bangundatarbangunruang.ui.bangundatar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ervin.bangundatarbangunruang.R;
import com.ervin.bangundatarbangunruang.data.Bangun;

import java.util.List;

public class BangunDatarFragment extends Fragment {

    private BangunDatarViewModel bangunDatarViewModel;
    private BangunDatarAdapter bangunDatarAdapter;
    private RecyclerView rvBangunDatar;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvBangunDatar = view.findViewById(R.id.rv_bangun_datar);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        bangunDatarViewModel = ViewModelProviders.of(this).get(BangunDatarViewModel.class);
        bangunDatarAdapter = new BangunDatarAdapter(getActivity());
        bangunDatarViewModel.getListBangunDatar().observe(this, new Observer<List<Bangun>>() {
            @Override
            public void onChanged(List<Bangun> banguns) {
                bangunDatarAdapter.setBangunDatar(banguns);
                bangunDatarAdapter.notifyDataSetChanged();
            }
        });
        rvBangunDatar.setLayoutManager(new LinearLayoutManager(getContext()));
        rvBangunDatar.setHasFixedSize(true);
        rvBangunDatar.setAdapter(bangunDatarAdapter);
    }
}