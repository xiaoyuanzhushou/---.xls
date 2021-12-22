package com.example.xiaoyuanzhushou.ui.home

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.annotation.LayoutRes
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.whenStarted
import com.example.xiaoyuanzhushou.R
import com.google.android.material.card.MaterialCardView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import splitties.dimensions.dip

abstract class BaseDialogFragment : DialogFragment() {

    fun launch(block: suspend CoroutineScope.() -> Unit): Job = lifecycleScope.launch {
        lifecycle.whenStarted(block)
    }

    @get:LayoutRes
    protected abstract val layoutId: Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        dialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.window?.setLayout(requireContext().dip(280), ViewGroup.LayoutParams.WRAP_CONTENT)
        val root = inflater.inflate(R.layout.activity_base_dialog_fragment, container, false)
        val cardView = root.findViewById<MaterialCardView>(R.id.base_card_view)
        LayoutInflater.from(context).inflate(layoutId, cardView, true)
        return root
    }

    override fun show(manager: FragmentManager, tag: String?) {
        super.show(manager,tag)


//        mDismissed = false
//        mShownByMe = true

        val ft = manager.beginTransaction()
        ft.add(this, tag)

        ft.commitAllowingStateLoss()
    }

}

