package com.example.frar

import android.app.Activity.RESULT_OK
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.example.frar.databinding.FragmentHomePageBinding
import com.github.drjacky.imagepicker.ImagePicker
import com.github.drjacky.imagepicker.constant.ImageProvider


class HomePageFragment : Fragment() {

    private lateinit var binding: FragmentHomePageBinding
    private val launcher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                val uri = it.data?.data
                uri?.let { u ->
                    binding.imgDisplay.setImageURI(u)
                }
            }
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomePageBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        binding.btnAddImage.setOnClickListener {
            ImagePicker.with(requireActivity())
                .provider(imageProvider = ImageProvider.BOTH)
                .createIntentFromDialog { i ->
                    launcher.launch(i)
                }
        }
        binding.imgDisplay
        return binding.root
    }
}