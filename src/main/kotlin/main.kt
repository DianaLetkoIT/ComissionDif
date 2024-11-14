fun main() {
    val typeOfCard = "Мир"
    val previousTransfersMonth = 0
    val transfer = 150_000

    val commission = calculateCommission(transfer, typeOfCard, previousTransfersMonth)

    println(commission)
}

fun calculateCommission(transfer: Int, typeOfCard: String, previousTransfersMonth: Int) {
    var checkLimitMonth = false
    if (previousTransfersMonth <= 600_000) {
        checkLimitMonth = true
    }

    var checkLimitDay = false
    if (transfer <= 150_000) {
        checkLimitDay = true
    }

    if (checkLimitMonth && checkLimitDay) {
        var finalTransfer = 0
        if (transfer + previousTransfersMonth >= 600_000) {
            finalTransfer = 600_000 - previousTransfersMonth
        } else {
            finalTransfer = transfer
        }
        val commission = when (typeOfCard) {
            "Mastercard" -> {
                if (previousTransfersMonth > 75000) {
                    finalTransfer * 0.006 + 20
                } else if (previousTransfersMonth + finalTransfer > 75_000) (previousTransfersMonth + finalTransfer - 75_000) * 0.006 + 20
                else 0
            }

            "Visa" -> if (finalTransfer * 0.0075 > 35) finalTransfer * 0.0075 else 35
            "Мир" -> 0
            else -> false

        }
        println("Клмиссия составит $commission рублей")
    } else {
        println("Превышен один из лимитов")
    }
}




