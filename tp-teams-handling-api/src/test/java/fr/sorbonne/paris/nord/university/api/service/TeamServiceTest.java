package fr.sorbonne.paris.nord.university.api.service;

import fr.sorbonne.paris.nord.university.api.entity.TeamEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@SpringBootTest
@Transactional
public class TeamServiceTest {


    @Autowired
    private TeamService teamService;

    @Test
    public void shouldReturnTheExpectedTeam_whenGetTeamByExistingId() {

        // Given.
        String psg = "PSG";
        // When.
        TeamEntity teamById = teamService.findTeamById(1L);
        // Then.
        Assertions.assertThat(teamById.getName()).isEqualTo(psg);
    }
    @Test
    public void shouldReturnListOfTeamsNotEmpty_whenFindTeams() {
        // When.
        List<TeamEntity> teams = teamService.findTeams();
        // Then.
        Assertions.assertThat(teams)
                .isNotEmpty()
                .hasSize(5);
    }

    @Test
    public void shouldDeleteTeam_whenDeleteById() {
        // Given.
        Long id = 1L;
        // When.
        teamService.deleteById(id);
        // Then.
        Assertions.assertThat(teamService.findTeamById(id)).isNull();
    }

    @Test
    public void shouldReturnTeam_whenInsertTeam() {
        // Given.
        TeamEntity team = new TeamEntity(6L,"Marseille","Droit Au But !");
        Long id = 6L;
        // When.
        teamService.insertTeam(team);
        // Then.
        Assertions.assertThat(teamService.findTeamById(id).getId()).isEqualTo(team.getId());
        Assertions.assertThat(teamService.findTeamById(id).getSlogan()).isEqualTo(team.getSlogan());
        Assertions.assertThat(teamService.findTeamById(id).getName()).isEqualTo(team.getName());
    }

    @Test
    public void shouldUpdateTeam_whenUpdateTeam() {
        // Given.
        TeamEntity team = new TeamEntity(6L,"Marseille","C'est pas la capital c'est marseille bébé");
        String slogan = "C'est pas la capital c'est marseille bébé";
        Long id = 6L;

        // When.
        teamService.updateTeam(team);
        // Then.
        Assertions.assertThat(teamService.findTeamById(id).getSlogan()).isEqualTo("C'est pas la capital c'est marseille bébé");
    }

}
