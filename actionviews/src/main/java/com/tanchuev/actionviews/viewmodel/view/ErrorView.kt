package com.tanchuev.actionviews.viewmodel.view

import android.support.annotation.StringRes
import com.tanchuev.actionviews.viewmodel.R
import com.tanchuev.actionviews.viewmodel.utils.isNullOrEmpty

/**
 * @author tanchuev
 */
interface ErrorView {
    fun showError(error: Throwable) {
        showError(if (error.message.isNullOrEmpty()) R.string.errorUnexpected else null, error.message)
    }
    fun showError(@StringRes errorMessageId: Int? = null, errorMessage: String? = null)

    //метода hide нет, потому, что он не нужен.
    //скрытие view такого типа должно контролироваться на уровне view
}
