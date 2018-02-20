package com.rigel.eventexchange.activities;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.rigel.eventexchange.R;
import com.firebase.client.Firebase;

import java.io.IOException;

/*

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.firebase.client.Firebase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
*/


public class SellerActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int PICK_IMAGE_REQUEST = 234;
    private Button buttonUpload;
    EditText NameEditText, TypeEditText, DescriptionEditText, NumberEditText;
    TextView textView;
    private ImageView imageView;
    private Button buttonChoose;
    Button SubmitButton;
    private Uri filePath;

    private StorageReference storageReference;
    private DatabaseReference mDatabase;

    public static final String Firebase_Server_URL = "https://event-exchange-add22.firebaseio.com/";
    String NameHolder, TypeHolder, DescriptionHolder, NumberHolder;

    Firebase firebase;

    DatabaseReference databaseReference;

//    public static final String Database_Path = "Seller_Database";
    public static final String Storage_Path = "Seller_Database";
    //public static final String STORAGE_PATH_UPLOADS = "uploads/";
    public static final String DATABASE_PATH_UPLOADS = "uploads";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller);
        Firebase.setAndroidContext(SellerActivity.this);

        firebase = new Firebase(Firebase_Server_URL);

        databaseReference = FirebaseDatabase.getInstance().getReference();

        SubmitButton = (Button) findViewById(R.id.submit);
        NameEditText = (EditText) findViewById(R.id.name);
        TypeEditText = (EditText) findViewById(R.id.type);
        DescriptionEditText = (EditText) findViewById(R.id.description);
        NumberEditText = (EditText) findViewById(R.id.number);
        buttonChoose = (Button) findViewById(R.id.buttonChoose);
        buttonUpload = (Button) findViewById(R.id.buttonUpload);
        imageView = (ImageView) findViewById(R.id.imageView);
        textView = (TextView) findViewById(R.id.textView);


        storageReference = FirebaseStorage.getInstance().getReference(Storage_Path);
        mDatabase = FirebaseDatabase.getInstance().getReference(DATABASE_PATH_UPLOADS);

        buttonChoose.setOnClickListener(this);
        buttonUpload.setOnClickListener(this);
        textView.setOnClickListener(this);

        SubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Declaring student class object.
                Seller seller = new Seller();

                // Calling function to Get data from EditText and store into string variables.
                GetDataFromEditText();

                // Adding student name into student class object.
                seller.setSellerName(NameHolder);

                // Adding phone number into class function object.
                seller.setSellerType(TypeHolder);

                seller.setSellerDescription(DescriptionHolder);

                seller.setSellerNumber(NumberHolder);

                String SellerRecordIDFromServer;
//                SellerRecordIDFromServer = databaseReference.push().getKey();
//                databaseReference.child(SellerRecordIDFromServer).setValue(seller);
                FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
                if (currentUser == null) {
                    //TODO: dialogue box
                } else {
                    String uid = currentUser.getUid();
                    mDatabase = FirebaseDatabase.getInstance().getReference();
                    mDatabase.child(uid).setValue(seller);
                }


                // Passing student phone number and name into firebase object to add into database.
//                firebase.child("Seller").setValue(seller);

                // Showing toast message after data inserted.
                Toast.makeText(SellerActivity.this, "Data Inserted Successfully", Toast.LENGTH_LONG).show();

            }
        });
    }

    public void GetDataFromEditText() {
        NameHolder = NameEditText.getText().toString().trim();
        TypeHolder = TypeEditText.getText().toString().trim();
        DescriptionHolder = DescriptionEditText.getText().toString().trim();
        NumberHolder = NumberEditText.getText().toString().trim();
    }


    private void showFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            filePath = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                imageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onClick(View view) {
        if (view == buttonChoose) {
            showFileChooser();
        } else if (view == buttonUpload) {
            uploadFile();
        } else if (view == textView) {
            Intent i = new Intent(SellerActivity.this, SellerPage.class);
            //TODO: change seller page.class to seller profile
            startActivity(i);
        }
    }

    public String getFileExtension(Uri uri) {
        ContentResolver cR = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cR.getType(uri));
    }
    //this method will upload the file


    private void uploadFile() {
        //if there is a file to upload
        if (filePath != null) {
            //displaying a progress dialog while upload is going on
            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setTitle("Uploading");
            progressDialog.show();

            StorageReference riversRef = storageReference.child("images.pic/.jpg");
//    StorageReference riversRef = storageReference.child(STORAGE_PATH_UPLOADS + System.currentTimeMillis() + "." + getFileExtension(filePath));
            riversRef.putFile(filePath)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override

                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            //if the upload is successfull
                            //hiding the progress dialog
                            progressDialog.dismiss();

                            //and displaying a success toast
                            Toast.makeText(getApplicationContext(), "File Uploaded ", Toast.LENGTH_LONG).show();
                        }

                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override

                        public void onFailure(@NonNull Exception exception) {
//if the upload is not successfull
//hiding the progress dialog
                            progressDialog.dismiss();

//and displaying error message

                            Toast.makeText(getApplicationContext(), exception.getMessage(), Toast.LENGTH_LONG).show();
                        }

                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override

                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
//calculating progress percentage

                            double progress = (100.0 * taskSnapshot.getBytesTransferred()) / taskSnapshot.getTotalByteCount();

//displaying percentage in progress dialog
                            progressDialog.setMessage("Uploaded " + ((int) progress) + "%...");
                        }

                    });
        }
//if there is not any file
        else{
//you can display an error toast
        }
    }
}
