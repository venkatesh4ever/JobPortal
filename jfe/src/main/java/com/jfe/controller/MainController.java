package com.jfe.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.security.Principal;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import com.jfe.dao.DataDAO;
import com.jfe.util.SocialControllerUtil;

@Controller
public class MainController {

    private static final Logger LOG = LoggerFactory.getLogger(MainController.class);


    @Autowired(required=true)
    private DataDAO dataDao;
    
    @Qualifier("dataDao")
    public void setDataDAO(DataDAO dataDao){
        this.dataDao = dataDao;
    }

    @Autowired(required=true)
    private SocialControllerUtil socialControllerUtil;
    
    @Qualifier("socialControllerUtil")
    public void setSocialControllerUtil(SocialControllerUtil socialControllerUtil){
        this.socialControllerUtil = socialControllerUtil;
    }

    /*
    @RequestMapping("/")
    public String home(HttpServletRequest request, Principal currentUser, Model model) {
    	socialControllerUtil.setModel(request, currentUser, model);
        return "home";
    }
    */

    @RequestMapping("/login")
    public String login(HttpServletRequest request, Principal currentUser, Model model) {
    	socialControllerUtil.setModel(request, currentUser, model);
        return "login";
    }

    @RequestMapping(value= "/update", method = POST)
    public String update(
        HttpServletRequest request,
        Principal currentUser,
        Model model,
        @RequestParam(value = "data", required = true) String data) {

        LOG.debug("Update data to: {}", data);
        String userId = currentUser.getName();
        dataDao.setData(userId, data);

        socialControllerUtil.setModel(request, currentUser, model);
        return "home";
    }

    @RequestMapping(value= "/updateStatus", method = POST)
    public String updateStatus(
        WebRequest webRequest,
        HttpServletRequest request,
        Principal currentUser,
        Model model,
        @RequestParam(value = "status", required = true) String status) {
        MultiValueMap<String, Connection<?>> cmap = null;//connectionRepository.findAllConnections();
        LOG.error("cs.size = {}", cmap.size());
        Set<Map.Entry<String, List<Connection<?>>>> entries = cmap.entrySet();
        for (Map.Entry<String, List<Connection<?>>> entry : entries) {
            for (Connection<?> c : entry.getValue()) {
                LOG.debug("Updates {} with the status '{}'", entry.getKey(), status);
                c.updateStatus(status);
            }
        }

        return "home";
    }
}
