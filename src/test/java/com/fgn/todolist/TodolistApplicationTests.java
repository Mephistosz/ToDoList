package com.fgn.todolist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.fgn.todolist.model.entities.Task;
import com.fgn.todolist.model.entities.enums.PriorityEnum;
import com.fgn.todolist.model.entities.enums.StatusEnum;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class TodolistApplicationTests {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	void testCreateTaskSucess() {
		var task = new Task("automate testing", "automate testing",
				StatusEnum.BACKLOG, PriorityEnum.LOW);

		webTestClient
				.post()
				.uri("/tasks")
				.bodyValue(task)
				.exchange()
				.expectStatus().isCreated();

	}

	@Test
	void testCreateTaskFailure() {
		var task = new Task("", "", StatusEnum.BACKLOG, PriorityEnum.LOW);

		webTestClient
				.post()
				.uri("/tasks")
				.bodyValue(task)
				.exchange()
				.expectStatus().is5xxServerError();

	}

}
