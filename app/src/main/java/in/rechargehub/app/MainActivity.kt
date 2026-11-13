package in.rechargehub.app

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.view.ViewGroup
import android.widget.*

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val navy = Color.rgb(16,42,67)
        val mint = Color.rgb(184,242,230)
        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(28, 34, 28, 24)
            setBackgroundColor(Color.rgb(243,247,249))
        }
        val title = TextView(this).apply {
            text = "RECHARGE HUB"
            textSize = 25f; setTextColor(navy); gravity = Gravity.CENTER
            setTypeface(null, android.graphics.Typeface.BOLD)
        }
        root.addView(title, LinearLayout.LayoutParams(-1, 64))
        val banner = TextView(this).apply {
            text = "INDIA • RECHARGE PLATFORM\n\nYour recharge business starts here."
            textSize = 19f; setTextColor(Color.WHITE); setPadding(22,24,22,24)
            setBackgroundColor(navy)
        }
        root.addView(banner, LinearLayout.LayoutParams(-1, 150))
        val warning = TextView(this).apply {
            text = "DEMO MODE — No real money is collected and no actual recharge is performed."
            textSize = 13f; setTextColor(navy); setPadding(12,18,12,18)
        }
        root.addView(warning)
        val operator = Spinner(this)
        val ops = listOf("Choose operator", "Jio", "Airtel", "Vi", "BSNL")
        operator.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, ops)
        root.addView(operator, LinearLayout.LayoutParams(-1, 52))
        val number = EditText(this).apply { hint = "10-digit mobile number"; inputType = 2 }
        root.addView(number, LinearLayout.LayoutParams(-1, 58))
        val amount = EditText(this).apply { hint = "Recharge amount (₹)"; inputType = 2 }
        root.addView(amount, LinearLayout.LayoutParams(-1, 58))
        val result = TextView(this).apply { textSize = 13f; setTextColor(navy); setPadding(4,18,4,18) }
        val button = Button(this).apply {
            text = "CREATE DEMO REQUEST"
            setTextColor(Color.WHITE); setBackgroundColor(navy)
            setOnClickListener {
                val phone = number.text.toString()
                val value = amount.text.toString().toIntOrNull()
                if (operator.selectedItemPosition == 0 || !phone.matches(Regex("[6-9][0-9]{9}")) || value == null || value !in 10..10000) {
                    result.text = "Please enter a valid operator, 10-digit mobile number and amount ₹10–₹10,000."
                } else {
                    result.text = "Demo request created. No recharge was made.\nReference: RH-DEMO-" + System.currentTimeMillis().toString().takeLast(8)
                }
            }
        }
        root.addView(button, LinearLayout.LayoutParams(-1, 58))
        root.addView(result)
        val spacer = Space(this)
        root.addView(spacer, LinearLayout.LayoutParams(1, 0, 1f))
        val footer = TextView(this).apply {
            text = "RECHARGE HUB • Sandbox starter v1.0"
            textSize = 11f; setTextColor(Color.GRAY); gravity = Gravity.CENTER
        }
        root.addView(footer)
        setContentView(ScrollView(this).apply { addView(root) })
    }
}
