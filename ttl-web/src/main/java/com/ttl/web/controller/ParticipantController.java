package com.ttl.web.controller;

import com.ttl.model.Participant;
import com.ttl.model.exception.BusinessException;
import com.ttl.service.ParticipantService;
import com.ttl.web.dto.ParticipantDto;
import com.ttl.web.mapper.ParticipantMapper;
import com.ttl.web.response.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: Moustafa.Bayoumy
 * @since: 1/15/2022 - 12:32 PM
 */
@RestController
@RequestMapping("/participant")
public class ParticipantController {

    @Autowired
    private ParticipantService participantService;

    @Autowired
    private ParticipantMapper participantMapper;

//    @PostMapping(value = "/save")
//    public SuccessResponse<ParticipantDto> save(@RequestBody ParticipantDto participantDto) throws BusinessException {
//        Participant participant = participantMapper.unMap(participantDto);
//        participant = participantService.save(participant);
//        participantDto = participantMapper.map(participant);
//        return new SuccessResponse<ParticipantDto>(participantDto);
//    }

    @PutMapping(value = "/update")
    public SuccessResponse<ParticipantDto> update(@RequestBody ParticipantDto participantDto) throws BusinessException {
        Participant participant = participantMapper.unMap(participantDto);
        participant = participantService.save(participant);
        participantDto = participantMapper.map(participant);
        return new SuccessResponse<ParticipantDto>(participantDto);
    }

    @GetMapping(value = "/{id}")
    public SuccessResponse<ParticipantDto> getById(@PathVariable(name="id") Integer id) throws BusinessException {
        Participant participant = participantService.getById(id);
        ParticipantDto participantDto = participantMapper.map(participant);
        return new SuccessResponse<ParticipantDto>(participantDto);
    }

    @GetMapping
    public SuccessResponse<List<ParticipantDto>> getAll() throws BusinessException {
        List<Participant> participants = participantService.findAll();
        List<ParticipantDto> participantDtos = participantMapper.mapList(participants);
        return new SuccessResponse<List<ParticipantDto>>(participantDtos);
    }

    @DeleteMapping(value = "delete/{id}")
    public SuccessResponse<Boolean> delete(@PathVariable(name="id") Integer id) throws BusinessException {
        return new SuccessResponse<Boolean>(participantService.deleteById(id));
    }
    
}
