class DateRange(val start: MyDate, val end: MyDate) : Iterable<MyDate> {
    override fun iterator(): Iterator<MyDate> {
        return object : Iterator<MyDate> {
            val end = this@DateRange.end
            var current: MyDate = this@DateRange.start

            override fun hasNext(): Boolean {
                return current <= end
            }

            override fun next(): MyDate {
                if (!hasNext()) throw kotlin.NoSuchElementException()
                else {
                    val result = current
                    current = current.followingDate()
                    return result
                }
            }
        }
    }
}

fun iterateOverDateRange(firstDate: MyDate, secondDate: MyDate, handler: (MyDate) -> Unit) {
    for (date in firstDate..secondDate) {
        handler(date)
    }
}