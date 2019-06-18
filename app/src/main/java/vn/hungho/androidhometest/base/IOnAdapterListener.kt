package vn.hungho.androidhometest.base

import android.view.View

interface IOnAdapterListener {
    fun onItemClickListener(view: View, position: Int, item: Any?)
}