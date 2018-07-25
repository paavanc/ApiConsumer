package com.api.consumer.manager;

import java.util.List;

import com.api.consumer.vo.Company;
import com.api.consumer.vo.Info;

public interface CBInsightsManager {

	List<Info> getInfo();

	List<Company> getCompany();

}