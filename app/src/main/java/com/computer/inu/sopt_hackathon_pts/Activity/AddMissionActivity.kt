package com.computer.inu.sopt_hackathon_pts.Activity

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.ExifInterface
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_add_mission.*
import java.io.File
import java.io.IOException
import java.util.Collections.rotate
import java.text.SimpleDateFormat
import java.util.*
import android.provider.MediaStore
import android.support.v7.app.AlertDialog
import org.jetbrains.anko.startActivity


class AddMissionActivity : AppCompatActivity() {
    private val photoUri: Uri? = null
    private val currentPhotoPath: String? = null//실제 사진 파일 경로
    var mImageCaptureName: String? = null//이미지 이름
    private val GALLERY_CODE = 1112
    private val CAMERA_CODE = 1111
    var profileimage : String? = null
    var Backgroundimage : String? = null
    var choice : Int = 0
    var imageURI : String? = null
    var status : String? =null
    val REQUEST_CODE_SELECT_IMAGE : Int = 1004
    val   My_READ_STORAGE_REQUEST_CODE = 7777
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.computer.inu.sopt_hackathon_pts.R.layout.activity_add_mission)
        iv_add_mission_comfirm.setOnClickListener {
            val alert = AlertDialog.Builder(this)
            alert.setPositiveButton("확인") { dialog, which ->
                startActivity<MissionStateActivity>()
                dialog.dismiss()     //닫기
            }
            alert.setMessage("자녀에게 미션이 발송되었습니다")
            alert.show()
            alert.setCancelable(false)
        }
        tv_add_mission_mission_title.text=intent.getStringExtra("title")
        iv_add_mission_mission_image.setOnClickListener {
                requestReadExternalStoragePermission() //사진열기

        }

    }
    private fun requestReadExternalStoragePermission(){
//첫번째 if문을 통해 과거에 이미 권한 메시지에 대한 OK를 했는지 아닌지에 대해 물어봅니다!
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)){
//사용자에게 권한을 왜 허용해야되는지에 메시지를 주기 위한 대한 로직을 추가하려면 이 블락에서 하면됩니다!!
//하지만 우리는 그냥 비워놓습니다!! 딱히 줄말 없으면 비워놔도 무관해요!!! 굳이 뭐 안넣어도됩니다!
            } else {
//아래 코드는 권한을 요청하는 메시지를 띄우는 기능을 합니다! 요청에 대한 결과는 callback으로 onRequestPermissionsResult 메소드에서 받습니다!!!
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), My_READ_STORAGE_REQUEST_CODE)
            }
        } else {
//첫번째 if 문의 else 로써, 기존에 이미 권한 메시지를 통해 권한을 허용했다면 아래와 같은 곧바로 앨범을 여는 메소드를 호출 해주면됩니다!!
       showAlbum()
        }
    }
    //외부저장소(앨범과 같은)에 접근 관련 요청에 대해 OK를 했는지 거부했는지를 callback으로 받는 메소드입니다!
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
//onActivityResult와 같은 개념입니다. requestCode로 어떤 권한에 대한 callback인지를 체크합니다.
        if (requestCode == My_READ_STORAGE_REQUEST_CODE){
//결과에 대해 허용을 눌렀는지 체크하는 조건문이구요!
            if(grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
//이곳은 외부저장소 접근을 허용했을 때에 대한 로직을 쓰시면됩니다. 우리는 앨범을 여는 메소드를 호출해주면되겠죠?
          showAlbum()
            } else {
//이곳은 외부저장소 접근 거부를 했을때에 대한 로직을 넣어주시면 됩니다.
                finish()
            }
        }
    }

    fun exifOrientationToDegrees(exifOrientation: Int): Int {
        if (exifOrientation == ExifInterface.ORIENTATION_ROTATE_90) {
            return 90
        } else if (exifOrientation == ExifInterface.ORIENTATION_ROTATE_180) {
            return 180
        } else if (exifOrientation == ExifInterface.ORIENTATION_ROTATE_270) {
            return 270
        }
        return 0
    }
      @Throws(IOException::class)


    private fun selectPhoto() {

        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent, CAMERA_CODE)
    }
    private fun getPictureForPhoto() {
        val bitmap = BitmapFactory.decodeFile(currentPhotoPath)
        var exif: ExifInterface? = null
        try {
            exif = ExifInterface(currentPhotoPath)
        } catch (e: IOException) {
            e.printStackTrace()
        }

        val exifOrientation: Int
        val exifDegree: Int

        if (exif != null) {
            exifOrientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL)
            exifDegree = exifOrientationToDegrees(exifOrientation)

        } else {
            exifDegree = 0
        }
        iv_add_mission_mission_image.setImageBitmap(bitmap)//이미지 뷰에 비트맵 넣기
    }

    private fun showAlbum(){
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = android.provider.MediaStore.Images.Media.CONTENT_TYPE
        intent.data = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        startActivityForResult(intent, REQUEST_CODE_SELECT_IMAGE)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
//REQUEST_CODE_SELECT_IMAGE를 통해 앨범에서 보낸 요청에 대한 Callback인지를 체크!!!
        if (requestCode == REQUEST_CODE_SELECT_IMAGE) {
            if (resultCode == Activity.RESULT_OK) {
//data.data에는 앨범에서 선택한 사진의 Uri가 들어있습니다!! 그러니까 제대로 선택됐는지 null인지 아닌지를 체크!!!
                if(data != null){
                    val selectedImageUri : Uri = data.data
//Uri를 getRealPathFromURI라는 메소드를 통해 절대 경로를 알아내고, 인스턴스 변수 imageURI에 넣어줍니다!
                    Glide.with(this)
                        .load(selectedImageUri)
                        .thumbnail(0.1f)
                        .into(iv_add_mission_mission_image)
                }
            }
        }
    }
}
