package com.lening.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Page {

	/**
	 * ��Ϊ������д���вι�������ϵͳĬ�ϵ��޲ι�������û���ˣ�
	 * ������Щ��һЩ������������߿�ܵײ������Ҫ�޲ι���ȥ
	 */
	
	public Page() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static final int DEFAULT_PAGE_SIZE = 5;
	//�ܼ�¼��
	private int count;
	//ÿҳ���ټ�¼
	private int pageSize;
	//��ҳ��
	private int pageCount;
	//��ǰҳ��
	private int currentPage;
	private int previousPage;
	private int nextPage;
	private int startRecord;
	private int endRecord;
	
	private String mohu;
	private Map<Object,Object> map = new HashMap<Object,Object>();
	public Map<Object, Object> getMap() {
		return map;
	}

	public void setMap(Map<Object, Object> map) {
		this.map = map;
	}

	public Page(String current, int count, String pageSize) {
		this.count = count;
		init(current, pageSize);
	}

	private void init(String current, String size) {
		initPageSize(size);
		initPageCount();
		initCurrentPage(current);
		initPreviousPage();
		initNextPage();
		initStartRecord();
		initEndRecord();
	}

	/**
	 * ������servlet�У�new page�࣬Ȼ���൱�ڵ���page���캯�����ڹ��캯���У��ȳ�ʼ����count
	 * Ȼ���ֵ�����init����
	 * init���е�����7�����������������ȫ����ʼ����
	 * ����ǳ�ʼ����ÿҳ��ʾ���ټ�¼�ģ����û�����Ϊ�գ�����paseint���쳣�ģ�
	 * �����û�����С��1����ֵʱ�򣬶�ΪĬ��ֵ
	 */
	
	private void initPageSize(String size) {
		if (size == null || size.trim().isEmpty()) {
			pageSize = DEFAULT_PAGE_SIZE;
			return;
		}
		try {
			pageSize = Integer.parseInt(size);
			if(pageSize<1){
				pageSize = DEFAULT_PAGE_SIZE;
			}
		} catch (Exception e) {
			pageSize = DEFAULT_PAGE_SIZE;
		}
	}

	/**
	 	��ʼ��һ���ֶ���ҳ�������������͵�����ȡ��
	 */
	private void initPageCount() {
		pageCount = count / pageSize;
		if (count % pageSize != 0) {
			pageCount++;
		}
	}
	
	/**
	 * ��ʼ����ǰҳ��Ҳ���Ǵ�ǰ̨ҳ�洫�ݹ����ģ�����û������ֶ����룬�����ϸ��ϸ�
	 * @param current
	 */
	private void initCurrentPage(String current) {
		
		if (current == null || current.trim().isEmpty()) {
			currentPage = 1;
			return;
		}
		
		try {
			currentPage = Integer.parseInt(current);
		} catch (Exception e) {
			currentPage = 1;
		}
		
		if (currentPage < 1) {
			currentPage = 1;
			return;
		}
		if (currentPage > pageCount) {
			currentPage = pageCount;
		}
	}
	

	private void initPreviousPage() {
		previousPage = currentPage - 1;
		if (previousPage < 1) {
			previousPage = 1;
		}
	}
	
	private void initNextPage() {
		nextPage = currentPage + 1;
		if (nextPage > pageCount) {
			nextPage = pageCount;
		}
	}




	private void initStartRecord() {
		startRecord = (currentPage - 1) * pageSize;
		if (startRecord < 0) {
			startRecord = 0;
		}
		if (startRecord > count) {
			startRecord = count;
		}
	}
	
	private void initEndRecord() {
		endRecord = startRecord + pageSize - 1;
		if (endRecord > count) {
			endRecord = count;
		}
	}
	


	public int getCount() {
		return count;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getPageCount() {
		return pageCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}



	public int getPreviousPage() {
		return previousPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public int getStartRecord() {
		return startRecord;
	}

	public int getEndRecord() {
		return endRecord;
	}

	public String getMohu() {
		return mohu;
	}

	public void setMohu(String mohu) {
		this.mohu = mohu;
	}

}
