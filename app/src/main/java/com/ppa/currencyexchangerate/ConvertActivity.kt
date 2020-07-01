package com.ppa.currencyexchangerate

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_convert.*
import java.math.BigDecimal
import java.math.RoundingMode
import java.text.NumberFormat
import java.util.*

class ConvertActivity : AppCompatActivity() {

    companion object {
        private const val Max_Length = 15
    }

    private enum class Exchange {
        OTHER, MM
    }

    private var exchangeRate = ""
    private var rate: BigDecimal? = null
    private var tempString = ""
    private var exchange = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_convert)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val appBar = intent.getStringExtra("app_bar")
        this.title = appBar

        convert_Currency_Short.text = intent.getStringExtra("Currency")
        val flagImage = intent.getIntExtra("Flag", R.drawable.ic_myanmar)
        findViewById<ImageView>(R.id.convert_Flag).apply {
            setImageResource(flagImage)
        }
        exchangeRate = intent.getStringExtra("Rate")!!
        setDefaultConverter()
        layout_1.setOnClickListener { switchOtherToMM() }
        layout_2.setOnClickListener { switchMmToOther() }
        btn_del.setOnLongClickListener {
            setDefaultConverter()
            true
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    private fun setDefaultConverter() {
        tempString = ""
        rate = BigDecimal(exchangeRate.replace(",", ""))
        switchOtherToMM()
        convert_MM_Rate.text = NumberFormat.getNumberInstance(Locale.US)
            .format(
                rate!!.multiply(
                    BigDecimal(
                        convert_Other_Rate.text.toString().replace(",", "")
                    )
                ).setScale(5, RoundingMode.CEILING)
            )
    }

    private fun resetConverter() {
        convert_Other_Rate.text = "1.0"
        convert_MM_Rate.text = exchangeRate
        switchOtherToMM()
    }

    private fun switchOtherToMM() {
        convert_Other_Rate.setTextColor(Color.parseColor("#736AFF"))
        convert_MM_Rate.setTextColor(Color.parseColor("#000000"))
        tempString = ""
        exchange = Exchange.OTHER.toString()
    }

    private fun switchMmToOther() {
        this.convert_MM_Rate.setTextColor(Color.parseColor("#736AFF"))
        convert_Other_Rate.setTextColor(Color.parseColor("#000000"))
        tempString = ""
        exchange = Exchange.MM.toString()
    }

    private fun changeText(str: String) {
        when (exchange) {
            Exchange.MM.toString() -> {
                convert_MM_Rate.text = str
                if (str.isNotEmpty())
                    convert_Other_Rate.text = NumberFormat.getNumberInstance(Locale.US).format(
                        BigDecimal(convert_MM_Rate.text.toString()).divide(
                            rate,
                            5,
                            RoundingMode.CEILING
                        )
                    )
            }
            Exchange.OTHER.toString() -> {
                convert_Other_Rate.text = str
                if (str.isNotEmpty())
                    convert_MM_Rate.text = NumberFormat.getNumberInstance(Locale.US).format(
                        rate!!.multiply(
                            BigDecimal(convert_Other_Rate.text.toString().replace(",", ""))
                        ).setScale(5, RoundingMode.CEILING)
                    )
            }
        }
    }

    fun onClickZero(view: View?) {
        if (tempString.startsWith("0") && tempString.length == 1) {
            changeText(tempString.substring(1) + "0".also {
                tempString = it
            })
        } else if (tempString.length <= Max_Length) changeText("0".let { tempString += it; tempString })
    }

    fun onClickOne(view: View?) {
        if (tempString.startsWith("0") && tempString.length == 1) {
            changeText(tempString.substring(1) + "1".also {
                tempString = it
            })
        } else if (tempString.length <= Max_Length) changeText("1".let { tempString += it; tempString })
    }

    fun onClickTwo(view: View?) {
        if (tempString.startsWith("0") && tempString.length == 1) {
            changeText(tempString.substring(1) + "2".also {
                tempString = it
            })
        } else if (tempString.length <= Max_Length) changeText("2".let { tempString += it; tempString })
    }

    fun onClickThree(view: View?) {
        if (tempString.startsWith("0") && tempString.length == 1) {
            changeText(tempString.substring(1) + "3".also {
                tempString = it
            })
        } else if (tempString.length <= Max_Length) changeText("3".let { tempString += it; tempString })
    }

    fun onClickFour(view: View?) {
        if (tempString.startsWith("0") && tempString.length == 1) {
            changeText(tempString.substring(1) + "4".also {
                tempString = it
            })
        } else if (tempString.length <= Max_Length) changeText("4".let { tempString += it; tempString })
    }

    fun onClickFive(view: View?) {
        if (tempString.startsWith("0") && tempString.length == 1) {
            changeText(tempString.substring(1) + "5".also {
                tempString = it
            })
        } else if (tempString.length <= Max_Length) changeText("5".let { tempString += it; tempString })
    }

    fun onClickSix(view: View?) {
        if (tempString.startsWith("0") && tempString.length == 1) {
            changeText(tempString.substring(1) + "6".also {
                tempString = it
            })
        } else if (tempString.length <= Max_Length) changeText("6".let { tempString += it; tempString })
    }

    fun onClickSeven(view: View?) {
        if (tempString.startsWith("0") && tempString.length == 1) {
            changeText(tempString.substring(1) + "7".also {
                tempString = it
            })
        } else if (tempString.length <= Max_Length) changeText("7".let { tempString += it; tempString })
    }

    fun onClickEight(view: View?) {
        if (tempString.startsWith("0") && tempString.length == 1) {
            changeText(tempString.substring(1) + "8".also {
                tempString = it
            })
        } else if (tempString.length <= Max_Length) changeText("8".let { tempString += it; tempString })
    }

    fun onClickNine(view: View?) {
        if (tempString.startsWith("0") && tempString.length == 1) {
            changeText(tempString.substring(1) + "9".also {
                tempString = it
            })
        } else if (tempString.length <= Max_Length) changeText("9".let { tempString += it; tempString })
    }

    fun onClickDecimal(view: View?) {
        if (!tempString.contains(".")) {
            if (tempString.isEmpty()) {
                changeText("0.".also { tempString = it })
            } else if (tempString.length <= Max_Length) {
                changeText(".".let { tempString += it; tempString })
            }
        }
        if (tempString.startsWith(".") || tempString.isEmpty()) {
            changeText("0. ".also { tempString = it })
        }
    }

    fun onClickDelete(view: View?) {
        if (tempString.isNotEmpty()) {
            changeText(tempString.substring(0, tempString.length - 1)
                .also { tempString = it })
        }
        if (tempString.isEmpty()) {
            resetConverter()
        }
    }
}
