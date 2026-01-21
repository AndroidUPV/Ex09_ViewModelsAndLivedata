/*
 * Copyright (c) 2022-2026 Universitat Politècnica de València
 * Authors: David de Andrés and Juan Carlos Ruiz
 *          Fault-Tolerant Systems
 *          Instituto ITACA
 *          Universitat Politècnica de València
 *
 * Distributed under MIT license
 * (See accompanying file LICENSE.txt)
 */

package upv.dadm.ex09_viewmodelsandlivedata.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map

/**
 * Holds the number of likes received and provides methods for increasing/decreasing it.
 */
class LikeViewModel : ViewModel() {

    // UI state (mutable): number of likes
    private val _like: MutableLiveData<Int> = MutableLiveData(0)

    // Backing property (immutable)
    val like: LiveData<String>
        // Int is transformed into String to be easily displayed by the UI
        get() = _like.map { value -> value.toString() }

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