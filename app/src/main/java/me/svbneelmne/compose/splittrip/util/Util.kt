package me.svbneelmne.compose.splittrip.util

/**
 * Function that calculates the tip on Total Amount
 * Based on the % given as input
 * @param totalBill Total Bill Amount
 * @param tipPercent %
 * @return totalTip
 */
fun calculateTotalTip(totalBill: Double, tipPercent: Int): Double {
    return if (
        totalBill > 1 && totalBill.toString().isNotEmpty()
    ) {
        (totalBill * tipPercent) / (100).toDouble()
    } else {
        0.0
    }
}

/**
 * Function that calculates the total split per person including tip amount
 * @param totalBill Total Bill Amount
 * @param splitBy No. of people to split
 * @param tipPercent %
 * @return totalPerPerson
 */
fun calculateTotalPerPerson(
    totalBill: Double,
    splitBy: Int,
    tipPercent: Int
): Double {
    val bill = calculateTotalTip(totalBill, tipPercent) + totalBill
    return (bill / splitBy)
}