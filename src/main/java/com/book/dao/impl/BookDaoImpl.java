package com.book.dao.impl;

import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.book.dao.IBookDao;
import com.book.exception.ApplicationException;
import com.book.model.BookDetail;

/**
 * 
 * @author ibrara
 *
 */
@Repository
public class BookDaoImpl implements IBookDao{
	
	@Autowired
	SessionFactory sessionFacoty;

	@Override
	@Transactional
	public List<BookDetail> getAllBooks() {
		@SuppressWarnings("unchecked")
		List<BookDetail> list = getSession().createQuery("from BookDetail").list();
		return list;
	}

	@Override
	@Transactional
	public BookDetail getArticle(Integer articleId) throws ApplicationException {
		BookDetail article = getSession().get(BookDetail.class, articleId);
		if(article==null)
			throw new ApplicationException("No artcile found with given id");
		return article;
	}

	@Override
	@Transactional
	public List<BookDetail> getArticleByAuthor(String authorName) {
		@SuppressWarnings("unchecked")
		List<BookDetail> list = getSession()
				.createQuery("from BookDetail b where lower(b.authors) LIKE :authorName")
				.setParameter("authorName", "%"+authorName.toLowerCase()+"%").list();
		return list;
	}

	@Override
	@Transactional
	public BookDetail updateArticle(BookDetail article) throws ApplicationException {
		try{
			getSession().update(article);
		}catch (Exception e) {
			throw new ApplicationException("Article does not exist");
		}
		 return article;
	}

	@Override
	@Transactional
	public boolean deleteArticle(Integer articleId) throws ApplicationException {
		BookDetail article = getSession().get(BookDetail.class, articleId);
		try{
			getSession().delete(article);
		}catch (Exception e) {
			throw new ApplicationException("Article does not exist");
		}	
	
		return true;
	}

	@Override
	@Transactional
	public BookDetail addArticle(BookDetail article) {
		 getSession().save(article);
		 return article;
	}


	@Override
	@Transactional
	public List<BookDetail> searchArticle(String keyword) {
		@SuppressWarnings("unchecked")
		List<BookDetail> list = getSession()
				.createQuery("from BookDetail b where lower(b.header) LIKE :keyword or lower(b.shortDescription) LIKE :keyword "
						+ "or lower(b.text) LIKE :keyword or lower(b.authors) LIKE :keyword")
				.setParameter("keyword", "%"+keyword.toLowerCase()+"%").list();
		return list;
	}

	
	private Session getSession(){
		return sessionFacoty.getCurrentSession();
	}

	@Override
	@Transactional
	public List<BookDetail> searchArticleByDate(Date startDate, Date endDate) {
		@SuppressWarnings("unchecked")
		List<BookDetail> list = getSession()
				.createQuery("from BookDetail b where b.publishedDate BETWEEN :startDate AND :endDate")
				.setParameter("startDate", startDate)
				.setParameter("endDate", endDate).list();
		return list;
	}
}
