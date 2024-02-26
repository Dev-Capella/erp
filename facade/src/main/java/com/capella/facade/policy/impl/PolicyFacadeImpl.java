package com.capella.facade.policy.impl;

import com.capella.facade.policy.PolicyFacade;
import com.capella.facade.policy.Policy;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@AllArgsConstructor
@Slf4j
public class PolicyFacadeImpl implements PolicyFacade {

    protected final ApplicationContext applicationContext;

    @Override
    public Set<String> getAll() {
        var policyBeans = applicationContext.getBeanNamesForAnnotation(Policy.class);
        return Set.of(policyBeans);
    }
}
