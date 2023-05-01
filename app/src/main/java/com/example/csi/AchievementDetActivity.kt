package com.example.csi

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.csi.Adapters.SliderAdapater
import com.example.csi.databinding.ActivityAchievementDetBinding
import com.example.csi.modelclasses.AchievementImagesDataClass
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.smarteist.autoimageslider.SliderAnimations

class AchievementDetActivity : AppCompatActivity() {
    private lateinit var binding:ActivityAchievementDetBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityAchievementDetBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val arrayList=ArrayList<AchievementImagesDataClass>()
        arrayList.add(AchievementImagesDataClass("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg"))
        arrayList.add(AchievementImagesDataClass("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg"))
        arrayList.add(AchievementImagesDataClass("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg"))
        arrayList.add(AchievementImagesDataClass("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg"))

        binding.sliderCarousel.setSliderAdapter(SliderAdapater(arrayList, this))
         binding.sliderCarousel.setIndicatorAnimation(IndicatorAnimationType.WORM)
        binding.sliderCarousel.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION)
        binding.sliderCarousel.startAutoCycle()



    }

}