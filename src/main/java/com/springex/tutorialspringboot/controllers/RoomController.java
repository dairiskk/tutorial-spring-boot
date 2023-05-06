package com.springex.tutorialspringboot.controllers;

import com.springex.tutorialspringboot.HttpResponseMessages;
import com.springex.tutorialspringboot.dbmodels.Room;
import com.springex.tutorialspringboot.othermodels.SecurityUser;
import com.springex.tutorialspringboot.repositories.RoomRepository;
import com.springex.tutorialspringboot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/room")
@PreAuthorize("hasRole('ROLE_USER')")
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private UserRepository userRepository;


    @PostMapping
    public Room save(Authentication authentication) {
        SecurityUser securityUser = (SecurityUser) authentication.getPrincipal();
        return roomRepository.save(new Room(securityUser.user));
    }

    @GetMapping()
    public List<Room> getAll(Authentication authentication) {
        SecurityUser securityUser = (SecurityUser) authentication.getPrincipal();
        return roomRepository.findByUsers(securityUser.user);

    }

    @GetMapping("/{id}")
    public Stream<Room> getOne(Authentication authentication, @PathVariable(value = "id") long id) {
        SecurityUser securityUser = (SecurityUser) authentication.getPrincipal();
        List<Room> clientRooms = roomRepository.findByUsers(securityUser.user);
        var rooms = clientRooms.stream().filter(x -> x.getId() == id);
        if (rooms.findAny().isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, HttpResponseMessages.VALUE_NOT_FOUND);
        } else {
            return clientRooms.stream().filter(x -> x.getId() == id);
        }

    }

    @PostMapping("/join/{id}")
    public Room join(Authentication authentication, @PathVariable(value = "id") long id) {
        SecurityUser securityUser = (SecurityUser) authentication.getPrincipal();
        List<Room> clientRooms = roomRepository.findByUsers(securityUser.user);
        var rooms = clientRooms.stream().filter(x -> x.getId() == id);
        if(roomRepository.findById(id).isEmpty()){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, HttpResponseMessages.ROOM_DOES_NOT_EXIST);
        }else {
            if (rooms.findAny().isEmpty()) {
                var roomToJoin = roomRepository.findById(id);
                roomToJoin.get().setUser(securityUser.user);
               return roomRepository.save(roomToJoin.get());
            } else {
                throw new ResponseStatusException(
                        HttpStatus.NOT_FOUND, HttpResponseMessages.ALREADY_MEMBER);
            }
        }
    }

    @PostMapping("/quit/{id}")
    public Set<Room> quit(Authentication authentication, @PathVariable(value = "id") long id) {
        SecurityUser securityUser = (SecurityUser) authentication.getPrincipal();

        var updatedRoom = roomRepository.findById(id).get().getUsers();
        updatedRoom.remove(securityUser.user);

       var currentUserRooms= securityUser.user.getRooms();
        currentUserRooms.remove(id);
        securityUser.user.setRooms(currentUserRooms);

     //   userRepository.updateUserRooms(currentUserRooms, securityUser.user.getId());
      //  roomRepository.updateRoomUser( updatedRoom, id);



        return userRepository.findByUsername(securityUser.user.getUsername()).get().getRooms();

    }
}