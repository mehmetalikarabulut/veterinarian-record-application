#veterinarian-record-application

This repo includes veterinarian record application.
 
This application contains the following restrictions:
 
  +	Animal presentation can be made. (species, genus, name, age, definition)

  +	Pet owner presentation can be made. (name, surname, contact information, phone, e-mail)

  +	The animal can be searched by name or the owner's name.

  +	For one animal owner, n animal definitions can be made.

  +	Changes can be made to an existing record.

  +	Existing records can be examined.

  +	An existing record can be deleted.
  

You can run the application by following the instructions below:

  +	MySQL was used when writing the application. The necessary setup for the database should be done at https://www.apachefriends.org/tr/
  
  +	After making sure that the following settings are in the "application.properties" file you can run the application on port 8090 using Postman.
  
`server.port=8090`

`spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver`

`spring.datasource.url=jdbc:mysql://localhost/veterinarian`

`spring.datasource.username=root`

`spring.datasource.password=`

`spring.jpa.hibernate.ddl-auto=update`

`spring.jpa.show-sql=true`
  
  +	Necessary information about Postman is given in the images below.
  
Database tables are given below.
  
Pet owner table:
  
![petOwnerDatabase](https://user-images.githubusercontent.com/82678940/187179923-431dc0a3-356d-4e48-b2fa-2e4ca08aaf76.png)
  
Animal table:
  
![animalDatabase](https://user-images.githubusercontent.com/82678940/187180017-0dfa9e36-231c-45ac-a86a-c960398094be.png)
  
Postman outputs are given below.
  
Output of save owner method:
  
![ownerName](https://user-images.githubusercontent.com/82678940/187180144-3e340de7-4776-4dcd-bba6-45f29727c643.png)
  
Output of update owner method:
  
![petOwnerUpdate](https://user-images.githubusercontent.com/82678940/187180255-157a2e30-21a8-4a21-bfda-ca1c15215ecf.png)
  
Output of list owner method:
  
![petOwnerList](https://user-images.githubusercontent.com/82678940/187180365-24562ee4-5d4f-4050-8978-c07a3ba14655.png)
  
Output of search owner method:
  
![petOwnerSingle](https://user-images.githubusercontent.com/82678940/187180456-973c7963-20e6-48e3-ae4a-65b9cf8b4f39.png)
  
Output of delete owner method:
  
![petOwnerDelete](https://user-images.githubusercontent.com/82678940/187180573-b4c6889a-2b40-4915-bd2b-373329e78ad6.png)

Output of animal save method:

![animalSave](https://user-images.githubusercontent.com/82678940/187180865-cf42481f-4e80-44ba-b866-ccef6ca79175.png)

Output of animal update method:

![animalUpdate](https://user-images.githubusercontent.com/82678940/187180923-51855951-6bce-4dd8-98dd-0e0bf46746d8.png)

Output of animal list method:

![animalList](https://user-images.githubusercontent.com/82678940/187180989-d6876870-75ec-4459-82ba-4204c89437d6.png)

Output of search animal method:

![animalSingle](https://user-images.githubusercontent.com/82678940/187181127-d717a6e6-54da-4b3c-8f50-6b44c33e7712.png)

Output of search by animal name or owner name method:

![animalSearch](https://user-images.githubusercontent.com/82678940/187181225-d213087e-ae1b-4a81-8030-b7dc3d848818.png)

Output of animal delete method:

![animalDelete](https://user-images.githubusercontent.com/82678940/187181286-0e993b80-7e8e-4bc9-b1fc-88891c100fe5.png)
