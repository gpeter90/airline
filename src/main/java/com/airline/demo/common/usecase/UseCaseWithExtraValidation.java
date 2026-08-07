package com.airline.demo.common.usecase;

public interface UseCaseWithExtraValidation<REQUEST> {
    void validate(REQUEST request);
}
