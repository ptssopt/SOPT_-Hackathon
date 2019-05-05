package com.computer.inu.sopt_hackathon_pts.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.computer.inu.sopt_hackathon_pts.Adapter.ImageRecyclerAdapter
import com.computer.inu.sopt_hackathon_pts.R
import com.computer.inu.sopt_hackathon_pts.data.ImageData
import kotlinx.android.synthetic.main.activity_request_list.*

class RequestListActivity : AppCompatActivity() {
    lateinit var imageRecyclerAdapter: ImageRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_request_list)
        var ImageDataList = ArrayList<ImageData>()
        ImageDataList.add(ImageData("https://scontent-icn1-1.xx.fbcdn.net/v/t1.0-9/58383648_1714122605401284_8261916106969579520_o.jpg?_nc_cat=107&_nc_ht=scontent-icn1-1.xx&oh=5685d155cc3622b1535485166619daff&oe=5D756045"))
        ImageDataList.add(ImageData("https://scontent-icn1-1.xx.fbcdn.net/v/t1.0-9/58383648_1714122605401284_8261916106969579520_o.jpg?_nc_cat=107&_nc_ht=scontent-icn1-1.xx&oh=5685d155cc3622b1535485166619daff&oe=5D756045"))
        ImageDataList.add(ImageData("https://scontent-icn1-1.xx.fbcdn.net/v/t1.0-9/58383648_1714122605401284_8261916106969579520_o.jpg?_nc_cat=107&_nc_ht=scontent-icn1-1.xx&oh=5685d155cc3622b1535485166619daff&oe=5D756045"))
        ImageDataList.add(ImageData("https://scontent-icn1-1.xx.fbcdn.net/v/t1.0-9/58383648_1714122605401284_8261916106969579520_o.jpg?_nc_cat=107&_nc_ht=scontent-icn1-1.xx&oh=5685d155cc3622b1535485166619daff&oe=5D756045"))
        ImageDataList.add(ImageData("https://scontent-icn1-1.xx.fbcdn.net/v/t1.0-9/58383648_1714122605401284_8261916106969579520_o.jpg?_nc_cat=107&_nc_ht=scontent-icn1-1.xx&oh=5685d155cc3622b1535485166619daff&oe=5D756045"))
        ImageDataList.add(ImageData("https://scontent-icn1-1.xx.fbcdn.net/v/t1.0-9/58383648_1714122605401284_8261916106969579520_o.jpg?_nc_cat=107&_nc_ht=scontent-icn1-1.xx&oh=5685d155cc3622b1535485166619daff&oe=5D756045"))
        ImageDataList.add(ImageData("https://scontent-icn1-1.xx.fbcdn.net/v/t1.0-9/58383648_1714122605401284_8261916106969579520_o.jpg?_nc_cat=107&_nc_ht=scontent-icn1-1.xx&oh=5685d155cc3622b1535485166619daff&oe=5D756045"))
        ImageDataList.add(ImageData("https://scontent-icn1-1.xx.fbcdn.net/v/t1.0-9/58383648_1714122605401284_8261916106969579520_o.jpg?_nc_cat=107&_nc_ht=scontent-icn1-1.xx&oh=5685d155cc3622b1535485166619daff&oe=5D756045"))

        imageRecyclerAdapter= ImageRecyclerAdapter(this, ImageDataList)
        rv_request_list.adapter = imageRecyclerAdapter
        rv_request_list.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)


    }
}
