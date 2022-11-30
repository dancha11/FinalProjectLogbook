package com.example.FinalProjectLogbook;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.FinalProjectLogbook.web.FlightController;

@RunWith(SpringRunner.class)
@SpringBootTest
class FinalProjectLogbookTests {
	@Autowired
	private FlightController controller;

	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

}