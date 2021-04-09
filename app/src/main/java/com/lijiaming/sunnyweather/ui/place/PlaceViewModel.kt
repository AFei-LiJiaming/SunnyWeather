package com.lijiaming.sunnyweather.ui.place

import android.view.animation.Transformation
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.lijiaming.sunnyweather.logic.Repository
import com.lijiaming.sunnyweather.logic.model.Place

class PlaceViewModel : ViewModel() {

    private val searchLiveData = MutableLiveData<String>()

    val placeList = ArrayList<Place>()  //对界面上显示的城市数据进行缓存(原则上与界面相关的数据都应放到viewModel中)

    val placeLiveData = Transformations.switchMap(searchLiveData) { query ->
        Repository.searchPlaces(query)
    }

    fun searchPlaces(query: String){
        searchLiveData.value = query
    }

}