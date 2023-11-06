package edu.temple.basicbrowser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.EditText
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {

    lateinit var urlEditText: EditText
    lateinit var goButton: ImageButton
    lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        urlEditText = findViewById(R.id.urlEditText)
        goButton = findViewById(R.id.goButton)
        webView = findViewById(R.id.webView)

        webView.webViewClient = object: WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
            }
        }

        goButton.setOnClickListener {
            val enteredUrl: String = urlEditText.text.toString()

            // Check if the URL contains a valid protocol (e.g., "http://" or "https://")
            val urlWithProtocol = if (enteredUrl.startsWith("http://") || enteredUrl.startsWith("https://")) {
                enteredUrl
            } else {
                "https://$enteredUrl"
            }

            // Load the URL in the WebView
            webView.loadUrl(urlWithProtocol)
        }
    }
}