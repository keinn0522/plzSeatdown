package com.bg.plzSeatdown.review.model.service;

import java.util.List;
import java.util.Map;

import com.bg.plzSeatdown.common.vo.PageInfo;
import com.bg.plzSeatdown.review.model.vo.Show;

public interface ReviewService {

	/** 전체 공연 수 조회용 Service
	 * @param map
	 * @return showCount
	 * @throws Exception
	 */
	int getShowCount(Map<String, String> map) throws Exception;

	/** 공연 목록 조회용 Service
	 * @param searchValue
	 * @param map
	 * @return list
	 * @throws Exception
	 */
	List<Show> selectList(Map<String, String> map, PageInfo pInf) throws Exception;

	/** 사이드 바에 출력할 공연 상세 정보 조회용 Service
	 * @param selectShowCode
	 * @return show
	 */
	Show selectShowDetail(String selectShowCode);

	

	


}