package com.book.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.book.config.BookConfig;
import com.book.exception.ApplicationException;
import com.book.service.IBookService;
import com.book.view.BookDetailVO;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 
 * @author ibrara
 *
 */
@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private IBookService bookService;

	@RequestMapping("/getAll")
	public ResponseEntity<List<BookDetailVO>> getAllArticle()throws ApplicationException{
		return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
	}
	
	@RequestMapping("/get/{id}")
	public ResponseEntity<BookDetailVO> getArticle(@PathVariable("id") Integer articleId)throws ApplicationException{
		BookDetailVO article = bookService.getArticle(articleId);
		return new ResponseEntity<>(article, HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public ResponseEntity<BookDetailVO> addArticle(@RequestBody BookDetailVO article)throws ApplicationException{
		BookDetailVO updatedArticle = bookService.addArticle(article);
		return new ResponseEntity<>(updatedArticle, HttpStatus.OK);
	}
	
	@RequestMapping(value= "/update",method=RequestMethod.PUT)
	public ResponseEntity<BookDetailVO> updateArticle(@RequestBody BookDetailVO article)throws ApplicationException{
		BookDetailVO updatedArticle = bookService.updateArticle(article);
		return new ResponseEntity<>(updatedArticle, HttpStatus.OK);
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteArticle(@PathVariable("id") Integer articleId)throws ApplicationException{
		bookService.deleteArticle(articleId);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
	
	@RequestMapping("/search/{keyword}")
	public ResponseEntity<List<BookDetailVO>> searchArticle(@PathVariable("keyword") String keyword)throws ApplicationException{
		List<BookDetailVO> articles = bookService.seacrhArticle(keyword);
		return new ResponseEntity<>(articles, HttpStatus.OK);
	}
	
	@RequestMapping("/searchDates/{startDate}/{endDate}")
	public ResponseEntity<List<BookDetailVO>> getAricleByDate(  @PathVariable("startDate") String startDate,
			 @PathVariable("endDate") String endDate) throws ApplicationException, ParseException{
		
		List<BookDetailVO> articles = bookService.seacrhArticleByDates(startDate,endDate);
		return new ResponseEntity<>(articles, HttpStatus.OK);
	}
	
	@RequestMapping("/searchByAuthor/{author}")
	public ResponseEntity<List<BookDetailVO>> searchByAuthor(@PathVariable("author") String authorName)throws ApplicationException{
		List<BookDetailVO> articles = bookService.getArticleByAuthor(authorName);
		return new ResponseEntity<>(articles, HttpStatus.OK);
	}
}
