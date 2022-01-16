package com.ttl.web.controller;

import com.ttl.model.League;
import com.ttl.model.Participant;
import com.ttl.model.exception.BusinessException;
import com.ttl.service.EmailService;
import com.ttl.service.LeagueService;
import com.ttl.service.MatchService;
import com.ttl.service.impl.EmailServiceImpl;
import com.ttl.web.dto.LeagueDto;
import com.ttl.web.dto.ParticipantDto;
import com.ttl.web.mapper.LeagueMapper;
import com.ttl.web.mapper.MatchMapper;
import com.ttl.web.mapper.ParticipantMapper;
import com.ttl.web.request.SubmitChampionRequest;
import com.ttl.web.response.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: Moustafa.Bayoumy
 * @since: 1/15/2022 - 12:32 PM
 */
@RestController
@RequestMapping("/league")
public class LeagueController {

    @Autowired
    private LeagueService leagueService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private LeagueMapper leagueMapper;

    @Autowired
    private ParticipantMapper participantMapper;

    @PostMapping(value = "/save")
    public SuccessResponse<LeagueDto> save(@RequestBody LeagueDto leagueDto) throws BusinessException {
        League league = leagueMapper.unMap(leagueDto);
        league = leagueService.save(league);
        leagueDto = leagueMapper.map(league);
        return new SuccessResponse<>(leagueDto);
    }

    @PutMapping(value = "/update")
    public SuccessResponse<LeagueDto> update(@RequestBody LeagueDto leagueDto) throws BusinessException {
        League league = leagueMapper.unMap(leagueDto);
        league = leagueService.save(league);
        leagueDto = leagueMapper.map(league);
        return new SuccessResponse<>(leagueDto);
    }

    @PutMapping(value = "/submit-champion")
    public SuccessResponse<LeagueDto> submitChampion(@RequestBody SubmitChampionRequest request) throws BusinessException {
        League league = leagueMapper.unMap(request.getLeague());
        Participant champion = participantMapper.unMap(request.getChampion());
        league.setChampion(champion);
        league = leagueService.save(league);
        emailService.sendCongratulationEmail(champion.getEmail());
        return new SuccessResponse<>(leagueMapper.map(league));
    }

    @GetMapping(value = "/{id}")
    public SuccessResponse<LeagueDto> getById(@PathVariable(name="id") Integer id) throws BusinessException {
        League league = leagueService.getById(id);
        LeagueDto leagueDto = leagueMapper.map(league);
        return new SuccessResponse<>(leagueDto);
    }

    @GetMapping
    public SuccessResponse<List<LeagueDto>> getAll() throws BusinessException {
        List<League> leagues = leagueService.findAll();
        List<LeagueDto> leagueDtos = leagueMapper.mapList(leagues);
        return new SuccessResponse<>(leagueDtos);
    }

    @DeleteMapping(value = "delete/{id}")
    public SuccessResponse<Boolean> delete(@PathVariable(name="id") Integer id) throws BusinessException {
        return new SuccessResponse<>(leagueService.deleteById(id));
    }
    
}
