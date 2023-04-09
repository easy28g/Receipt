# **Receipt**

   This is an API for calculating a purchase receipt
based on a JSON shopping cart file. The API provides 
the ability to calculate the total purchase amount, 
the amount of taxes and discounts, as well as 
the total amount to be paid.

#### Using

1. Call the receipt calculation API by passing
the bucket file as input.

2. Get a receipt in JSON format containing the total amount
of the purchase, the amount of taxes and discounts, 
as well as the total amount to be paid.

#### Shopping Cart Features

##### Feature 1: Calculation of the total purchase amount

The API calculates the total purchase amount based 
on the prices specified in the JSON bucket file. 
The result is the total purchase amount.

##### Feature 2: calculation of the amount of taxes

The API calculates the amount of taxes based on 
the tax rate specified in the API code and the interim 
purchase amount. The result is the amount of taxes and 
the interim purchase amount.

##### Feature 3: Processing of taxable and non-taxable goods

The API calculates the tax only for products for which 
the value "isTaxable" is true in the JSON bucket file. 
For products for which this value is false, the tax is 
not calculated. The result is the interim purchase amount, 
the taxable interim amount, and the amount of taxes.

##### Feature 4: Discount accounting

The API takes into account discounts applied to items 
in the cart. Discounts specified in the JSON coupon file 
are automatically applied to the products for which they 
are valid. The price of the product after applying 
the discount cannot be negative. The result is the interim 
purchase amount before and after the application of discounts,
the total amount of discounts, the taxable interim amount
after the application of discounts, the amount of taxes and 
the total amount to be paid.

#### To run the solution, follow these steps:

1. Download and install JDK 11. You can view 
dependencies and their versions in pom.xml
2. Create a database to store application data. 
See the settings for connecting to the database 
in the application.properties file.
3. Run the application and follow the link 
http://localhost:8080/swagger-ui.html#/ to view the api.
