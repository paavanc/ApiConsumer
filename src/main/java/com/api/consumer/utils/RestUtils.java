package com.api.consumer.utils;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLContext;

import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.api.consumer.exception.ConsumerException;

public class RestUtils {

	private static RestTemplate getRestTemplate()
			throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
		TrustStrategy acceptingTrustStrategy = new TrustStrategy() {
			@Override
			public boolean isTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
				return true;
			}
		};
		SSLContext sslContext = org.apache.http.ssl.SSLContexts.custom().loadTrustMaterial(null, acceptingTrustStrategy)
				.build();
		SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext, new NoopHostnameVerifier());
		CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(csf).build();
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setHttpClient(httpClient);
		RestTemplate restTemplate = new RestTemplate(requestFactory);
		return restTemplate;
	}

	private static String testStatus(ResponseEntity<String> entity) {

		System.out.println(entity.getStatusCode());
		if (entity.getStatusCode().is4xxClientError()) {
			throw new ConsumerException(entity.getBody(), entity.getStatusCode());
		}
		return entity.getBody();
	}

	public static <T> T create(String url, T s, Class<T> classType, Map<String, String> headers) {
		try {
			return JsonUtils.toObject(testStatus(
					getRestTemplate().postForEntity(url, new HttpEntity<>(s, creatHeaders(headers)), String.class)),
					classType);
		} catch (Exception e) {
			throw new ConsumerException(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	public static <T> T update(String url, Class<T> classType, Map<String, String> headers) {
		try {
			return JsonUtils.toObject(testStatus(getRestTemplate().exchange(url, HttpMethod.PUT,
					new HttpEntity<>(creatHeaders(headers)), String.class)), classType);
		} catch (Exception e) {
			throw new ConsumerException(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	public static <T> T get(String url, Class<T> classType, Map<String, String> headers) {
		try {
			return JsonUtils.toObject(testStatus(getRestTemplate().exchange(url, HttpMethod.GET,
					new HttpEntity<>(creatHeaders(headers)), String.class)), classType);
		} catch (Exception e) {
			throw new ConsumerException(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	public static <T> List<T> getAll(String url, Class<T> classType, Map<String, String> headers) {
		try {
			return JsonUtils.toListOfObjects(testStatus(getRestTemplate().exchange(url, HttpMethod.GET,
					new HttpEntity<>(creatHeaders(headers)), String.class)), classType);
		} catch (Exception e) {
			throw new ConsumerException(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	public static void delete(String url, Map<String, String> headers) {
		try {
			getRestTemplate().exchange(url, HttpMethod.DELETE, new HttpEntity<>(creatHeaders(headers)), Void.class);
		} catch (Exception e) {
			throw new ConsumerException(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	private static HttpHeaders creatHeaders(Map<String, String> headers) {
		HttpHeaders result = new HttpHeaders();
		result.setContentType(MediaType.APPLICATION_JSON);

		for (Map.Entry<String, String> entry : headers.entrySet()) {
			result.add(entry.getKey(), entry.getValue());
		}
		return result;
	}

}
