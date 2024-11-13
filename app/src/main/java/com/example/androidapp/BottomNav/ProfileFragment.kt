package com.example.androidapp.BottomNav

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.*
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.example.androidapp.R

class ProfileFragment : Fragment() {

    private lateinit var webView: WebView
    private var filePathCallback: ValueCallback<Array<Uri>>? = null
    private lateinit var filePickerLauncher: ActivityResultLauncher<Intent>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_cure, container, false)

        webView = view.findViewById(R.id.webview)

        // Configure the WebView
        setupWebView()

        // Register the file picker callback
        filePickerLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (filePathCallback == null) return@registerForActivityResult
            val uriResult = if (result.resultCode == Activity.RESULT_OK) {
                result.data?.data?.let { arrayOf(it) }
            } else null
            filePathCallback?.onReceiveValue(uriResult)
            filePathCallback = null
        }

        // Load the Streamlit chatbot URL
        webView.loadUrl("https://ayuvisionapp.streamlit.app/")
        return view
    }

    private fun setupWebView() {
        webView.settings.apply {
            javaScriptEnabled = true
            domStorageEnabled = true
            allowFileAccess = true
            allowContentAccess = true
        }

        // WebViewClient to handle navigation within the WebView
        webView.webViewClient = WebViewClient()

        // WebChromeClient to handle file input
        webView.webChromeClient = object : WebChromeClient() {
            override fun onShowFileChooser(
                webView: WebView?,
                filePathCallback: ValueCallback<Array<Uri>>?,
                fileChooserParams: FileChooserParams?
            ): Boolean {
                this@ProfileFragment.filePathCallback = filePathCallback
                val intent = fileChooserParams?.createIntent()
                try {
                    if (intent != null) {
                        filePickerLauncher.launch(intent)
                    }
                } catch (e: Exception) {
                    this@ProfileFragment.filePathCallback = null
                    return false
                }
                return true
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        filePathCallback = null
    }
}
