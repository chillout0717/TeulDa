package com.teulda.review.test;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.teulda.common.Search;
import com.teulda.service.domain.Review;
import com.teulda.service.review.ReviewService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration	(locations = {	"classpath:config/context-common.xml",
										"classpath:config/context-aspect.xml",
										"classpath:config/context-mybatis.xml",
										"classpath:config/context-transaction.xml" })

public class ReviewServiceTest {
	
	@Autowired
	@Qualifier("reviewServiceImpl")
	private ReviewService reviewService;
	
	int no = 10027;
	
	//@Test
	public void testAddReview() throws Exception{
		
		Review review = new Review();
		review.setReviewNo(no);
		review.setNickname("king채경");
	    review.setReviewPlace("매디슨 스퀘어 가든");
	    review.setReviewContents(
	    				"오늘은 매디슨 스퀘어 가든에서 2만명을 앞에 두고 공연을 했다. 2만명 앞에서 공연이라 떨렸지만 나의 랩에 열광하는 사람들을 보며 즐거운 마음으로 랩을 할 수 있었다. make some noise!!");
	    review.setReviewPhoto("");
	    Timestamp dateTime = Timestamp.valueOf(LocalDateTime.now());
	    review.setReviewDate(dateTime);
	    review.setStar(4);
	    review.setIsAllowed('t');
	    
	    System.out.println(review);
	    reviewService.addReview(review);
	    
	    Review reviewGod = reviewService.getReview(no);
	    System.out.println(reviewGod);
	    
	    Assert.assertEquals(no, reviewGod.getReviewNo());
	    Assert.assertEquals("king채경", reviewGod.getNickname());
	    Assert.assertEquals("매디슨 스퀘어 가든", reviewGod.getReviewPlace());
	    Assert.assertEquals("오늘은 매디슨 스퀘어 가든에서 2만명을 앞에 두고 공연을 했다. 2만명 앞에서 공연이라 떨렸지만 나의 랩에 열광하는 사람들을 보며 즐거운 마음으로 랩을 할 수 있었다. make some noise!!", review.getReviewContents());
	    Assert.assertEquals(null, reviewGod.getReviewPhoto());
//	    Assert.assertEquals(dateTime, reviewGod.getReviewDate());
	    Assert.assertEquals(4, reviewGod.getStar());
	    Assert.assertEquals('t', reviewGod.getIsAllowed());
	}
	
	//@Test
	public void testGetReview() throws Exception{
		
		Review reviewGod = reviewService.getReview(no);
	    System.out.println(reviewGod);
	    
	    Assert.assertEquals(no, reviewGod.getReviewNo());
	    Assert.assertEquals("king채경", reviewGod.getNickname());
	    Assert.assertEquals("매디슨 스퀘어 가든", reviewGod.getReviewPlace());
	    Assert.assertEquals("오늘은 매디슨 스퀘어 가든에서 2만명을 앞에 두고 공연을 했다. 2만명 앞에서 공연이라 떨렸지만 나의 랩에 열광하는 사람들을 보며 즐거운 마음으로 랩을 할 수 있었다. make some noise!!", reviewGod.getReviewContents());
	    Assert.assertEquals(null, reviewGod.getReviewPhoto());
//	    Assert.assertEquals(dateTime, reviewGod.getReviewDate());
	    Assert.assertEquals(4, reviewGod.getStar());
	    Assert.assertEquals('t', reviewGod.getIsAllowed());
	}
	
	//@Test
	public void testUpdateReview() throws Exception{
		
		Review reviewGod = reviewService.getReview(no);
		System.out.println(reviewGod);
		
		Assert.assertEquals(no, reviewGod.getReviewNo());
	    Assert.assertEquals("king채경", reviewGod.getNickname());
	    Assert.assertEquals("매디슨 스퀘어 가든", reviewGod.getReviewPlace());
	    Assert.assertEquals("오늘은 매디슨 스퀘어 가든에서 2만명을 앞에 두고 공연을 했다. 2만명 앞에서 공연이라 떨렸지만 나의 랩에 열광하는 사람들을 보며 즐거운 마음으로 랩을 할 수 있었다. make some noise!!", reviewGod.getReviewContents());
	    Assert.assertEquals(null, reviewGod.getReviewPhoto());
	    Assert.assertEquals(4, reviewGod.getStar());
	    Assert.assertEquals('t', reviewGod.getIsAllowed());
	    
	    Review review = new Review();
		review.setReviewNo(no);
		review.setNickname("king성영");
	    review.setReviewPlace("강알리에서 대마도까지");
	    review.setReviewContents("강알리 등킨드나스 개꿀맛 개존잼 해수욕장 겨울에도 완전 좋아! 헤엄쳐서 바다 건너 일본까지 쌉가능");
	    review.setReviewPhoto("");
	    Timestamp dateTime = Timestamp.valueOf(LocalDateTime.now());
	    review.setReviewDate(dateTime);
	    review.setStar(5);
	    review.setIsAllowed('t');
	    
	    reviewService.updateReview(review);
	    Review reviewKang = reviewService.getReview(no);
		System.out.println(reviewKang);
		
		Assert.assertEquals(no, reviewKang.getReviewNo());
	    Assert.assertEquals("king성영", reviewKang.getNickname());
	    Assert.assertEquals("강알리에서 대마도까지", reviewKang.getReviewPlace());
	    Assert.assertEquals("강알리 등킨드나스 개꿀맛 개존잼 해수욕장 겨울에도 완전 좋아! 헤엄쳐서 바다 건너 일본까지 쌉가능", reviewKang.getReviewContents());
	    Assert.assertEquals(null, reviewKang.getReviewPhoto());
	    Assert.assertEquals(5, reviewKang.getStar());
	    Assert.assertEquals('t', reviewKang.getIsAllowed());
		
	}
	
	//@Test
	public void testDeleteReview() throws Exception{
		
		System.out.println(reviewService.getReview(no));
		reviewService.deleteReview(no);
		
		System.out.println(reviewService.getReview(no));
	}
	
	public void testGetReviewList() throws Exception{
		
		Search search = new Search();
		
		Map<String, Object> map = reviewService.getReviewList(search);
		List<Object> list = (List<Object>)map.get("list"); 
	}
}
