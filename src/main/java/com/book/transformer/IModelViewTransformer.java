package com.book.transformer;

import java.util.List;

import com.book.model.BookDetail;
import com.book.view.BookDetailVO;

public interface IModelViewTransformer<T,K> {

	/**
	 * 
	 * @param k
	 * @return
	 */
	T transformView(K k);
	
	/**
	 * 
	 * @param t
	 * @return
	 */
	K transformModel(T t);

	/**
	 * 
	 * @param k
	 * @return
	 */
	List<BookDetailVO> transformViewList(List<BookDetail> k);
}
