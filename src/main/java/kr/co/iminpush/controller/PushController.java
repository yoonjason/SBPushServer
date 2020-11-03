package kr.co.iminpush.controller;

import kr.co.iminpush.dto.UserDto;
import kr.co.iminpush.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PushController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserService userService;

    @RequestMapping(value = "/push")
    public String push(Model model) {
        logger.trace("Trace Level push 테스트");
        logger.debug("DEBUG Level push 테스트");
        logger.info("INFO Level push 테스트");
        logger.warn("Warn Level push 테스트");
        logger.error("ERROR Level push 테스트");
        List<UserDto> users = userService.printUser();
        model.addAttribute("userList", users);
        return "list";
    }


}
