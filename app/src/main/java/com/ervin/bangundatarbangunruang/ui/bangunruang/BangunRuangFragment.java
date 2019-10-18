package com.ervin.bangundatarbangunruang.ui.bangunruang;

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

public class BangunRuangFragment extends Fragment {

    private BangunRuangViewModel bangunRuangViewModel;
    private RecyclerView rvBangunRuang;
    private BangunRuangAdapter bangunRuangAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvBangunRuang = view.findViewById(R.id.rv_bangun_ruang);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        bangunRuangViewModel = ViewModelProviders.of(this).get(BangunRuangViewModel.class);
        bangunRuangAdapter = new BangunRuangAdapter(getActivity());
        bangunRuangViewModel.getListBangunRuang().observe(this, new Observer<List<Bangun>>() {
            @Override
            public void onChanged(List<Bangun> banguns) {
                bangunRuangAdapter.setbangunRuang(banguns);
                bangunRuangAdapter.notifyDataSetChanged();
            }
        });

        rvBangunRuang.setLayoutManager(new LinearLayoutManager(getContext()));
        rvBangunRuang.setHasFixedSize(true);
        rvBangunRuang.setAdapter(bangunRuangAdapter);
    }
}