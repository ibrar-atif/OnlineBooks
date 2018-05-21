package com.book.config;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.book.dao.IBookDao;
import com.book.model.BookDetail;


/**
 * Config class to load pre config values like All book details.
 * @author ibrara
 *
 */
@Component
public class BookConfig implements InitializingBean {
	
	@Autowired
	private IBookDao bookDao;

	private static List<BookDetail> bookLists = new ArrayList<>();
	
	
	
	/**
	 * @return the bookLists
	 */
	public static List<BookDetail> getBookLists() {
		return bookLists;
	}



	/**
	 * @param bookLists the bookLists to set
	 */
	public static void setBookLists(List<BookDetail> bookLists) {
		BookConfig.bookLists = bookLists;
	}



	@Override
	public void afterPropertiesSet() throws Exception {
		bookLists.add(createArticle(1,"Header 1", "Long Text", "A", new Date(), "Short Desc"));
		
		bookDao.addArticle(createArticle(1," Why is Terminology your Passion?", 
				"The star of  2016 has been undoubtedly this section, which includes inspiring interviews with prominent language specialist from all over the world. Would you like to learn from the best? Stay tuned to this section.", 
				"Author A", 
				new Date(), 
				"The objective of this initiative is to bring the terminology work in the spotlight and raise awareness about its importance in both monolingual and multilingual communication."));
	
		
		bookDao.addArticle(createArticle(2,"Lost in translation: five untranslatable words", 
				"Some expressions and terms are used to express a very specific concept or meaning linked to culture, traditions and lifestyle of the words’ country of origin and therefore is a struggle to translate into English.", 
				"Author B", 
				new GregorianCalendar(2018, Calendar.APRIL, 20).getTime(), 
				"Having a throwback into one of our previous posts, today’s topic is about five untranslatable words. As you can see, those are expressions or terms that express a very specific concept or meaning,"));
	
		
		bookDao.addArticle(createArticle(3,"The periodic table of the Spanish spelling", 
				"Our readers love the periodic table created by the Spanish linguist Juan Romeu. This is a really useful spelling periodic table which keeps the original chemical nomenclatures but with a short description of Spanish spelling standards related to the corresponding one or two letters. Haven’t you seen it yet?", 
				"Author B", 
				new GregorianCalendar(2018, Calendar.MARCH, 20).getTime(), 
				"The Spanish linguist Juan Romeu Fernández is the brain behind this idea. "));
	
	}
	
	
	private BookDetail createArticle(Integer id,String header, String text, String author,
			Date date,String desc){
		BookDetail article = new BookDetail();
		article.setShortDescription(desc);
		article.setAuthors(author);
		article.setHeader(header);
		article.setPublishedDate(date);
		article.setText(text);
		article.setArticleId(id);
		return article;
	}
	

}
