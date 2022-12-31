package com.va.spring.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(FootballTeamController.class)
public class FootballTeamControllerTest {

  @Autowired private MockMvc mockMvc;

  private static final String TEAM = "spurs";
		  
  private static final String TEAM_TO_RETURN =
		  "{"
          + "\"name\":\"spurs\","
          + "\"city\":\"london\","
          + "\"owner\":\"daniel levy\","
          + "\"stadiumCapacity\":30000,"
          + "\"competition\":\"Premier League\","
          + "\"numberOfPlayers\":22,"
          + "\"dateOfCreation\":\"20/07/1901\""
          + "}";


  @Test
  public void getTeam() throws Exception {
    mockMvc
    	.perform(get("/{team}", TEAM))
        .andExpect(status().isOk())
        .andExpect(content().json(TEAM_TO_RETURN));
  }
  
}