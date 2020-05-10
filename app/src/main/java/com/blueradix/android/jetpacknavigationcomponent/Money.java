package com.blueradix.android.jetpacknavigationcomponent;

import android.os.Parcel;
import android.os.Parcelable;

import java.math.BigDecimal;

public class Money implements Parcelable {

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    private BigDecimal amount;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeSerializable(this.amount);
    }

    public Money() {
    }

    protected Money(Parcel in) {
        this.amount = (BigDecimal) in.readSerializable();
    }

    public static final Parcelable.Creator<Money> CREATOR = new Parcelable.Creator<Money>() {
        @Override
        public Money createFromParcel(Parcel source) {
            return new Money(source);
        }

        @Override
        public Money[] newArray(int size) {
            return new Money[size];
        }
    };
}
