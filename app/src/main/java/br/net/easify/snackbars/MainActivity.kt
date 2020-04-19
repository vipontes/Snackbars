package br.net.easify.snackbars

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

/**
 * @author Vinicius Pontes
 *
 * https://developer.android.com/reference/com/google/android/material/snackbar/Snackbar
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        simpleMessageButton.setOnClickListener {
            Snackbar.make(rootLayout, R.string.simple_message, Snackbar.LENGTH_LONG)
                    .show()
        }

        actionButton.setOnClickListener {
            val snackbar = Snackbar
                    .make(rootLayout, R.string.action_message, Snackbar.LENGTH_LONG)
                    .setAction(R.string.undo) {
                        Snackbar.make(rootLayout, R.string.message_restored, Snackbar.LENGTH_SHORT)
                                .show()
                    }
            snackbar.show()
        }

        customButton.setOnClickListener {
            val snackbar: Snackbar = Snackbar
                    .make(rootLayout, R.string.custom_message, Snackbar.LENGTH_LONG)
                    .setAction(R.string.undo) {
                        Snackbar.make(rootLayout, R.string.message_restored, Snackbar.LENGTH_SHORT)
                                .show()
                    }
            snackbar.setActionTextColor(Color.RED)
            val snackbarView: View = snackbar.view
            snackbarView.findViewById<TextView>(com.google.android.material.R.id.snackbar_text)
                    .setTextColor(Color.YELLOW)
            snackbar.show()
        }
    }
}
