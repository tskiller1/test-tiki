package vn.hungho.androidhometest.base

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

abstract class BaseActivity : AppCompatActivity(), IView {
    var dialogProgress: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dialogProgress = ProgressDialog(this)
    }

    override fun showLoading() {
        if (dialogProgress == null) {
            dialogProgress = ProgressDialog(this)
        }
        dialogProgress?.show()
    }

    override fun hideLoading() {
        if (dialogProgress?.isShowing!!) {
            dialogProgress?.dismiss()
        }
    }

    @SuppressLint("ShowToast")
    override fun showErrorMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG)
    }
}