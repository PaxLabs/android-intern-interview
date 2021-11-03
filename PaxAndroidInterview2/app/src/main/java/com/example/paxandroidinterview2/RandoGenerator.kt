package com.example.paxandroidinterview2

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.paxandroidinterview2.RandoGenerator.RandoContent.Connected
import com.example.paxandroidinterview2.RandoGenerator.RandoContent.Disconnected
import com.example.paxandroidinterview2.RandoGenerator.RandoContent.PodChange
import com.example.paxandroidinterview2.RandoGenerator.RandoContent.Puff
import com.example.paxandroidinterview2.RandoGenerator.RandoContent.Unknown
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Flowable
import java.util.concurrent.TimeUnit

class RandoGenerator(application: Application) : AndroidViewModel(application) {
    val content: MutableLiveData<List<RandoContent>> = MutableLiveData(emptyList())

    sealed class RandoContent {
        object Unknown : RandoContent()
        data class Puff(val duration: Int) : RandoContent()
        data class PodChange(val type: StrainType) : RandoContent()
        object Connected : RandoContent()
        object Disconnected : RandoContent()
    }

    fun start() {
        Flowable.interval(1, TimeUnit.SECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { i ->
                content.value?.let { list -> content.value = list + listOf(randomContent()) }
            }
    }

    private fun randomContent(): RandoContent {
        val x = Math.random()
        return when {
            x < 0.2 -> Puff((Math.random() * 100).toInt() + 2)
            x < 0.4 -> PodChange(StrainType.values()[(0..3).random()])
            x < 0.6 -> Connected
            x < 0.8 -> Disconnected
            else -> Unknown
        }
    }

    enum class StrainType(val encodedValue: Int) {
        HYBRID(1),
        SATIVA(2),
        INDICA(3),
        CBD(4)
    }
}