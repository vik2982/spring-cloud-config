package com.va.spring.rest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

	@RequestMapping(
		value = "/", 
		method = RequestMethod.GET, 
		produces = "application/json"
	)
	public List<FootballTeam> allTeams() {
		
		return footballTeams;
	}
	
	@RequestMapping(
		value = "/{team}", 
		method = RequestMethod.GET, 
		produces = "application/json"
	)
	public FootballTeam getTeam(@PathVariable("team") String team) throws FootballTeamException {

		for (FootballTeam footballTeam : footballTeams){
			
			if (footballTeam.getName().equalsIgnoreCase(team)){
				return footballTeam;
			}
		}
		
		logger.error("Team not found for provided path variable");
		throw new FootballTeamException("No Team found");
	}
	
	@RequestMapping(
		value = "/capacity", 
		method = RequestMethod.GET, 
		produces = "application/json"
	)
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
	
	@RequestMapping(
		value = "/create", 
		method = RequestMethod.POST, 
		produces = "application/json"
	)
	public List<FootballTeam> createTeam(@RequestBody FootballTeam team) throws FootballTeamException {
		
		if (footballTeams.contains(team)){	
			logger.error("Cannot create team as it already exists");
			throw new FootballTeamException("Team already exists");
		}
		
		footballTeams.add(team);
		
		return footballTeams;
	}
	
	@ExceptionHandler(FootballTeamException.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {

        ErrorResponse error = new ErrorResponse();
        error.setMessage(ex.getMessage());
        return new ResponseEntity<ErrorResponse>(error, HttpStatus.OK);

    }

}