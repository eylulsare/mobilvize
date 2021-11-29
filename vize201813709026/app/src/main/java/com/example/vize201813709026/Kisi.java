package com.example.vize201813709026;

import android.graphics.Bitmap;

public class Kisi {
    private Bitmap Photo;
    private String Name;
    private String PhoneNu;

    public Kisi(Bitmap photo, String name, String phoneNu) {
        Photo = photo;
        Name = name;
        PhoneNu = phoneNu;
    }

    public Bitmap getPhoto() {
        return Photo;
    }

    public void setPhoto(Bitmap photo) {
        Photo = photo;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhoneNu() {
        return PhoneNu;
    }

    public void setPhoneNu(String phoneNu) {
        PhoneNu = phoneNu;
    }
}
