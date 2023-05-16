package com.springex.tutorialspringboot;

import com.springex.tutorialspringboot.dbmodels.Deal;
import com.springex.tutorialspringboot.dbmodels.Pet;
import com.springex.tutorialspringboot.dbmodels.Photo;
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
	void dealTest() {
		Response response = httpRequest.get("/api/deal");
		List<Deal> room = List.of(response.body().as(Deal[].class));
		Assertions.assertEquals(2, room.size());
	}
	@Test
	void petTest() {
		Response response = httpRequest.get("/api/pet");
		List<Pet> messages = List.of(response.body().as(Pet[].class));
		Assertions.assertEquals(2, messages.size());
	}
	@Test
	void photoTest() {
		Response response = httpRequest.get("/api/photo");
		List<Photo> messages = List.of(response.body().as(Photo[].class));
		Assertions.assertEquals(2, messages.size());
	}
}
