package fr.sorbonne.paris.nord.university.api.service;


import fr.sorbonne.paris.nord.university.api.entity.TeamEntity;
import org.springframework.beans.factory.annotation.Autowired;
import fr.sorbonne.paris.nord.university.api.repository.TeamRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class TeamService {

private final TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<TeamEntity> findTeams(){
        return teamRepository.findAll();
    }

    public TeamEntity findTeamById(Long id){
        return (TeamEntity) teamRepository.findById(id).orElse(null);
    }

    @Transactional
    public TeamEntity insertTeam(TeamEntity team){
        return teamRepository.save(team);
    }

    @Transactional
    public void deleteById(Long id){
        teamRepository.deleteById(id);
    }

    @Transactional
    public void updateTeam(TeamEntity team){
        teamRepository.save(team);
    }

}
