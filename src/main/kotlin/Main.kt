fun main() {
    val mastercardAndMaestroPayLimit = 75000
    val mastercardAndMaestroPercent = 0.6
    val mastercardAndMaestroTax = 20

    val visaAndMIRPercent = 0.75
    val visaAndMIRMinCommission = 35

    val bankCardsStopLimitAtMonth = 600_000
    val vkPayStopLimitAtMonth = 40_000
//Варианты: "Mastercard" "Maestro" "Visa" "MIR" "VkPay"
    val cardType = "VkPay"
    val sentAtThisMonth = 20_000
    val amountToSend = 100000

    if (limitChecker(
            cardType,
            sentAtThisMonth,
            bankCardsStopLimitAtMonth,
            vkPayStopLimitAtMonth,
            amountToSend
        )
    ) {
        transferOperation(
            cardType,
            sentAtThisMonth,
            amountToSend,
            mastercardAndMaestroPayLimit,
            mastercardAndMaestroPercent,
            mastercardAndMaestroTax,
            visaAndMIRPercent,
            visaAndMIRMinCommission
        )
    } else println(
        "Операция невозможна. Вы уже превысили лимит переводов или ваш текущий перевод превышает его."
    )
    println("Уменьшите сумму перевода или дождитесь окончания текущего месяца.")


}

fun transferOperation(
    cardType: String,
    sentAtThisMonth: Int,
    amountToSend: Int,
    mastercardAndMaestroPayLimit: Int,
    mastercardAndMaestroPercent: Double,
    mastercardAndMaestroTax: Int,
    visaAndMIRPercent: Double,
    visaAndMIRMinCommission: Int
) = if (cardType == "VkPay") {
    println("Платёж успешно выполнен! Комиссия отсутсвует, cпасибо что пользуетесь VkPay!")
} else if (cardType == "Visa" || cardType == "MIR") {
    println(
        "Платёж успешно выполнен! Ваша комиссия составила ${
            commissionCalculator(
                cardType,
                amountToSend,
                mastercardAndMaestroPercent,
                mastercardAndMaestroTax,
                visaAndMIRPercent,
                visaAndMIRMinCommission
            )
        } р."
    )
} else {
    if (amountToSend + sentAtThisMonth > mastercardAndMaestroPayLimit) {
        println(
            "Платёж успешно выполнен! Ваша комиссия составила ${
                commissionCalculator(
                    cardType,
                    amountToSend,
                    mastercardAndMaestroPercent,
                    mastercardAndMaestroTax,
                    visaAndMIRPercent,
                    visaAndMIRMinCommission
                )
            } р."
        )
    } else println("Платёж успешно выполнен!Комиссия отсутсвует!")
}

fun limitChecker(
    cardType: String,
    sentAtThisMonth: Int,
    bankCardsStopLimitAtMonth: Int,
    vkPayStopLimitAtMonth: Int,
    amountToSend: Int
): Boolean {
    if (cardType == "VkPay") {
        when (amountToSend + sentAtThisMonth > vkPayStopLimitAtMonth) {
            true -> return false
            false -> return true
        }
    } else if (amountToSend + sentAtThisMonth > bankCardsStopLimitAtMonth) {
        return false
    }
    return true
}

fun commissionCalculator(
    cardType: String,
    amountToSend: Int,
    mastercardAndMaestroPercent: Double,
    mastercardAndMaestroTax: Int,
    visaAndMIRPercent: Double,
    visaAndMIRMinCommission: Int
): Int {
    if (cardType == "Visa" || cardType == "MIR") {
        when (((amountToSend / 100) * visaAndMIRPercent > visaAndMIRMinCommission)) {
            true -> return ((amountToSend / 100) * visaAndMIRPercent).toInt()
            false -> return visaAndMIRMinCommission
        }
    } else {
        return (((amountToSend / 100) * mastercardAndMaestroPercent) + mastercardAndMaestroTax).toInt()

    }
}