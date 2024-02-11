package com.capella.helper;

import com.capella.base.constant.MessageConstant;
import com.capella.base.util.MessagesUtils;
import com.capella.domain.data.restservice.ServiceResponseData;
import com.capella.domain.enums.ProcessStatus;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Arrays;
import java.util.stream.Collectors;

@ControllerAdvice
@AllArgsConstructor
@Slf4j
public class ExceptionHelper {
    protected final MessageSource messageSource;
    protected final Environment environment;

    @ExceptionHandler(value = {AccessDeniedException.class})
    public ResponseEntity<ServiceResponseData> handleAccessDeniedExceptionException(AccessDeniedException ex){
        return new ResponseEntity<>(fillServiceResponseData(ex), HttpStatus.UNAUTHORIZED);
    }
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ServiceResponseData> handleException(Exception ex){
        return new ResponseEntity<>(fillServiceResponseData(ex), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    private ServiceResponseData fillServiceResponseData(Exception ex){
        var serviceResponseData = new ServiceResponseData();
        if(ex instanceof AccessDeniedException){
            serviceResponseData.setStatus(ProcessStatus.UNAUTHORIZED);
            serviceResponseData.setErrorMessage(messageSource.getMessage(MessageConstant.ACCESS_DENIED_EXCEPTION_MESSAGE, null, MessagesUtils.getMessagesLocale()));
        }else{
            serviceResponseData.setStatus(ProcessStatus.ERROR);
            serviceResponseData.setErrorMessage(ExceptionUtils.getMessage(ex));
        }
        serviceResponseData.setErrorMessageDetail(Arrays.asList(ExceptionUtils.getStackFrames(ex)).stream().limit(50).collect(Collectors.joining()));
        return serviceResponseData;
    }
}
