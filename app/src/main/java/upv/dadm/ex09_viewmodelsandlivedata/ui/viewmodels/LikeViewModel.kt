/*
 * Copyright (c) 2022
 * David de Andrés and Juan Carlos Ruiz
 * Development of apps for mobile devices
 * Universitat Politècnica de València
 */

package upv.dadm.ex09_viewmodelsandlivedata.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

/**
 * Holds the number of likes received and provides methods for increasing/decreasing it.
 */
class LikeViewModel : ViewModel() {

    // UI state (mutable): number of likes
    private val _like: MutableLiveData<Int> = MutableLiveData(0)
    // Backing property (immutable)
    val like: LiveData<String>
        // Int is transformed into String to be easily displayed by the UI
        get() = Transformations.map(_like) { value -> value.toString() }

    /**
     * Increases the current number of likes.
     */
    fun thumbUp() {
        _like.value = _like.value?.plus(1)
    }

    /**
     * Decreases the current number of likes (it can be negative!).
     */
    fun thumbDown() {
        _like.value = _like.value?.minus(1)
    }
}