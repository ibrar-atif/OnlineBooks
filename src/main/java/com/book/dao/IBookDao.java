package com.book.dao;

import java.util.Date;
import java.util.List;

import com.book.exception.ApplicationException;
import com.book.model.BookDetail;
import com.book.view.BookDetailVO;

/**
 * 
 * @author ibrara
 *
 */
public interface IBookDao {

	/**
	 * 
	 */
	List<BookDetail> getAllBooks()throws ApplicationException;
	
	
	BookDetail getArticle(Integer articleId)throws ApplicationException;
	
	/**
	 * 
	 * @return
	 */
	List<BookDetail> getArticleByAuthor(String authorName)throws ApplicationException;
	
	/**
	 * 
	 * @param article
	 * @return
	 */
	BookDetail updateArticle(BookDetail article)throws ApplicationException;
	
	
	/**
	 * 
	 * @param articleId
	 * @return
	 */
	boolean deleteArticle(Integer articleId)throws ApplicationException;


	/**
	 * 
	 * @param transformModel
	 */
	BookDetail addArticle(BookDetail transformModel)throws ApplicationException;


	/**
	 * 
	 * @param keyword
	 */
	List<BookDetail> searchArticle(String keyword)throws ApplicationException;

	/**
	 * 
	 * @param startDate
	 * @param endDate
	 */

	List<BookDetail> searchArticleByDate(Date startDate, Date endDate);

}
