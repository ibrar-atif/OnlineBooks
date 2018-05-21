clone git project

1. run com.book.BookStarter class as java application



H2 in memory db is used and at load time three articles are loaded that you can find in BookConfig class.

Exceptioncontroller is to handle response in case of exception.



Api

1. Get All article
method:get
http://localhost:8080/book/getAll


2. 	Get Article by id
	method:get
	http://localhost:8080/book/get/<id>

	Example :   http://localhost:8080/book/get/1


3. 	Add arctile
	method:post
	http://localhost:8080/book/add
	input json
 	note: date should be in dd-mm-yyyy format
	 {"header": " This is header",
    
	"shortDescription": "short description",
    
	"text": "long description",
    
	"authors": "Author c",
    
	"publishedDate": "01-05-2018"
  }

4.   	Update Article
	method:put
	http://localhost:8080/book/update
	input json:
	note: date should be in dd-mm-yyyy format

	 {"articleId": 2,
	"header": " This is header",
    
	"shortDescription": "short description",
    
	"text": "long description",
    
	"authors": "Author c",
    
	"publishedDate": "01-05-2018"
  }


5.	Search article with keyword
	http://localhost:8080/book/search/<keyword>
	http://localhost:8080/book/search/Terminology



6.      search article between dates
	method get
	http://localhost:8080/book/searchDates/<startdate>/<enddate>
	http://localhost:8080/book/searchDates/01-05-2018/22-05-2018


7.	Search by Author
	method: get
	http://localhost:8080/book/searchByAuthor/<author name>
	http://localhost:8080/book/searchByAuthor/Author a

8.  	Delte Artclie
	method:delete
	http://localhost:8080/book/delete/<id>
	http://localhost:8080/book/delete/1


	

I have kept all the relation in one table only, author can be segregated in different table with many to many maping, but for quick demo purpos i kept in single table.
