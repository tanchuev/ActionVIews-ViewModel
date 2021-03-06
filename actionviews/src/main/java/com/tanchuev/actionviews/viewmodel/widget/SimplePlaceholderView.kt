package com.tanchuev.actionviews.viewmodel.widget

import android.content.Context
import android.support.annotation.DrawableRes
import android.support.annotation.StringRes
import android.text.TextUtils
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.l_placeholder_view.view.*
import com.tanchuev.actionviews.viewmodel.R
import com.tanchuev.actionviews.viewmodel.R.id.placeholderViewText
import com.tanchuev.actionviews.viewmodel.utils.getAppCompatDrawable
import com.tanchuev.actionviews.viewmodel.utils.setVisibility

/**
 * @author tanchuev
 */

open class SimplePlaceholderView(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {

    init {
        init(context, attrs)
    }

    private fun init(context: Context, attrs: AttributeSet) {
        View.inflate(context, R.layout.l_placeholder_view, this)

        val a = context.theme.obtainStyledAttributes(attrs, R.styleable.SimplePlaceholderView, 0, 0)

        try {
            placeholderViewText.text = a.getString(R.styleable.SimplePlaceholderView_text)
            placeholderViewIcon.setImageDrawable(
                context.getAppCompatDrawable(
                    a,
                    R.styleable.SimplePlaceholderView_icon,
                    R.drawable.ic_warning
                )
            )
            val buttonText = a.getString(R.styleable.SimplePlaceholderView_buttonText)
            if (!TextUtils.isEmpty(buttonText)) {
                placeholderViewButton.text = buttonText
                placeholderViewButton.visibility = View.VISIBLE
            } else {
                placeholderViewButton.visibility = View.GONE
            }
        } finally {
            a.recycle()
        }
    }

    fun setButtonClickListener(buttonClickListener: View.OnClickListener) {
        placeholderViewButton.setOnClickListener(buttonClickListener)
    }

    fun bindView(@DrawableRes icon: Int? = null,
                 @StringRes text: Int? = null,
                 @StringRes buttonText: Int? = null,
                 buttonClickListener: View.OnClickListener? = null) {
        if (icon != null) {
            placeholderViewIcon.setImageResource(icon)
        }
        if (text != null) {
            placeholderViewText.setText(text)
        }
        if (buttonText != null) {
            placeholderViewButton.setText(buttonText)
            placeholderViewButton.visibility = View.VISIBLE
        } else {
            placeholderViewButton.visibility = View.GONE
        }
        if (buttonClickListener != null) {
            placeholderViewButton.setOnClickListener(buttonClickListener)
        }
    }
}
