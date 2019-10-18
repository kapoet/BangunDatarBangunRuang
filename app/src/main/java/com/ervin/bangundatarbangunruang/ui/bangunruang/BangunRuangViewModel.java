package com.ervin.bangundatarbangunruang.ui.bangunruang;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ervin.bangundatarbangunruang.data.Bangun;
import com.ervin.bangundatarbangunruang.data.BangunData;

import java.util.List;

public class BangunRuangViewModel extends ViewModel {

    public LiveData<List<Bangun>> getListBangunRuang() {
        MutableLiveData<List<Bangun>> bangunListMutableLiveData = new MutableLiveData<>();
        bangunListMutableLiveData.setValue(BangunData.genereateBangunRuang());
        return bangunListMutableLiveData;
    }
}