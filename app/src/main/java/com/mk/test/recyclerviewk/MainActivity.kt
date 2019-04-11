package com.mk.test.recyclerviewk

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // List of Objects
    //val animals: ArrayList<String> = ArrayList()
    val imageList:ArrayList<Image> = ArrayList()

    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val bottomImage : ImageView = findViewById(R.id.BottomImage)

        Glide
            .with(this)
            .load("https://images.pexels.com/photos/46239/salmon-dish-food-meal-46239.jpeg?auto=compress&cs=tinysrgb&h=50")
            .placeholder(R.mipmap.ic_launcher)
            .dontAnimate()
            .into(bottomImage);

        val requestOption = RequestOptions()
            .placeholder(R.mipmap.ic_launcher).centerCrop()
/*
        Glide.with(this).load("https://images.pexels.com/photos/46239/salmon-dish-food-meal-46239.jpeg?auto=compress&cs=tinysrgb&h=1000")
            .transition(DrawableTransitionOptions.withCrossFade())
            .thumbnail(Glide.with(this)
                .load("https://images.pexels.com/photos/46239/salmon-dish-food-meal-46239.jpeg?auto=compress&cs=tinysrgb&h=50")
                .apply(requestOption))
            .apply(requestOption)
            //.listener(MyImageRequestListener(this))
            .into(bottomImage)
*/
        //animals.add("cat")
        //animals.add("dog")
        //animals.add("mouse")

        var image0 : Image = Image()
        image0.imageUrl = "https://www.cameraegg.org/wp-content/uploads/2015/06/canon-powershot-g3-x-sample-images-1.jpg?auto=compress&cs=tinysrgb&h=50"
        image0.name = "first thing"
        image0.description = "first description"
        imageList.add(image0)
        var image1 : Image = Image()
        image1.imageUrl = "https://images.pexels.com/photos/46239/salmon-dish-food-meal-46239.jpeg?auto=compress&cs=tinysrgb&h=50"
        image1.name = "second thing"
        image1.description = "second description"
        imageList.add(image1)
        var image2 : Image = Image()
        image2.imageUrl = "https://googlechrome.github.io/samples/picture-element/images/butterfly.webp?auto=compress&cs=tinysrgb&h=50"
        image2.name = "third thing"
        image2.description = "third description"
        imageList.add(image2)

        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager

        recyclerView.adapter = RecyclerAdapter(imageList, this)
    }
}
