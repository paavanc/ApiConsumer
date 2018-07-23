package com.api.consumer.utils;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

public class TestUtils {
	public static <T> T create(MockMvc mvc, String url, T s, Class<T> classType) throws Exception {
		MvcResult response = mvc.perform(
				MockMvcRequestBuilders.post(url).contentType(MediaType.APPLICATION_JSON).content(JsonUtils.toJson(s)))
				.andReturn();
		return JsonUtils.toObject(response.getResponse().getContentAsString(), classType);

	}

	public static <T> T update(MockMvc mvc, String url, T s, Class<T> classType) throws Exception {
		MvcResult response = mvc.perform(
				MockMvcRequestBuilders.put(url).contentType(MediaType.APPLICATION_JSON).content(JsonUtils.toJson(s)))
				.andReturn();
		return JsonUtils.toObject(response.getResponse().getContentAsString(), classType);

	}

	public static <T> List<T> getAll(MockMvc mvc, String url, Class<T> classType) throws Exception {
		MvcResult response = mvc.perform(MockMvcRequestBuilders.get(url).contentType(MediaType.APPLICATION_JSON))
				.andReturn();
		return JsonUtils.toListOfObjects(response.getResponse().getContentAsString(), classType);

	}

	public static <T> T get(MockMvc mvc, String url, Class<T> classType) throws Exception {
		MvcResult response = mvc.perform(MockMvcRequestBuilders.get(url).contentType(MediaType.APPLICATION_JSON))
				.andReturn();
		return JsonUtils.toObject(response.getResponse().getContentAsString(), classType);

	}

	public static <T> void expectBadRequestGet(MockMvc mvc, String url, Class<T> classType) throws Exception {
		mvc.perform(MockMvcRequestBuilders.get(url).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());

	}

}
