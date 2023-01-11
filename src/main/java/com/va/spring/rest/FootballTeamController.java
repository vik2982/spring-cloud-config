package com.va.spring.rest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.va.spring.rest.model.FootballTeam;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
public class FootballTeamController {
	
	private static final Logger logger = LoggerFactory.getLogger(FootballTeamController.class);

	private static final String ASC = "asc";
	private static final String DESC = "desc";
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	private List<FootballTeam> footballTeams;
	
	public FootballTeamController() throws ParseException{
		footballTeams = new ArrayList<FootballTeam>(){
			{
				add(new FootballTeam("spurs","london","daniel levy",30000,"Premier League",22,dateFormat.parse("20/07/1901")));
				add(new FootballTeam("man utd","manchester","glazers",60000,"Champions League",18,dateFormat.parse("20/07/1955")));
				add(new FootballTeam("chelsea","london","abramhovic",40000,"Premier League",30,dateFormat.parse("20/07/2004")));
				
			}
		};
	}


	@GetMapping
	public List<FootballTeam> allTeams() {
		
		return footballTeams;
	}
	
	@Operation(summary = "Get a team by its name")
	@ApiResponses(value = { 
	  @ApiResponse(responseCode = "200", description = "Found the team", 
	    content = { @Content(mediaType = "application/json", 
	      schema = @Schema(implementation = FootballTeam.class)) }),
	  @ApiResponse(responseCode = "404", description = "Team not found", 
	    content = { @Content(mediaType = "application/json", 
	      schema = @Schema(implementation = ErrorResponse.class)) }) })
	@GetMapping("/{team}")
	public FootballTeam getTeam(@PathVariable("team") String team) throws FootballTeamNotFoundException {

		for (FootballTeam footballTeam : footballTeams){
			
			if (footballTeam.getName().equalsIgnoreCase(team)){
				return footballTeam;
			}
		}
		
		logger.error("Team not found for provided path variable");
		throw new FootballTeamNotFoundException("No Team found");
	}
	
	
	@GetMapping("/capacity")
	public List<FootballTeam> sortByCapacity(@RequestParam("sort") String sort) {
		
		if (sort.equals(ASC)){
			class TeamCompareAsc implements Comparator<FootballTeam> {
		        public int compare(FootballTeam teamOne, FootballTeam teamTwo) {
		        	return Integer.compare(teamOne.getStadiumCapacity(), teamTwo.getStadiumCapacity());
		        }
		    }
			Collections.sort (footballTeams, new TeamCompareAsc());
		}else if (sort.equals(DESC)){
			class TeamCompareDesc implements Comparator<FootballTeam> {
		        public int compare(FootballTeam teamOne, FootballTeam teamTwo) {
		        	return Integer.compare(teamTwo.getStadiumCapacity(), teamOne.getStadiumCapacity());
		        }
		    }
			Collections.sort (footballTeams, new TeamCompareDesc());
		}
		
		return footballTeams;
	}
	
	@PostMapping("/create")
	public List<FootballTeam> createTeam(@RequestBody FootballTeam team) throws FootballTeamException {
		
		if (footballTeams.contains(team)){	
			logger.error("Cannot create team as it already exists");
			throw new FootballTeamException("Team already exists");
		}
		
		footballTeams.add(team);
		
		return footballTeams;
	}

}