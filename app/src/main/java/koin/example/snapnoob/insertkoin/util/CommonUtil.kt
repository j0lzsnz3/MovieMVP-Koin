package koin.example.snapnoob.insertkoin.util

import android.app.ProgressDialog
import android.content.Context
import android.graphics.Color
import androidx.core.graphics.drawable.toDrawable
import koin.example.snapnoob.insertkoin.R

object CommonUtil {

    fun showLoadingProgress(context: Context?) : ProgressDialog {
        val progressDialog = ProgressDialog(context)

        progressDialog.let {
            it.show()
            it.window.setBackgroundDrawable(Color.TRANSPARENT.toDrawable())
            it.setContentView(R.layout.progress_dialog)
            it.isIndeterminate = true
            it.setCanceledOnTouchOutside(false)
            it.setCancelable(false)

        }

        return progressDialog
    }
}