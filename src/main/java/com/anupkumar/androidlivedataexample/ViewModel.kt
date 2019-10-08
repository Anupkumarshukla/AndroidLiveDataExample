package com.anupkumar.androidlivedataexample

import android.os.Handler
import android.util.Log
import androidx.core.os.HandlerCompat.postDelayed
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import java.util.*


class ViewModel : ViewModel() {

    companion object {
        const val TAG = "ViewModel"
    }

    private val TAG = ViewModel::class.java.simpleName

    private var metroList: MutableLiveData<List<String>>? = null

       fun getFruitList(): LiveData<List<String>> {
          if (metroList == null) {
              metroList = MutableLiveData()
              loadFruits()
          }
          return metroList as MutableLiveData<List<String>>
      }

    private fun loadFruits() {
        // do async operation to fetch users
        val myHandler = Handler()
        myHandler.postDelayed({
            val metroStringList = arrayListOf<String>()
            metroStringList.add("Ghatkopar")
            metroStringList.add("Jagruti Nagar")
            metroStringList.add("Asalfa")
            metroStringList.add("Sakinaka")
            metroStringList.add("Marol naka")

            metroStringList.add("Airport Road")
            metroStringList.add("Chakala")
            metroStringList.add("Western Express Highway")
            metroStringList.add("Andheri")
            metroStringList.add("Azad Nagar")

            metroStringList.add("D N Nagar")
            metroStringList.add("Versova")
            val seed = System.nanoTime()
            Collections.shuffle(metroStringList, Random(seed))

            metroList!!.setValue(metroStringList)
        }, 2000)

    }

    override fun onCleared() {
        super.onCleared()
        Log.d(TAG, "on cleared called")
    }

}