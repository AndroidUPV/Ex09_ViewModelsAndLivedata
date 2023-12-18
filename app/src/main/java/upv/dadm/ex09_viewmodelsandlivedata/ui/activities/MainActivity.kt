/*
 * Copyright (c) 2022-2023 Universitat Politècnica de València
 * Authors: David de Andrés and Juan Carlos Ruiz
 *          Fault-Tolerant Systems
 *          Instituto ITACA
 *          Universitat Politècnica de València
 *
 * Distributed under MIT license
 * (See accompanying file LICENSE.txt)
 */

package upv.dadm.ex09_viewmodelsandlivedata.ui.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import upv.dadm.ex09_viewmodelsandlivedata.databinding.ActivityMainBinding
import upv.dadm.ex09_viewmodelsandlivedata.ui.viewmodels.LikeViewModel

/**
 * Displays the number of likes, which can be increased/decreased using the provided Buttons.
 */
class MainActivity : AppCompatActivity() {

    // Get the ViewModel from the default Factory
    private val viewModel: LikeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Get the automatically generated view binding for the layout resource
        val binding = ActivityMainBinding.inflate(layoutInflater)
        // Set the activity content to the root element of the generated view
        setContentView(binding.root)

        // Observe the number of likes and display it on a TextView
        viewModel.like.observe(this@MainActivity) { like ->
            binding.tvLike.text = like
        }
        // Increase the current number of likes
        binding.bThumbUp.setOnClickListener { viewModel.thumbUp() }
        // Decrease the current number of likes
        binding.bThumbDown.setOnClickListener { viewModel.thumbDown() }
    }
}