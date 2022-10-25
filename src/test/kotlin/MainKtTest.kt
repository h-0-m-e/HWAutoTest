import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun commissionCalculator_VisaOverstepsMinCommission() {
        val cardType = "Visa"
        val amountToSend = 10_000
        val mastercardAndMaestroPercent = 0.6
        val mastercardAndMaestroTax = 20
        val visaAndMIRPercent = 0.75
        val visaAndMIRMinCommission = 35

        val result = commissionCalculator(
            cardType,
            amountToSend,
            mastercardAndMaestroPercent,
            mastercardAndMaestroTax,
            visaAndMIRPercent,
            visaAndMIRMinCommission)

        assertEquals(75, result)
    }

    @Test
    fun commissionCalculator_MIROverstepsMinCommission() {
        val cardType = "MIR"
        val amountToSend = 10_000
        val mastercardAndMaestroPercent = 0.6
        val mastercardAndMaestroTax = 20
        val visaAndMIRPercent = 0.75
        val visaAndMIRMinCommission = 35

        val result = commissionCalculator(
            cardType,
            amountToSend,
            mastercardAndMaestroPercent,
            mastercardAndMaestroTax,
            visaAndMIRPercent,
            visaAndMIRMinCommission)

        assertEquals(75, result)
    }

    @Test
    fun commissionCalculator_VisaNotOverstepsMinCommission() {
        val cardType = "Visa"
        val amountToSend = 2_000
        val mastercardAndMaestroPercent = 0.6
        val mastercardAndMaestroTax = 20
        val visaAndMIRPercent = 0.75
        val visaAndMIRMinCommission = 35

        val result = commissionCalculator(
            cardType,
            amountToSend,
            mastercardAndMaestroPercent,
            mastercardAndMaestroTax,
            visaAndMIRPercent,
            visaAndMIRMinCommission)

        assertEquals(35, result)
    }

    @Test
    fun commissionCalculator_MIRNotOverstepsMinCommission() {
        val cardType = "MIR"
        val amountToSend = 2_000
        val mastercardAndMaestroPercent = 0.6
        val mastercardAndMaestroTax = 20
        val visaAndMIRPercent = 0.75
        val visaAndMIRMinCommission = 35

        val result = commissionCalculator(
            cardType,
            amountToSend,
            mastercardAndMaestroPercent,
            mastercardAndMaestroTax,
            visaAndMIRPercent,
            visaAndMIRMinCommission)

        assertEquals(35, result)
    }

    @Test
    fun commissionCalculator_MastercardAndMaestoCommission() {
        val cardType = "Mastercard"
        val amountToSend = 1_000
        val mastercardAndMaestroPercent = 0.6
        val mastercardAndMaestroTax = 20
        val visaAndMIRPercent = 0.75
        val visaAndMIRMinCommission = 35

        val result = commissionCalculator(
            cardType,
            amountToSend,
            mastercardAndMaestroPercent,
            mastercardAndMaestroTax,
            visaAndMIRPercent,
            visaAndMIRMinCommission)

        assertEquals(26, result)
    }
}