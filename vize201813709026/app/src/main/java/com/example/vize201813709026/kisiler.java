package com.example.vize201813709026;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.RadioButton;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class kisiler extends AppCompatActivity {
    private ArrayList<Kisi> Kisilerim;
    private RecyclerView recyclerView;
    private PersonRescycleAdapter personRecyclerAdapter;
    RadioButton Grup1,Grup2,Grup3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kisiler);
        Kisilerim= new ArrayList<>();

        recyclerView=(RecyclerView) findViewById(R.id.recyclerView);
        personRecyclerAdapter=new PersonRescycleAdapter(Kisilerim);
        recyclerView.setAdapter(personRecyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Grup1=(RadioButton)findViewById(R.id.radioButton);
        Grup2=(RadioButton)findViewById(R.id.radioButton2);
        Grup3=(RadioButton)findViewById(R.id.radioButton3);

        getContactList();



    }
    @SuppressLint("Range")
    private void getContactList() {

        ContentResolver ContRe = getContentResolver();
        Cursor c = ContRe .query(ContactsContract.Contacts.CONTENT_URI,
                null, null, null, null);

        if ((c != null ? c.getCount() : 0) > 0) {
            while (c != null && c.moveToNext()) {
                @SuppressLint("Range") String id = c.getString(
                        c.getColumnIndex(ContactsContract.Contacts._ID));
                @SuppressLint("Range") String name = c.getString(c.getColumnIndex(
                        ContactsContract.Contacts.DISPLAY_NAME));

                if (c.getInt(c.getColumnIndex(
                        ContactsContract.Contacts.HAS_PHONE_NUMBER)) > 0) {

                    Bitmap bitmap= BitmapFactory.decodeResource(getResources(),
                            R.drawable.ic_launcher_foreground);




                    @SuppressLint("Range") String image_uri = c.getString(c.getColumnIndex(
                            ContactsContract.CommonDataKinds.Phone.PHOTO_URI));

                    if (image_uri != null) {

                        try {
                            bitmap = MediaStore.Images.Media
                                    .getBitmap(getContentResolver(),
                                            Uri.parse(image_uri));

                        } catch (FileNotFoundException e) {

                            e.printStackTrace();
                        } catch (IOException e) {

                            e.printStackTrace();
                        }
                    }





                    Cursor pCur = ContRe.query(
                            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                            null,
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?",
                            new String[]{id}, null);
                    while (pCur.moveToNext()) {
                        String phoneNo = pCur.getString(pCur.getColumnIndex(
                                ContactsContract.CommonDataKinds.Phone.NUMBER));
                        Kisilerim.add(new Kisi(bitmap,name,phoneNo));
                    }
                    pCur.close();
                }
            }
        }
        if(c!=null){
            c.close();
        }

    }

}