package org.binar.kamihikoukiairlines.service;

import lombok.extern.slf4j.Slf4j;
import org.binar.kamihikoukiairlines.model.Users;
import org.binar.kamihikoukiairlines.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

    @Service
    @Slf4j
    public class UserService {
        @Autowired
        UserRepository userRepository;

        public List<Users> getAllUser(){
            log.info("Get All Data User Success");
            return userRepository.findAll();
        }

        public Page<Users> getAllUsersPagination(int page, int size) {
            PageRequest request = PageRequest.of(page, size);
            Page<Users> result = userRepository.findAll(request);
            log.info("Get All Data User Pagination Success");
            return result;
        }

        public Optional<Users> getUserById(Long id) {
            log.info("Get Data User By Id Success");
            return userRepository.findById(id);
        }

        @Transactional
        public Users updateUser(Long id, Users user) {
            Users user1 = userRepository.findById(id).get();
            user1.setName(user.getName());
            user1.setEmail(user.getEmail());
            user1.setPhoneNumber(user.getPhoneNumber());
            user1.setPassword(user.getPassword());
            log.info("Update Data User Success");
            return userRepository.save(user1);
        }

        public void deleteUser(Long id) {
            userRepository.deleteById(id);
        }
    }
