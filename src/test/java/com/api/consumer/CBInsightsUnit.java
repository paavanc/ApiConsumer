package com.api.consumer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.api.consumer.manager.impl.CBInsightsManagerImpl;
import com.api.consumer.vo.Combo;
import com.api.consumer.vo.Company;
import com.api.consumer.vo.Info;

@RunWith(MockitoJUnitRunner.class)
public class CBInsightsUnit {
	
	@InjectMocks
	CBInsightsManagerImpl cbInsightsManager;
	
	@Test
	@Ignore
	public void getInfo() {
		List<Info> infos = cbInsightsManager.getInfo();
		
		assertFalse(infos.isEmpty());
	}
	
	@Test
	@Ignore
	public void getCompany() {
		List<Company> companies = cbInsightsManager.getCompany();
		
		assertFalse(companies.isEmpty());
		System.out.println(companies);
	}
	
	@Test
	public void getCombo() {
		List<Combo> combos = cbInsightsManager.getCombos();
		
		assertFalse(combos.isEmpty());
		assertEquals(2,combos.size());
		System.out.println(combos.get(0).getIdCompany());
		System.out.println(combos.get(1).getIdCompany());
		System.out.println(combos);
	}

}
