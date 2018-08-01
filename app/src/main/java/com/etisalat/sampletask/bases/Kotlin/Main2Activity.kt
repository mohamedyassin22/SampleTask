package com.etisalat.sampletask.bases.Kotlin

import android.Manifest.permission.CAMERA
import android.app.Activity
import android.app.PendingIntent.getActivity
import android.content.Intent
import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import butterknife.ButterKnife
import com.etisalat.sampletask.R
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.main_toolbar.*

class Main2Activity : AppCompatActivity() {
    private val CAMERA = 1;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        ButterKnife.bind(this)
        setSupportActionBar(toolbar);
        ivPohto.setOnClickListener { takePhotoFromCamera() }
    }

    private fun takePhotoFromCamera() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent, CAMERA)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == CAMERA && resultCode == Activity.RESULT_OK) {
            val thumbnail = data?.extras?.get("data") as Bitmap
            ivPohto.setImageBitmap(thumbnail)

        }
    }
}
