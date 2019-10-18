package com.ervin.bangundatarbangunruang.ui.bangundatar;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ervin.bangundatarbangunruang.data.Bangun;
import com.ervin.bangundatarbangunruang.data.BangunData;

import java.util.List;

public class BangunDatarViewModel extends ViewModel {

    public LiveData<List<Bangun>> getListBangunDatar() {
        MutableLiveData<List<Bangun>> bangunListMutableLiveData = new MutableLiveData<>();
        bangunListMutableLiveData.setValue(BangunData.generateBangunDatar());
        return bangunListMutableLiveData;
    }

}