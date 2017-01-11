package co.com.netcom.mpos.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.com.netcom.mpos.dto.UserLoginDTO;

@Controller
public class FooController {
 
    @PreAuthorize("#oauth2.hasScope('read')")
    @RequestMapping(method = RequestMethod.GET, value = "/foos/{id}")
    @ResponseBody
    public UserLoginDTO findById(@PathVariable long id) {
    	UserLoginDTO dto = new UserLoginDTO("lalala", "12345");
    	
        return dto;
    }
}
