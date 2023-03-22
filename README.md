# Product-Management-API
I build a Product Management API in java which is used to perform various CRUD opreataions using Spring Boot for which i used STS (Spring Tool Suite) veresion 4.6.2 and for run this API, I used Apache Tomcat version 9.0.
And I use MYSQL as the database for this API.

In this API there is three Entity classes, the main Entity class name is "product".
The other two Entity classes name is "brand" and "color" which are used as the instance variable in the Product Entity class.
We use "brand" and "color" Entity classes in the Product class by mapping them in "product" class using many to one mapping.

We can perform various CRUD operations Using this API.

### All url's are mentioned below for performing the opreation using api

===========================================================================
**For Performing Operations in Product Class :-**                                                                                                                                
x------------------------------------------------------------------x                                                                                                                                                               
                                                                                                                                                                                                                                                           
Add Product --- http://localhost:8080/product/add                                                                                                                                                                   
Show Products List --- http://localhost:8080/product/list                                                                                                                                                        
Delete Product by ID --- http://localhost:8080/product/deletebyid/pid=1                                                                                                                             
Delete Product by Name --- http://localhost:8080/product/deletebyname/name=laptop                                                                                                
Delete All Products --- http://localhost:8080/product/deleteall                                                                                                                                               
Update Product by ID --- http://localhost:8080/product/updateproductbyid/1                                                                                                                                      
                                                                                                                                                                        
Search Product by ID --- http://localhost:8080/product/search/byid/pid=1                                                                                                                                                                        
Search Product by Name ---  http://localhost:8080/product/search/byname/name=laptop                                                                                                                                                                    
Search Product by Prize ---  http://localhost:8080/product/search/byprize/10000                                                                                                                                                                   
Search Product by Name and Prize ---  http://localhost:8080/product/search/bynameandprize/laptop/10000                                                                                                                                                                   
Search Product by Prize Between --- http://localhost:8080/product/search/byprizebetween/10000/20000                                                                                                                                                                   
Search Product by Prize Less Than ---  http://localhost:8080/product/search/prizebelow/10000                                                                                                                                                                   
Search Product by Prize Less Than and Equal to ---  http://localhost:8080/product/search/10000                                                                                                                                                                   
Search Product by Prize Above ---  http://localhost:8080/product/search/prizeabove/10000                                                                                                                                                                   
Search Product by Prize Above and Equal to ---  http://localhost:8080/product/search/10000                                                                                                                                                                   
Search Product in Ascending Order of Prize ---  http://localhost:8080/product/search/prizeinascendingorder         
Search Product in Descending Order of Prize ---  http://localhost:8080/product/search/prizeindescendingorder                                                                                                                                                                   
Search Product in Ascending Order of Product name ---  http://localhost:8080/product/search/productnameinascendingorder                                                                                                                                                                   
Search Product in Descending Order of Product Name ---  http://localhost:8080/product/search/productnameindescendingorder                                                                                                                                                                   
Search Product by Name in Prize Ascending Order ---  http://localhost:8080/product/search/productdetailsbynameinprizeascendingorder/laptop                                                                                                                                                                   
Search Product by Name in Prize Descending Order ---  http://localhost:8080/product/search/productdetailsbynameinprizedescendingorder/laptop                                                                                                                                                                   
Search Product by Name Starting wih ---  http://localhost:8080/product/search/productdetailsbynamestartingwith/{String prefix}                                                                                                                                                                   
Search Product by Name Ending with ---  http://localhost:8080/product/search/productdetailsbynameendwith/{String suffix}                                                                                                                                                                   
Search Product by Name Containing --- http://localhost:8080/product/search/productdetailsbynamecontaining/{String infix}

===========================================================================
**For Performing Operations in Brand Class :-**                                                                                                                                                                   
x----------------------------------------------------------------x

Add Brand  --- http://localhost:8080/brand/add                                                                                                                                                                   
Show Brand List --- http://localhost:8080/brand/list                                                                                                                                                                   
Search Brand by ID --- http://localhost:8080/brand/search/byid/bid=1                                                                                                                                                                   
Search Brand by Name --- http://localhost:8080/brand/search/byname/brandname=apple                                                                                                                                                                   
Search Product by Brand ID --- http://localhost:8080/brand/search/productbybrandid/1                                                                                                                                                                   
Search Product by Brand Name --- http://localhost:8080/brand/search/productbybrandname/apple                                                                                                                                                                   
Delete Product by Brand ID --- http://localhost:8080/brand/deleteproductbybrandid/1                                                                                                                                                                   
Delete All Brands --- http://localhost:8080/brand/deleteall                                                                                                                                                                   
Update Brand by ID --- http://localhost:8080/brand/updatebrandbyid/1

===========================================================================
**For Performing Operations in Color Class :-**                                                                                                                                                                   
x------------------------------------------------------------------x

Add Color --- http://localhost:8080/color/add                                                                                                                                                                   
Show Color List --- http://localhost:8080/color/list                                                                                                                                                                   
Search Color by ID --- http://localhost:8080/color/search/byid/cid=1                                                                                                                                                                   
Search Color by Name --- http://localhost:8080/color/search/byname/color=blue;                                                                                                                                                                   
Search Product by Color ID --- http://localhost:8080/color/search/productbycolorid/1;                                                                                                                                                                   
Search Product by Color Name --- http://localhost:8080/color/search/productbycolor/blue;                                                                                                                                                                   
Delete All Colors --- http://localhost:8080/color/deleteall                                                                                                                                                                   
Update Color by ID --- http://localhost:8080/color/updatecolorbyid/1


===========================================================================


















