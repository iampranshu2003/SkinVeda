package com.example.androidapp.BottomNav

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.example.androidapp.R

class CureFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_cure, container, false)

        // Find the WebView by its ID and configure it
        val webView: WebView = view.findViewById(R.id.webview)
        webView.settings.javaScriptEnabled = true // Enable JavaScript for the WebView
        webView.settings.domStorageEnabled = true // Enable DOM storage for the WebView
        webView.webViewClient = WebViewClient() // Open links within the WebView

        // Load the Streamlit chatbot URL
        webView.loadUrl("https://ayuchatbot.streamlit.app/")

        return view
    }
}
