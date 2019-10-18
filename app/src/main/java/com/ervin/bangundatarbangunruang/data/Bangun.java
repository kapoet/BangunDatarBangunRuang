package com.ervin.bangundatarbangunruang.data;

import android.os.Parcel;
import android.os.Parcelable;

public class Bangun implements Parcelable {
    private String bangunName;
    private String bnagunPic;

    public String getBnagunPic() {
        return bnagunPic;
    }

    public void setBnagunPic(String bnagunPic) {
        this.bnagunPic = bnagunPic;
    }

    public String getBangunName() {
        return bangunName;
    }

    public void setBangunName(String bangunName) {
        this.bangunName = bangunName;
    }

    public Bangun(String bangunName, String bnagunPic) {
        this.bangunName = bangunName;
        this.bnagunPic = bnagunPic;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.bangunName);
        dest.writeString(this.bnagunPic);
    }

    protected Bangun(Parcel in) {
        this.bangunName = in.readString();
        this.bnagunPic = in.readString();
    }

    public static final Parcelable.Creator<Bangun> CREATOR = new Parcelable.Creator<Bangun>() {
        @Override
        public Bangun createFromParcel(Parcel source) {
            return new Bangun(source);
        }

        @Override
        public Bangun[] newArray(int size) {
            return new Bangun[size];
        }
    };
}
