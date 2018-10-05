package pl.alburnus.team;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class BackendApplication {

	private TeamStorage teamStorage;

	public BackendApplication(TeamStorage teamStorage) {
		this.teamStorage = teamStorage;
	}

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@GetMapping(path = "/test")
	ResponseEntity<String> getTest() {
		return ResponseEntity.ok("Sukces");
	}

	@GetMapping(path = "/api/team")
	ResponseEntity<List<Team>> getTeams() {
		return ResponseEntity.ok(teamStorage.getTeams());
	}

	@PostMapping(path = "/api/team")
	ResponseEntity add(@RequestBody Team team) {
		System.out.println(team.toString());
		teamStorage.addTeam(team);
		return ResponseEntity.ok().build();
	}

}
