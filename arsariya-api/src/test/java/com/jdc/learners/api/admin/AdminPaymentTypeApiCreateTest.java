package com.jdc.learners.api.admin;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.client.MockMvcWebTestClient;
import org.springframework.web.context.WebApplicationContext;

import com.jdc.learners.domain.dto.ApiResult;
import com.jdc.learners.domain.dto.ApiResult.ApiStatus;
import com.jdc.learners.domain.dto.PaymentTypeDto;

@SpringBootTest
@WithMockUser(username = "admin@gmail.com", authorities = "Admin")
@TestMethodOrder(value = OrderAnnotation.class)
public class AdminPaymentTypeApiCreateTest {
	
	private WebTestClient client;
	
	@BeforeEach
	void setUp(WebApplicationContext context) {
		client = MockMvcWebTestClient.bindToApplicationContext(context).build();
	}

	@Order(1)
	@ParameterizedTest
	@CsvSource({
			"1,KBZ Pay",
			"2,Aya Pay",
			"3,Wave Pay"
	})
	void createSuccess(int id, String name) {
		var result = client.post().uri(builder -> builder.path("/admin/payment").build())
			.bodyValue(new PaymentTypeDto(0, name))
			.exchange()
			.expectStatus().isOk()
			.expectBody(ApiResult.class)
			.returnResult()
			.getResponseBody();
			
		assertThat(result).matches(data -> {
			return data.getStatus() == ApiStatus.Success;
		});
		
		if(result.getResult() instanceof PaymentTypeDto dto) {
			assertThat(dto).matches(a -> a.getId() == id && a.getName().endsWith(name));
		}
	}
	
	@Order(2)
	@Test
	void create_with_empty_name() {
		var result = client.post().uri(builder -> builder.path("/admin/payment").build())
				.bodyValue(new PaymentTypeDto(0, ""))
				.exchange()
				.expectStatus().isBadRequest()
				.expectBody(ApiResult.class)
				.returnResult()
				.getResponseBody();
				
		assertThat(result).matches(data -> {
			return data.getStatus() == ApiStatus.Business;
		});
	}
	
}
