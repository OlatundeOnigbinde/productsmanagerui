package com.lpg.pmappui.controller;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("portalusers")
@Slf4j
public class PortalUsersController {


//    @PostMapping(value = "/createUser", consumes = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseStatus(HttpStatus.CREATED)
//    public String createUser(@RequestBody PortalUsers obj, Model model) {
//        log.info(MessageFormat.format("user supplied to controller: {0}", obj));
//        List<PortalUsers> opUser = userRepository.findByUsernameIgnoreCase(obj.getUsername());
//        if((!opUser.isEmpty()) && (!opUser.stream().findFirst().get().getUsername().equalsIgnoreCase(obj.getUsername()))){//using an existing user
//            model.addAttribute("message", MessageFormat.format("User with name {0} already exists", obj.getUsername()));
//            return "duplicate";
//        }else if((!opUser.isEmpty()) && opUser.stream().findFirst().get().getUsername().equalsIgnoreCase(obj.getUsername())){//modifying an existing user
//            long roleId= obj.getRoleId();
//            obj = opUser.stream().findFirst().get();
//            obj.setRoleId(roleId);
//            log.info(MessageFormat.format("Updating user: {0}", obj));
//            userRepository.save(obj);
//            AuditLog a = new AuditLog();
//            a.setAuditDetails(String.format("User with username '%s' modified successfully", obj.getUsername()));
//            a.setAuditType(AuditTypesEnum.USER_MODIFICATION);
//            portalAuditService.createAuditLog(a);
//            log.info("Audit log created for user modification...");
//            return "modified";
//        }
//        if(opUser.isEmpty()){
//            obj.setStatus(CommonConstants.statusInactive);
//            obj.setCreatedDate(new Date());
//            log.info(MessageFormat.format("Saving user: {0}", obj));
//            userRepository.save(obj);
//            model.addAttribute("message","User created successfully");
//            AuditLog a = new AuditLog();
//            a.setAuditDetails(String.format("User with username %s created successfully", obj.getUsername()));
//            a.setAuditType(AuditTypesEnum.USER_CREATION);
//            portalAuditService.createAuditLog(a);
//            log.info("Audit log created for user creation...");
//            return "success";
//        }else {
//            model.addAttribute("message", MessageFormat.format("User with username {0} already exists", obj.getUsername()));
//            return "duplicate";
//        }
//    }

//    @GetMapping(value = "/searchByUsername", produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<PortalUsers> getUsers(HttpSession session, @RequestParam(name="username") String username, Model model) {
//        if(session==null || session.getAttribute("userInSession") == null){
//            return null;
//        }
//        log.info(MessageFormat.format("user supplied to searchByUsername controller: {0}", username));
//        List<PortalUsers> retList;
//        if(Util.isNullOrBlank(username)){
//            retList = portalUserService.getUsers();
//        }else{
//            retList = portalUserService.getUsersByUsernameLike(username);
//        }
//        for(PortalUsers t: retList){
////            if(!Util.isNullOrBlank(t.getRoleId())) {
//            if(t.getRoleId() > 0){
//                t.setRole(portalRoleRepository.findByRoleId(Long.valueOf(t.getRoleId())).orElse(new PortalRoles()));
//            }
//        }
//        return retList;
//    }


}
