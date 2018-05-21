package com.book.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.dao.IBookDao;
import com.book.exception.ApplicationException;
import com.book.model.BookDetail;
import com.book.service.IBookService;
import com.book.transformer.IModelViewTransformer;
import com.book.view.BookDetailVO;
/**
 * 
 * @author ibrara
 *
 */
@Service
public class BookServiceImpl implements IBookService{
	

	@Autowired
	private IBookDao bookDao;
	
	@Autowired
	private IModelViewTransformer<BookDetailVO, BookDetail> transformer;

	/**
	 * @throws ApplicationException 
	 * 
	 */
	@Override
	public List<BookDetailVO> getAllBooks() throws ApplicationException {
		List<BookDetail> articleList = bookDao.getAllBooks();
		return transformer.transformViewList(articleList);
	}

	@Override
	public BookDetailVO getArticle(Integer articleId) throws ApplicationException {
		BookDetail article= bookDao.getArticle(articleId);
		return transformer.transformView(article);
	}

	@Override
	public List<BookDetailVO> getArticleByAuthor(String authorName) throws ApplicationException {
		List<BookDetail> articleList = bookDao.getArticleByAuthor(authorName);
		return transformer.transformViewList(articleList);
	}

	@Override
	public BookDetailVO updateArticle(BookDetailVO article) throws ApplicationException {
		try{
		BookDetail savedArticle = bookDao.updateArticle(transformer.transformModel(article));
		return transformer.transformView(savedArticle);
		}catch (Exception e) {
			throw new ApplicationException("Article does not exist");
		}
		
	}

	@Override
	public boolean deleteArticle(Integer articleId) throws ApplicationException {
		return bookDao.deleteArticle(articleId);
	}

	@Override
	public BookDetailVO addArticle(BookDetailVO article) throws ApplicationException {
		BookDetail savedArticle = bookDao.addArticle(transformer.transformModel(article));
		return transformer.transformView(savedArticle);
	}

	@Override
	public List<BookDetailVO> seacrhArticle(String keyword) throws ApplicationException {
		List<BookDetail> articleList = bookDao.searchArticle(keyword);
		 return transformer.transformViewList(articleList);
	}

	@Override
	public List<BookDetailVO> seacrhArticleByDates(String start, String end) throws ApplicationException, ParseException {
		SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
		Date startDate = sd.parse(start);
		Date endDate = sd.parse(end);
		List<BookDetail> articleList = bookDao.searchArticleByDate(startDate,endDate);
		return transformer.transformViewList(articleList);
	}
	
	
}
