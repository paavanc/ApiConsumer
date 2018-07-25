package com.api.consumer.manager.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.api.consumer.manager.CBInsightsManager;
import com.api.consumer.utils.Constants;
import com.api.consumer.utils.RestUtils;
import com.api.consumer.vo.Combo;
import com.api.consumer.vo.Company;
import com.api.consumer.vo.Info;

public class CBInsightsManagerImpl implements CBInsightsManager {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.api.consumer.manager.impl.CBInsightsManager#getInfo()
	 */
	@Override
	public List<Info> getInfo() {

		return RestUtils.getAll(Constants.CB_URI + Constants.REQ_ONE, Info.class, Collections.EMPTY_MAP);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.api.consumer.manager.impl.CBInsightsManager#getCompany()
	 */
	@Override
	public List<Company> getCompany() {

		return RestUtils.getAll(Constants.CB_URI + Constants.REQ_TWO, Company.class, Collections.EMPTY_MAP);
	}

	public List<Combo> getCombos() {

		List<Info> infos = getInfo();
		List<Company> companies = getCompany();


		Map<Long, Combo> resultMap = new HashMap<>();

		infoHelper(resultMap, infos);

		companyHelper(resultMap, companies);

		return new ArrayList<Combo>(resultMap.values());

	}

	private void infoHelper(Map<Long, Combo> resultMap, List<Info> infos) {

		for (Info in : infos) {

			resultMap.put(in.getIdCompany(), new Combo(in));
		}
	}

	private void companyHelper(Map<Long, Combo> resultMap, List<Company> companies) {

		for (Company ca : companies) {

			if (resultMap.containsKey(ca.getIdCompany())) {

				resultMap.get(ca.getIdCompany()).setCompany(ca);
			} else {
				resultMap.put(ca.getIdCompany(), new Combo(ca));
			}

		}
	}

}
