package com.ridgue.homefood.http.domain.builder;

import com.ridgue.homefood.database.entity.StateEntity;
import com.ridgue.homefood.domain.StateTO;
import com.ridgue.homefood.exceptions.InvalidClientFieldException;
import com.ridgue.homefood.http.domain.request.StateRequest;
import org.springframework.stereotype.Component;

@Component
public class StateBuilder {
    public StateTO build(StateEntity stateEntity) {
        if (stateEntity == null) return null;

        StateTO to = new StateTO();
        to.setId(stateEntity.getId());
        to.setName(stateEntity.getName());

        return to;
    }

    public StateEntity build(StateRequest stateRequest) {
        if (stateRequest == null) return null;

        try {
            StateEntity state = new StateEntity();
            state.setName(stateRequest.getName());
            state.setCountry(stateRequest.getCountryEntity());

            return state;
        } catch (Exception e) {
            throw new InvalidClientFieldException();
        }
    }
}
