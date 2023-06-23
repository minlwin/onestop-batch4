package com.jdc.learners.api.admin;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.client.MockMvcWebTestClient;
import org.springframework.web.context.WebApplicationContext;

import com.jdc.learners.domain.dto.ApiResult;
import com.jdc.learners.domain.dto.PaymentTypeDto;
import com.jdc.learners.domain.dto.ApiResult.ApiStatus;

@SpringBootTest
@WithMockUser(username = "admin@gmail.com", authorities = "Admin")
@TestMethodOrder(value = OrderAnnotation.class)
@Sql({ "/sql/truncate-all.sql", "/sql/payment-type.sql", })
public class AdminPaymentTypeApiUpdateTest {

	private WebTestClient client;

	@BeforeEach
	void setUp(WebApplicationContext context) {
		client = MockMvcWebTestClient.bindToApplicationContext(context).build();
	}

	@Test
	@Order(1)
	void update_validation_error() {
		var result = client.put().uri(builder -> builder.path("/admin/payment/1").build())
				.bodyValue(new PaymentTypeDto(0, "")).exchange().expectStatus().isBadRequest()
				.expectBody(ApiResult.class).returnResult().getResponseBody();

		assertThat(result).matches(data -> {

			assertThat(data.getResult()).matches(listResult -> {
				if (listResult instanceof List list) {
					if (list.size() != 1) {
						return false;
					}

					if (!"Please enter payment type name.".equals(list.get(0))) {
						return false;
					}
				}

				return null != listResult;
			});

			return data.getStatus() == ApiStatus.Business;
		});
	}

	@Test
	@Order(2)
	void update_no_data_error() {
		var result = client.put().uri(builder -> builder.path("/admin/payment/4").build())
				.bodyValue(new PaymentTypeDto(0, "TRUE MONEY")).exchange().expectStatus().isBadRequest()
				.expectBody(ApiResult.class).returnResult().getResponseBody();

		assertThat(result).matches(data -> {

			assertThat(data.getResult()).matches(listResult -> {
				if (listResult instanceof List list) {
					if (list.size() != 1) {
						return false;
					}

					if (!"There is no Payment Type with id 4.".equals(list.get(0))) {
						return false;
					}
				}

				return null != listResult;
			});

			return data.getStatus() == ApiStatus.Business;
		});
	}

	@Test
	@Order(3)
	void update_success() {
		var result = client.put().uri(builder -> builder.path("/admin/payment/1").build())
				.bodyValue(new PaymentTypeDto(0, "TRUE MONEY"))
				.exchange()
				.expectStatus().isOk()
				.expectBody(ApiResult.class).returnResult().getResponseBody();

		assertThat(result).matches(data -> {

			assertThat(data.getResult()).matches(apiResult -> {
				if (apiResult instanceof PaymentTypeDto dto) {
					return dto.getId() == 1 && dto.getName().equals("TRUE MONEY");
				}

				return null != apiResult;
			});

			return data.getStatus() == ApiStatus.Success;
		});
	}
}
