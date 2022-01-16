package com.ttl.web.validation;

import com.ttl.model.constant.ErrorMessages;
import com.ttl.model.exception.BusinessException;
import com.ttl.service.MatchService;
import com.ttl.web.request.FirstRoundRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author: Moustafa.Bayoumy
 * @since: 1/16/2022 - 5:36 PM
 */
@Component
public class FirstRoundRequestValidator implements Validator {

    @Autowired
    private MatchService matchService;

    @Override
    public boolean supports(Class<?> clazz) {
        return FirstRoundRequest.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        FirstRoundRequest firstRoundRequest = (FirstRoundRequest) target;
        if(firstRoundRequest.getLeague() == null || firstRoundRequest.getLeague().getId() ==null) {
            throw new BusinessException(ErrorMessages.LEAGUE_CAN_NOT_BE_NULL.getErrorMessage());
        }

        long firstRoundCount = matchService.getFirstRoundCount();

        if(firstRoundCount > 0) {
            throw new BusinessException(ErrorMessages.FIRST_ROUND_EXIST.getErrorMessage());
        }
    }
}
