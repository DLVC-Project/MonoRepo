// Build a map from the customer name to the customer
fun Shop.nameToCustomerMap(): Map<String, Customer> =
        customers.associateBy { customer: Customer -> customer.name }

// Build a map from the customer to their city
fun Shop.customerToCityMap(): Map<Customer, City> =
        customers.associateWith { it.city }

// Build a map from the customer name to their city
fun Shop.customerNameToCityMap(): Map<String, City> =
        customers.associate { Pair(it.name, it.city) }