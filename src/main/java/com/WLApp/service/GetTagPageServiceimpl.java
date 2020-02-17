package com.WLApp.service;

import java.util.Map;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.WLApp.model.TagPage;

@Service
public class GetTagPageServiceimpl implements GetTagPageService {

	RestTemplate restTemplate = new RestTemplate();
	HttpHeaders headers = new HttpHeaders();

	public GetTagPageServiceimpl() {
		RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
		restTemplate = restTemplateBuilder
				.basicAuthorization("vatsalkumar.rupavatia.external@atos.net", "jZUJSv89Zm3gJqcxCztDDEC9").build();

	}

	@Override
	public String getPages(String pageTag) {

		String Token = getOAuthToken();
		String uri = "https://vatsalwltest.atlassian.net/wiki/rest/api/content/search?cql={filter}";
		String filter = "{label='" + pageTag + "' and type='page'}";
		TagPage tagPages = restTemplate.getForObject(uri, TagPage.class, filter);
		StringBuilder pages = new StringBuilder();
		// pages.append("Following is the list of pages:\n");
		System.out.println("in for");
		for (int i = 0; i < tagPages.getResults().size(); i++) {
			System.out.println(tagPages.getResults().get(i).getTitle());

			pages.append(tagPages.getResults().get(i).getTitle());
			if (i < tagPages.getResults().size() - 1) {
				pages.append(", ");
			}
		}
		System.out.println(pages.toString());
		return pages.toString();

	}

	@Override
	public String getOAuthToken() {
		System.out.println("t oget auth code");
		String uri = "https://auth.atlassian.com/authorize?audience=api.atlassian.com&client_id=COPi75ecOiVOzPjE8a0WO4ufWrSl5ybz&scope=read%3Aconfluence-space.summary%20read%3Aconfluence-props%20read%3Aconfluence-content.summary%20search%3Aconfluence%20write%3Aconfluence-content%20write%3Aconfluence-space%20write%3Aconfluence-file%20manage%3Aconfluence-configuration&redirect_uri=http%3A%2F%2Flocalhost%3A8080%2Fcallback&state=vatsal&response_type=code&prompt=consent";

		final Map<?, ?> result = restTemplate.getForObject(uri, Map.class);
		StringBuilder pages = new StringBuilder();
		// pages.append("Following is the list of pages:\n");
		System.out.println("in for");
		
		System.out.println(result);
		return pages.toString();

	}

}
