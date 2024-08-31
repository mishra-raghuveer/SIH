package com.example.fertilizeroptimizer

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.raghuveermishra.myapplication.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cropTypeSpinner: Spinner = findViewById(R.id.cropTypeSpinner)
        val soilTypeSpinner: Spinner = findViewById(R.id.soilTypeSpinner)
        val landSizeInput: EditText = findViewById(R.id.landSize)
        val expectedYieldInput: EditText = findViewById(R.id.expectedYield)
        val organicCarbonInput: EditText = findViewById(R.id.organicCarbon)
        val progressBar: ProgressBar = findViewById(R.id.progressBar)
        val recommendFertilizerButton: Button = findViewById(R.id.btnRecommendFertilizer)
        val calculatePPMButton: Button = findViewById(R.id.btnCalculatePPM)
        val recommendationTextView: TextView = findViewById(R.id.fertilizerRecommendation)
        val ppmResultTextView: TextView = findViewById(R.id.ppmResult)

        // Populate dropdowns with data
        val cropTypes = arrayOf("Wheat", "Rice", "Corn", "Soybeans")
        cropTypeSpinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, cropTypes)

        val soilTypes = arrayOf("Sandy", "Clay", "Loam")
        soilTypeSpinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, soilTypes)

        recommendFertilizerButton.setOnClickListener {
            progressBar.visibility = View.VISIBLE
            val cropType = cropTypeSpinner.selectedItem.toString()
            val soilType = soilTypeSpinner.selectedItem.toString()
            val landSize = landSizeInput.text.toString().toDoubleOrNull() ?: 0.0
            val expectedYield = expectedYieldInput.text.toString().toDoubleOrNull() ?: 0.0
            val organicCarbon = organicCarbonInput.text.toString().toDoubleOrNull() ?: 0.0

            // Simulate recommendation calculation
            val recommendation = "Recommended Fertilizer: Balanced NPK (10-10-10)"
            recommendationTextView.text = recommendation

            // Hide progress bar
            progressBar.visibility = View.GONE
        }

        calculatePPMButton.setOnClickListener {
            progressBar.visibility = View.VISIBLE
            val landSize = landSizeInput.text.toString().toDoubleOrNull() ?: 0.0
            val expectedYield = expectedYieldInput.text.toString().toDoubleOrNull() ?: 0.0

            // Simulate PPM calculation
            val ppmResult = "PPM Solution: Mix 1.5 kg of fertilizer in 100 liters of water"
            ppmResultTextView.text = ppmResult

            // Hide progress bar
            progressBar.visibility = View.GONE
        }
    }
}
