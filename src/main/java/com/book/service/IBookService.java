package com.book.service;

import java.text.ParseException;
import java.util.List;

import com.book.exception.ApplicationException;
import com.book.view.BookDetailVO;
/**
 * 
 * @author ibrara
 *
 */
public interface IBookService {

	/**
	 * 
	 * @return
	 */
	List<BookDetailVO> getAllBooks()throws ApplicationException;
	
	/**
	 * 
	 * @return
	 */
	BookDetailVO getArticle(Integer articleId)throws ApplicationException;
	
	/**
	 * 
	 * @return
	 */
	List<BookDetailVO> getArticleByAuthor(String authorName)throws ApplicationException;
	
	/**
	 * 
	 * @param article
	 * @return
	 */
	BookDetailVO updateArticle(BookDetailVO article)throws ApplicationException;
	
	
	/**
	 * 
	 * @param articleId
	 * @return
	 */
	boolean deleteArticle(Integer articleId)throws ApplicationException;

	/**
	 * 
	 * @param article
	 * @return
	 */
	BookDetailVO addArticle(BookDetailVO article)throws ApplicationException;
	
	/**
	 * 
	 * @return
	 */
	List<BookDetailVO> seacrhArticle(String keyword)throws ApplicationException;
	
	/**
	 * 
	 * @param start
	 * @param end
	 * @return
	 * @throws ApplicationException
	 * @throws ParseException 
	 */
	List<BookDetailVO> seacrhArticleByDates(String start, String end)throws ApplicationException, ParseException;
	
	
}
