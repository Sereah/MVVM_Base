package com.lunacattus.my_base.bind

import android.widget.TextView
import androidx.databinding.BindingAdapter
import io.noties.markwon.Markwon

@BindingAdapter("setMarkdownText")
fun setMarkdownText(textView: TextView, markDownText: String) {
    val markwon = Markwon.create(textView.context)
    markwon.setMarkdown(textView, markDownText)
}
