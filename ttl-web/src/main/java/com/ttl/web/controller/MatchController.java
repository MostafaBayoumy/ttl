package com.ttl.web.controller;

import com.ttl.model.Match;
import com.ttl.model.custom.ParticipantGroup;
import com.ttl.model.exception.BusinessException;
import com.ttl.service.LeagueParticipantService;
import com.ttl.service.MatchService;
import com.ttl.web.dto.MatchDto;
import com.ttl.web.mapper.MatchMapper;
import com.ttl.web.mapper.ParticipantMapper;
import com.ttl.web.request.FirstRoundRequest;
import com.ttl.web.response.SuccessResponse;
import com.ttl.web.validation.FirstRoundRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author: Moustafa.Bayoumy
 * @since: 1/15/2022 - 12:32 PM
 */
@RestController
@RequestMapping("/match")
public class MatchController {

    @Autowired
    private MatchService matchService;

    @Autowired
    private LeagueParticipantService leagueParticipantService;

    @Autowired
    private MatchMapper matchMapper;

    @Autowired
    private ParticipantMapper participantMapper;

    @Autowired
    private FirstRoundRequestValidator firstRoundRequestValidator;

    @InitBinder("firstRoundRequest")
    public void initValidators(WebDataBinder binder) {
        binder.addValidators(firstRoundRequestValidator);
    }

    @PostMapping(value = "/save")
    public SuccessResponse<MatchDto> save(@RequestBody MatchDto matchDto) throws BusinessException {
        Match match = matchMapper.unMap(matchDto);
        match = matchService.save(match);
        matchDto = matchMapper.map(match);
        return new SuccessResponse<MatchDto>(matchDto);
    }

    @PostMapping(value = "/first-round")
    public SuccessResponse<List<MatchDto>> createFirstRound(@Valid @RequestBody FirstRoundRequest firstRoundRequest) throws BusinessException {
        List<ParticipantGroup> participantGroups = leagueParticipantService.groupParticipantRandomly(firstRoundRequest.getLeague().getId());
        List<Match> matches = matchService.createFirstRoundMatches(participantGroups, firstRoundRequest.getLeague().getId());
        List<MatchDto> matchDtos = matchMapper.mapList(matches);
        return new SuccessResponse<>(matchDtos);
    }

    @GetMapping(value = "/league/{leagueId}/get-first-round-matches")
    public SuccessResponse<List<MatchDto>> getFirstRoundMatches(@PathVariable(name="leagueId") Integer leagueId) throws BusinessException {
        List<Match> matches = matchService.getFirstRoundMatches(leagueId);
        List<MatchDto> matchDtos = matchMapper.mapList(matches);
        return new SuccessResponse<>(matchDtos);
    }

    @GetMapping(value = "/league/{leagueId}/close-round/{roundNumber}")
    public SuccessResponse<Boolean> closeRound(@PathVariable(name="leagueId") Integer leagueId,
                                               @PathVariable(name="roundNumber") Byte roundNumber) throws BusinessException {
        return new SuccessResponse<>(matchService.closeRound(leagueId, roundNumber));
    }

    @PutMapping(value = "/update")
    public SuccessResponse<MatchDto> update(@RequestBody MatchDto matchDto) throws BusinessException {
        Match match = matchMapper.unMap(matchDto);
        match = matchService.update(match);
        matchDto = matchMapper.map(match);
        return new SuccessResponse<MatchDto>(matchDto);
    }

    @GetMapping(value = "/{id}")
    public SuccessResponse<MatchDto> getById(@PathVariable(name="id") Integer id) throws BusinessException {
        Match match = matchService.getById(id);
        MatchDto matchDto = matchMapper.map(match);
        return new SuccessResponse<MatchDto>(matchDto);
    }

    @GetMapping
    public SuccessResponse<List<MatchDto>> getAll() throws BusinessException {
        List<Match> matches = matchService.findAll();
        List<MatchDto> matchDtos = matchMapper.mapList(matches);
        return new SuccessResponse<List<MatchDto>>(matchDtos);
    }

    @DeleteMapping(value = "delete/{id}")
    public SuccessResponse<Boolean> delete(@PathVariable(name="id") Integer id) throws BusinessException {
        return new SuccessResponse<Boolean>(matchService.deleteById(id));
    }
    
}
