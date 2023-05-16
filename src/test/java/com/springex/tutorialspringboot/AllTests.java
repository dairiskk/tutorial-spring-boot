package com.springex.tutorialspringboot;

import com.springex.tutorialspringboot.BaseTest;
import com.springex.tutorialspringboot.dbmodels.Message;
import com.springex.tutorialspringboot.dbmodels.Room;
import com.springex.tutorialspringboot.dbmodels.User;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

@Slf4j
class AllTests extends BaseTest {
	@Test
	void userTest() {
		Response response = httpRequest.get("/api/user");
		List<User> users = List.of(response.body().as(User[].class));
		Assertions.assertEquals(2, users.size());
	}
	@Test
	void roomTest() {
		Response response = httpRequest.get("/api/room");
		List<Room> room = List.of(response.body().as(Room[].class));
		Assertions.assertEquals(2, room.size());
	}
	@Test
	void messageTest() {
		Response response = httpRequest.get("/api/message");
		List<Message> messages = List.of(response.body().as(Message[].class));
		Assertions.assertEquals(2, messages.size());
	}
}
