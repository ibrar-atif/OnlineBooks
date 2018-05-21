package com.book.transformer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.book.model.BookDetail;
import com.book.view.BookDetailVO;

/**
 * 
 * @author ibrara
 *
 */

@Component
public class ArticleTransformerImpl implements IModelViewTransformer<BookDetailVO, BookDetail>{

	@Override
	public BookDetailVO transformView(BookDetail k) {
		BookDetailVO article = new BookDetailVO();
		BeanUtils.copyProperties(k, article);
		return article;
	}

	@Override
	public BookDetail transformModel(BookDetailVO t) {
		BookDetail article = new BookDetail();
		BeanUtils.copyProperties(t, article);
		return article;
	}
	
	@Override
	public List<BookDetailVO> transformViewList(List<BookDetail> k) {
		List<BookDetailVO> bookList = new ArrayList<>();
		for(BookDetail b:k){
			BookDetailVO article = new BookDetailVO();
			BeanUtils.copyProperties(b, article);
			bookList.add(article);
		}
		
		return bookList;
	}

}
