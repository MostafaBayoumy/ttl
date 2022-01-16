package com.ttl.web.controller;

import com.ttl.model.LeagueParticipant;
import com.ttl.model.Participant;
import com.ttl.model.custom.ParticipantGroup;
import com.ttl.model.exception.BusinessException;
import com.ttl.service.LeagueParticipantService;
import com.ttl.web.dto.LeagueParticipantDto;
import com.ttl.web.dto.ParticipantDto;
import com.ttl.web.dto.ParticipantGroupDto;
import com.ttl.web.mapper.LeagueParticipantMapper;
import com.ttl.web.mapper.ParticipantGroupMapper;
import com.ttl.web.mapper.ParticipantMapper;
import com.ttl.web.response.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author: Moustafa.Bayoumy
 * @since: 1/15/2022 - 12:32 PM
 */
@RestController
@RequestMapping("/league-participant")
public class LeagueParticipantController {

    @Autowired
    private LeagueParticipantService leagueParticipantService;

    @Autowired
    private LeagueParticipantMapper leagueParticipantMapper;

    @Autowired
    private ParticipantMapper participantMapper;

    @Autowired
    private ParticipantGroupMapper participantGroupMapper;

    @PostMapping(value = "/save")
    public SuccessResponse<LeagueParticipantDto> save(@Valid @RequestBody LeagueParticipantDto leagueParticipantDto) throws BusinessException {
        LeagueParticipant leagueParticipant = leagueParticipantMapper.unMap(leagueParticipantDto);
        leagueParticipant = leagueParticipantService.save(leagueParticipant);
        leagueParticipantDto = leagueParticipantMapper.map(leagueParticipant);
        return new SuccessResponse<LeagueParticipantDto>(leagueParticipantDto);
    }

    @PutMapping(value = "/update")
    public SuccessResponse<LeagueParticipantDto> update(@RequestBody LeagueParticipantDto leagueParticipantDto) throws BusinessException {
        LeagueParticipant leagueParticipant = leagueParticipantMapper.unMap(leagueParticipantDto);
        leagueParticipant = leagueParticipantService.save(leagueParticipant);
        leagueParticipantDto = leagueParticipantMapper.map(leagueParticipant);
        return new SuccessResponse<LeagueParticipantDto>(leagueParticipantDto);
    }

    @GetMapping(value = "/{id}")
    public SuccessResponse<LeagueParticipantDto> getById(@PathVariable(name="id") Integer id) throws BusinessException {
        LeagueParticipant leagueParticipant = leagueParticipantService.getById(id);
        LeagueParticipantDto leagueParticipantDto = leagueParticipantMapper.map(leagueParticipant);
        return new SuccessResponse<LeagueParticipantDto>(leagueParticipantDto);
    }

    @GetMapping(value = "/league/{leagueId}")
    public SuccessResponse<List<ParticipantDto>> getParticipantByLeagueId(@PathVariable(name="leagueId") Integer leagueId) throws BusinessException {
        List<Participant> participants = leagueParticipantService.getParticipantByLeagueId(leagueId);
        List<ParticipantDto> participantDtos = participantMapper.mapList(participants);
        return new SuccessResponse<List<ParticipantDto>>(participantDtos);
    }

    @GetMapping(value = "/league/{leagueId}/group-participants")
    public SuccessResponse<List<ParticipantGroupDto>> groupParticipantByLeagueId(@PathVariable(name="leagueId") Integer leagueId) throws BusinessException {
        List<ParticipantGroup> participantGroups = leagueParticipantService.groupParticipantRandomly(leagueId);
        List<ParticipantGroupDto> participantGroupDtos = participantGroupMapper.mapList(participantGroups);
        return new SuccessResponse<List<ParticipantGroupDto>>(participantGroupDtos);
    }

    @GetMapping
    public SuccessResponse<List<LeagueParticipantDto>> getAll() throws BusinessException {
        List<LeagueParticipant> leagueParticipants = leagueParticipantService.findAll();
        List<LeagueParticipantDto> leagueParticipantDtos = leagueParticipantMapper.mapList(leagueParticipants);
        return new SuccessResponse<List<LeagueParticipantDto>>(leagueParticipantDtos);
    }

    @DeleteMapping(value = "delete/{id}")
    public SuccessResponse<Boolean> delete(@PathVariable(name="id") Integer id) throws BusinessException {
        return new SuccessResponse<Boolean>(leagueParticipantService.deleteById(id));
    }
    
}
