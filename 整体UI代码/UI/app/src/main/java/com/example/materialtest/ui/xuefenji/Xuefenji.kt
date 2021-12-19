package com.example.materialtest.ui.xuefenji

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer

import com.example.materialtest.R
import com.example.materialtest.databinding.FragmentSlideshowBinding
import com.example.materialtest.ui.slideshow.SlideshowViewModel

class Xuefenji : Fragment() {

    companion object {
        fun newInstance() = Xuefenji()
    }

    private lateinit var xuefenjiViewModel: XuefenjiViewModel

    private var _binding: FragmentSlideshowBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        xuefenjiViewModel = ViewModelProvider(this).get(XuefenjiViewModel::class.java)
        _binding = FragmentSlideshowBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textSlideshow


        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // TODO: Use the ViewModel
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}