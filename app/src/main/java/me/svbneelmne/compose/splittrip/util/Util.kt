package me.svbneelmne.compose.splittrip.util

fun calculateTotalTip(totalBill: Double, tipPercent: Int): Double {
    return if (
        totalBill > 1 && totalBill.toString().isNotEmpty()
    ) {
        (totalBill * tipPercent) / (100).toDouble()
    } else {
        0.0
    }
}

fun calculateTotalPerPerson(
    totalBill: Double,
    splitBy: Int,
    tipPercent: Int
): Double {
    val bill = calculateTotalTip(totalBill, tipPercent) + totalBill
    return (bill / splitBy)
}