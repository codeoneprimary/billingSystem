package com.billing.system.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SmaUtil {

	private final RestTemplate restTemplate = new RestTemplate();

	public String sendOtp(String mobile, String otp) {
		try {
			String url = "https://api.msg91.com/api/v5/otp";

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.set("authkey", "YOUR_MSG91_AUTH_KEY");

			Map<String, Object> body = new HashMap<>();
			body.put("mobile", "91" + mobile); // For India
			body.put("otp", otp);
			body.put("template_id", "YOUR_DLT_TEMPLATE_ID");
			body.put("sender_id", "SENDERID"); // Optional
			body.put("otp_length", 6);

			HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);

			ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);

			return response.getBody();
		} catch (Exception e) {
			return null;
		}
	}
}
