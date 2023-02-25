// Return the set of products that were ordered by all customers
fun Shop.getProductsOrderedByAll(): Set<Product> = customers.flatMap { customer: Customer -> customer.getOrderedProducts() }.toSet()

fun Customer.getOrderedProducts(): Set<Product> =
    orders.flatMap(Order::products).toSet()