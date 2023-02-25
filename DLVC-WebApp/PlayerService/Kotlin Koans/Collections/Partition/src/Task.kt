// Return customers who have more undelivered orders than delivered
fun Shop.getCustomersWithMoreUndeliveredOrders(): Set<Customer> =
    customers.filter { customer ->
        val (delivered, undelivered) = customer.orders.partition { it.isDelivered }
        delivered.size < undelivered.size
    }.toSet()
