package com.teulda.service.subscribe.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.teulda.service.domain.Diary;
import com.teulda.service.domain.Subscribe;
import com.teulda.service.subscribe.SubscribeDao;
import com.teulda.service.subscribe.SubscribeService;

	@Service("subscribeServiceImpl")
	public class SubscribeServiceImpl implements SubscribeService {

		@Autowired
		@Qualifier("subscribeDaoImpl")
		private SubscribeDao subscribeDao;
		
		public void setSubscribeDao(SubscribeDao subscribeDao){
			this.subscribeDao = subscribeDao;
		}
		
		//디버깅을 위한
		public SubscribeServiceImpl() {  
			System.out.println(this.getClass()+" : default Constructor call");
		}
	

	@Override
	public boolean addSubscribe(Subscribe subscribe) throws Exception {
		if(subscribeDao.checkSubscribe(subscribe)) {
			subscribeDao.addSubscribe(subscribe);
			return true;
		}
		return false;
	}

	@Override
	public List<Subscribe> getSubscribeInfoList(String subNickname) throws Exception {
		return subscribeDao.getSubscribeInfoList(subNickname);
	}
	
	@Override
	public List<String> getSubscriberList(String subNickname) throws Exception{
		List<String> subscriberList = new ArrayList<String>();
		for(Subscribe each : subscribeDao.getSubscribeInfoList(subNickname)) {
			subscriberList.add(each.getSubTargetNickname());
		}
		return subscriberList;
	}
	
	@Override
	public List<Diary> getSubscriberDiaryList(List<String> subscriberList, Timestamp start) throws Exception{
		
		Map<String, Object> subscriberListInfo = new HashMap<String, Object>();
		subscriberListInfo.put("subscriberList", subscriberList);
		subscriberListInfo.put("start", start);
		
		return subscribeDao.getSubscriberDiaryList(subscriberListInfo);
	}
	
	@Override
	public List<Diary> getSubscriberDiaryPeriodList(List<String> subscriberList, Timestamp start, Timestamp end) throws Exception {
		
		Map<String, Object> subscriberListInfo = new HashMap<String, Object>();
		subscriberListInfo.put("subscriberList", subscriberList);
		subscriberListInfo.put("start", start);
		subscriberListInfo.put("end", end);
		return subscribeDao.getSubscriberDiaryList(subscriberListInfo);
	}
	
	@Override
	public boolean deleteSubscribe(Subscribe subscribe) throws Exception {
		if(!subscribeDao.checkSubscribe(subscribe)) {
			subscribeDao.deleteSubscribe(subscribe);
			return true;
		}
		return false;
	}

	@Override
	public boolean checkSubscribe(Subscribe subscribe) throws Exception {
		return subscribeDao.checkSubscribe(subscribe);	//	구독 중이면 false, 구독하지 않는 중이면 true.(그러니까 구독 가능하면 true)
	}


}
