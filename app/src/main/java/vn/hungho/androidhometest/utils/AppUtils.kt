package vn.hungho.androidhometest.utils

import java.math.BigDecimal
import java.text.NumberFormat
import java.util.*

object AppUtils {
    fun formatNumberToText(num: BigDecimal): String {
        try {
            val formatter = NumberFormat.getInstance(Locale.JAPAN)
            var txt = formatter.format(num)
            txt = txt.replace(",", ".")
            return txt
        } catch (e: Exception) {
            return num.toString()
        }

    }
}